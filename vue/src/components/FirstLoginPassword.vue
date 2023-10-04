<template>
  <div>
    <div class="text">
      Please Create a New Password
   </div>
<form v-on:submit.prevent="registerNewPassword">
    <div class="form-input-group">
        <label for="password">New Password</label>
        <input type="password" id="password" v-model="user.password"  />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword"  />
      </div>
      <button type="submit">Submit New Password</button>
</form>
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

<style>
.text{
  text-align: left;
  font-size: 48px;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  color: #5E8558;
  margin-left: 24px;
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

  .checkbox {
    width: 95%;
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