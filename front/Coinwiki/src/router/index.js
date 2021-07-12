import Vue from 'vue'
import Router from 'vue-router'
import SignUp from "../components/SignUp";
import MemberList from "../components/MemberList";
import HelloWorld from "../components/HelloWorld";
import List from "../components/board/List";
import Write from "../components/Write";
import View from "../components/board/View"

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
    },
    {
      path: '/board/write',
      name: Write,
      component: Write
    },
    {
      path: '/board/view',
      name: View,
      component: View
    }
  ]
})
