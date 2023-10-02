<template>
<div class="all-volunteer-apps">
<h1>Approve Volunteers</h1>
<table>
<tr v-for="application in applications" v-bind:key="application.applicationId">
<div id="card" v-show="application.approved =='pending' || application.approved == 'approved'">
    <td class="application-input-group">First Name: {{application.firstName}}</td>
        <td class="application-input-group">Last Name: {{application.lastName}}</td>
        <td class="application-input-group">Email: {{application.emailAddress}}</td>
        <td class="application-input-group">Phone Number: {{application.phoneNumber}}</td>
        <td class="application-input-group">Are you over 18? {{application.overEighteen}}</td>
        <td>Allergies:</td>
        <td class="application-input-group" v-show="application.dander == true">Dander</td>
        <td class="application-input-group" v-show="application.pollen == true">Pollen</td>
        <td class="application-input-group" v-show="application.mold == true">Mold</td>
        <td class="application-input-group" v-show="application.houseCleaners == true">House Cleaners</td>
        <td class="application-input-group">{{ application.allergies }} </td>
        <td>Skills:</td>
        <td class="application-input-group" v-show="application.animalCare == true"> Animal Care</td>
        <td class="application-input-group" v-show="application.grooming == true">Grooming</td>
        <td class="application-input-group" v-show="application.cleaningKennels == true">Cleaning Kennels</td>
        <td class="application-input-group" v-show="application.walkingDogs == true">Walking Dogs</td>
        <td class="application-input-group" v-show="application.catWhisperer == true">Cat Whisperer</td>
        <td class="application-input-group" v-show="application.customerService == true">Customer Service</td>
        <td class="application-input-group" v-show="application.liftOverThirtyPounds == true">Lift Over Thirty Pounds</td>
        <td class="application-input-group" v-show="application.laundry == true">Laundry</td>
        <td class="application-input-group" v-show="application.stockingSupplies == true">Stocking Supplies</td>
        <td class="application-input-group"> {{application.skills}}</td>
        <td class="application-input-group">Status: {{application.approved}}</td>
        <button class="button" v-on:click.prevent="approveApplication(application.applicationId)">Approve Application</button>
        <button class="button" v-on:click.prevent="denyApplication(application.applicationId)">Deny Application</button>
</div>

</tr>


</table>


</div>

</template>

<script>
import VolunteerService from '../services/VolunteerService';
import AuthService from '../services/AuthService';

export default {
data() {
    return {
        applications: [],
        user: {
        username: '',
        password: 'password',
        confirmPassword: 'password',
        role: 'user',
      },
        }
    },
    created() {
        VolunteerService.getAllApplications().then(
            (response) => {
                this.applications = response.data
            }
        );
    },
    methods: {
        approveApplication(id) {
            console.log(this.applications)
            let indexNum = this.applications.findIndex((application) => id == application.applicationId);
            console.log(this.applications[indexNum].applicationId)
            this.applications[indexNum].approved = 'approved';
            this.user.username = this.applications[indexNum].emailAddress
            this.applications[indexNum].phoneNumber = String(this.applications[indexNum].phoneNumber)
            console.log(typeof this.applications[indexNum].phoneNumber)
            VolunteerService.updateApplication(this.applications[indexNum])
        AuthService.register(this.user)
        },

        denyApplication(id) {
            let indexNum = this.applications.findIndex((application) => id == application.applicationId);
            this.applications[indexNum].approved = 'denied';
        }

    }
};

</script>

<style>


</style>