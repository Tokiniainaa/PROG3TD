CREATE TABLE IF NOT EXISTS SUBSCRIBES (
    id int  primary key not null,
    name varchar (100) not null,
    gender char (1) check (gender='M' or gender='F') not null
    );
INSERT INTO SUBSCRIBES (id,name,gender)values(1,'JULE','M');
INSERT INTO SUBSCRIBES (id,name,gender)values(2,'JULIETTE','F');
INSERT INTO SUBSCRIBES (id,name,gender)values(3,'CESAR','M');