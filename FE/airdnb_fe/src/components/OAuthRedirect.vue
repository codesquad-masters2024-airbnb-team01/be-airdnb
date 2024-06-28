<template>
<div>
    <button @click="getAuthorization">쿠키 가져오기</button>
    <div ></div>
</div>
</template>
    
<script>
import { useCookies } from "vue3-cookies";
export default {
    data(){
        return {
        }
    },
    setup() {
        const { cookies } = useCookies();
        return { cookies };
    },
    created(){
        alert(this.cookies.get("jwt"));
        this.$store.commit('setToken',this.cookies.get("jwt"));
        this.cookies.remove("jwt");
        this.$router.push('/');
    }
}
</script>


