<template>
<div class="application-container">
  <div class="image-container">
    <img src="../img/cartoon-background.jpg" alt="Cat and Dog" class="image-container">
  </div>
  <div class="container" style="margin-bottom: 64px;">
   <div class="text">
      Volunteer Application
   </div>
   <form v-on:submit.prevent="submitForm">
      <div class="form-row">
         <div class="input-data">
            <input  type="text" required id="FirstName" v-model="application.firstName">
            <div class="underline"></div>
            <label for="" style="margin-left: 16px; opacity: 70%;">First Name</label>
         </div>
      </div>
      <div class="form-row">
         <div class="input-data">
            <input type="text" required id="lastName" v-model="application.lastName">
            <div class="underline"></div>
            <label for="" style="margin-left: 16px; opacity: 70%;">Last Name</label>
         </div>
      </div>
      <div class="form-row">
         <div class="input-data">
            <input type="text" required id="emailAddress" v-model="application.emailAddress">
            <div class="underline"></div>
            <label for="" style="margin-left: 16px; opacity: 70%;">Email Address</label>
         </div>
      </div>
      <div class="form-row">
         <div class="input-data">
            <input type="text" required id="phone-number" v-model="application.phoneNumber">
            <div class="underline"></div>
            <label for="" style="margin-left: 16px; opacity: 70%;">Phone Number</label>
         </div>
      </div>
      <div class="form-row" style="padding-top: 48px;">
        <div class='field'>
          <label for="over-eighteen" class="subtitle">Are you over the age of 18?</label>
          <ul class='checkboxes'>
            <li class='checkbox'>
              <input class='checkbox-input' id='true' name='true' type='checkbox' value='true' v-model="application.overEighteen">
              <label class='checkbox-label' for='true'>Yes</label>
            </li>
            <li class='checkbox'>
              <input class='checkbox-input' id='false' name='false' type='checkbox' value='false' v-model="application.overEighteen">
              <label class='checkbox-label' for='false'>No</label>
            </li>
          </ul>
        </div>
      </div>
        <div class="form-row" style="padding-top: 48px;">
         <div class='field'>
            <label class="label subtitle">Allergies?</label>
              <ul class='checkboxes'>
                <li class='checkbox'>
                  <input class='checkbox-input' id='choice-A' name='choice' type='checkbox' value='A' v-model="application.allergies">
                  <label class='checkbox-label' for='choice-A'> Dander</label>
                </li>
                <li class='checkbox'>
                 <input class='checkbox-input' id='choice-B' name='choice' type='checkbox' value='B' v-model="application.allergies">
                 <label class='checkbox-label' for='choice-B'> Pollen</label>
                </li>
                <li class='checkbox'>
                  <input class='checkbox-input' id='choice-C' name='choice' type='checkbox' value='C' v-model="application.allergies">
                  <label class='checkbox-label' for='choice-C'> Mold</label>
                </li>
                <li class='checkbox'>
                  <input class='checkbox-input' id='choice-D' name='choice' type='checkbox' value='D' v-model="application.allergies">
                  <label class='checkbox-label' for='choice-D'> House Cleaners</label>
                </li>
                <li class='checkbox'>
                  <input class='checkbox-input' id='choice-E' name='choice' type='checkbox' value='E' v-model="application.allergies">
                  <label class='checkbox-label' for='choice-E'> Other</label>
                </li>
              </ul>
          </div>
        </div>
        <div class="form-row">
          <div class="input-data textarea">
            <textarea rows="8" cols="80" required></textarea>
            <br />
            <div class="underline"></div>
            <label for="">If you selected other, please list them here.</label>
            <br />
          </div>
        </div>

        <div class="form-row" style="padding-top: 48px;">   
          <div class='field'>
            <label class="label subtitle">Skills</label>
              <ul class='checkboxes'>
                <li class='checkbox'>
                <input class='checkbox-input' id='choice-0' name='choice' type='checkbox' value='0' v-model="application.skills">
                <label class='checkbox-label' for='choice-0'> Animal Care</label>
                </li>
                <li class='checkbox'>
                <input class='checkbox-input' id='choice-1' name='choice' type='checkbox' value='1' v-model="application.skills">
                <label class='checkbox-label' for='choice-1'> Grooming</label>
                </li>
                <li class='checkbox'>
                <input class='checkbox-input' id='choice-2' name='choice'   type='checkbox' value='2' v-model="application.skills">
                <label class='checkbox-label' for='choice-2'> Cleaning Kennels</label>
                <li class='checkbox'>
                <input class='checkbox-input' id='choice-3' name='choice' type='checkbox' value='3' v-model="application.skills">
                <label class='checkbox-label' for='choice-3'> Walking Dogs</label>
                </li>
                <li class='checkbox'>
                <input class='checkbox-input' id='choice-4' name='choice' type='checkbox' value='4' v-model="application.skills">
                <label class='checkbox-label' for='choice-4'> Cat Whisperer</label>
                </li>
                <li class='checkbox'>
                <input class='checkbox-input' id='choice-5' name='choice' type='checkbox' value='5' v-model="application.skills">
                <label class='checkbox-label' for='choice-5'> Customer Service </label>
                </li>
                <li class='checkbox'>
                <input class='checkbox-input' id='choice-6' name='choice' type='checkbox' value='6' v-model="application.skills">
                <label class='checkbox-label' for='choice-6'> Can lift over 30lbs</label>
                </li>
                <li class='checkbox'>
                <input class='checkbox-input' id='choice-7' name='choice' type='checkbox' value='7' v-model="application.skills">
                <label class='checkbox-label' for='choice-7'> Laundry</label>
                </li>
                <li class='checkbox'>
                <input class='checkbox-input' id='choice-8' name='choice' type='checkbox' value='8' v-model="application.skills">
                <label class='checkbox-label' for='choice-8'> Stocking Supplies</label>
                </li>
                <li class='checkbox'>
                <input class='checkbox-input' id='choice-9' name='choice' type='checkbox' value='9' v-model="application.skills">
                <label class='checkbox-label' for='choice-9'> Other</label>
                </li>
              </ul>
            </div>
          </div>
            
          <div class="form-row">
            <div class="input-data textarea">
              <textarea rows="8" cols="80" required></textarea>
              <br />
              <div class="underline"></div>
              <label for="">If you selected other, please list them here.</label>
              <br />
            </div>
          </div>
            
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

