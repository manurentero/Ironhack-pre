/*Ironhack prework*/
CREATE TABLE rating (
    id INT,
    app_name VARCHAR(255),
    app_size BIGINT,
    price DECIMAL(5,2),
    total_ratings DECIMAL(2,1),
    genre VARCHAR(50)
);

INSERT INTO rating (id, app_name, app_size, price, total_ratings, genre)
values (281656475, "PAC-MAN Premium", 100788224, 3.99, 4.5, "Games");

INSERT INTO rating (id, app_name, app_size, price, total_ratings, genre)
values (32165, "Centipede", 99632342, 5.99, 3.7, "Games");

INSERT INTO rating (id, app_name, app_size, price, total_ratings, genre)
values (6549873, "Dracula", 10243, 1.99, 4.9, "Books");

select * 
from rating;

/*EX - 1*/
select sum(price)
from rating;

/*EX - 2*/
select max(total_ratings)
from rating;

/*EX - 3*/
select avg(price)
from rating
group by genre;
