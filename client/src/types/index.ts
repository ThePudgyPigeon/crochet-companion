export type User = {
  token: string
  username: string
  roles: string[]
}

export type LoginDto = {
  username: string
  password: string
}

export type RegisterDto = {
  username: string
  email: string
  role: string[]
  password: string
}
