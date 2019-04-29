import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import { MdButton, MdContent, MdApp, MdIcon, MdToolbar, MdField } from 'vue-material/dist/components'
import 'vue-material/dist/vue-material.min.css';
import 'vue-material/dist/theme/default.css';

Vue.use(MdButton);
Vue.use(MdContent);
Vue.use(MdApp);
Vue.use(MdIcon);
Vue.use(MdToolbar);
Vue.use(MdField);

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
