<template>
<div class="directory-container">
  <div class="image-container">
    <img src="../img/cartoon-background.jpg" alt="Cat and Dog" class="image-container">
  </div>
  <div class="overlay">
  <div class="container" style="margin-bottom: 64px;">
   <div class="text">
      Volunteer Directory
   </div>
   <table class="directory">
       <thead>
           <tr>
               <th>First Name</th>
               <th>Last Name</th>
               <th>Phone Number</th>
               <th>Email Address</th>
           </tr>
       </thead>
       <tbody>
        <tr v-for="user in users" :key="user.id">
              <td>{{ user.first_name }}</td>
              <td>{{ user.last_name }}</td>
              <td>{{ user.phone_number }}</td>
              <td>{{ user.email_address }}</td>
        </tr>
       </tbody>
    </table>
   </div>
</div>
</div>


</template>

<script>

import ApprovedUsersService from '../services/ApprovedUsersService.js';

export default {
  name: "directory",
data() {
return {
  users: []
        };
    },

created() {
  ApprovedUsersService.getApprovedUsers().then(
      (resp) => {
          this.approvedUsers = resp.data;
      }
  );


        },
    };

</script>

<style scoped>

.directory-container{
    position: relative;
    overflow: hidden;
}

.form-input-group {
  margin-bottom: 1rem;
}

label {
  margin-right: 0.5rem;
}

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
}

.image-container {
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
}

.application-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  font-family: 'Poppins', sans-serif;
}

.image-container {
  width: 100%;
  max-height: 600px;
  overflow: hidden;
  position: relative;
}

img {
  width: 100%;
  height: 500px;
  object-fit: cover;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1; 
  
} 

.container {
      position: absolute;

  max-width: 60%;
  width: 60%;
  background-color: #FFFFFF;
  padding: 64px 40px 32px 40px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
  border-radius: 8px;
  margin: 0 auto;
  margin-top: 400px; 
  z-index: 1; 
}

.table-container{
    max-width: 60px;
    width: 60px;
    background-color: #FFFFFF;
    padding: 64px 40px 32px 40px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
    border-radius: 8px;
    margin: 0 auto;
    margin-top: -150px; /* Adjust this value to control the vertical position of the table */
    z-index: 1;
}

.text{
  text-align: center;
  font-size: 48px;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  color: #8E37D7;
  margin-left: 24px;
}

.field {
  margin-left: 20px;
}

.textarea textarea{
  resize: none;
  padding-top: 10px;
}

.textarea label{
  width: 100%;
  bottom: 40px;
  background: #fff;
}

@media (max-width: 700px) {
    .container {
    max-width: 85%;
    width: 85%;
    padding: 48px 16px 16px 16px;
    margin-top: -450px;
    z-index: 1;
  }
  .text{
    font-size: 30px;
    text-align: center;
    line-height: 40px;
    margin-left: 0;
  }
  

  table.directory {
      text-align: center;
      border-style: 1px solid black;
      border-color: black;
      text-align: center;
      border-collapse: collapse;
      outline: black;
      width: 100%;
      border: 1px solid black;
      border-width: 20px 20px 20px 20px;
  }

  table.directory th, table.directory td{
      border: 1px solid black;
      padding: 8px;
      text-align: center;
  }

  table.directory tr{
      border-bottom: 1px solid black;
  }

  tr.border-bottom{
      border-bottom: 1px solid black;
      padding: 1px;
      text-align: center;
      outline: black;
      outline-style: solid;
  }

  
}


</style>

