import axios from "axios";
import { BASE_URL } from "./utils/requests";

let id = document.getElementById('id')?.ariaValueText;
let projectName = document.getElementById('projectName')?.ariaValueText
let developerName = document.getElementById('developerName?')?.ariaValueText

const API_URL = BASE_URL;

export function fetchDevelopers() {
    return axios.get(`${API_URL}/api/developers`)
}

export function fetchEditDevelopers() {
    return axios.post(`${API_URL}/api/developers/{idDeveloper}`)
}

export function fetchDelDev() {
    return axios.delete(`${API_URL}/api/developers/`)
}

export function fetchProjects() {
    return axios.get(`${API_URL}/api/projects`)
}


export function fetchProjectsDel() {
    return axios.delete(`${API_URL}/api/projects/`)
}

export function fetchProjectsEdit() {
    return axios.put(`${API_URL}/projects/${id}`)
}
