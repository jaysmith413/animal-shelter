<template>
  <div class="home">
    <div class="page-title">
      <h1>Home</h1>
    </div>
     <div class="page-title2">
      <h2>Browse our available pets below!</h2>
    </div>
    <table>
      <tr v-for="pet in pets" v-bind:key="pet.id">
        <div id="card">
          <img v-bind:src="pet.petPicture">
        <td class="pet-name">{{pet.name}}</td>
        <td>Age: {{pet.age}}</td>
        <td>{{pet.type}}</td>
        <td>Adoption Status: {{pet.adopted}}</td>
        <td>Gender: {{pet.gender}}</td>
        <td>Special Needs: {{pet.specialNeeds}}</td>
        <td>Personality Traits: {{pet.personalityTraits}}</td>
        <td>Good with Kids: {{pet.goodWithKids}}</td>
        <td>Good with Other Animals: {{pet.goodWithOtherAnimals}}</td>
        <button> 
          <router-link v-bind:to="{ name: 'updatePet', params: {id: pet.id} }" v-if="$store.state.token != ''" class="button" v-bind:pet="pet" style="text-decoration: none; color: #FFFFFF; font-weight: bold; font-size: 1rem;">Update Pet</router-link>
        </button>
        </div>
      </tr>
    </table>
  </div>
</template>

<script>

import PetService from '../services/PetService.js';

export default {
  name: "home",
  data(){
    return {
      pets:[]
    };
  },
  created(){
    PetService.getAllPets().then(
      (resp) => {
        this.pets = resp.data;
      }
    );
  },
};
</script>

<style scoped>
.home {
  background-image: url(../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png);
  background-repeat: repeat;
  margin: 0;
  padding: 0;
}

.page-title {
  background: #ffffff;
  border-radius: 24px;
  text-decoration: none;
  align-items: center;
  width: 400px;
  margin: 0 auto;
}

.page-title2 {
  background: #ffffff;
  border-radius: 24px;
  text-decoration: none;
  align-items: center;
  margin: 0 auto;
  width: 650px;
}

h1 {
  text-align: center;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  font-size: 50px;
  color: #5E8558;
  margin: 0; 
  margin-top: 30px;
}

h2 {
  text-align: center;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  font-size: 35px;
  color: #5E8558;
  margin: 0; 
  margin-top: 20px;
}

button {
  background-color: #5E8558;
  padding: 16px 0;
  margin-top: 24px;
  border-radius: 8px;
  border: none;
}

button:hover {
  background-color: #7EA578;
}

table {
  font-family: 'Poppins', sans-serif;
  text-transform: capitalize;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: stretch;
}

tr {
display: flex;
align-items: stretch;
}

img {
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