export type Developers = {
    id: number,
    developerName: string,
    email: string,
    birthDate: string,
    salary: number,
    workload: number
}

export type DevelopersPage = {
    content?: Developers[];
    last: boolean;
    totalElements: number;
    totalPages: number;
    size?: number;
    number: number;
    first: boolean;
    numberOfElements?: number;
    empty?: boolean;
}