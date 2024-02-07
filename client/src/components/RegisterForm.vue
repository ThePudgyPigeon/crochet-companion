<script setup lang="ts">
import { useAuthStore } from '@/stores/authStore'
import type { RegisterDto } from '@/types'
import Button from 'primevue/button'
import Divider from 'primevue/divider'
import InputText from 'primevue/inputtext'
import Password from 'primevue/password'

import { ref } from 'vue'
import { RouterLink } from 'vue-router'

const { register } = useAuthStore()

const confirmPassword = ref('')

const registerDto = ref<RegisterDto>({
  username: '',
  email: '',
  role: [],
  password: ''
})
</script>

<template>
  <div class="wrapper">
    <div class="form-cuddler">
      <form class="form" @submit.prevent="register(registerDto)">
        <div class="header-wrapper"><h1 class="register-header">Crochet Companion</h1></div>
        <div class="text-inputs">
          <span class="p-float-label">
            <InputText id="username" v-model="registerDto.username" class="username-input" />
            <label for="username">Username</label>
          </span>
          <img src="@/assets/images/pink-tulip.png" class="image" />
          <span class="p-float-label">
            <InputText id="email" v-model="registerDto.email" class="email-input" />
            <label for="email">Email</label>
          </span>
        </div>
        <div class="text-inputs">
          <span class="p-float-label">
            <Password
              id="password"
              v-model="registerDto.password"
              class="password-input"
              toggleMask
            />
            <label for="password">Password</label>
          </span>
          <img src="@/assets/images/flower-blue.png" class="image" />
          <span class="p-float-label">
            <Password
              id="confirm-password"
              v-model="confirmPassword"
              class="password-input"
              toggleMask
              :feedback="false"
            />
            <label for="confirm-password">Confirm password</label>
          </span>
        </div>
        <div class="button-wrapper">
          <Button label="Submit" type="submit" rounded>Register</Button>
        </div>
        <Divider />
        <div class="text-container">
          <p class="text">Already a user?</p>
          <RouterLink :to="{ name: 'login' }" class="login-link"
            >Head to the login page now!</RouterLink
          >
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped>
.wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.form-cuddler {
  margin: 0 auto;
  width: 100%;
  max-width: 800px;
}

.form {
  gap: 20px;
  padding: 80px;
  background-color: rgba(251, 246, 245, 0.9);
  border-radius: 30px;
}

.header-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 30px;
}

.register-header {
  color: rgb(168, 97, 83);
  font-family: 'Nothing You Could Do', cursive;
  font-weight: bold;
  font-size: 2.5rem;
}

.text-inputs {
  display: flex;
  justify-content: center;
  margin-bottom: 25px;
}

.username-input {
  padding: 12px 40px 12px 12px;
}

.button-cuddler {
  display: flex;
  justify-content: center;
}

.button-wrapper {
  display: flex;
  justify-content: center;
}

.p-button {
  max-width: 100px;
  justify-content: center;
  background: rgb(170, 110, 100);
  border: 1px solid rgb(197, 146, 137);
  transition: 0.3s;
}

.p-button:first-child {
  padding-left: 29px;
  padding-right: 29px;
}

.p-button:hover {
  background: rgb(190, 125, 113);
}

.tulips {
  margin-left: 20px;
  margin-right: 20px;
  height: 40px;
}
.p-inputtext:focus {
  box-shadow: 0 0 0 0.2rem rgba(224, 206, 203, 0.9);
  border-color: rgb(205, 112, 100);
}

.p-inputtext:hover {
  border-color: rgb(205, 112, 100);
}

.password-input:enabled:focus,
:deep(input:enabled:focus) {
  box-shadow: 0 0 0 0.2rem rgba(224, 206, 203, 0.9);
  border-color: rgb(205, 112, 100);
}

.p-password-input:enabled:hover,
:deep(input:enabled:hover) {
  border-color: rgb(205, 112, 100);
}

.username-input,
.email-input {
  padding: 12px 40px 12px 12px;
}

.text-container {
  display: flex;
  align-items: center;
  justify-content: center;
}

.text {
  font-weight: 300;
  margin-right: 5px;
}

.login-link {
  display: inline-block;
  text-decoration: none;
  color: rgb(161, 85, 72);
  font-weight: bold;
}

.login-link:hover {
  text-decoration: underline;
}
</style>
