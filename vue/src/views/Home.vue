<template>
  <div class="home">
    <h1>Home</h1>
    <table>
      <tr v-for="pet in pets" v-bind:key="pet.id">
        
        <td>{{pet.age}}</td>
        <td>{{pet.name}}</td>
        <td>{{pet.type}}</td>
        <td>{{pet.adopted}}</td>
        <img v-bind:src="pet.image">
        
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
