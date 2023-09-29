import axios from 'axios';

export default {

    processApplication(application) {
        return axios.post("/apply", application);
    },

    getAllApplications() {
        return axios.get("/applications");
    },

}