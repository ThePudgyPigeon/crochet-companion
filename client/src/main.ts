import '@/assets/base.css'
import 'primevue/resources/themes/lara-light-green/theme.css'

import { createPinia } from 'pinia'
import { createApp } from 'vue'

import App from '@/App.vue'
import router from '@/router'
import axios from 'axios'
import PrimeVue from 'primevue/config'

axios.defaults.baseURL = import.meta.env.VITE_REMOTE_API + '/api'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(PrimeVue)
app.mount('#app')
