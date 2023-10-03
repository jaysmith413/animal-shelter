<template>
  <div class="addPet-container">
  <!-- <div class="image-container">
    <img src="../img/green-cartoon-animal-header.png" alt="Purple Cartoon Animals Header" class="image-container">
  </div> -->
  <div class="container" style="margin-bottom: 64px;">
   <div class="text">
      Add Pet
   </div>
   <!-- Pet Information Block -->

   <form v-on:submit.prevent="submitForm">
      <div class="form-row">
        <div class="input-data">
          <input type="text" required id="PetName" v-model="addPet.petName">
            <div class="underline"></div>
          <label for="" style="opacity: 70%;">Name</label>
        </div>
      </div>
      
      <div class="form-row">
        <div class="input-data">
          <input type="text" required id="petType" v-model="addPet.petType">
            <div class="underline"></div>
              <label for="" style="opacity: 70%;">Type</label>
            </div>
          </div>
      <div class="form-row">
        <div class="input-data">
          <input type="text" required id="petAge" v-model="addPet.petAge">
            <div class="underline"></div>
              <label for="" style="opacity: 70%;">Age</label>
            </div>
          </div>
          
        <div class="form-row">
        <div class="input-data">
            <input type="text" required id="petGender" v-model="addPet.petGender">
            <div class="underline"></div>
            <label for="" style="opacity: 70%;">Gender</label>
         </div>
         </div>
         
         <div class="form-row">
         <div class="input-data">
            <input type="text" required id="petSpecialNeeds" v-model="addPet.petSpecialNeeds">
            <div class="underline"></div>
            <label for="" style="opacity: 70%;">Special Needs</label>
         </div>
         </div>
         <div class="form-row" style="padding-top: 48px;">
        <div class='field'>
          <label for="adopted" class="subtitle">Adopted?</label>
          <ul class='checkboxes'>
            <li class='checkbox' v-bind:class="{ 'selected-checkbox': addPet.adopted }" v-on:click="addPet.adopted = !addPet.adopted">
              <input class='checkbox-input' id='true' name='true' type='radio' value='true' v-model="addPet.adopted">
              <label class='checkbox-label' for='true'>Yes</label>
            </li>
                     <li class='checkbox' v-bind:class="{ 'selected-checkbox': addPet.adopted }" v-on:click="addPet.adopted = !addPet.adopted">
              <input class='checkbox-input' id='false' name='false' type='radio' value='false' v-model="addPet.adopted">
              <label class='checkbox-label' for='false'>No</label>
            </li>
            </ul>
        </div>
      </div>
      <div class="form-row">
         <div class="input-data">
            <input type="text" required id="petPicture" v-model="addPet.petPicture">
            <div class="underline"></div>
            <label for="" style="opacity: 70%;">Picture</label>
         </div>
         </div>
         <div class="form-row">
         <div class="input-data">
            <input type="text" required id="petPersonalityTraits" v-model="addPet.petPersonalityTraits">
            <div class="underline"></div>
            <label for="" style="opacity: 70%;">Personality Traits</label>
         </div>
         </div>
         
<div class="form-row" style="padding-top: 48px;">
        <div class='field'>
          <label for="goodWithKids" class="subtitle">Good With Kids?</label>
          <ul class='checkboxes'>
            <li class='checkbox' v-bind:class="{ 'selected-checkbox': addPet.goodWithKids }" v-on:click="addPet.goodWithKids = !addPet.goodWithKids">
              <input class='checkbox-input' id='true' name='true' type='radio' value='true' v-model="addPet.goodWithKids">
              <label class='checkbox-label' for='true'>Yes</label>
            </li>
                     <li class='checkbox' v-bind:class="{ 'selected-checkbox': addPet.goodWithKids }" v-on:click="addPet.goodWithKids = !addPet.goodWithKids">
              <input class='checkbox-input' id='false' name='false' type='radio' value='false' v-model="addPet.goodWithKids">
              <label class='checkbox-label' for='false'>No</label>
            </li>
            </ul>
        </div>
      </div>
      
      <div class="form-row" style="padding-top: 48px;">
        <div class='field'>
          <label for="goodWithOtherAnimals" class="subtitle">Good With Other Animals?</label>
          <ul class='checkboxes'>
            <li class='checkbox' v-bind:class="{ 'selected-checkbox': addPet.goodWithOtherAnimals }" v-on:click="addPet.goodWithOtherAnimals = !addPet.goodWithOtherAnimals">
              <input class='checkbox-input' id='true' name='true' type='radio' value='true' v-model="addPet.goodWithOtherAnimals">
              <label class='checkbox-label' for='true'>Yes</label>
            </li>
                     <li class='checkbox' v-bind:class="{ 'selected-checkbox': addPet.goodWithOtherAnimals }" v-on:click="addPet.goodWithOtherAnimals = !addPet.goodWithOtherAnimals">
              <input class='checkbox-input' id='false' name='false' type='radio' value='false' v-model="addPet.goodWithOtherAnimals">
              <label class='checkbox-label' for='false'>No</label>
            </li>
            </ul>
        </div>
        </div>
   



          <!-- Submit Button Block -->
          <div class="form-row">
            <div class="input-data textarea">
                <div class="form-row submit-btn">
                  <div class="input-data">
                      <div class="inner"></div>
                      <input type="submit" value="submit">
                  </div>
  </div>
            </div></div>
  </form>
  </div>
  </div>
