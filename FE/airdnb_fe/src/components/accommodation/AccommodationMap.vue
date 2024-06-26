<template>
    <div class="map-container">
      <div id="map"></div>
    </div>
  </template>
  
  <style>
  .map-container {
    width: 100%; /* 화면 너비에 맞게 조정 */
    height: 100%; /* 화면 높이에 맞게 조정 */
    position: relative; /* 위치 설정 */
  }
  
  #map {
    width: 100%;
    height: 100%;
  }
  </style>
  
  <script>
  export default {
    name: 'AccommodationMap',
    data() {
      return {
        map: null,
        currentLatitude: 0,
        currentLongitude: 0,
      };
    },
    mounted() {
        this.loadScript();  
    },
    methods: {
      loadScript() {
        const script = document.createElement("script");
        script.src =
          "//dapi.kakao.com/v2/maps/sdk.js?appkey="+process.env.VUE_APP_API_KEY+"&libraries=services&autoload=false";
        script.onload = () => {
          window.kakao.maps.load(() => {
            this.currentLocation();
          });
        };
  
        document.head.appendChild(script);
      },
      currentLocation() {
        navigator.geolocation.getCurrentPosition((position) => {
          this.currentLatitude = position.coords.latitude;
          this.currentLongitude = position.coords.longitude;
          this.loadMap(); // Load the map after getting the location
        });
      },
      loadMap() {
        const container = document.getElementById("map");
        const options = {
          center: new window.kakao.maps.LatLng(this.currentLatitude, this.currentLongitude),
          level: 3
        };
  
        this.map = new window.kakao.maps.Map(container, options);
        this.loadMarker();
      },
      loadMarker() {
        // 마커가 표시될 위치
        const markerPosition = new window.kakao.maps.LatLng(this.currentLatitude, this.currentLongitude);
  
        // 마커 생성
        const marker = new window.kakao.maps.Marker({
          position: markerPosition
        });
  
        // 마커가 지도 위에 표시되도록 설정
        marker.setMap(this.map);
      }
    }
  };
  </script>
  