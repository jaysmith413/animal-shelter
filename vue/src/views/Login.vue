<template>
  <div id="login">
    <div class="application-container">
      <!-- <div class="image-container">
        <img src="../img/green-cartoon-animal-header.png" alt="Purple Cartoon Animals Header" class="image-container">
      </div> -->
      <div class="container" style="margin-bottom: 64px;">
        <div class="text">
          Please Sign In
        </div>
        <form @submit.prevent="login">
          <div role="alert" v-if="invalidCredentials">
            Invalid username and password!
          </div>
          <div role="alert" v-if="this.$route.query.registration">
            Thank you for registering, please sign in.
          </div>
          <div class="form-row">
            <div class="input-data">
              <input type="text" id="username" v-model="user.username" required autofocus />
              <div class="underline"></div>
              <label for="username">Username</label>
            </div>
          </div>
          <div class="form-row">
            <div class="input-data">
              <input type="password" id="password" v-model="user.password" required />
              <div class="underline"></div>
              <label for="password">Password</label>
            </div>
          </div>
          <div class="form-row">
            <div class="input-data">
              <button type="submit">SIGN IN</button>
              <p><router-link :to="{ name: 'register' }" style="color: #5E8558;">Need an account? Sign Up!</router-link></p>
            </div>         
          </div>
        </form>
      </div>
    </div>
    <div class="empty">
      <img src="../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png" alt="nonstretch">
      <img src="../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png" alt="2">
      <img src="../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png" alt="3">
    </div>
    <div class="empty">
      <img src="../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png" alt="nonstretch">
      <img src="../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png" alt="2">
      <img src="../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png" alt="3">
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        id: "",
        username: "",
        password: "",
        activated: false
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            if(this.$store.state.user.hasLoggedIn === false) {
              let userID = this.$store.state.user.id
              console.log(userID)
              this.$router.push(`/changepassword/${userID}`)
            } else {
              console.log(this.$store.state.user.hasLoggedIn)
              console.log(this.$store.state.user.id)
              this.$router.push("/");
            }
            
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');

*{
  margin: 0;
  padding: 0;
  outline: none;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}

body{
  margin: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  padding: 10px;
  font-family: 'Poppins', sans-serif;
  background-image: url(../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png);
}

/* .image-container {
  display: inline-block;
  position: relative;
  line-height: 0;
  background: #ffffff;
}
.image-container::after {
  content: '';
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  mix-blend-mode: multiply;
  background: #fa00cc;
  opacity: 0.5;
}
.image-container > img {
  -webkit-filter:    grayscale(100%) hue-rotate(0deg) invert(0%) opacity(100%) saturate(100%) sepia(0%);
          filter:    grayscale(100%) hue-rotate(0deg) invert(0%) opacity(100%) saturate(100%) sepia(0%);
  mix-blend-mode: none;
} */

.application-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

/* .image-container {
  width: 100%;
  max-height: 500px;
  overflow: hidden;
  position: relative;
} */

.empty{
  display: flex;
  flex-direction: row;
}

img{
  background-repeat: repeat-y;
  width: auto;
  display: flex;
  flex-direction: row;
}

.container {
  max-width: 60%;
  width: 60%;
  background-color: #FFFFFF;
  padding: 80px 100px 80px 80px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
  border-radius: 8px;
  margin: 0 auto;
  margin-top: 60px; /* Adjust this value to control the vertical position of the form */
  z-index: 1;
}

.text{
  text-align: left;
  font-size: 48px;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  color: #5E8558;
  margin: 0;
  padding: 0 16px;
}

form {
  padding: 8px 0 0 0;
}

.form-row {
  display: flex;
  margin: 32px 0;
}

.field {
  margin-left: 20px;
}

.checkbox {
  display: inline-block;
  align-items: center;
  margin: 16px 10px 0 0;
  background-color: #f1f1f1;
  padding: 16px;
  border-radius: 8px;
  width: 225px;
}

form .form-row .input-data{
  width: 100%;
  height: 40px;
  margin: 0 20px;
  position: relative;
}

form .form-row .textarea{
  height: 70px;
}

.input-data input,
.textarea textarea{
  display: block;
  width: 100%;
  height: 100%;
  border: none;
  font-size: 16px;
  border-bottom: 2px solid rgba(0,0,0, 0.12);
}

.input-data label, .textarea label {
  transform: translateY(-26px);
  font-size: 16px;
  color: #775576;
}

.textarea textarea{
  resize: none;
  padding-top: 10px;
}

.input-data label{
  position: absolute;
  pointer-events: none;
  bottom: 10px;
  font-size: 16px;
  transition: all 0.3s ease;
}

.textarea label{
  width: 100%;
  bottom: 40px;
  background: #fff;
}

.input-data .underline{
  position: absolute;
  bottom: 0;
  height: 2px;
  width: 100%;
}

.input-data .underline:before{
  position: absolute;
  content: "";
  height: 2px;
  width: 100%;
  background: #8E37D7;
  transform: scaleX(0);
  transform-origin: center;
  transition: transform 0.3s ease;
}

.input-data input:focus ~ .underline:before,
.input-data input:valid ~ .underline:before,
.textarea textarea:focus ~ .underline:before,
.textarea textarea:valid ~ .underline:before{
  transform: scale(1);
}

button {
  overflow: hidden;
  height: 56px!important;
  width: 25%!important;
  border-radius: 8px;
  margin: 0!important;
}

button .input-data{
  height: 100%;
  width: 50%;
  position: absolute;
  background-color: #5E8558;
  transition: all 0.4s;
}

button {
  border: none;
  background-color: #5E8558;
  color: #FFFFFF;
  font-size: 17px;
  font-weight: 500;
}

button:hover {
  left: 0;
  background: #7EA578;
}

button .input-data input{
  background: none;
  border: none;
  color: #fff;
  font-size: 17px;
  font-weight: 500;
  letter-spacing: 1px;
  cursor: pointer;
  position: relative;
  z-index: 2;
}

@media (max-width: 1000px) {
    .container {
    max-width: 85%;
    width: 85%;
    padding: 40px 16px 48px 16px;
    
    z-index: 1;
  }

  .text {
    font-size: 24px;
    text-align: left;
    line-height: 40px;
  }

  form {
    padding: 10px 0 0 0;
  }

  .form-row {
    display: block;
  }

  form .form-row .input-data {
    margin: 0 auto;
    width: 88%;
  }

  button .input-data {
    width: 100%!important;
  }

    button {
    width: 100%!important;
  }
}
</style>