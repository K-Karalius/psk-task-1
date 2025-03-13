-- Insert Teachers
INSERT INTO teacher (id, name) VALUES (1, 'John Doe') ON CONFLICT (id) DO NOTHING;
INSERT INTO teacher (id, name) VALUES (2, 'Jane Smith') ON CONFLICT (id) DO NOTHING;
INSERT INTO teacher (id, name) VALUES (3, 'Alice Johnson') ON CONFLICT (id) DO NOTHING;

-- Insert Students
INSERT INTO student (id, name) VALUES (1, 'Alice') ON CONFLICT (id) DO NOTHING;
INSERT INTO student (id, name) VALUES (2, 'Bob') ON CONFLICT (id) DO NOTHING;
INSERT INTO student (id, name) VALUES (3, 'Charlie') ON CONFLICT (id) DO NOTHING;
INSERT INTO student (id, name) VALUES (4, 'David') ON CONFLICT (id) DO NOTHING;

-- Insert Courses
INSERT INTO course (id, title, teacher_id) VALUES (1, 'Math 101', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO course (id, title, teacher_id) VALUES (2, 'Physics 101', 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO course (id, title, teacher_id) VALUES (3, 'Computer Science', 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO course (id, title, teacher_id) VALUES (4, 'History', 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO course (id, title, teacher_id) VALUES (5, 'Biology 101', 3) ON CONFLICT (id) DO NOTHING;
INSERT INTO course (id, title, teacher_id) VALUES (6, 'Chemistry 101', 3) ON CONFLICT (id) DO NOTHING;

-- Assign Students to Courses (Many-to-Many)

INSERT INTO student_courses (student_id, course_id) VALUES (1, 1) ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES (1, 3) ON CONFLICT DO NOTHING;

INSERT INTO student_courses (student_id, course_id) VALUES (2, 2) ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES (2, 4) ON CONFLICT DO NOTHING;

INSERT INTO student_courses (student_id, course_id) VALUES (3, 1) ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES (3, 3) ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES (3, 5) ON CONFLICT DO NOTHING;

INSERT INTO student_courses (student_id, course_id) VALUES (4, 2) ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES (4, 4) ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES (4, 6) ON CONFLICT DO NOTHING;

INSERT INTO student_courses (student_id, course_id) VALUES (1, 6) ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES (2, 6) ON CONFLICT DO NOTHING;

INSERT INTO student_courses (student_id, course_id) VALUES (3, 4) ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES (4, 4) ON CONFLICT DO NOTHING;
