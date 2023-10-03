<template>
<div class="application-container">
  <div class="container" style="margin-bottom: 64px;">
   <div class="text">
      Volunteer Application
   </div>
   <!-- Personal Information Block -->
   <form v-on:submit.prevent="submitForm">
      <div class="form-row">
         <div class="input-data">
            <input type="text" required id="FirstName" v-model="application.firstName">
            <div class="underline"></div>
            <label for="" style="opacity: 70%;">First Name</label>
         </div>
      </div>
      <div class="form-row">
         <div class="input-data">
            <input type="text" required id="lastName" v-model="application.lastName">
            <div class="underline"></div>
            <label for="" style="opacity: 70%;">Last Name</label>
         </div>
      </div>
      <div class="form-row">
         <div class="input-data">
            <input type="text" required id="emailAddress" v-model="application.emailAddress">
            <div class="underline"></div>
            <label for="" style="opacity: 70%;">Email Address</label>
         </div>
      </div>
      <div class="form-row">
         <div class="input-data">
            <input type="text" required id="phone-number" v-model="application.phoneNumber">
            <div class="underline"></div>
            <label for="" style="opacity: 70%;">Phone Number</label>
         </div>
      </div>
      <div class="form-row" style="padding-top: 48px;">
        <div class='field'>
          <label for="over-eighteen" class="subtitle">Are you over the age of 18?</label>
          <ul class='checkboxes'>
            <li class='checkbox' :class="{ 'selected-checkbox': application.overEighteen === 'true' }" @click="toggleOverEighteen('true')">
              <input class='checkbox-input' id='true' name='overEighteen' type='radio' value='true' v-model="application.overEighteen">
              <label class='checkbox-label' for='true'>
                <span @click="toggleOverEighteen('true')">Yes</span>
              </label>
            </li>

            <li class='checkbox' :class="{ 'selected-checkbox': application.overEighteen === 'false' }" @click="toggleOverEighteen('false')">
              <input class='checkbox-input' id='false' name='overEighteen' type='radio' value='false' v-model="application.overEighteen">
              <label class='checkbox-label' for='false'>
                <span @click="toggleOverEighteen('false')">No</span>
              </label>
            </li>
          </ul>
        </div>
      </div>
      <!-- Do You Have Allergies Block -->
        <div class="form-row" style="padding-top: 48px;">
         <div class='field'>
            <label class='label' style="font-weight: bold; font-size:16px; font-size: 24px;">Allergies?</label>
              <ul class='checkboxes'>
                <li class='checkbox' :class="{ 'selected-checkbox': application.dander }" @click="toggleDander">
                  <input class='checkbox-input' id='choice-A' name='choice' type='checkbox' value='A' v-model="application.dander">
                  <label class='checkbox-label' for='choice-A'>
                    <span @click="toggleDander">Dander</span>
                  </label>
                </li>
                <li class='checkbox' :class="{ 'selected-checkbox': application.pollen }" @click="application.pollen = !application.pollen">
                  <input class='checkbox-input' id='choice-B' name='choice' type='checkbox' value='B' v-model="application.pollen">
                  <label class='checkbox-label' for='choice-B'>
                    <span @click="application.pollen = !application.pollen">Pollen</span>
                  </label>
                </li>
                <li class='checkbox' :class="{ 'selected-checkbox': application.mold }" @click="application.mold = !application.mold">
                  <input class='checkbox-input' id='choice-C' name='choice' type='checkbox' value='C' v-model="application.mold">
                  <label class='checkbox-label' for='choice-C'>
                    <span @click="application.mold = !application.mold">Mold</span>
                  </label>
                </li>
                <li class='checkbox' :class="{ 'selected-checkbox': application.householdCleaners }" @click="application.householdCleaners = !application.householdCleaners">
                  <input class='checkbox-input' id='choice-D' name='choice' type='checkbox' value='D' v-model="application.householdCleaners">
                  <label class='checkbox-label' for='choice-D'>
                    <span @click="application.householdCleaners = !application.householdCleaners">House Cleaners</span>
                  </label>
                </li>
              </ul>
          </div>
        </div>
        <div class="form-row other-padding">
          <div class="input-data">
            <input type="text" v-model="application.allergies">
            <br />
            <div class="underline"></div>
            <label for="" style="opacity: 70%;">If your have any allergies that aren't listed, please list them below.</label>
            <br />
          </div>
        </div>
        <!-- What Skills Do You Have Block -->
        <div class="form-row">   
          <div class='field'>
            <label class='label' style="font-weight: bold;font-size: 24px;">Skills</label>
              <ul class='checkboxes'>
                <li class='checkbox' :class="{ 'selected-checkbox': application.animalCare }" @click="toggleAnimalCare">
                  <input class='checkbox-input' id='choice-0' name='choice' type='checkbox' value='0' v-model="application.animalCare">
                  <label class='checkbox-label' for='choice-0'>
                    <span @click="toggleAnimalCare">Animal Care</span>
                  </label>
                </li>
                <li class='checkbox' :class="{ 'selected-checkbox': application.grooming }" @click="toggleGrooming">
                  <input class='checkbox-input' id='choice-1' name='choice' type='checkbox' value='1' v-model="application.grooming">
                  <label class='checkbox-label' for='choice-1'>
                    <span @click="toggleGrooming">Grooming</span>
                  </label>
                </li>
                <li class='checkbox' :class="{ 'selected-checkbox': application.cleaningKennels }" @click="toggleCleaningKennels">
                  <input class='checkbox-input' id='choice-2' name='choice' type='checkbox' value='2' v-model="application.cleaningKennels">
                  <label class='checkbox-label' for='choice-2'>
                    <span @click="toggleCleaningKennels">Cleaning Kennels</span>
                  </label>
                </li>
                <li class='checkbox' :class="{ 'selected-checkbox': application.walkingDogs }" @click="toggleWalkingDogs">
                  <input class='checkbox-input' id='choice-3' name='choice' type='checkbox' value='3' v-model="application.walkingDogs">
                  <label class='checkbox-label' for='choice-3'>
                    <span @click="toggleWalkingDogs">Walking Dogs</span>
                  </label>
                </li>
                <li class='checkbox' :class="{ 'selected-checkbox': application.catWhisperer }" @click="toggleCatWhisperer">
                  <input class='checkbox-input' id='choice-4' name='choice' type='checkbox' value='4' v-model="application.catWhisperer">
                  <label class='checkbox-label' for='choice-4'>
                    <span @click="toggleCatWhisperer">Cat Whisperer</span>
                  </label>
                </li>
                <li class='checkbox' :class="{ 'selected-checkbox': application.customerService }" @click="toggleCustomerService">
                  <input class='checkbox-input' id='choice-5' name='choice' type='checkbox' value='5' v-model="application.customerService">
                  <label class='checkbox-label' for='choice-5'>
                    <span @click="toggleCustomerService">Customer Service</span>
                  </label>
                </li>
                <li class='checkbox' :class="{ 'selected-checkbox': application.liftOverThirtyPounds }" @click="toggleLiftOverThirtyPounds">
                  <input class='checkbox-input' id='choice-6' name='choice' type='checkbox' value='6' v-model="application.liftOverThirtyPounds">
                  <label class='checkbox-label' for='choice-6'>
                    <span @click="toggleLiftOverThirtyPounds">Can lift over 30lbs</span>
                  </label>
                </li>
                <li class='checkbox' :class="{ 'selected-checkbox': application.laundry }" @click="toggleLaundry">
                  <input class='checkbox-input' id='choice-7' name='choice' type='checkbox' value='7' v-model="application.laundry">
                  <label class='checkbox-label' for='choice-7'>
                    <span @click="toggleLaundry">Laundry</span>
                  </label>
                </li>
                <li class='checkbox' :class="{ 'selected-checkbox': application.stockingSupplies }" @click="toggleStockingSupplies">
                  <input class='checkbox-input' id='choice-8' name='choice' type='checkbox' value='8' v-model="application.stockingSupplies">
                  <label class='checkbox-label' for='choice-8'>
                    <span @click="toggleStockingSupplies">Stocking Supplies</span>
                  </label>
                </li>
              </ul>
            </div>
          </div>
          <div class="form-row other-padding">
            <div class="input-data">
              <input type="text" v-model="application.skills">
              <br />
              <div class="underline"></div>
              <label for="" style="opacity: 70%;">If a relevant skill you have isn't listed, please list them below.</label>
              <br />
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
            </div>
        </div>
   </form>
  </div>
