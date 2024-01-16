<script setup lang="ts">
import { useAuthStore } from '@/stores/authStore'
import type { LoginDto } from '@/types'
import Button from 'primevue/button'
import InputText from 'primevue/inputtext'
import { ref } from 'vue'

const { login } = useAuthStore()

const loginDto = ref<LoginDto>({
  username: '',
  password: ''
})
</script>

<template>
  <div class="login-form-container">
    <h1 class="login-header">Login</h1>
    <form>
      <span class="p-float-label">
        <InputText id="username" v-model="loginDto.username" class="username-input" />
        <label for="username">Username</label>
      </span>
      <span class="p-float-label">
        <InputText id="password" v-model="loginDto.password" class="password-input" />
        <label for="password">Password</label>
      </span>
      <Button label="Submit">Login</Button>
    </form>
  </div>
</template>

<style scoped>
.login-form-container {
  display: flex;
  justify-content: center;
  align-items: center;
}

.login-header {
  color: black;
}
</style>
