INSERT INTO ? (nazwaWydatku, opisWydatku, kwotaWydatku, dataDodania) VALUES (? , ?, ?, CURRENT_TIMESTAMP);

SELECT * FROM miesiace.miesiac;

SELECT * FROM miesiace.rok;



INSERT INTO kwiecien2022.dom (nazwaWydatku, opisWydatku, kwotaWydatku, dataDodania) VALUES (20 , 20, 20, CURRENT_TIMESTAMP);



SHOW TABLES  FROM kwiecien2022;

SELECT SUM(kwotaWydatku) AS SUM FROM kwiecien2022.dom;

SELECT * FROM kwiecien2022.dom WHERE id=1;

SELECT * FROM kwiecien2022.podarunki WHERE id= 2;

SELECT * FROM kwiecien2022.dom WHERE id= 2;