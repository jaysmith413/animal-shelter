<template>
  <div class="adopted">
    <div class="page-title">
      <h1>Adopted Pets</h1>
      <!-- <h2>Let's celebrate these furry friends who found their forever home!</h2> -->
    </div>
    <div class="page-title2">
      <h2>Let's celebrate these furry friends who found their forever home!</h2>
    </div>
    <table>
      <tr v-for="adopted in adopt" v-bind:key="adopted.id">
        <div id="card">
          <img v-bind:src="adopted.image">
        <td class="pet-name">{{adopted.name}}</td>
        <td>Age: {{adopted.age}}</td>
        <td>{{adopted.type}}</td>
        <!-- <td>Adoption Status: {{adopted.adopted}}</td> -->
        <td>Gender: {{adopted.gender}}</td>
        <td>Special Needs: {{adopted.specialNeeds}}</td>
        <td>Personality Traits: {{adopted.personalityTraits}}</td>
        <td>Good with Kids: {{adopted.goodWithKids}}</td>
        <td>Good with Other Animals: {{adopted.goodWithOtherAnimals}}</td>
        </div>
      </tr>
    </table>
  </div>
</template>

<script>

import AdoptedService from '../services/AdoptedService';

export default {
 name: "adopted",
  data(){
    return {
      adopt:[]
    }
  },
  created(){
    AdoptedService.getAdoptedPets().then(
      (resp) => {
        this.adopt = resp.data;
      }
    );
  }
}
</script>

<style scoped>

.adopted{
  background-image: url(../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png);
  background-repeat: repeat;
  margin: 0;
  padding: 0;
}

.page-title{
  background: #ffffff;
  border-radius: 24px;
  text-decoration: none;
  align-items: center;
  width: 400px;
  margin: 0 auto;
}

.page-title2{
  background: #ffffff;
  border-radius: 24px;
  text-decoration: none;
  align-items: center;
  margin: 0 auto;
  width: 1200px;
}

h1{
  text-align: center;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  font-size: 50px;
  color: #5E8558;
  margin: 0; 
  margin-top: 20px;
}

h2{
  text-align: center;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  font-size: 35px;
  color: #5E8558;
  margin: 0; 
  margin-top: 20px;
}

table{
  font-family: 'Poppins', sans-serif;
  text-transform: capitalize;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: stretch;
}

tr{
display: flex;
align-items: stretch;
}

img{
  height: 350px;
  width: 350px;
  overflow: hidden;
  object-fit: cover;
}

#card{
  box-shadow: rgba(149, 157, 165, 0.2) 0px 8px 24px;
  margin: 24px;
  padding: 24px;
  display: flex;
  flex-direction: column;
  border-radius: 25px;
  background-color: #ffffff;
  text-align: left;
  table-layout: fixed;
  word-wrap: break-word;
  height: auto;
  align-items: stretch;
}

td{
  max-width: 350px;
}


.pet-name {
  font-size: 1.5rem;
  margin-top: 16px;
  margin-bottom: 8px;
  font-weight: bold;
  color: #5E8558;
  font-family: "Poppins", sans-serif;
  text-decoration: underline;
}

</style>