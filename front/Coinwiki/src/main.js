import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VueHead from "vue-head";

Vue.config.productionTip = false
Vue.use(VueHead);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

