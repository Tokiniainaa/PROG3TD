CREATE TABLE IF NOT EXISTS SUBCRIBES (
    id serial primary key,
    name varchar (100) not null,
    gender char (1) check (gender='M' or gender='F') not null
    );
INSERT INTO SUBSCRIBES (name,gender)values('JULE','M');
INSERT INTO SUBSCRIBES (name,gender)values('JULIETTE','F');
INSERT INTO SUBSCRIBES (name,gender)values('CESAR','M');