<!-- <form v-on:submit.prevent="submitForm">
    <h1>Please fill out application</h1>
    <div class="form-input-group" v-on:click="changeOverEighteen">
        <label for="over-eighteen">Are you over the age of 18?</label>
        <input type="checkbox" id="over-eighteen" v-model="application.overEighteen"/>
    </div>

    <div class="form-input-group">
        <label for="firstName">First Name:</label>
        <input type="text" id="FirstName" v-model="application.firstName"/>
    </div>

    <div class="form-input-group">
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" v-model="application.lastName"/>
    </div>

    <div class="form-input-group">
        <label for="skills">What kind of tasks would you prefer?</label>
        <input type="text" id="skills" v-model="application.skills"/>
    </div>

    <div class="form-input-group">
        <label for="emailAddress">Email Address:</label>
        <input type="text" id="emailAddress" v-model="application.emailAddress"/>
    </div>

    <div class="form-input-group">
        <label for="phone-number">Phone Number:</label>
        <input type="text" id="phone-number" v-model="application.phoneNumber"/>
    </div>

    <div class="form-input-group">
        <label for="allergies">Any allergies? If so, what are they:</label>
        <input type="text" id="allergies" v-model="application.allergies"/>
    </div>

    <button type="submit">Confirm Application</button>
</form> -->
</div>


</template>

<script>
import PetService from '../services/PetService';

export default {
data() {
return {
    application: {
        overEighteen: false,
        firstName: '',
        lastName: '',
        skills: '',
        emailAddress: '',
        phoneNumber: '',
        allergies: '',

        }
    }
},
methods: {
    submitForm() {
      PetService.processApplication(this.application).then(
          response => {if(response.status == 200) {
              window.alert('Application added')
              // push them back to another component
              this.$router.push("/")
              }
           }
    )
    },
    changeOverEighteen() {
    this.application.overEighteen = !this.application.overEighteen   
    }
  }
}



</script>

<style scoped>
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



/* The .image-container class needs to be applied to a div wrapped around the image you want to apply this filter to */
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

.container {
  max-width: 60%;
  width: 60%;
  background-color: #FFFFFF;
  padding: 64px 40px 32px 40px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
  border-radius: 8px;
  margin: 0 auto;
  margin-top: -400px; /* Adjust this value to control the vertical position of the form */
  z-index: 1; /* Ensure the form is above the image */
}

.text{
  text-align: left;
  font-size: 48px;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  color: #8E37D7;
  margin-left: 24px;
}

.subtitle {
  font-weight: bold;
  font-size: 24px;
}

form{
  padding: 8px 0 0 0;
}
.form-row{
  display: flex;
  margin: 32px 0;
}

#over-eighteen{
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
  margin: 16px 10px 0 0; /* Add margin for spacing */
  background-color: #f1f1f1;
  padding: 16px;
  border-radius: 8px;
  width: 225px;
}

.checkbox:hover {
  background-color: #775576;
  color: #FFFFFF;

}

.checkbox-label {
  flex: 1; /* Expand to fill available space */
  margin-left: 8px; /* Add some spacing between the checkbox and the label */
}

/* Adjust the width if needed */
.checkbox-input {
  width: auto;
  margin-bottom: 0;
}

form .form-row .input-data{
  width: 100%;
  height: 40px;
  margin: 0 20px;
  position: relative;
}
form .form-row .textarea{
  height: 40px;
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
.input-data .underline:before{
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
.submit-btn .input-data{
  overflow: hidden;
  height: 56px!important;
  width: 25%!important;
  border-radius: 8px;
}
.submit-btn .input-data .inner{
  height: 100%;
  width: 300%;
  position: absolute;
  left: -100%;
  background-color: #8E37D7;
  transition: all 0.4s;
  margin: 0;
}
.submit-btn .input-data:hover .inner{
  left: 0;
  background: #0070BB;
}
.submit-btn .input-data input{
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



@media (max-width: 700px) {
    .container {
    max-width: 85%;
    width: 85%;
    padding: 48px 16px 0 16px;
    margin-top: -450px;
    z-index: 1;
  }
  .text{
    font-size: 30px;
    text-align: center;
    line-height: 40px;
    margin-left: 0;
  }

  .subtitle {
    font-size: 16px;
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
    margin: 35px 0!important;
  }
  .submit-btn .input-data {
    width: 100%!important;
  }
}


</style>

