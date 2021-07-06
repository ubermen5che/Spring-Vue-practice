<template>
<div id="example">
  <input v-model="parentMsg" placeholder="여기를 수정해보세요.">
  <br>
  <child v-bind:message="parentMsg"></child>
</div>
</template>

<script>
export default {
  name: 'example',
  data: function (){
    return {parentMsg : ''}
  }
}
</script>

<style scoped>

</style>
