export type Projects = {
    id: number,
    projectName: string,
    clientName: string,
    date: string,
    deadline: string,
    budget: number 
}

export type ProjectsPage = {
    content?: Projects[];
    last: boolean;
    totalElements: number;
    totalPages: number;
    size?: number;
    number: number;
    first: boolean;
    numberOfElements?: number;
    empty?: boolean;
}