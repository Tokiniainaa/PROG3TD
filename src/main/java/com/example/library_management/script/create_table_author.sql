CREATE TABLE IF NOT EXISTS AUTHOR (
    id_author int primary key not null,
    name varchar (100) not null,
    sex char(1) check (sex='M' or sex='F')
);
INSERT INTO AUTHOR (id_author,name,sex)values(1,'RAKOTO','M');
INSERT INTO AUTHOR (id_author,name,sex)values(2,'RASOA','F');
INSERT INTO AUTHOR (id_author,name,sex)values(3,'RABE','M');