import axios from "axios"

const PATH = "http://20.194.59.184";

export const login = async ({id, pw}) => {
  await axios.post(`${PATH}/login`, {id: id, password: pw}).then((res) => {
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