</div>
</template>

<script>
import VolunteerService from '../services/VolunteerService';

export default {
data() {
return {
    application: {
        overEighteen: false,
        firstName: '',
        lastName: '',
        animalCare: false,
        grooming: false,
        cleaningKennels: false,
        walkingDogs: false,
        catWhisperer: false,
        customerService: false,
        liftOverThirtyPounds: false,
        laundry: false,
        stockingSupplies: false,
        skills: '',
        emailAddress: '',
        phoneNumber: '',
        mold: false,
        dander: false,
        pollen: false,
        householdCleaners: false,
        allergies: '',

        }
    }
},
computed: {
  isCheckboxSelected() {
    return (field) => {
      return this.application[field];
    };
  },
},
methods: {
    submitForm() {
      VolunteerService.processApplication(this.application).then(
          response => {if(response.status == 200) {
              window.alert('Application added')
              this.$router.push("/")
              }
           })
        },
    toggleOverEighteen(value) {
      this.application.overEighteen = value;
    },
    toggleDander() {
    this.application.dander = !this.application.dander;
    },
    togglePollen() {
      this.application.pollen = !this.application.pollen;
    },
    toggleMold() {
      this.application.mold = !this.application.mold;
    },
    toggleHouseholdCleaners() {
      this.application.householdCleaners = !this.application.householdCleaners;
    },
    toggleAnimalCare() {
      this.application.animalCare = !this.application.animalCare;
    },
    toggleGrooming() {
      this.application.grooming = !this.application.grooming;
    },
    toggleCleaningKennels() {
      this.application.cleaningKennels = !this.application.cleaningKennels;
    },
    toggleWalkingDogs() {
      this.application.walkingDogs = !this.application.walkingDogs;
    },
    toggleCatWhisperer() {
      this.application.catWhisperer = !this.application.catWhisperer;
    },
    toggleCustomerService() {
      this.application.customerService = !this.application.customerService;
    },
    toggleLiftOverThirtyPounds() {
      this.application.liftOverThirtyPounds = !this.application.liftOverThirtyPounds;
    },
    toggleLaundry() {
      this.application.laundry = !this.application.laundry;
    },
    toggleStockingSupplies() {
      this.application.stockingSupplies = !this.application.stockingSupplies;
    },
  }
}
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

