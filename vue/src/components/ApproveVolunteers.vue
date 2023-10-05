<template>
<div class="all-volunteer-apps">
    <div class="container">
        <h1 class="text">Approve Volunteers</h1>
        <div id="showFilters">
      <button v-on:click.prevent="showForm = !showForm">Show Filters</button>
    </div>
    <table id="filters" v-show="showForm === true">
      <tbody>
        <tr class="filterTr">
          <td class="td1">
            First Name: <input type="text" id="firstNameFilter" v-model="filter.firstName" />
          </td>
          <td class="td1">
            Last Name: <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td class="td1">Over 18
            <input type="checkbox" v-model="filter.overEighteen" :value="true" />
            
          </td>
          <td class="td1">
            Status
            <select id="statusFilter" v-model="filter.status">
              <option value>Show All</option>
              <option value="pending">Pending</option>
              <option value="approved">Approved</option>
            </select>
          </td>
          
          
        </tr>
      </tbody>
    </table>
            
            
            <table>
                <!-- <tr v-for="application in applications" v-bind:key="application.applicationId">
                    <div id="card" v-show="application.approved =='pending' || application.approved == 'approved'">
                        <tr class="application-input-group"><span style="font-weight: bold;">First Name:</span> {{application.firstName}}</tr>
                            <tr class="application-input-group"><span style="font-weight: bold;">Last Name:</span> {{application.lastName}}</tr>
                            <tr class="application-input-group"><span style="font-weight: bold;">Email:</span> {{application.emailAddress}}</tr>
                            <tr class="application-input-group"><span style="font-weight: bold;">Phone Number:</span> {{application.phoneNumber}}</tr>
                            <tr class="application-input-group"><span style="font-weight: bold;">Are you over 18?</span> {{application.overEighteen}}</tr>
                        <tr style="font-weight: bold;">Allergies:</tr>
                            <td class="application-input-group" v-show="application.dander == true">Dander</td>
                            <td class="application-input-group" v-show="application.pollen == true">Pollen</td>
                            <td class="application-input-group" v-show="application.mold == true">Mold</td>
                            <td class="application-input-group" v-show="application.houseCleaners == true">House Cleaners</td>
                            <td class="application-input-group">{{ application.allergies }} </td>
                        <tr style="font-weight: bold;">Skills:</tr>
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
                        <tr class="application-input-group"><span style="font-weight: bold;">Status:</span> {{application.approved}}</tr>
                        <button class="button-approved" v-on:click.prevent="approveApplication(application.applicationId)">Approve Application</button>
                        <button class="button-denied" v-on:click.prevent="denyApplication(application.applicationId)">Deny Application</button>
                    </div>
                </tr> -->

                <tr v-for="application in filteredList" :key="application.applicationId">
                    <!-- Individual Applications -->
                    <div id="card" v-show="application.approved === 'pending' || application.approved === 'approved'">
                        <tr class="application-input-group"><span style="font-weight: bold;">First Name:</span> {{ application.firstName }}</tr>
                        <tr class="application-input-group"><span style="font-weight: bold;">Last Name:</span> {{ application.lastName }}</tr>
                        <tr class="application-input-group"><span style="font-weight: bold;">Email:</span> {{ application.emailAddress }}</tr>
                        <tr class="application-input-group"><span style="font-weight: bold;">Phone Number:</span> {{ application.phoneNumber }}</tr>
                        <tr class="application-input-group"><span style="font-weight: bold;">Are you over 18?</span> {{ application.overEighteen }}</tr>
                        <tr class="application-input-group"><span style="font-weight: bold;">Allergies: </span>
                            <span v-if="application.dander">Dander, </span>
                            <span v-if="application.pollen">Pollen, </span>
                            <span v-if="application.mold">Mold, </span>
                            <span v-if="application.houseCleaners">House Cleaners, </span>
                            <span>{{ application.allergies }}</span>
                        </tr>
                        <tr class="application-input-group"><span style="font-weight: bold;">Skills: </span>
                            <span v-if="application.animalCare">Animal Care, </span>
                            <span v-if="application.grooming">Grooming, </span>
                            <span v-if="application.cleaningKennels">Cleaning Kennels, </span>
                            <span v-if="application.walkingDogs">Walking Dogs, </span>
                            <span v-if="application.catWhisperer">Cat Whisperer, </span>
                            <span v-if="application.customerService">Customer Service, </span>
                            <span v-if="application.liftOverThirtyPounds">Lift Over Thirty Pounds, </span>
                            <span v-if="application.laundry">Laundry, </span>
                            <span v-if="application.stockingSupplies">Stocking Supplies, </span>
                            <span>{{ application.skills }}</span>
                        </tr>
                        <tr class="application-input-group"><span style="font-weight: bold;">Status:</span> {{ application.approved }}</tr>
                            <button class="button-approved" @click.prevent="approveApplication(application.applicationId)">Approve Application</button>
                            <button class="button-denied" @click.prevent="denyApplication(application.applicationId)">Deny Application</button>
                    </div>
                    <!-- End Individual Applications -->
                </tr>
            </table>
        </div>
    </div>
