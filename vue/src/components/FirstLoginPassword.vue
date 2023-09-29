<template>
  <div>
    <h1>Please create a new password</h1>
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


</style>