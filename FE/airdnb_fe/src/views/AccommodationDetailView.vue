<template>
    <DnbHeader/>
    <DetailTop/>
    <div class="flex w-full">
        <ImageSlider/>
    </div>
</template>

<script>
import DnbHeader from "../components/header/DnbHeader.vue";
import DetailTop from "../components/detail/DetailTop.vue";
import ImageSlider from "../components/detail/ImageSlider.vue";
export default {
    name : 'AccommodationDetail',
    components :{
        DnbHeader,
        DetailTop,
        ImageSlider,
    }
}
</script>
