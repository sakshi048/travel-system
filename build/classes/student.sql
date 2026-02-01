create table student
(name char(15) not null,
student_id char(10),
degree_level char(15),
primary key (student_id),
check (degree_level in (’Bachelors’, ’Masters’, ’Doctorate’)))
