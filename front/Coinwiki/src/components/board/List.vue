<template>
  <div>
    <h2>게시판 리스트</h2>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      posts: []
    }
  },
  created: function () {
    axios.get('/api/board').then(result => {
      console.log(result.data)
      this.posts = result.data;
      console.log(this.posts);
    }).catch(error => {
      console.log(error)
    });
  }
}
</script>

<style scoped>

</style>
