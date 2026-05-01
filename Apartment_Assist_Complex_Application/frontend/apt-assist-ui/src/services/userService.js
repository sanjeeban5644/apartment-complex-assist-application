import api from "../api/api";

export const getUser = async (uniqueNumber) => {
  const response = await api.get(`/admin/getUserByUniqueNumber?uniqueNumber=${uniqueNumber}`);
  return response.data.apiData;
};

export const saveUser = async (userData) => {
  const response = await api.post("/admin/saveUser", userData);
  return response.data;
};

export const getUserTypes = async () => {
  const response = await api.get("/admin/getUserTypes");
  return response.data.apiData.userTypeMasterMap;
};

export const registerUser = async (userData) => {
  const payload = {
    uniqueUserNumber: userData.uniqueNumber,  // renamed
    registerTo: userData.userType,             // renamed
  };
  const response = await api.post("/admin/registerUser", payload);
  return response.data;
};