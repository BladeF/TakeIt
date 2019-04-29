<template>
  <div class="create page-container">
    <md-app md-waterfall md-mode="fixed">
      <md-app-toolbar class="md-primary">
        <span class="md-title">
          <md-button @click="goBack">
            <md-icon>arrow_back_ios</md-icon>
          </md-button>
          Create A New Note
        </span>
      </md-app-toolbar>
      <md-app-content>
        <md-field>
          <label>Enter your new note</label>
          <md-textarea v-model="note"></md-textarea>
        </md-field>
        <md-button class="md-primary" @click="addNote">Submit</md-button>
      </md-app-content>
    </md-app>
  </div>
</template>
<script>
export default {
  name: "create",
  data() {
    return {
      note: ''
    };
  },
  methods: {
    goBack() {
      this.$router.push(`/`);
    },
    addNote(){
      this.$store.dispatch("CREATE", this.note);
      this.goBack();
    }
  }
};
</script>
<style lang="scss" scoped>
#note {
  font-family: "Courier New", Courier, monospace;
  font-size: 18px;
  width: 100%;
}
</style>
