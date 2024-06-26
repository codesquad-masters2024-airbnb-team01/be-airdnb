<template>
    <div class="reviews">
      <h2>후기</h2>
      <p>{{ reviews }}</p>
    </div>
  </template>
  
  <script>
  export default {
    name: 'DetailAccommodationReview',
    props: {
      reviews: String
    }
  }
  </script>
  
  <style scoped>
  .reviews {
    margin-top: 20px;
  }
  </style>
  