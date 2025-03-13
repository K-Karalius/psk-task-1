
import axios from "axios";
import { Student, Teacher } from "./models.ts";

const API_BASE_URL = "http://localhost:8080";

export const getStudentsWithCourses = async (): Promise<Student[]> => {
    try {
        const response = await axios.get(`${API_BASE_URL}/students`)
        return response.data
    } catch (error) {
        console.error("Error fetching students:", error)
        return []
    }
}

export const getTeachersWithCourses = async (): Promise<Teacher[]> => {
    try {
        const response = await axios.get(`${API_BASE_URL}/teachers`)
        return response.data
    } catch (error) {
        console.error("Error fetching teachers:", error)
        return []
    }
}
