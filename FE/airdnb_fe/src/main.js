import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router'
import mitt from 'mitt'
import './tailwind.css'
import store from './store'

let emitter = mitt();
let app = createApp(App)
app.config.globalProperties.emitter = emitter; // 글로벌 변수 보관함

app.use(router).use(store).mount('#app') 
