import axios from "axios";
import { Projects } from "./types/Projects";
import { BASE_URL } from "./utils/requests";
import { Developers } from "./types/Developer";

let id = document.getElementById('id')?.ariaValueText;
let projectName = document.getElementById('projectName')?.ariaValueText
let developerName = document.getElementById('developerName')?.ariaValueText

const API_URL = BASE_URL;

export function fetchDevelopers() {
    return axios.get(`${API_URL}/api/developers`)
}

export async function fetchNewDevelopers(Developers: Developers) {
    const response = await axios.post(`${API_URL}/api/developers/{idDeveloper}`)
}

export function fetchEditDevelopers() {
    return axios.put(`${API_URL}/api/developers/${id}`)
}

export function fetchDelDev() {
    return axios.delete(`${API_URL}/api/developers/`)
}

export function fetchProjects() {
    return axios.get(`${API_URL}/api/projects`)
}

export async function fetchNewProjects(Projects: Projects) {
    const response = await axios.post(`${API_URL}/api/projects/{idProject}`);
}

export function fetchProjectsEdit() {
    return axios.put(`${API_URL}/api/projects/${id}`)
}

export function fetchProjectsDel() {
    return axios.delete(`${API_URL}/api/projects/`)
}
