import axios from 'axios';

export default{

getApprovedUsers(){
    return axios.get("/approvedUsers");
},

}