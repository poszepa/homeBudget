CREATE DATABASE kwiecien2022 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


CREATE TABLE wyplata(
    id INT AUTO_INCREMENT,
    wyplata DOUBLE,
    PRIMARY KEY (id)
);

CREATE TABLE kieszonkowe(
    id INT AUTO_INCREMENT,
    nazwaWydatku VARCHAR(50),
    opisWydatku VARCHAR(50),
    kwotaWydatku DOUBLE,
    dataDodania DATE,
    PRIMARY KEY (id)
);

CREATE TABLE zobowiazania(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   PRIMARY KEY (id)
);

CREATE TABLE potrzeby_codzienne(
                            id INT AUTO_INCREMENT,
                            nazwaWydatku VARCHAR(50),
                            opisWydatku VARCHAR(50),
                            kwotaWydatku DOUBLE,
                            dataDodania DATE,
                            PRIMARY KEY (id)
);

CREATE TABLE podarunki(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   PRIMARY KEY (id)
);

CREATE TABLE dom(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   PRIMARY KEY (id)
);

CREATE TABLE ubezpieczenie(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   PRIMARY KEY (id)
);

CREATE TABLE technologia(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   PRIMARY KEY (id)
);

CREATE TABLE transport(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   PRIMARY KEY (id)
);

CREATE TABLE podroze(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   PRIMARY KEY (id)
);

CREATE TABLE media(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   PRIMARY KEY (id)
);

CREATE TABLE oszczednosci(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   PRIMARY KEY (id)
);

CREATE TABLE zdrowie(
                                   id INT AUTO_INCREMENT,
                                   nazwaWydatku VARCHAR(50),
                                   opisWydatku VARCHAR(50),
                                   kwotaWydatku DOUBLE,
                                   dataDodania DATE,
                                   PRIMARY KEY (id)
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

