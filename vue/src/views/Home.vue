<template>
  <div class="home page-container">
    <md-app md-waterfall md-mode="fixed">
      <md-app-toolbar class="md-primary">
        <span class="md-title">TakeIt</span>
      </md-app-toolbar>
      <md-app-content>
        <div v-for="note in notes" v-bind:key="note.id" @dblclick="deleteNote(note)">
          <p class="note">{{ note }}</p>
          <hr>
        </div>
      </md-app-content>
    </md-app>
    <md-button @click="createNote" class="md-fab md-mini md-primary">
      <md-icon>add</md-icon>
    </md-button>
  </div>
</template>

<script>
export default {
  name: "home",
  data() {
    return {
      notes: [],
      msg: "Testing"
    };
  },
  mounted() {
    this.$data.notes = this.$store.getters.GetNotes;
  },
  methods: {
    createNote() {
      this.$router.push(`/create/`);
    },
    deleteNote(note){
      this.$store.dispatch("DELETE", note);
    }
  }
};
</script>
<style lang="scss" scoped>
.md-app {
  max-height: 100vh;
  width: 100vw;
  border: 1px solid rgba(#000, 0.12);
}
.md-fab {
  position: absolute;
  bottom: 10px;
  right: 10px;
}
.note{
  width: 100vw;
  padding: 15px;
  font-size: 16px;
  //border-bottom: 1px solid black;
}
</style>
