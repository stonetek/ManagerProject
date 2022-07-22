import axios from "axios";

const API_URL = 'localhost:8080';

export function fetchDevelopers() {
    return axios(`${API_URL}/developers`)
}