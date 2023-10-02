import axios from 'axios';

export default {

    processApplication(application) {
        return axios.post("/apply", application);
    },

    getAllApplications() {
        return axios.get("/applications");
    },

    updateApplication(application) {
        console.log(this.application.applicationId)
        return axios.put(`/updateapplication/${application.applicationId}`, application)
    }

}