-- Insert sample students
INSERT INTO students (id, username, email, team_id, is_leader, join_date)
VALUES
    (1, 'john', 'john@example.com', 1, true, '2021-01-01'),
    (2, 'mary', 'mary@example.com', 1, false, '2021-01-05'),
    (3, 'alex', 'alex@example.com', 2, true, '2021-02-01'),
    (4, 'sara', 'sara@example.com', 2, false, '2021-02-05');

-- Insert sample teams
INSERT INTO teams (id, team_name, leader_id, activity_id)
VALUES
    (1, 'Team A', 1, 1),
    (2, 'Team B', 3, 2);

-- Insert sample mentors
INSERT INTO mentors (id, username)
VALUES
    (1, 'mentor1'),
    (2, 'mentor2');

-- Insert sample activities
INSERT INTO activities (id, activity_name)
VALUES
    (1, 'Activity A'),
    (2, 'Activity B');

-- Insert sample attendance
INSERT INTO attendance (id, student_id, session_id, mentor_id, attendance)
VALUES
    (1, 1, 1, 1, true),
    (2, 2, 1, 1, true),
    (3, 3, 2, 2, false),
    (4, 4, 2, 2, true);

-- Insert sample grades
INSERT INTO grades (id, student_id, mentor_id, session_id, grade, comment)
VALUES
    (1, 1, 1, 1, 85, 'Good work'),
    (2, 2, 1, 1, 75, 'Needs improvement'),
    (3, 3, 2, 2, 90, 'Excellent performance'),
    (4, 4, 2, 2, 80, 'Well done');

-- Insert sample sessions
INSERT INTO session (id, activity_id, session_date)
VALUES
    (1, 1, '2021-01-10'),
    (2, 2, '2021-02-10');
