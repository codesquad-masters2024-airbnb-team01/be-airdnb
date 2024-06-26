<template>
<div class="modal-wrap" v-show="loginModalStatus" @click="cahngeLoginModalStatus">
    <!-- <div class="modal-container" @click.stop=""> -->
    <link rel="stylesheet" href="https://kit-pro.fontawesome.com/releases/v5.15.1/css/pro.min.css" />

  <div  @click.stop="" class="modal-container flex flex-col bg-white shadow-md px-4 sm:px-6 md:px-8 lg:px-10 py-8 rounded-md w-full max-w-md">
    <div class="font-medium self-center text-xl sm:text-2xl text-gray-800">로그인 또는 회원가입</div>

    <button @click="googleLogin" class="relative mt-6 border rounded-md py-2 text-sm text-gray-800 bg-gray-100 hover:bg-gray-200">
      <span class="absolute left-0 top-0 flex items-center justify-center h-full w-10 text-blue-500"><i class="fab fa-google"></i></span>
      <span>Login with Google</span>
    </button>

  </div>


</div>
</template>

<script>
export default{
    name : 'LoginModal',
    data(){
        return{
            loginModalStatus : false,
        }
    },
    methods:{
        cahngeLoginModalStatus(){
            this.loginModalStatus = !this.loginModalStatus;
            //이벤트 쏘는 법
            this.emitter.emit('cahngeLoginModalStatus', this.loginModalStatus);
        },
        googleLogin(){
            // window.location.href = "http://localhost:8080/oauth2/authorization/google";
            window.location.href = "https://airdnb.3utilities.com/oauth2/authorization/google";
        }
    },
    mounted(){
        this.emitter.on('cahngeLoginModalStatus',(loginModalStatus) => {
            this.loginModalStatus = loginModalStatus;
            console.log(this.loginModalStatus);
        })
    }
}
</script>

<style>
/* dimmed */
.modal-wrap {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.4);
}
/* modal or popup */
.modal-container {
  position: relative;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 500px;
  background: #fff;
  border-radius: 10px;
  padding: 20px;
  box-sizing: border-box;
}
</style>