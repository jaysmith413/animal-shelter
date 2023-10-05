<template>
  <div class="password-container">
    <div class="container" style="margin-bottom: 64px;">
      <div class="text">
        Please Create a New Password
    </div>
      <form v-on:submit.prevent="registerNewPassword">
        <div class="form-row">
            <div class="input-data">
            <input type="password" id="password" v-model="user.password"  />
            <div class="underline"></div>
            <label for="password">New Password</label>
          </div>
        </div>
        <div class="form-row">
          <div class="input-data">         
            <input type="password" id="confirmPassword" v-model="user.confirmPassword"  />
            <div class="underline"></div>
            <label for="confirmPassword">Confirm Password</label>
          </div>
        </div>
          <button type="submit">Submit New Password</button>
      </form>
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
import AuthService from '../services/AuthService';
export default {
    data() {
    return {
      user: {
        id: this.$store.state.user.id,
        username: this.$store.state.user.username,
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    }
 },
 methods: {
    registerNewPassword() {
        if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        AuthService
        .changePassword(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.state.user.hasLoggedIn = true
            this.$router.push({
                path: '/logout',
                
              });
          }
        })
      }
    }
 }
}
</script>

<style scoped>
*{
  margin: 0;
  padding: 0;
  outline: none;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}

.password-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-family: 'Poppins', sans-serif;
  background-image: url(../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png);
}

.container {
  max-width: 60%;
  width: 60%;
  background-color: #FFFFFF;
  padding: 64px 40px 64px 40px;
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
  margin-left: 18px;
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
  margin: 16px 0 0 18px;
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

.empty{
  display: flex;
  flex-direction: row;
}

@media (max-width: 1000px) {
  .container {
    max-width: 85%;
    width: 85%;
    padding: 16px 16px 0 16px;
    margin-top: -450px;
    z-index: 1;
  }

  .text{
    font-size: 24px;
    text-align: left;
    line-height: 40px;
    margin-left: 8px;
  }

  form {
    padding: 10px 0 0 0;
  }

  .form-row{
    display: block;
  }

  form .form-row .input-data{
    margin: 0 auto;
    width: 88%;
  }

  .other-padding {
    padding-top: 24px;
  }

  .submit-btn .input-data{
    width: 100%!important;
  }
}

</style>