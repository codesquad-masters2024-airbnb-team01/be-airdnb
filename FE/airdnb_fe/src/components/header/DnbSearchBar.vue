<template>
    <div class="flex justify-center">
      <div class="bar flex justify-center items-center w-[650px] bg-white shadow-all-sides h-[55px] rounded-full" >
        <div class="check-in flex-1 px-4 py-2">
          <p class="text-xs font-medium text-gray-600">체크인</p>
          <input type="date" placeholder="날짜입력" class="w-full mt-1 bg-transparent border-none focus:outline-none text-sm placeholder-gray-400" />
        </div>
        <div class="check-out flex-1 px-4 py-2">
          <p class="text-xs font-medium text-gray-600">체크아웃</p>
          <input type="date" placeholder="날짜 입력" class="w-full mt-1 bg-transparent border-none focus:outline-none text-sm placeholder-gray-400" />
        </div>
        <div class="check-out flex-1 px-4 py-2">
          <p class="text-xs font-medium text-gray-600">요금</p>
          <input type="text" placeholder="금액대 설정" class="w-full mt-1 bg-transparent border-none focus:outline-none text-sm placeholder-gray-400" />
        </div>
        <div class="cost flex-1 px-4 py-2 relative">
          <p class="text-xs font-medium text-gray-600">인원</p>
          <input type="text" placeholder="게스트 추가" class="w-full mt-1 bg-transparent border-none focus:outline-none text-sm placeholder-gray-400" />
          <!-- 버튼 -->
          <span class="absolute top-1/2 right-2 transform -translate-y-1/2 bg-red-500 text-white text-sm p-2 rounded-full flex items-center justify-center">
            <i class="lni lni-search-alt"></i>
          </span>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "DnbSearchBar",
  };
  </script>
  
  <style scoped>
  /* Import Linearicons icon font for the search icon */
  @import url('https://cdn.linearicons.com/free/1.0.0/icon-font.min.css');
  </style>
  