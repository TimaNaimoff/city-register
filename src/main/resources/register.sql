DROP TABLE IF EXISTS cr_address_person;
DROP TABLE IF EXISTS cr_person;
DROP TABLE IF EXISTS cr_address;
DROP TABLE IF EXISTS cr_street;
DROP TABLE IF EXISTS cr_district;



CREATE TABLE cr_district (
    district_code integer not null,
    district_name varchar(300),
    PRIMARY KEY(district_code)
);
INSERT INTO cr_district(district_code,district_name)VALUES(1,'Балфоров район');



CREATE TABLE cr_street(
    street_code integer not null,
    street_name varchar(300),
    PRIMARY KEY(street_code)
);

INSERT INTO cr_street(street_code,street_name)VALUES(1,'Проспект Инсания');

CREATE TABLE cr_adress(
   address_id SERIAL,
   district_code integer not null,
   street_code integer not null,
   building varchar(10),
   extension varchar(10),
   apartment varchar(10),
   PRIMARY KEY (address_id),
   FOREIGN KEY (street_code)REFERENCES cr_street(street_code) ON DELETE RESTRICT,
   FOREIGN KEY (district_code)REFERENCES cr_district(district_code)ON DELETE RESTRICT
);
INSERT INTO cr_adress(district_name,street_code,building,extension,apartment)VALUES(1,1,'10','6','666');

CREATE TABLE cr_person(
    person_id SERIAL not null,
    sur_name varchar(100) not null,
    given_name varchar(100) not null,
    patronymic varchar(100) not null,
    date_of_bith date not null,
    passport_seria varchar(10),
    passport_number varchar(10),
    passport_date date not null
    certificate_number varchar(10),
    certificate_date date,
    PRIMARY KEY (person_id)

);
INSERT INTO cr_person(sur_name,given_name,patronymic,date_of_bith,passport_seria,passport_number,
passport_date,certificate_number,certificate_date) VALUES ('Kozus','Balfor','Firewild','1995-03-18','6666','12343','2015-04-11');

INSERT INTO cr_person(sur_name,given_name,patronymic,date_of_bith,passport_seria,passport_number,
passport_date,certificate_number,certificate_date) VALUES ('Valenta','Balfor','Tornikay','1994-03-11','6664','12323','2015-04-11');

INSERT INTO cr_person(sur_name,given_name,patronymic,date_of_bith,passport_seria,passport_number,
passport_date,certificate_number,certificate_date) VALUES ('Kollet','Balfor','Kozuswild','2016-09-01',null,null,'2015-04-11');

INSERT INTO cr_person(sur_name,given_name,patronymic,date_of_bith,passport_seria,passport_number,
passport_date,certificate_number,certificate_date) VALUES ('Fizzerina','Balfor','Tornikus','2018-01-09',null,null,'2015-04-11');


CREATE TABLE cr_address_person(
    person_address_id SERIAL,
    address_id integer not null,
    person_id integer not null,
    start_date date not null,
    end_date date,
    PRIMARY KEY(person_address_id),
    PRIMARY KEY(address_id)REFERENCES cr_adress(address_id)ON DELETE RESTRICT,
    PRIMARY KEY (person id)REFERENCES cr_person(person_id)ON DELETE RESTRICT,



)
4. Персона -ФИО,дата рождения,Паспорт (серия/номер/дата выдачи),
Свидетельство о рождении (номер/дата выдачи)
5. Связь персоны и адреса - Персона,адрес и диапазон дат,вид регистрации


Бизнес-логика: Проверка персоны по адресу
