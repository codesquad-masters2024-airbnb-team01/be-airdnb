<template>
    <DnbHeader/>

    <div class="flex w-full">
        <div class="w-1/2">
            <div>ex. 300개 이상의 숙소 5월 12일 - 5월 18일  게스트 3명</div>
            <h3 class="text-lg font-semibold">서초구의 아파트 전체</h3>
            <SimpleAccommodation class="mt-4" v-for="acc in 3" :key="acc"/>
        </div>
        <div class="w-1/2">
            <AccommodationMap/>
        </div>
    </div>
</template>

<script>
import DnbHeader from "../components/header/DnbHeader.vue";
import SimpleAccommodation from "@/components/accommodation/SimpleAccommodation.vue";
import AccommodationMap from "@/components/accommodation/AccommodationMap.vue";
export default {
    name : 'AccommodationListView',
    components :{
        DnbHeader,
        SimpleAccommodation,
        AccommodationMap,
    }
}
</script>
