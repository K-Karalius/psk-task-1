export interface Course {
    id: number
    title: string
}

export interface Student {
    id: number
    name: string
    courses: Course[]
}

export interface Teacher {
    id: number
    name: string
    courses: Course[]
}
