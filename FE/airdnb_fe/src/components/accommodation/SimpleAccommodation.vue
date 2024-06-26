<template>
    <div class="flex justify-center">
      <div class="w-full max-w-4xl bg-white shadow-lg rounded-lg overflow-hidden flex">
        <!-- Image Section -->
        <div class="w-1/2">
          <img class="w-full h-full object-cover" src="@/assets/roomsample.png" alt="Room Image" />
        </div>
        
        <!-- Information Section -->
        <div class="w-1/2 p-6">
          <p class="text-gray-600 mt-2">Spacious and Comfortable cozy house #4</p>
          <ul class="text-gray-600 mt-2">
            <li>최대 인원 3명 · 원룸 · 침대 1개 · 욕실 1개</li>
            <li>주방 · 무선 인터넷 · 에어컨 · 헤어드라이어</li>
          </ul>
          <div class="flex items-center justify-between mt-4">
            <div class="text-red-600 flex items-center">
              <svg class="w-4 h-4 mr-1" fill="currentColor" viewBox="0 0 20 20">
                <path d="M9.049 2.927C9.347 2.165 10.653 2.165 10.951 2.927L12.392 6.637L16.546 7.196C17.328 7.315 17.634 8.347 17.095 8.951L13.894 12.318L14.668 16.432C14.823 17.25 13.972 17.823 13.294 17.428L10 15.684L6.706 17.428C6.028 17.823 5.177 17.25 5.332 16.432L6.106 12.318L2.905 8.951C2.366 8.347 2.672 7.315 3.454 7.196L7.608 6.637L9.049 2.927Z" />
              </svg>
              <span>4.80 (후기 127개)</span>
            </div>
            <div class="text-gray-700 text-right">
              <p>₩82,953 / 박</p>
              <p class="text-gray-500">총액 ₩1,493,159</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  

<script>
export default{
    name : 'SimpleAccommodation',
}
</script>
