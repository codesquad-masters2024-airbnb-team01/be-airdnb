<template>
    <div class = "flex">
    <input type="text" placeholder="우편번호" v-model="zonecode" readonly />
    <input type="text" v-model="roadAddress" placeholder="주소" readonly /><br />
    <input type="text" v-model="detailAddress" placeholder="상세주소" />
    <button id="postcode" @click="openPostcode">검색</button><br />
  </div>
  <button @click="getCoordinate">좌표 검색</button>
</template>

<script>
import axios from 'axios';

export default{
    name : 'PostCode',
    data() {
        return {
        zonecode: "",
        roadAddress: "",
        detailAddress: "",
        };
    },
    methods: {
        openPostcode() {
        new window.daum.Postcode({
            oncomplete: (data) => {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분
            this.zonecode = data.zonecode;
            this.roadAddress = data.roadAddress;
            },
        }).open();
        },
        getCoordinate(){
            axios.get('https://dapi.kakao.com/v2/local/search/address.json', {
                params: {
                    query: this.roadAddress, // 사용자가 입력한 주소를 query 파라미터로 전달
                },
                headers: {
                    Authorization: 'KakaoAK '+ process.env.VUE_APP_KKAO_AK, // Kakao API 키를 여기에 넣어주세요
                },})
                .then((response)=>{
                 // API 호출 성공 시 처리
                if (response.data.documents.length > 0) {
                    const firstResult = response.data.documents[0];
                    const coordinates = {
                        x: firstResult.x,
                        y: firstResult.y,
                    };
                console.log('좌표:', coordinates);
                // 여기서 좌표값을 필요에 맞게 처리하면 됩니다.
                } else {
                    console.log('주소에 대한 좌표를 찾을 수 없습니다.');
                }
            })
        }
    },
};
</script>