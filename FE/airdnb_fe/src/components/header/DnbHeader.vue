<template>
    <header class="flex items-center justify-between">
        <div @click="$router.push('/')" class="text-lg font-bold ml-auto cursor-pointer">daybnb</div>
        <div class="flex items-center space-x-3 ml-auto" >
            <div class="flex space-x-3" v-show="dataSearchbarOpen">
                <div class="text-lg hover:text-green-700 hover:font-bold cursor-pointer">숙소</div>
                <div class="text-lg hover:text-green-700 hover:font-bold cursor-pointer">체험</div>
                <div class="text-lg hover:text-green-700 hover:font-bold cursor-pointer">온라인 체험</div>
            </div>
            <DnbSimpleSearchBar v-show="dataSearchbarOpen==false"/>
        </div>
        <!-- <div v-if="Login == true" class="text-lg ml-auto mr-auto">Login</div> -->
        <div class="relative ml-auto mr-auto">
            <div @click="changeMenuStatus" class="flex cursor-pointer"> 
                <img src="../../assets/icons/menu.png" alt="Menu"/>
                <img src="../../assets/icons/user.png" alt="User">
            </div>
            <DnbMenu @closeMenu="menuStatus=false" :menuStatus = 'menuStatus' :logIn = 'logIn' class=" z-20"/>
        </div>

    </header>
    <DnbSearchBar v-show="dataSearchbarOpen" class="mt-12"/>

    <hr class="mt-8" color="grey">
</template>

<script>
import DnbMenu from "./DnbMenu.vue";
import DnbSearchBar from "./DnbSearchBar.vue";
import DnbSimpleSearchBar from "./DnbSimpleSearchBar.vue";

export default{
    name : 'DnbHeader',
    components:{
        DnbMenu,
        DnbSearchBar,
        DnbSimpleSearchBar,
    },
    data(){
        return{
            logIn : false,
            menuStatus : false,
            // loginModalStatus : false,
        }
    },
    props:{
        dataSearchbarOpen : Boolean,
    },
    methods:{
        changeMenuStatus(){
            this.menuStatus = !this.menuStatus;
        },
    },
    // mounted(){
    //     this.emitter.on('cahngeLoginModalStatus',(loginModalStatus) => {
    //         this.loginModalStatus = loginModalStatus;
    //     })
    // }
}
</script>
