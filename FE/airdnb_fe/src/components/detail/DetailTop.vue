<template>
    <div class="flex justify-between items-center">
        <h1 class="truncate max-w-md text-5xl">Eddy's HOME</h1>
        <div class="relative group">
            <div class="relative group rounded-md flex items-center space-x-2 cursor-pointer transition-colors duration-300 hover:bg-gray-300">
                <img class="w-6 h-6" src="@/assets/icons/bookmark.png" alt="Bookmark" />
                <div class="text-xl underline">저장</div>
            </div>
        </div>  
    </div>
</template>
<script>
export default{
    name : 'DetailTop',
}
</script>