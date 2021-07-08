<template>
  <div id="app">
    <!-- 추가된 헤더 컴포넌트 사용 -->
    <Header />
    <router-view/>

    <!-- 추가된 풋터 컴포넌트 사용 -->
    <Footer />
  </div>
</template>

<script>
import Header from "./components/common/Header";
import Footer from "./components/common/Footer";
import HelloWorld from "./components/HelloWorld";
import List from "./components/board/List";

export default {
  name: 'App',
  components: {
    List,
    Header,
    Footer,
    HelloWorld,
  }
}
</script>

<style>
#app {
  max-width: 1000px;
  margin: 0 auto;
  line-height: 2.0;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

h1 {
  text-align: center;
}
</style>
