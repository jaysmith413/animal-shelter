<template>
  <div class="home">
    <h1>Home</h1>
    <table>
      <tr v-for="pet in pets" v-bind:key="pet.id">
        <div id="card">
          <img v-bind:src="pet.image">
        <td class="pet-name">{{pet.name}}</td>
        <td>Age: {{pet.age}}</td>
        <td>{{pet.type}}</td>
        <td>Adoption Status: {{pet.adopted}}</td>
        <td>Gender: {{pet.gender}}</td>
        <td>Special Needs: {{pet.specialNeeds}}</td>
        <td>Personality Traits: {{pet.personalityTraits}}</td>
        <td>Good with Kids: {{pet.goodWithKids}}</td>
        <td>Good with Other Animals: {{pet.goodWithOtherAnimals}}</td>
        </div>

      </tr>
    </table>
  </div>
</template>

<script>

import petService from '../services/PetService.js';

export default {
  name: "home",
  data(){
    return {
      pets:[]
    }
  },
  created(){
    petService.getAllPets().then(
      (resp) => {
        this.pets = resp.data;
      }
    );
  }
};
</script>

<style scoped>
table{
  font-family: Arial, Helvetica, sans-serif;
  text-transform: capitalize;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
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
}

h1{
  text-align: center;
}

.pet-name {
  font-size: 1.5rem;
  font-weight: bold;
  color: #46ACC2;
}
</style>