CREATE DATABASE kwiecien2022 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE miesiace CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE users CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE miesiac(
                        id INT AUTO_INCREMENT,
                        nazwa_miesiaca VARCHAR(20),
                        PRIMARY KEY (id)
);

CREATE TABLE rok(
                    id INT AUTO_INCREMENT,
                    rok INT,
                    PRIMARY KEY (id));

CREATE TABLE wyplata(
    id INT AUTO_INCREMENT,
    wyplata DOUBLE,
    opis VARCHAR(100),
    data_dodania DATE,
    userID INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userID) REFERENCES users.user(id)
);

CREATE TABLE kieszonkowe(
    id INT AUTO_INCREMENT,
    nazwaWydatku VARCHAR(50),
    opisWydatku VARCHAR(50),
    kwotaWydatku DOUBLE,
    dataDodania DATE,
    userID INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userID) REFERENCES users.user(id)
);

CREATE TABLE zobowiazania(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   userID INT NOT NULL,
                                   PRIMARY KEY (id),
                                   FOREIGN KEY (userID) REFERENCES users.user(id)
);

CREATE TABLE potrzeby_codzienne(
                            id INT AUTO_INCREMENT,
                            nazwaWydatku VARCHAR(50),
                            opisWydatku VARCHAR(50),
                            kwotaWydatku DOUBLE,
                            dataDodania DATE,
                            userID INT NOT NULL,
                            PRIMARY KEY (id),
                            FOREIGN KEY (userID) REFERENCES users.user(id)
);

CREATE TABLE podarunki(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   userID INT NOT NULL,
                                   PRIMARY KEY (id),
                                   FOREIGN KEY (userID) REFERENCES users.user(id)
);

CREATE TABLE dom(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   userID INT NOT NULL,
                                   PRIMARY KEY (id),
                                   FOREIGN KEY (userID) REFERENCES users.user(id)
);

CREATE TABLE ubezpieczenie(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   userID INT NOT NULL,
                                   PRIMARY KEY (id),
                                   FOREIGN KEY (userID) REFERENCES users.user(id)
);

CREATE TABLE technologia(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   userID INT NOT NULL,
                                   PRIMARY KEY (id),
                                   FOREIGN KEY (userID) REFERENCES users.user(id)
);

CREATE TABLE transport(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   userID INT NOT NULL,
                                   PRIMARY KEY (id),
                                   FOREIGN KEY (userID) REFERENCES users.user(id)
);

CREATE TABLE podroze(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   userID INT NOT NULL,
                                   PRIMARY KEY (id),
                                   FOREIGN KEY (userID) REFERENCES users.user(id)
);

CREATE TABLE media(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   userID INT NOT NULL,
                                   PRIMARY KEY (id),
                                   FOREIGN KEY (userID) REFERENCES users.user(id)
);

CREATE TABLE oszczednosci(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   userID INT NOT NULL,
                                   PRIMARY KEY (id),
                                   FOREIGN KEY (userID) REFERENCES users.user(id)
);

CREATE TABLE zdrowie(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   userID INT NOT NULL,
                                   PRIMARY KEY (id),
                                   FOREIGN KEY (userID) REFERENCES users.user(id)
);

INSERT INTO miesiace.miesiac(nazwa_miesiaca) VALUES ('Styczen');
INSERT INTO miesiace.miesiac(nazwa_miesiaca) VALUES ('Luty');
INSERT INTO miesiace.miesiac(nazwa_miesiaca) VALUES ('Marzec');
INSERT INTO miesiace.miesiac(nazwa_miesiaca) VALUES ('Kwiecien');
INSERT INTO miesiace.miesiac(nazwa_miesiaca) VALUES ('Maj');
INSERT INTO miesiace.miesiac(nazwa_miesiaca) VALUES ('Czerwiec');
INSERT INTO miesiace.miesiac(nazwa_miesiaca) VALUES ('Lipiec');
INSERT INTO miesiace.miesiac(nazwa_miesiaca) VALUES ('Sierpien');
INSERT INTO miesiace.miesiac(nazwa_miesiaca) VALUES ('Wrzesien');
INSERT INTO miesiace.miesiac(nazwa_miesiaca) VALUES ('Pazdziernik');
INSERT INTO miesiace.miesiac(nazwa_miesiaca) VALUES ('Listopad');
INSERT INTO miesiace.miesiac(nazwa_miesiaca) VALUES ('Grudzien');

INSERT INTO miesiace.rok(rok) VALUES (2022);
INSERT INTO miesiace.rok(rok) VALUES (2023);


create table users.user
(
    id       int auto_increment,
    email    varchar(50)  not null,
    password varchar(100) not null,
    constraint user_email_uindex
        unique (email),
    constraint user_id_uindex
        unique (id)
);

alter table users.user
    add primary key (id);


CREATE DATABASE NazwyBazDanych CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

create table nazwy_baz_danych
(
    `1`       int auto_increment,
    nazwy_baz varchar(50) null,
    constraint nazwy_baz_danych_1_uindex
        unique (`1`)
);

alter table nazwy_baz_danych
    add primary key (`1`);

INSERT INTO NazwyBazDanych.nazwy_baz_danych(nazwy_baz) VALUES ('kwiecien2022');