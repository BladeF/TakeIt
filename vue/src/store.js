import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    Notes: []
  },
  getters: {
    GetNotes: state => {
      return state.Notes;
    }
  },
  mutations: {
    Add_Note: (state, note) => {
      state.Notes.push(note);
    },
    Remove_Note: (state, note) => {
      state.Notes.splice(state.Notes.indexOf(note), 1);
    }
  },
  actions: {
    CREATE: (context, note) => {
      return context.commit("Add_Note", note);
    },
    DELETE: (context, note) => {
      return context.commit("Remove_Note", note);
    },
  }
});
