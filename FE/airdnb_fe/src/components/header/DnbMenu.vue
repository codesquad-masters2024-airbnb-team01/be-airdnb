<template>
    <ul  v-if="!isAuthenticated" v-show="menuStatus" class="absolute right-0 mt-2 w-48 bg-white border border-gray-200 rounded-md shadow-lg">
        <li class="px-4 py-2 text-gray-700 hover:text-green-700 hover:font-bold cursor-pointer border-b" @click="cahngeLoginModalStatus">로그인</li>
    </ul>
    <ul v-else v-show="menuStatus" class="absolute right-0 mt-2 w-48 bg-white border border-gray-200 rounded-md shadow-lg">
        <li class="px-4 py-2 text-gray-700 hover:text-green-700 hover:font-bold cursor-pointer border-b" @click="selectOption('Option 1')">예약 취소</li>
        <li class="px-4 py-2 text-gray-700 hover:text-green-700 hover:font-bold cursor-pointer border-b" @click="selectOption('Option 2')">위시리스트</li>
        <li class="px-4 py-2 text-gray-700 hover:text-green-700 hover:font-bold cursor-pointer" @click="logout">로그아웃</li>
    </ul>
</template>

<script>

export default{
    name : 'DnbMenu',
    data(){
        return {
            loginModalStatus:false,
        }
    },
    computed: {
        isAuthenticated() {
            return this.$store.getters.isAuthenticated; // Corrected getter name
        }
    },
    props:{
        menuStatus : Boolean,
        logIn : Boolean,
    },
    methods:{
        cahngeLoginModalStatus(){
            this.loginModalStatus = !this.loginModalStatus;
            //이벤트 쏘는 법
            this.emitter.emit('cahngeLoginModalStatus', this.loginModalStatus);
            this.$emit('closeMenu');
            //menustatus 변경 필요
        },
        logout(){
            alert("logout");
            this.$store.commit('clearToken');
            this.$router.push('/');
        }
    },
    onMounted(){
        this.emitter.on('cahngeLoginModalStatus',(loginModalStatus) => {
            this.loginModalStatus = loginModalStatus;
            console.log(this.loginModalStatus);
        })
    },
}
</script>