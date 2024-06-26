import { createStore } from 'vuex'
import axios from 'axios'

const store = createStore({

    state() {
      return {
        count: 0,
        token: localStorage.getItem('token') || null,
      }
    },
    getters: {
        isAuthenticated: (state) => !!state.token
    },
    mutations: {
        setToken(state, token) {
            state.token = token;
            localStorage.setItem('token', token);
            axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
        },
        clearToken(state) {
            state.token = null;
            localStorage.removeItem('token');
            delete axios.defaults.headers.common['Authorization'];
        }
    },
    actions: {
      getData() {
        axios.get().then((response) => {
          // success
          console.log(response);
        }).catch((error) => {
          // error handling
          console.error('Error fetching data:', error);
        });
      },
    },
  });
  
  export default store;
  