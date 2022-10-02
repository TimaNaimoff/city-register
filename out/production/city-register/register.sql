DROP TABLE IF EXISTS cr_address_person;
DROP TABLE IF EXISTS cr_person;
DROP TABLE IF EXISTS cr_adress;
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
   building varchar(10)not null,
   extenssion varchar(10),
   apartment varchar(10),
   PRIMARY KEY (address_id),
   FOREIGN KEY (district_code)REFERENCES cr_district(district_code)ON DELETE RESTRICT,
   FOREIGN KEY (street_code)REFERENCES cr_street(street_code) ON DELETE RESTRICT
);
INSERT INTO cr_adress(district_code,street_code,building,extenssion,apartment)VALUES(1,1,'build','exten','apar');
INSERT INTO cr_adress(district_code,street_code,building,extenssion,apartment)VALUES(1,1,'count1',null,'4');
CREATE TABLE cr_person(
    person_id SERIAL,
    sur_name varchar(100) not null,
    given_name varchar(100) not null,
    patronymic varchar(100) not null,
    date_of_bith date not null,

    passport_seria varchar(10),
    passport_number varchar(10),
    passport_date date,
    certificate_number varchar(10),
    certificate_date date,
    PRIMARY KEY (person_id)

);
INSERT INTO cr_person(sur_name,given_name,patronymic,date_of_bith,passport_seria,passport_number,
passport_date,certificate_number,certificate_date) VALUES ('Kozus','Balfor','Firewald','1995-03-18','6666','12343','2003-06-15',null,null);

INSERT INTO cr_person(sur_name,given_name,patronymic,date_of_bith,passport_seria,passport_number,
passport_date,certificate_number,certificate_date) VALUES ('Valenta','Balfor','Tornikay','1994-03-11','6664','12323','2001-08-04',null,null);

INSERT INTO cr_person(sur_name,given_name,patronymic,date_of_bith,passport_seria,passport_number,
passport_date,certificate_number,certificate_date) VALUES ('Kollet','Balfor','Kozuswild','2016-09-01',null,null,null,'123454','2015-04-11');

INSERT INTO cr_person(sur_name,given_name,patronymic,date_of_bith,passport_seria,passport_number,
passport_date,certificate_number,certificate_date) VALUES ('Fizzerina','Balfor','Tornikus','2018-01-09',null,null,null,'123212','2015-01-21');


CREATE TABLE cr_address_person(
    person_address_id SERIAL,
    address_id integer not null,
    person_id integer not null,
    start_date date not null,
    end_date date,
    temporal boolean DEFAULT false,
    PRIMARY KEY(person_address_id),
    FOREIGN KEY(address_id)REFERENCES cr_adress(address_id)ON DELETE RESTRICT,
    FOREIGN KEY (person_id)REFERENCES cr_person(person_id)ON DELETE RESTRICT
);
 INSERT INTO cr_address_person(address_id,person_id,start_date,end_date)VALUES(1,1,'2014-12-10',null);
 INSERT INTO cr_address_person(address_id,person_id,start_date,end_date)VALUES(2,2,'2014-12-10',null);
 INSERT INTO cr_address_person(address_id,person_id,start_date,end_date)VALUES(1,3,'2016-10-05',null);
 INSERT INTO cr_address_person(address_id,person_id,start_date,end_date)VALUES(1,4,'2018-04-10',null);




4. Персона -ФИО,дата рождения,Паспорт (серия/номер/дата выдачи),
Свидетельство о рождении (номер/дата выдачи)
5. Связь персоны и адреса - Персона,адрес и диапазон дат,вид регистрации


Бизнес-логика: Проверка персоны по адресу
