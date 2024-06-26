const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

module.export = {
  devServer: {
    proxy:{
      "/api":{
        target : "https://airdnb.3utilities.com"
      }
    }
  },
  pluginOptions: {
    webpack: {
        // .env 파일을 로드하기 위한 설정
        dotenv: {
            path: '.env',  // 사용할 .env 파일의 경로
        },
    },
  },
}
