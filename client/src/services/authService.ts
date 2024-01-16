import type { LoginDto } from '@/types'
import axios from 'axios'

export const authService = {
  login(loginDto: LoginDto) {
    return axios.post('auth/login', loginDto)
  }
}
