import Vue from 'vue'
import Router from 'vue-router'
import SignUp from "../components/SignUp";
import MemberList from "../components/MemberList";
import HelloWorld from "../components/HelloWorld";
import List from "../components/board/List";

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
    },
    {
      path: '/',
      name: HelloWorld,
      component: HelloWorld
    },
    {
      path: '/board/list',
      name: List,
      component: List
    }
  ]
})
