
import router from './router';
<template>
  <div id="app" >
    <div id="nav" class="navbar sticky">
      <a href="/">
        <img src="../src/img/cheersPoppins5E8558.png" alt="logo" id="logo">
      </a>
      <!-- Hamburger Menu -->
      <input type="checkbox" id="checkbox_toggle" />
      <label for="checkbox_toggle" class="hamburger">&#9776;</label>
      <!-- Navigation -->
      <div class="menu">
        <router-link v-bind:to="{ name: 'home' }" class="button">Home</router-link>
        <router-link v-bind:to="{ name: 'apply'}" v-if="$store.state.token === ''" class="button">Be a Volunteer</router-link>
        <router-link v-bind:to="{ name: 'directory' }" v-if="$store.state.token != ''" class="button">Volunteer Directory</router-link>
        <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''" class="button">Login</router-link>
        <router-link v-bind:to="{ name: 'applications' }" v-if="$store.state.token != ''" class="button">View Applications</router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" class="button">Logout</router-link>
        <router-link v-bind:to="{ name: 'addPet' }" v-if="$store.state.token != ''" class="button">Add Pet</router-link>
      </div>
    </div>
    <router-view/>
  </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');

* {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

body {
  margin: 0;
}

.sticky {
  position: sticky;
  top: 0;
  width: 100%;
  z-index: 3;
} 

#app{
  margin: 0;
  background-image: url(img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png);
}

#nav{
  box-shadow: 0 4px 6px -2px rgba(0, 0, 0, 0.1);
  background-color: #FFFFFF;
  display: flex;
  align-items: center;
  padding: 0 24px;
}

#logo {
  width: 200px;
  margin-right: 32px;
}

.button {
  background: #775576;
  transition: all 0.4s;
  color: #FFFFFF;
  border-radius: 8px;
  margin: 0 8px;
  padding: 16px 24px;
  text-decoration: none;
  width: 180px;
}

.button:hover {
  background-color: #B185A7;
}

.navbar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 16px 32px;
  background-color: #FFFFFA;
  color: rgba(102, 102, 102);
  box-shadow: 0 4px 6px -2px rgba(0, 0, 0, 0.1);
}

input[type=checkbox] {
  display: none;
} 

/* HAMBURGER MENU */
.hamburger {
  display: none;
  font-size: 32px;
  user-select: none;
}

/* APPLYING MEDIA QUERIES */
@media (max-width: 992px) {

  #logo {
    width: 150px;
  }

 .menu {
    display:none;
    position: absolute;
    background-color:#FFFFFA;
    right: 0;
    left: 0;
    text-align: center;
    padding: 16px 0 4px 0;
    margin-top: 280px;
  }

  .button {
    display: block;
    border-radius: 0;
    width: 100%;
    margin: 0 0 8px 0;
  }

  .menu li:hover {
    background-color:#feeadc;
    transition: 0.3s ease;
  }

  .menu li + li {
    margin-top: 12px;
  }

  input[type=checkbox]:checked ~ .menu {
    display: block;
  }

  .hamburger {
    display: block;
  }
}

</style>