import { useEffect, useState } from "react";
import { getStudentsWithCourses } from "./api.ts";
import { StudentWithCourses, Course } from "./models.ts";

const StudentList = () => {
    const [students, setStudents] = useState<StudentWithCourses[]>([]);

    useEffect(() => {
        getStudentsWithCourses().then((data) => setStudents(data));
    }, []);

    return (
        <div>
            <h2>Students and Their Courses</h2>
            {students.length === 0 ? (
                <p>Loading students...</p>
            ) : (
                <ul>
                    {students.map((student) => (
                        <li key={student.id}>
                            <strong>{student.name}</strong>
                            <ul>
                                {student.courses.map((course: Course) => (
                                    <li key={course.id}>{course.title}</li>
                                ))}
                            </ul>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default StudentList;
