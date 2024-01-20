<script setup lang="ts"></script>

<template>
  <nav class="nav-wrap">
    <div class="left">
      <h1 class="header">Crochet Companion</h1>
      <img src="@/assets/images/basket-short-trans.png" class="square" />
    </div>
    <div class="right"></div>
  </nav>
</template>

<style scoped>
.nav-wrap {
  background-color: rgba(251, 246, 245, 0.9);
  height: 3rem;
  display: flex;
  align-items: center;
  margin-bottom: 5px;
}

.left {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  flex-wrap: nowrap;
}

.square {
  height: 40px;
  margin-bottom: 5px;
  margin-left: 10px;
}

.header {
  font-family: 'Nothing You Could Do', cursive;
  font-weight: bold;
  color: rgb(168, 97, 83);
  padding-left: 20px;
}
</style>
