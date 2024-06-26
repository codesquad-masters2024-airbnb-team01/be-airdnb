<template>
    <DnbHeader :dataSearchbarOpen="dataSearchbarOpen"/>
</template>

<script> 
import DnbHeader from "../components/header/DnbHeader.vue";

export default{
    name : 'DnbHome',
    components:{
        DnbHeader,
    },
    data(){
        return {
            dataSearchbarOpen : true,
        }
    },
}
</script>
