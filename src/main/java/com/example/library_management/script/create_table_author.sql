CREATE TABLE IF NOT EXISTS AUTHOR (
    id_author serial primary key,
    name varchar (100) not null,
    sex char(1) check (sex='M' or sex='F')
);
INSERT INTO AUTHOR (name,sex)values('RAKOTO','M');
INSERT INTO AUTHOR (name,sex)values('RASOA','F');
INSERT INTO AUTHOR (name,sex)values('RABE','M');