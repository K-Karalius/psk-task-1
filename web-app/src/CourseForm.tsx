import React, { useEffect, useState } from 'react';
import {addCourse, getTeachers} from "./api.ts";
import {AddCourse, Teacher} from "./models.ts";

const CourseForm: React.FC = () => {
    const [teachers, setTeachers] = useState<Teacher[]>([])
    const [course, setCourse] = useState<{
        title: string
        teacherId: number | undefined,
    }>({
        title: '',
        teacherId: undefined,
    });


    useEffect(() => {
        getTeachers()
            .then((data: Teacher[]) => {
                setTeachers(data)
            })
    }, [])

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        if (course.teacherId && course.title) {
            const addCourseObj: AddCourse = {
                title: course.title,
                teacherId: course.teacherId,
            }
            await addCourse(addCourseObj);
            setCourse({
                title: '',
                teacherId: undefined,
            });
            alert('Course created successfully!');
        } else {
            alert('Please fill all fields');
        }
    };

    return (
        <div>
            <h2>Create a New Course</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Course Title:</label>
                    <input
                        type="text"
                        value={course.title}
                        onChange={(e) => setCourse({ ...course, title: e.target.value })}
                    />
                </div>

                <div>
                    <label>Select Teacher:</label>
                    <select
                        value={course.teacherId ?? ''}
                        onChange={(e) => setCourse({ ...course, teacherId: parseInt(e.target.value) })}
                    >
                        <option value=''>
                            Select Teacher
                        </option>
                        {teachers.map((teacher) => (
                            <option key={teacher.id} value={teacher.id}>
                                {teacher.name}
                            </option>
                        ))}
                    </select>
                </div>

                <button type="submit">Create Course</button>
            </form>
        </div>
    );
};

export default CourseForm
