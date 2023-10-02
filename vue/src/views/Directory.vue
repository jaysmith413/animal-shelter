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
              <td>{{ user.firstName }}</td>
              <td>{{ user.lastName }}</td>
              <td>{{ user.phoneNumber }}</td>
              <td>{{ user.emailAddress }}</td>
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
          this.users = resp.data;
      }
  );
        },
    };


</script>


<style scoped>


table.directory{
  width: 100%;
  border-collapse: collapse;
}

table.directory th, table.directory td{
  border: 1px solid black;
  padding: 8px;
  text-align: center;
}


@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');



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


/* Long container: */
/* .container {


  max-width: 60%;
  width: 60%;
  height: 1000px;
  background-color: #FFFFFF;
  padding: 64px 40px 32px 40px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
  border-radius: 8px;
  margin: 0 auto;
  margin-top: 500px;
  z-index: 1;
} */


/* Small container: */
.container {


  max-width: 60%;
  width: 60%;
  background-color: #FFFFFF;
  padding: 64px 40px 32px 40px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
  border-radius: 8px;
  margin: 0 auto;
  margin-top: -275px;
  z-index: 1;
}

.text{
  text-align: center;
  font-size: 24px;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  color: #5E8558;
  padding-top: -50px;
  margin-top: -35px;
  margin-bottom: 30px;
  line-height: 40px;
  margin-left: 8px;
  /* outline: none; */
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
    width: 100%;
    border-collapse: collapse;
    border-style: solid;
  }
 
thead{
    border: 1px solid black;
    border-collapse: separate;
    padding: 8px;
    text-align: center;
}


tbody{
    border: 1px solid black;
    border-collapse: separate;
    padding: 8px;
    text-align: center;
}


table.directory th,
table.directory td {
  outline-color: black;
  outline: solid;
  border: 1px solid black;
  padding: 8px;
  text-align: center;
}
}

</style>





