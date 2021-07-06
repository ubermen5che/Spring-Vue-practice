<template>
  <div id="app">
    <div class="container">
        <h1>Hello Spring</h1>
        <p align="center">회원 기능</p>
        <SignUp></SignUp>
        <MemberList></MemberList>
    </div> <!-- /container -->
    <router-view/>
  </div>
</template>

<script>
import MemberList from "./components/MemberList";
import SignUp from "./components/SignUp";

export default {
  name: 'App',
  components: {
    MemberList,
    SignUp
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
