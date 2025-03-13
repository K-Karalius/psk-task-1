import { useEffect, useState } from "react";
import { getTeachersWithCourses } from "./api.ts";
import { TeacherWithCourses, Course } from "./models.ts";

const TeacherList = () => {
    const [teachers, setTeachers] = useState<TeacherWithCourses[]>([]);

    useEffect(() => {
        getTeachersWithCourses().then((data) => setTeachers(data));
    }, []);

    return (
        <div>
            <h2>Teachers and Their Courses</h2>
            {teachers.length === 0 ? (
                <p>Loading teachers...</p>
            ) : (
                <ul>
                    {teachers.map((teacher) => (
                        <li key={teacher.id}>
                            <strong>{teacher.name}</strong>
                            <ul>
                                {teacher.courses.map((course: Course) => (
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

export default TeacherList;
