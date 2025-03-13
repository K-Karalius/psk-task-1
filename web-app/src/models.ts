export interface Course {
    id: number
    title: string
}

export interface AddCourse {
  title: string
  teacherId: number
}

export interface CourseWithTeacher {
    id: number
    title: string
    teacherId: string
    teacherName: string
}

export interface StudentWithCourses {
    id: number
    name: string
    courses: Course[]
}

export interface Teacher {
    id: number
    name: string
}

export interface TeacherWithCourses {
    id: number
    name: string
    courses: Course[]
}
