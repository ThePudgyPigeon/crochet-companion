import type { LoginDto, RegisterDto } from '@/types'
import axios from 'axios'

export const authService = {
  login(loginDto: LoginDto) {
    return axios.post('auth/login', loginDto)
  },

  register(registerDto: RegisterDto) {
    return axios.post('auth/register', registerDto)
  }
}
