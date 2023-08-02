CREATE TABLE students (
  id SERIAL PRIMARY KEY,
  username VARCHAR,
  email VARCHAR,
  team_id INT REFERENCES teams (id),
  is_leader BOOLEAN,
  join_date DATE
);

CREATE TABLE teams (
  id SERIAL PRIMARY KEY,
  team_name VARCHAR,
  leader_id INT REFERENCES students (id),
  activity_id INT REFERENCES activities (id)
);

CREATE TABLE mentors (
  id SERIAL PRIMARY KEY,
  username VARCHAR
);

CREATE TABLE activities (
  id SERIAL PRIMARY KEY,
  activity_name VARCHAR
);

CREATE TABLE attendance (
  id SERIAL PRIMARY KEY,
  student_id INT REFERENCES students (id),
  session_id INT REFERENCES session (id),
  mentor_id INT REFERENCES mentors (id),
  attendance BOOLEAN
);

CREATE TABLE grades (
  id SERIAL PRIMARY KEY,
  student_id INT REFERENCES students (id),
  mentor_id INT REFERENCES mentors (id),
  session_id INT REFERENCES session (id),
  grade NUMERIC,
  comment VARCHAR
);

CREATE TABLE session (
  id SERIAL PRIMARY KEY,
  activity_id INT REFERENCES activities (id),
  session_date DATE
);
