import axios from 'axios';

export default {

    getAllPets(){
        return axios.get("/pets");
    },

    getPetById(id){
        return axios.get(`/pets/${id}`);
    },

    addPet(pet) {
        return axios.post("/pets", pet);
    },

    updatePet(id, pet){
        return axios.put(`/pets/${id}`, pet);
    }

};