CREATE TABLE departments (
	id		INTEGER PRIMARY KEY,
	name	VARCHAR(30)
);;

CREATE TABLE employees (
	id				INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), -- INTEGER PRIMARY KEY,
	name			VARCHAR(30),
	email			VARCHAR(50),
	department_id 	INTEGER,
	CONSTRAINT PK_EMP_ID PRIMARY KEY (id)
);;