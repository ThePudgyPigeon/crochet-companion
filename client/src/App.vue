<script setup lang="ts">
import NavBar from '@/components/NavBar.vue'
import { RouterView } from 'vue-router'
</script>

<template>
  <div class="app-wrap">
    <NavBar />
    <RouterView />
  </div>
</template>

<style scoped></style>
