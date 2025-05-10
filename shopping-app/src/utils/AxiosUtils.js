import axios from "axios";

const axiosInstance = axios.create({
    baseURL: 'http://localhost:8085',
    withCredentials: true,
    headers: {
        "Content-type": "application/json"
    }
    , timeout: 5000,
});

export const request = (method, url, data = {}) => {
    return axiosInstance({
        url,
        method: method,
        data: data
    });
}
