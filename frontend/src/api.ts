import axios from "axios";
import { BASE_URL } from "./utils/requests";

const API_URL = BASE_URL;

export function fetchDevelopers() {
    return axios.get(`${API_URL}/developers`)
}