</template>

<script>
import VolunteerService from '../services/VolunteerService';
import AuthService from '../services/AuthService';

export default {
data() {
    return {
        filter: {
        firstName: "",
        lastName: "",
        overEighteen: null,
        status: ""
      },
        applications: [],
        user: {
        username: '',
        firstName: '',
        password: 'password',
        confirmPassword: 'password',
        role: 'user',
      },
      showForm: false,
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
            if(this.applications[indexNum].approved == 'approved') {
                alert('This application has already been approved')
            } else {
                this.applications[indexNum].approved = 'approved';
                this.user.username = this.applications[indexNum].emailAddress
                this.user.firstName = this.applications[indexNum].firstName
                this.user.lastName = this.applications[indexNum].lastName
                this.user.phoneNumber = this.applications[indexNum].phoneNumber
                this.user.emailAddress = this.applications[indexNum].emailAddress
                this.applications[indexNum].phoneNumber = String(this.applications[indexNum].phoneNumber)
                console.log(typeof this.applications[indexNum].phoneNumber)
                if(confirm('Are you sure you want approve this application?')) {
                    VolunteerService.updateApplication(this.applications[indexNum])
                AuthService.register(this.user)
                }
                
            }
           
        },

        denyApplication(id) {
            let indexNum = this.applications.findIndex((application) => id == application.applicationId);
            this.applications[indexNum].approved = 'denied';
            if(confirm('Are you sure you want deny this application?')) {
                VolunteerService.updateApplication(this.applications[indexNum])
            }  
        }
    },
    computed: {
    filteredList() {
      let filteredApplications = this.applications;
      if (this.filter.firstName != "") {
        filteredApplications = filteredApplications.filter((app) =>
          app.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredApplications = filteredApplications.filter((app) =>
          app.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.overEighteen === true) {
        filteredApplications = filteredApplications.filter((app) =>
          app.overEighteen === this.filter.overEighteen
        );
      }
      if (this.filter.status != "") {
        filteredApplications = filteredApplications.filter((app) =>
          app.approved === this.filter.status
        );
      }
      
      return filteredApplications;
    }
  }
};

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

.all-volunteer-apps {
  background-image: url(../img/1e4982cd-3f91-42c0-92d3-4f50f42496cb.png);
  background-repeat: repeat;
  margin: 0;
  padding: 0;
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

#showFilters {
padding-bottom: 24px;
width: 25%;
}

#card {
    background-color: #F1F1F1;
    padding: 32px;
    margin-bottom: 16px;
    border-radius: 8px;
    width: 100%;
}

.container {
  max-width: 75%;
  width: 75%;
  background-color: #FFFFFF;
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
  font-family: 'Poppins', sans-serif;
  color: #5E8558;
  margin-left: 24px;
  margin-bottom: 24px;
}

.button-approved {
  background-color: #5E8558;
  color: #FFFFFF;
  padding: 16px 8px;
  margin: 24px 16px 0 0;
  border-radius: 8px;
  width: 40%;
  border: none;
}

.button-approved:hover {
  background-color: #7EA578;
}

.button-denied {
  background-color: #D73533;
  color: #FFFFFF;
  padding: 16px 8px;
  margin: 24px 0 0 0;
  border-radius: 8px;
  width: 40%;
  border: none;
}

.button-denied:hover {
  background-color: #E16866;
}

#filters {
padding-bottom: 24px;
border-spacing: 16px;
}

</style>