import axios from "axios";
import { Projects } from "./types/Projects";
import { BASE_URL } from "./utils/requests";

let id = document.getElementById('id')?.ariaValueText;
let projectName = document.getElementById('projectName')?.ariaValueText

const API_URL = BASE_URL;

export function fetchDevelopers() {
    return axios.get(`${API_URL}/developers`)
}

export function fetchEditDevelopers() {
    return axios.post(`${API_URL}/developers/id`)
}

export function fetchDelDev() {
    return axios.delete(`${API_URL}/developers/`)
}

export function fetchProjects() {
    return axios.get(`${API_URL}/projects`)
}

export async function fetchNewProjects(Projects: Projects) {
    const response = await axios.post(`${API_URL}/projects`,{projectName: projectName } );
}

export function fetchProjectsDel() {
    return axios.delete(`${API_URL}/projects/`)
}

export function fetchProjectsEdit() {
    return axios.put(`${API_URL}/projects/${id}`)
}
 
    /* method:'DELETE',
        headers: {
            'content-type': 'application/json'
        },
    }).then(response => response.data())
    .then(data => {
        setProjects(projects.filter((project) => project.id !== id))
    }
).catch(err => console.log(err)) */
