import StudentList from "./StudentList.tsx";
import TeacherList from "./TeacherList.tsx";
import CourseForm from "./CourseForm.tsx";

function App() {

    return (
        <div>
            <h1>Welcome to the School Management System</h1>
            <StudentList />
            <TeacherList />
            <CourseForm />
        </div>
    )
}

export default App
