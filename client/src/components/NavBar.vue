<script setup lang="ts"></script>

<template>
  <nav class="nav-wrap">
    <div class="left">
      <h1 class="header">
        <RouterLink :to="{ name: 'landing' }" class="landing-link">Crochet Companion</RouterLink>
      </h1>
      <img src="@/assets/images/basket-short-trans.png" class="image" />
    </div>
    <div class="right"></div>
  </nav>
</template>

<style scoped>
.nav-wrap {
  background-color: rgba(251, 246, 245, 0.9);
  height: 3.5rem;
  display: flex;
  align-items: center;
}

.left {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  flex-wrap: nowrap;
}

.image {
  height: 50px;
  margin-bottom: 5px;
  margin-left: 10px;
}

.header {
  padding-left: 20px;
  font-size: 1.5rem;
}

a {
  text-decoration: none;
  font-family: 'Nothing You Could Do', cursive;
  font-weight: bold;
  color: rgb(168, 97, 83);
}
</style>
