<template>
<div class="application">
    
<form v-on:submit.prevent="submitForm">
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
</form>
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

</style>

