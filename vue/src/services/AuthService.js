import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  }, 

  changePassword(user) {
    return axios.put(`/changepassword/${user.id}`, user)
  }

}
