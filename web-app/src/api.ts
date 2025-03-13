
import axios from "axios";
import {AddCourse, CourseWithTeacher, StudentWithCourses, Teacher, TeacherWithCourses} from "./models.ts";

const API_BASE_URL = "http://localhost:8080";

export const getStudentsWithCourses = async (): Promise<StudentWithCourses[]> => {
    try {
        const response = await axios.get(`${API_BASE_URL}/students/with-courses`)
        return response.data
    } catch (error) {
        console.error("Error fetching students:", error)
        return []
    }
}

export const getTeachersWithCourses = async (): Promise<TeacherWithCourses[]> => {
    try {
        const response = await axios.get(`${API_BASE_URL}/teachers/with-courses`)
        return response.data
    } catch (error) {
        console.error("Error fetching teachers:", error)
        return []
    }
}

export const getCourses = async (): Promise<CourseWithTeacher[]> => {
    try {
        const response = await axios.get(`${API_BASE_URL}/courses`)
        return response.data
    } catch (error) {
        console.error("Error fetching courses:", error)
        return [];
    }
};

export const addCourse = async (course: AddCourse): Promise<CourseWithTeacher | null> => {
    try {
        const response = await axios.post(`${API_BASE_URL}/courses`, course)
        return response.data
    } catch (error) {
        console.error("Error adding course:", error)
        return null
    }
};

export const getTeachers = async (): Promise<Teacher[]> => {
    try {
        const response = await axios.get(`${API_BASE_URL}/teachers`)
        return response.data
    } catch (error) {
        console.error("Error fetching courses:", error)
        return [];
    }
};
