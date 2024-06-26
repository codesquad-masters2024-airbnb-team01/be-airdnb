import { createWebHistory, createRouter } from "vue-router";

import DnbHome from "../views/DnbHomeView.vue";
import Accommodations from "../views/AccommodationListView.vue";
import AccommodationDetail from "../views/AccommodationDetailView.vue";
import OAuthRedirect from '@/components/OAuthRedirect.vue';
import PostCode from '@/components/PostCode';
const routes = [
  {
    path: '/callback',
    name: 'OAuthRedirect',
    component: OAuthRedirect
  },
  {
    path:'/',
    component: DnbHome,
  },
  {
    path:'/accommodations',
    component: Accommodations,
  },
  {
    path:'/accommodation',
    component: AccommodationDetail,
  },
  {
    path:'/postcode',
    component: PostCode,
  }


];
const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;