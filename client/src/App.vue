<script setup lang="ts">
import NavBar from '@/components/NavBar.vue'
import { RouterView } from 'vue-router'
</script>

<template>
  <div class="app-wrap">
    <NavBar />
    <div class="router-view-cuddler">
      <RouterView />
    </div>
    <nav class="bottom-nav">
      <div class="right">
        <div class="credits">Credits</div>
      </div>
    </nav>
  </div>
</template>

<style scoped>
.bottom-nav {
  background-color: rgba(251, 246, 245, 0.9);
  height: 1.5rem;
  display: flex;
  justify-content: flex-end;
}

.credits {
  margin-right: 10px;
  font-weight: 400;
  color: rgb(168, 97, 83);
}

.app-wrap {
  display: grid;
  grid-template-rows: auto 1fr auto;
  position: absolute;
  inset: 0;
}

.router-view-cuddler {
  overflow-y: hidden;
  display: flex;
  justify-content: center;
}
</style>
