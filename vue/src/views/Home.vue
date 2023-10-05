<template>
  <div class="home">
    <div class="page-title">
      <h1>Home</h1>
    </div>
     <div class="page-title2">
      <h2>Browse our available pets below!</h2>
    </div>
    <div id="showFilters">
      <button v-on:click.prevent="showForm = !showForm">Show Filters</button>
    </div>
    
    <table id="tblUsers">
      <tbody>
        <tr id="filterTable" v-show="showForm === true">
          <td>
            Species: <input type="text" id="speciesFilter" v-model="filter.type" />
          </td>
          <td>
            Gender: 
            <select id="genderFilter" v-model="filter.gender">
              <option value>Show All</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
            </select>
          </td>
         
          <td class="tblData">Good With Kids
            <input type="checkbox" id="good-with-kids" v-model="filter.goodWithKids" :value="true" />
            
          </td>
          <td class="tblData" id="data-pets">
            <label for="good-with-pets">Good with Pets</label>
            <input type="checkbox" id="good-with-pets" v-model="filter.goodWithOtherAnimals" :value="true" />
            
          </td> 
        </tr>
      </tbody>
    </table>
    <table>
      <tr v-for="pet in filteredList" v-bind:key="pet.id">
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
        <router-link v-bind:to="{ name: 'updatePet', params: {id: pet.id} }" v-if="$store.state.token != ''" class="button" v-bind:pet="pet"><button>Update Pet</button></router-link>
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
      showForm: false,
      filter: {
        type: "",
        gender: "",
        goodWithKids: null,
        goodWithOtherAnimals: null
      },
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
  computed: {
    filteredList() {
      let filteredPets = this.pets;
      if (this.filter.type != "") {
        filteredPets = filteredPets.filter((pet) =>
          pet.type
            .toLowerCase()
            .includes(this.filter.type.toLowerCase())
        );
      }
      if (this.filter.gender != "") {
        filteredPets = filteredPets.filter((pet) =>
          pet.gender === this.filter.gender
        );
      }
      if (this.filter.goodWithKids === true) {
        filteredPets = filteredPets.filter((pet) =>
          pet.goodWithKids === this.filter.goodWithKids
        );
      }
      if (this.filter.goodWithOtherAnimals === true) {
        filteredPets = filteredPets.filter((pet) =>
          pet.goodWithOtherAnimals == this.filter.goodWithOtherAnimals
            
        );
      }
      
      return filteredPets;
    }
  }
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
  text-decoration: none;
  color: #FFFFFF;
  font-weight: bold;
  font-size: 1rem;
  width: 100%;
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
  justify-content: space-between;
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

#tblUsers {
justify-content: center;
align-items: center;
margin-top: 24px;
background-color: #FFF4E9;
border-radius: 8px;
align-items: center;
width: 65%;
margin: 0 auto;
}

.tblData {
  display: flex;
  align-items: last baseline;
  margin: 5px;
  text-align: justify;
}

#showFilters {
 margin: 0 auto;
 width: 25%;
 margin-bottom: 24px;
}

#good-with-kids {
margin: 5px
}

#good-with-pets {
  margin: 5px
}

tbody {
  display: flex;
  flex-direction: column;
}

#speciesFilter {
  margin: 5px;
  padding: 0;
    height: 30px;
    position: relative;
    left: 0;
    outline: none;
    border: 1px solid #cdcdcd;
    border-color: rgba(0,0,0,.15);
    background-color: white;
    font-size: 16px;
}

#genderFilter {
  margin: 5px;
  padding: 0;
    height: 30px;
    position: relative;
    left: 0;
    outline: none;
    border: 1px solid #cdcdcd;
    border-color: rgba(0,0,0,.15);
    background-color: white;
    font-size: 16px;
}

:root {
  --form-control-color: rebeccapurple;
  --form-control-disabled: #959495;
}

*,
*:before,
*:after {
  box-sizing: border-box;
}

body {
  margin: 0;
}

.form-control {
  font-family: system-ui, sans-serif;
  font-size: 2rem;
  font-weight: bold;
  line-height: 1.1;
  display: grid;
  grid-template-columns: 1em auto;
  gap: 0.5em;
}

.form-control + .form-control {
  margin-top: 1em;
}

.form-control--disabled {
  color: var(--form-control-disabled);
  cursor: not-allowed;
}

input[type="checkbox"] {
  /* Add if not using autoprefixer */
  -webkit-appearance: none;
  /* Remove most all native input styles */
  appearance: none;
  /* For iOS < 15 */
  background-color: var(--form-background);
  /* Not removed via appearance */
  margin: 0;

  font: inherit;
  color: currentColor;
  width: 1.15em;
  height: 1.15em;
  border: 0.15em solid currentColor;
  border-radius: 0.15em;
  transform: translateY(-0.075em);

  display: grid;
  place-content: center;
}

input[type="checkbox"]::before {
  content: "";
  width: 0.65em;
  height: 0.65em;
  clip-path: polygon(14% 44%, 0 65%, 50% 100%, 100% 16%, 80% 0%, 43% 62%);
  transform: scale(0);
  transform-origin: bottom left;
  transition: 120ms transform ease-in-out;
  box-shadow: inset 1em 1em var(--form-control-color);
  /* Windows High Contrast Mode */
  background-color: CanvasText;
}

input[type="checkbox"]:checked::before {
  transform: scale(1);
}

input[type="checkbox"]:focus {
  outline: max(2px, 0.15em) solid currentColor;
  outline-offset: max(2px, 0.15em);
}

input[type="checkbox"]:disabled {
  --form-control-color: var(--form-control-disabled);

  color: var(--form-control-disabled);
  cursor: not-allowed;
}
</style>