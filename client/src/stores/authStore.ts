import { authService } from '@/services/authService'
import type { LoginDto, User } from '@/types'
import { defineStore } from 'pinia'
import { ref } from 'vue'
import { useRouter } from 'vue-router'

export const useAuthStore = defineStore('auth', () => {
  const emptyUser: User = {
    token: '',
    username: '',
    roles: []
  }
  const user = ref<User>(JSON.parse(localStorage.getItem('user') ?? '{}'))
  const router = useRouter()

  async function login(loginDto: LoginDto) {
    const response = await authService.login(loginDto)
    user.value = response.data
    localStorage.setItem('user', JSON.stringify(response.data))

    //router.push()
  }

  function logout() {
    console.log('Token expired. User logged out.')
    user.value = emptyUser
    localStorage.removeItem('user')
    router.push({ name: 'login' })
  }

  return {
    user,
    login,
    logout
  }
})