</template>

<script>
import AddPet from "../services/PetService.js";

export default {
  data() {
    return {
      addPet: {
        petName: "",
        petType: "",
        petAge: "",
        petGender: "",
        petSpecialNeeds: "",
        adopted: "",
        petPicture: "",
        personalityTraits: "",
        goodWithKids: "",
        goodWithOtherAnimals: "",
      },
    };
  },
  computed: {
    isCheckboxSelected() {
      return (field) => {
        return this.addPet[field];
      };
    },
  },
  methods: {
    submitForm() {
      AddPet.processAdd(this.addPet).then((response) => {
        if (response.status == 200) {
          window.alert("Pet added");
          this.$router.push("/");
        }
      });
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap");

* {
  margin: 0;
  padding: 0;
  outline: none;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}

body {
  margin: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  padding: 10px;
  font-family: "Poppins", sans-serif;
}

/* .image-container {
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
} */

.addPet-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  font-family: "Poppins", sans-serif;
  background-image: url(../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png);
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

.container {
  max-width: 60%;
  width: 60%;
  background-color: #ffffff;
  padding: 64px 40px 40px 40px;
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
  font-family: "Poppins", sans-serif;
  color: #5e8558;
  margin-left: 24px;
}

form {
  padding: 8px 0 0 0;
}

.form-row {
  display: flex;
  margin: 32px 0;
}

.other-padding {
  padding-top: 8px;
}

#over-eighteen {
  width: 15px;
  height: 15px;
  display: inline-block;
  margin-top: 10px;
  margin-right: 5px;
  margin-left: 225px;
  border: 1px solid #0070bb;
}

.field {
  margin-left: 20px;
}

.checkbox {
  display: inline-block;
  align-items: center;
  margin: 16px 10px 0 0;
  background-color: #f1f1f1;
  padding: 16px;
  border-radius: 8px;
  width: 225px;
}

.checkbox:hover {
  background-color: #ceded0;
}

.selected-checkbox {
  background-color: #ceded0;
}

.checkbox-label {
  flex: 1;
  margin-left: 8px;
}

.checkbox-input {
  width: auto;
  margin-bottom: 0;
}

input[type="checkbox"] {
  display: none;
}

form .form-row .input-data {
  width: 100%;
  height: 40px;
  margin: 0 20px;
  position: relative;
}
form .form-row .textarea {
  height: 70px;
}
.input-data input,
.textarea textarea {
  display: block;
  width: 100%;
  height: 100%;
  border: none;
  font-size: 16px;
  border-bottom: 2px solid rgba(0, 0, 0, 0.12);
}
.input-data input:focus ~ label,
.textarea textarea:focus ~ label,
.input-data input:valid ~ label,
.textarea textarea:valid ~ label {
  transform: translateY(-20px);
  font-size: 16px;
  color: #775576;
}
.textarea textarea {
  resize: none;
  padding-top: 10px;
}
.input-data label {
  position: absolute;
  pointer-events: none;
  bottom: 10px;
  font-size: 16px;
  transition: all 0.3s ease;
}
.textarea label {
  width: 100%;
  bottom: 40px;
  background: #fff;
}
.input-data .underline {
  position: absolute;
  bottom: 0;
  height: 2px;
  width: 100%;
}
.input-data .underline:before {
  position: absolute;
  content: "";
  height: 2px;
  width: 100%;
  background: #8e37d7;
  transform: scaleX(0);
  transform-origin: center;
  transition: transform 0.3s ease;
}
.input-data input:focus ~ .underline:before,
.input-data input:valid ~ .underline:before,
.textarea textarea:focus ~ .underline:before,
.textarea textarea:valid ~ .underline:before {
  transform: scale(1);
}

.submit-btn .input-data {
  overflow: hidden;
  height: 56px !important;
  width: 25% !important;
  border-radius: 8px;
  margin: 0 !important;
}

.submit-btn .input-data .inner {
  height: 100%;
  width: 300%;
  position: absolute;
  background-color: #5e8558;
  transition: all 0.4s;
}

.submit-btn .input-data:hover .inner {
  left: 0;
  background: #7ea578;
}

.submit-btn .input-data input {
  background: none;
  border: none;
  color: #fff;
  font-size: 17px;
  font-weight: 500;
  text-transform: uppercase;
  letter-spacing: 1px;
  cursor: pointer;
  position: relative;
  z-index: 2;
}

@media (max-width: 1000px) {
  .container {
    max-width: 85%;
    width: 85%;
    padding: 16px 16px 0 16px;
    margin-top: -450px;
    z-index: 1;
  }

  .text {
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

  .form-row {
    display: block;
  }

  form .form-row .input-data {
    margin: 0 auto;
    width: 88%;
  }

  .other-padding {
    padding-top: 24px;
  }

  .submit-btn .input-data {
    width: 100% !important;
  }
}
</style>

