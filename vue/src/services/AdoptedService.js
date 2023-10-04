import axios from 'axios';

export default {

    getAdoptedPets(){
        return axios.get('/adopted');
    },

}