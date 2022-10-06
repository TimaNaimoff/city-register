DELETE FROM cr_address_person
DELETE FROM cr_person
DELETE FROM cr_adress
DELETE FROM cr_street
DELETE FROM cr_district


SELECT temporal FROM cr_address_person ap
INNER JOIN cr_person pp ON pp.person_id = ap.person_id
INNER JOIN cr_adress aa ON aa.address_id = ap.address_id
WHERE
UPPER(pp.sur_name)=UPPER('Kozus') AND UPPER(pp.given_name)=UPPER('Balfor') AND UPPER(pp.patronymic)=UPPER('Firewald')
AND pp.date_of_bith='1995-03-18' AND aa.street_code= 1 AND UPPER(aa.building)=UPPER('10') AND UPPER(aa.extenssion)=UPPER('6')
AND UPPER(aa.apartment)=UPPER('8')




"SELECT temporal FROM cr_address_person ap " +
            "INNER JOIN cr_person pr ON pr.person_id = ap.person_id " +
            "INNER JOIN cr_adress ad ON ad.address_id = ap.address_id " +
            "WHERE " +
            "UPPER(pr.sur_name)=UPPER(?) AND UPPER(pr.given_name)=UPPER(?) AND UPPER(patronymic)=UPPER(?) " +
            "AND pr.date_of_bith=? AND ad.street_code= ? AND UPPER(ad.building)=UPPER(?) AND UPPER(ad.extension)=UPPER(?) " +
            "AND UPPER(ad.apartment)=UPPER(?)"


            http://localhost:8080/city-register-1.0/checkPerson?surname=Kozus&givenname=Balfor&patronymic=Firewald&dateofBith=18.03.1995&streetCode=1&building=build&extension=exten&apartment=apar&surname=Kozus