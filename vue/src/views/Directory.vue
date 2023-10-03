<template>
  <div class="directory-container">
    <div class="container" style="margin-bottom: 64px;">
      <div class="text">
        Volunteer Directory
      </div>
      <table>
        <thead>
          <tr>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Email Address</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in users" :key="user.id">
            <td data-label="First Name">{{ user.firstName }}</td>
            <td data-label="Last Name">{{ user.lastName }}</td>
            <td data-label="Phone Number">{{ user.phoneNumber }}</td>
            <td data-label="Email Address">{{ user.emailAddress }}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="background">
      <img src="../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png" alt="nonstretch">
      <img src="../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png" alt="2">
      <img src="../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png" alt="3">
    </div>
    <div class="background">
      <img src="../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png" alt="nonstretch">
      <img src="../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png" alt="2">
      <img src="../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png" alt="3">
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
        });
      },
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

body {
  margin: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  padding: 10px;
  font-family: 'Poppins', sans-serif;
}

.background{
  display: flex;
  flex-direction: column;
}

.directory-container {
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
  padding: 40px 40px 40px 40px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
  border-radius: 8px;
  margin: 0 auto;
  margin-top: 60px; /* Adjust this value to control the vertical position of the form */
  z-index: 1;
}

.text {
  text-align: left;
  font-size: 48px;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  color: #5E8558;
  margin-left: 24px;
  padding-bottom: 24px;
}

table {
  border: 1px solid #ccc;
  border-collapse: collapse;
  margin: 0;
  padding: 0;
  width: 100%;
  table-layout: fixed;
}

table caption {
  font-size: 1.5em;
  margin: .5em 0 .75em;
}

table tr {
  background-color: #f8f8f8;
  border: 1px solid #ddd;
  padding: .35em;
}

table th,
table td {
  padding: .625em;
  text-align: center;
}

table th {
  font-size: .85em;
  letter-spacing: .1em;
  text-transform: uppercase;
  background-color: #FFFFD1;
}

tbody {
   word-wrap: break-word;
}

@media screen and (max-width: 600px) {
  table {
    border: 0;
  }

  table caption {
    font-size: 1.3em;
  }
  
  table thead {
    border: none;
    clip: rect(0 0 0 0);
    height: 1px;
    margin: -1px;
    overflow: hidden;
    padding: 0;
    position: absolute;
    width: 1px;
  }
  
  table tr {
    border-bottom: 3px solid #ddd;
    display: block;
    margin-bottom: .625em;
  }
  
  table td {
    border-bottom: 1px solid #ddd;
    display: block;
    font-size: .8em;
    text-align: right;
  }
  
  table td::before {
    content: attr(data-label);
    float: left;
    font-weight: bold;
    text-transform: uppercase;
  }
  
  table td:last-child {
    border-bottom: 0;
  }

  th {
    color: #8D6B94;
  }
}

@media (max-width: 1000px) {
  .container {
    max-width: 85%;
    width: 85%;
    padding: 16px 16px 16px 16px;
    z-index: 1;
  }

  .text {
    font-size: 24px;
    text-align: left;
    line-height: 40px;
    margin-left: 8px;
    padding-bottom: 16px;
  }

  table.directory {
    text-align: center;
    width: 100%;
    border-collapse: collapse;
    border-style: solid;
  }

  thead {
    border: 1px solid black;
    border-collapse: separate;
    padding: 8px;
    text-align: center;
  }
}
</style>