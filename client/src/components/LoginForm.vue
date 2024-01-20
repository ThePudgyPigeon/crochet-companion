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
  <div class="wrapper">
    <div class="form-cuddler">
      <form class="form">
        <div class="header-wrapper"><h1 class="login-header">Crochet Companion</h1></div>
        <div class="text-inputs">
          <span class="p-float-label">
            <InputText id="username" v-model="loginDto.username" class="username-input" />
            <label for="username">Username</label>
          </span>
          <span class="p-float-label">
            <InputText id="password" v-model="loginDto.password" class="password-input" />
            <label for="password">Password</label>
          </span>
        </div>
        <div class="button-wrapper">
          <Button label="Submit" rounded>Login</Button>
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
  padding: 100px;
  background-color: rgba(251, 246, 245, 0.9);
  border-radius: 30px;
}

.header-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 30px;
}

.login-header {
  color: rgb(168, 97, 83);
  font-family: 'Nothing You Could Do', cursive;
  font-weight: bold;
}

.text-inputs {
  display: flex;
  justify-content: center;
  margin-bottom: 50px;
}

.button-wrapper {
  display: flex;
  justify-content: center;
}

.p-float-label:first-child {
  margin-right: 50px;
}

.p-button {
  max-width: 100px;
  justify-content: center;
  background: rgb(170, 110, 100);
  border: 1px solid rgb(197, 146, 137);
  transition: 0.3s;
}

.p-inputtext:enabled:focus {
  box-shadow: 0 0 0 0.2rem rgba(224, 206, 203, 0.9);
  border-color: rgb(205, 112, 100);
}

.p-inputtext:enabled:hover {
  border-color: rgb(205, 112, 100);
}

.p-button:hover {
  background: rgb(190, 125, 113);
}
</style>