body{
  margin: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  padding: 10px;
  font-family: 'Poppins', sans-serif;
}

.application-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  font-family: 'Poppins', sans-serif;
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
  background-color: #FFFFFF;
  padding: 64px 40px 40px 40px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
  border-radius: 8px;
  margin: 0 auto;
  margin-top: 60px; /* Adjust this value to control the vertical position of the form */
  z-index: 1;
}

.text{
  text-align: left;
  font-size: 48px;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  color: #5E8558;
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
  border: 1px solid #0070BB;
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
  background-color: #CEDED0;
}

.selected-checkbox {
  background-color: #775576;
  color: #FFFFFF;
  cursor: pointer;
}

.checkbox-label:hover, .checkbox:hover {
  background-color: #775576;
  color: #FFFFFF;
}

.checkbox-label {
  flex: 1;
  margin-left: 8px;
}

.checkbox-input {
  width: auto;
  margin-bottom: 0;
}

input[type="checkbox"]  {
   display: none;
}

input[type="radio"]  {
   display: none;
}

form .form-row .input-data{
  width: 100%;
  height: 40px;
  margin: 0 20px;
  position: relative;
}
form .form-row .textarea{
  height: 70px;
}
.input-data input,
.textarea textarea{
  display: block;
  width: 100%;
  height: 100%;
  border: none;
  font-size: 16px;
  border-bottom: 2px solid rgba(0,0,0, 0.12);
}
.input-data input:focus ~ label, .textarea textarea:focus ~ label,
.input-data input:valid ~ label, .textarea textarea:valid ~ label{
  transform: translateY(-20px);
  font-size: 16px;
  color: #775576;
}
.textarea textarea{
  resize: none;
  padding-top: 10px;
}
.input-data label{
  position: absolute;
  pointer-events: none;
  bottom: 10px;
  font-size: 16px;
  transition: all 0.3s ease;
}
.textarea label{
  width: 100%;
  bottom: 40px;
  background: #fff;
}
.input-data .underline{
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
  background: #8E37D7;
  transform: scaleX(0);
  transform-origin: center;
  transition: transform 0.3s ease;
}
.input-data input:focus ~ .underline:before,
.input-data input:valid ~ .underline:before,
.textarea textarea:focus ~ .underline:before,
.textarea textarea:valid ~ .underline:before{
  transform: scale(1);
}

.submit-btn .input-data {
  overflow: hidden;
  height: 56px!important;
  width: 25%!important;
  border-radius: 8px;
  margin: 0!important;
}

.submit-btn .input-data .inner {
  height: 100%;
  width: 300%;
  position: absolute;
  background-color: #5E8558;
  transition: all 0.4s;
}

.submit-btn .input-data:hover .inner {
  left: 0;
  background: #7EA578;
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

  .text{
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

  .form-row{
    display: block;
  }

  form .form-row .input-data{
    margin: 0 auto;
    width: 88%;
  }

  .other-padding {
    padding-top: 24px;
  }

  .submit-btn .input-data{
    width: 100%!important;
  }
}
</style>

