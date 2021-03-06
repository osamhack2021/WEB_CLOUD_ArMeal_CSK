import axios from "axios"

const PATH = "http://20.194.59.184:8080";

export const login = ({login_id, password}) => {
  return axios.post(`${PATH}/login`, {login_id: login_id, password: password});
}

export const signup = ({email, group_id, login_id, name, password}) => {
  return axios.post(`${PATH}/signup`, 
    {
      "email": email,
      "group_id": Number(group_id),
      "login_id": login_id,
      "name": name,
      "password": password
    }
  );
}

export const getAllSidedishData = (group_id) => {
  return axios.get(`${PATH}/get/ingredient/info/${group_id}/all`)
}

export const getSidedishData = ({group_id, id}) => {
  return axios.get(`${PATH}/get/ingredient/info/${group_id}/${id}`)
}

export const getAllMenuData = (group_id) => {
  return axios.get(`${PATH}/get/menu/info/${group_id}/all`)
}

export const getMenuData = ({group_id, id}) => {
  return axios.get(`${PATH}/get/menu/info/${group_id}/${id}`)
}

export const getRatioToday = ({date, group_id}) => {
  return axios.get(`${PATH}/get/ratio/today/${group_id}/${date}`);
}

export const addRatingDaily = ({userId, date, time, rating_value, badReason, group_id}) => {
  let data = [{
    userId: userId,
    date: date,
    time: time,
    rating_value: rating_value,
    badReason: badReason,
    group_id: group_id
  }]
  let keep = JSON.parse(localStorage.getItem("keep"));
  localStorage.setItem("keep", JSON.stringify(data[0]))
  if(keep) {
    data.push(keep)
  }
  return axios.post(`${PATH}/add/rating/daily`, data);
}

export const getManagementData = ({group_id, start, end}) => {
  return axios.get(`${PATH}/get/dailymenu/info/${group_id}/${start}/${end}`);
}

export const getTopData = (group_id) => {
  return axios.get(`${PATH}/get/rating/top5/${group_id}`);
}

export const getAverage = (group_id) => {
  return axios.get(`${PATH}/get/ratio/${group_id}/all`);
}

export const getCount = (group_id) => {
  return axios.get(`${PATH}/get/satisfy/count/${group_id}`);
}

export const getMonthData = (param) => {
  return axios.post(`${PATH}/get/rating/month`, param);
}