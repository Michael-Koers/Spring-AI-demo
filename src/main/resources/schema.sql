CREATE TABLE book
(
    id     serial primary key not null,
    author varchar(100)       NOT NULL,
    title  varchar(100)       NOT NULL,
    price  money              NOT NULL
);