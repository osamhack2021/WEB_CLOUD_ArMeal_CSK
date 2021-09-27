import axios from "axios"

const PATH = "http://20.194.59.184";

export const login = async ({login_id, password}) => {
  await axios.post(`${PATH}/login`, {"login_id": login_id, "password": password}).then((res) => {
    return res;
  }).catch((e) => {
    throw new Error(e);
  })
}

export const getDashboardData = async () => {
  await axios.post(`${PATH}/getDashboardData`).then((res) => {
    return res;
  }).catch((e) => {
    throw new Error(e);
  })
}