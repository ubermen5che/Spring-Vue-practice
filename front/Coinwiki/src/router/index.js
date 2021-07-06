import Vue from 'vue'
import Router from 'vue-router'
import SignUp from "../components/SignUp";
import MemberList from "../components/MemberList";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/member/new',
      name: 'SignUp',
      component: SignUp
    },
    {
      path: '/members',
      name: 'MemberList',
      component: MemberList
    }
  ]
})
