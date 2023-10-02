<template>
<div class="all-volunteer-apps">
    <h1>Approve Volunteers</h1>
    <table>
        <tr v-for="application in applications" v-bind:key="application.applicationId">
            <div id="card">
                <td class="application-input-group">{{application.firstName}}</td>
                    <td>Age: {{application.lastName}}</td>
            </div>
                    
        </tr>
    <!-- <ApproveVolunteers/> -->

</table>
</div>
<script>

import VolunteerService from '../services/VolunteerService.js';

export default{
    data() {
        return{
            applications: [],
        }
        
    },
    created(){
        VolunteerService.getAllApplications().then(
            (response) => {

            }
        )
    }
})
</script>
