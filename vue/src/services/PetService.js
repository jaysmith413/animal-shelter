import axios from 'axios';

export default {

    getAllPets(){
        return axios.get("/pets");
    },

    processApplication(application) {
        return axios.post("/apply", application);
    }

}