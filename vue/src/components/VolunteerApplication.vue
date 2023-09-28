<template>
<div class="application">

<div class="container">
   <div class="text">
      Contact us Form
   </div>
   <form action="#">
      <div class="form-row">
         <div class="input-data">
            <input type="text" required>
            <div class="underline"></div>
            <label for="">First Name</label>
         </div>
         <div class="input-data">
            <input type="text" required>
            <div class="underline"></div>
            <label for="">Last Name</label>
         </div>
      </div>
      <div class="form-row">
         <div class="input-data">
            <input type="text" required>
            <div class="underline"></div>
            <label for="">Email Address</label>
         </div>
         <div class="input-data">
            <input type="text" required>
            <div class="underline"></div>
            <label for="">Phone Number</label>
         </div>
      </div>
      <div class="form-row">
            <div class="input-data"
           v-on:click="changeOverEighteen">
            <label for="over-eighteen">Are you over the age of 18?</label>
            <input type="checkbox" id="over-eighteen" v-model="application.overEighteen"/>
            </div>
        </div>
         <div class='field'>
            <label class='label'>Allergies?</label>
            <ul class='checkboxes'>
            <li class='checkbox' style="display:inline-block;">
                <input class='checkbox-input' id='choice-A' name='choice' type='checkbox' value='A'>
            <label class='checkbox-label' for='choice-A'> Dander</label>
            </li>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-B' name='choice' type='checkbox' value='B'>
            <label class='checkbox-label' for='choice-B'> Pollen</label>
            </li>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-C' name='choice' type='checkbox' value='C'>
            <label class='checkbox-label' for='choice-C'> Mold</label>
            </li>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-D' name='choice' type='checkbox' value='D'>
            <label class='checkbox-label' for='choice-D'> Household Cleaners</label>
            </li>
            <li class='checkbox' style="display:inline-block;">
                <input class='checkbox-input' id='choice-E' name='choice' type='checkbox' value='E'>
            <label class='checkbox-label' for='choice-E'> Other</label>
            </li>
            </ul>
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
            
            <div class='field'>
                <label class='label'>Skills</label>
            <ul class='checkboxes'>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-0' name='choice' type='checkbox' value='0'>
            <label class='checkbox-label' for='choice-0'> Animal Care</label>
            </li>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-1' name='choice' type='checkbox' value='1'>
            <label class='checkbox-label' for='choice-1'> Grooming</label>
            </li>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-2' name='choice'   type='checkbox' value='2'>
            <label class='checkbox-label' for='choice-2'> Cleaning Kennels</label>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-3' name='choice' type='checkbox' value='3'>
            <label class='checkbox-label' for='choice-3'> Walking Dogs</label>
            </li>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-4' name='choice' type='checkbox' value='4'>
            <label class='checkbox-label' for='choice-4'> Cat Whisperer</label>
            </li>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-5' name='choice' type='checkbox' value='5'>
            <label class='checkbox-label' for='choice-5'> Customer Service </label>
            </li>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-6' name='choice' type='checkbox' value='6'>
            <label class='checkbox-label' for='choice-6'> Can lift over 30lbs</label>
            </li>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-7' name='choice' type='checkbox' value='7'>
            <label class='checkbox-label' for='choice-7'> Laundry</label>
            </li>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-8' name='choice' type='checkbox' value='8'>
            <label class='checkbox-label' for='choice-8'> Stocking Supplies</label>
            </li>
            <li class='checkbox' style="display:inline-block;">
            <input class='checkbox-input' id='choice-9' name='choice' type='checkbox' value='9'>
            <label class='checkbox-label' for='choice-9'> Other</label>
            </li>
                </ul>
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
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  padding: 10px;
  font-family: 'Poppins', sans-serif;
  background: linear-gradient(115deg, #e7bede 10%, #775576 90%);
}
.container{
  max-width: 800px;
  background: #fff;
  width: 800px;
  padding: 25px 40px 10px 40px;
  box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
}
.container .text{
  text-align: center;
  font-size: 41px;
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
  background: -webkit-linear-gradient(right, #e7bede 10%, #775576, #e7bede 10%, #775576);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
.container form{
  padding: 30px 0 0 0;
}
.container form .form-row{
  display: flex;
  margin: 32px 0;
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
  font-size: 17px;
  border-bottom: 2px solid rgba(0,0,0, 0.12);
}
.input-data input:focus ~ label, .textarea textarea:focus ~ label,
.input-data input:valid ~ label, .textarea textarea:valid ~ label{
  transform: translateY(-20px);
  font-size: 14px;
  color: #3498db;
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
  background: #3498db;
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
  height: 45px!important;
  width: 25%!important;
}
.submit-btn .input-data .inner{
  height: 100%;
  width: 300%;
  position: absolute;
  left: -100%;
  background: -webkit-linear-gradient(right, #56d8e4, #9f01ea, #56d8e4, #9f01ea);
  transition: all 0.4s;
}
.submit-btn .input-data:hover .inner{
  left: 0;
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
  .container .text{
    font-size: 30px;
  }
  .container form{
    padding: 10px 0 0 0;
  }
  .container form .form-row{
    display: block;
  }
  form .form-row .input-data{
    margin: 35px 0!important;
  }
  .submit-btn .input-data{
    width: 40%!important;
  }
}


</style>

