import { authService } from '@/services/authService';
import type { LoginDto, RegisterDto, User } from '@/types';
import { defineStore } from 'pinia';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

export const useAuthStore = defineStore('auth', () => {
  const emptyUser: User = {
    token: '',
    username: '',
    roles: []
  };
  const user = ref<User>(JSON.parse(localStorage.getItem('user') ?? '{}'));
  const router = useRouter();

  async function login(loginDto: LoginDto) {
    try {
      const response = await authService.login(loginDto);
      if (response.status === 200) {
        return Promise.resolve({
          type: 'success',
          status: response.status,
          data: response.data
        });
      }
    } catch (error) {
      return Promise.resolve({
        type: 'error',
        status: 0,
        error: error != null ? error.toString() : 'Unknown Error'
      });
    }
  }

  async function register(registerDto: RegisterDto) {
    try {
      const response = await authService.register(registerDto);
      if (response.status === 200) {
        return Promise.resolve({
          type: 'success',
          status: response.status,
          data: response.data
        });
      }
    } catch (error) {
      return Promise.resolve({
        type: 'error',
        status: 0,
        error: error != null ? error.toString() : 'Unknown Error'
      });
    }
  }

  function logout() {
    user.value = emptyUser;
    localStorage.removeItem('user');
    router.push({ name: 'login' });
  }

  return {
    user,
    register,
    login,
    logout
  };
});
