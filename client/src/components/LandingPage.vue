<script setup lang="ts">
import Button from 'primevue/button';
</script>

<template>
  <div class="wrapper">
    <div class="landing-cuddler">
      <div class="landing">
        <div class="header-wrapper"><h1 class="login-header">Crochet Companion</h1></div>
        <div class="button-cuddler">
          <div class="button-wrapper">
            <Button label="button" rounded>
              <RouterLink :to="{ name: 'login' }" class="login-link">Login</RouterLink></Button
            >
          </div>
          <img src="@/assets/images/granny-square.png" class="granny" />
          <div class="button-wrapper">
            <Button label="button" rounded>
              <RouterLink :to="{ name: 'register' }" class="register-link"
                >Register</RouterLink
              ></Button
            >
          </div>
        </div>
      </div>
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

.landing-cuddler {
  margin: 0 auto;
  width: 100%;
  max-width: 800px;
}

.landing {
  gap: 20px;
  padding: 140px;
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
  font-size: 3rem;
  margin-top: 0;
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

.p-button:not(:disabled):hover {
  background: rgb(190, 125, 113);
}

a {
  text-decoration: none;
  color: #fff;
}

.granny {
  margin-left: 50px;
  margin-right: 50px;
}
</style>
