<template>
    <div class="flex rounded">
      <img v-for="(image, index) in imagesToShow" :key="index" :src="image" :alt="'Image ' + (index + 1)">
    </div>
  </template>
  
  <script>
  export default {
    name: 'ImageSlider',
    props: {
      images: {
        type: Array,
        default: () => ['https://via.placeholder.com/800x400'] // Default image
      }
    },
    computed: {
      imagesToShow() {
        return this.images.length > 0 ? this.images : ['https://via.placeholder.com/800x400'];
      }
    }
  }
  </script>
  
  <style scoped>
  .image-slider {
    display: flex;
    overflow-x: scroll;
    scroll-snap-type: x mandatory;
  }
  .image-slider img {
    width: 100%;
    scroll-snap-align: center;
  }
  </style>
  