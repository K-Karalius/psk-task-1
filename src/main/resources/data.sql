-- Insert Teachers
INSERT INTO teacher (id, name) VALUES ('e2b2b12e-40fb-4fcb-87f5-6e5d5d47c24b', 'John Doe') ON CONFLICT (id) DO NOTHING;
INSERT INTO teacher (id, name) VALUES ('53f6f717-9d22-42a5-b5a4-8c80e4a2ad75', 'Jane Smith') ON CONFLICT (id) DO NOTHING;
INSERT INTO teacher (id, name) VALUES ('89c8e6d1-05f6-4d35-967b-bb1b240f70b1', 'Alice Johnson') ON CONFLICT (id) DO NOTHING;

-- Insert Students
INSERT INTO student (id, name) VALUES ('6c8b3d92-2b9e-47f5-88a3-4a5a4b89b65d', 'Alice') ON CONFLICT (id) DO NOTHING;
INSERT INTO student (id, name) VALUES ('2fe44131-f18f-4cf0-bd7d-71f0571731fc', 'Bob') ON CONFLICT (id) DO NOTHING;
INSERT INTO student (id, name) VALUES ('cfe8498f-e09e-4b67-a1b5-26f29d987d71', 'Charlie') ON CONFLICT (id) DO NOTHING;
INSERT INTO student (id, name) VALUES ('cf75e587-9371-43ef-8d62-943e13c8c128', 'David') ON CONFLICT (id) DO NOTHING;

-- Insert Courses
INSERT INTO course (id, title, teacher_id) VALUES ('4d0c6238-372f-4c6c-b03e-cf629122d3c9', 'Math 101', 'e2b2b12e-40fb-4fcb-87f5-6e5d5d47c24b') ON CONFLICT (id) DO NOTHING;
INSERT INTO course (id, title, teacher_id) VALUES ('d4f98391-6b78-437d-bd74-bc22861abcf6', 'Physics 101', '53f6f717-9d22-42a5-b5a4-8c80e4a2ad75') ON CONFLICT (id) DO NOTHING;
INSERT INTO course (id, title, teacher_id) VALUES ('b7fd5f52-d693-4a89-86bb-7464428b34a3', 'Computer Science', 'e2b2b12e-40fb-4fcb-87f5-6e5d5d47c24b') ON CONFLICT (id) DO NOTHING;
INSERT INTO course (id, title, teacher_id) VALUES ('d024b739-5c5e-4c56-bff7-4c6c14cd6e43', 'History', '53f6f717-9d22-42a5-b5a4-8c80e4a2ad75') ON CONFLICT (id) DO NOTHING;
INSERT INTO course (id, title, teacher_id) VALUES ('ca453fa4-e6c7-4f9b-8a39-6a1eb6947751', 'Biology 101', '89c8e6d1-05f6-4d35-967b-bb1b240f70b1') ON CONFLICT (id) DO NOTHING;
INSERT INTO course (id, title, teacher_id) VALUES ('dcdff5e4-8691-4645-bb62-6b5e2b30e2d5', 'Chemistry 101', '89c8e6d1-05f6-4d35-967b-bb1b240f70b1') ON CONFLICT (id) DO NOTHING;

-- Assign Students to Courses (Many-to-Many)
INSERT INTO student_courses (student_id, course_id) VALUES
    ('6c8b3d92-2b9e-47f5-88a3-4a5a4b89b65d', '4d0c6238-372f-4c6c-b03e-cf629122d3c9') ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES
    ('6c8b3d92-2b9e-47f5-88a3-4a5a4b89b65d', 'b7fd5f52-d693-4a89-86bb-7464428b34a3') ON CONFLICT DO NOTHING;

INSERT INTO student_courses (student_id, course_id) VALUES
    ('2fe44131-f18f-4cf0-bd7d-71f0571731fc', 'd4f98391-6b78-437d-bd74-bc22861abcf6') ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES
    ('2fe44131-f18f-4cf0-bd7d-71f0571731fc', 'd024b739-5c5e-4c56-bff7-4c6c14cd6e43') ON CONFLICT DO NOTHING;

INSERT INTO student_courses (student_id, course_id) VALUES
    ('cfe8498f-e09e-4b67-a1b5-26f29d987d71', '4d0c6238-372f-4c6c-b03e-cf629122d3c9') ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES
    ('cfe8498f-e09e-4b67-a1b5-26f29d987d71', 'b7fd5f52-d693-4a89-86bb-7464428b34a3') ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES
    ('cfe8498f-e09e-4b67-a1b5-26f29d987d71', 'ca453fa4-e6c7-4f9b-8a39-6a1eb6947751') ON CONFLICT DO NOTHING;

INSERT INTO student_courses (student_id, course_id) VALUES
    ('cf75e587-9371-43ef-8d62-943e13c8c128', 'd4f98391-6b78-437d-bd74-bc22861abcf6') ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES
    ('cf75e587-9371-43ef-8d62-943e13c8c128', 'd024b739-5c5e-4c56-bff7-4c6c14cd6e43') ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES
    ('cf75e587-9371-43ef-8d62-943e13c8c128', 'dcdff5e4-8691-4645-bb62-6b5e2b30e2d5') ON CONFLICT DO NOTHING;

-- Additional student-course assignments
INSERT INTO student_courses (student_id, course_id) VALUES
    ('6c8b3d92-2b9e-47f5-88a3-4a5a4b89b65d', 'dcdff5e4-8691-4645-bb62-6b5e2b30e2d5') ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES
    ('2fe44131-f18f-4cf0-bd7d-71f0571731fc', 'dcdff5e4-8691-4645-bb62-6b5e2b30e2d5') ON CONFLICT DO NOTHING;

INSERT INTO student_courses (student_id, course_id) VALUES
    ('cfe8498f-e09e-4b67-a1b5-26f29d987d71', 'd024b739-5c5e-4c56-bff7-4c6c14cd6e43') ON CONFLICT DO NOTHING;
INSERT INTO student_courses (student_id, course_id) VALUES
    ('cf75e587-9371-43ef-8d62-943e13c8c128', 'd024b739-5c5e-4c56-bff7-4c6c14cd6e43') ON CONFLICT DO NOTHING;
