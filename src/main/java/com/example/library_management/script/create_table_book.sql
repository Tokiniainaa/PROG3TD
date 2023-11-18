CREATE TABLE IF NOT EXISTS BOOK (
    id_book serial primary key,
    book_name varchar (100) not null,
    page_number int not null,
    topic 'Topic' not null,
    release_date varchar (15),
    id_author int references author(id_author)
    );
INSERT INTO BOOK (book_name,page_number,topic,release_date,id_author)values('papillon noir',200,'OTHER','2022-12-11',1);
INSERT INTO BOOK (book_name,page_number,topic,release_date,id_author)values('lala sy noro',100,'COMEDY','2000-12-11',2);
INSERT INTO BOOK (book_name,page_number,topic,release_date,id_author)values('batman',200,'ROMANCE','2023-12-11',3);