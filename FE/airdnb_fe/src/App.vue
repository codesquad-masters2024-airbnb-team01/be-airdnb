<template>
  <RouterView/>
  <LoginModal/>
</template>

<script>
import { useCookies } from "vue3-cookies";
// import axios from 'axios';
import LoginModal from "./components/modal/LoginModal.vue";
export default {
  name: 'App',
  setup() {
    const { cookies } = useCookies();
    return { cookies };
  },
  components: {
    LoginModal,
  },
  data(){
    return {
      logIn : true,
    }
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 50px;
}
</style>
