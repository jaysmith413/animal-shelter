
import router from './router';
<template>
  <div id="app">
    <div id="nav">
      <img src="../src/img/Cheers.png" alt="logo" id="logo">
      <router-link v-bind:to="{ name: 'home' }" class="button">Home</router-link>
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''" class="button">Login</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" class="button">Logout</router-link>
      <router-link v-bind:to="{ name: 'apply'}" v-if="$store.state.token === ''" class="button">Apply to be a Volunteer</router-link>
    </div>

    <router-view/>
  </div>
</template>

<style scoped>
* {
  margin: 0;
}

#app{
  margin: 0;
}

#nav{
  background-color: #ACEB98;
  display: flex;
  align-items: center;
  padding: 24px;
}

#logo {
  width: 150px;
  margin-right: 32px;
}

.button {
  background-color: #498C8A;
  color: #FFFFFF;
  border-radius: 8px;
  margin: 0 8px;
  padding: 16px 24px;
  text-decoration: none;
}

.button:hover {
  background-color: #46ACC2;
}


</style>