<template>
  <div id="memberList">
    <H2>Member::List</H2>
    <ul>
      <li v-for="member in members" v-bind:key="member.id">
        {{member.name}}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "MemberList",
  data() {
    return {
      members: []
    }
  },
  head: {
    title: {
      inner: "member Vue.js"
    },
    link: [
      { rel: 'stylesheet', href: 'https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css'}
    ]
  },
  created: function () {
      axios.get('/members').then(result => {
        console.log(result.data)
        this.members = result.data;
        console.log(this.members);
      }).catch(error => {
        console.log(error)
      });
    }
}
</script>

<style scoped>

</style>
