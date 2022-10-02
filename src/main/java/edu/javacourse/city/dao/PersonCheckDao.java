package edu.javacourse.city.dao;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;

import java.sql.*;

public class PersonCheckDao {
    private static final String SQL_REQUEST=
            " SELECT temporal FROM cr_address_person ap " +
            " INNER JOIN cr_person pp ON pp.person_id = ap.person_id " +
            " INNER JOIN cr_adress aa ON aa.address_id = ap.address_id " +
            " WHERE " +
            " UPPER(pp.sur_name)=UPPER(?) AND UPPER(pp.given_name)=UPPER(?) AND UPPER(pp.patronymic)=UPPER(?) " +
            " AND pp.date_of_bith= ? AND aa.street_code= ? AND UPPER(aa.building)=UPPER(?) AND UPPER(aa.extenssion)= UPPER(?) " +
            " AND UPPER(aa.apartment)=upper(?)";
    public PersonResponse checkPerson(PersonRequest personRequest)throws PersonCheckException{
        PersonResponse response=new PersonResponse();
        try(Connection con=getConnection();
            PreparedStatement stat = con.prepareStatement(SQL_REQUEST))
            {   //con.setAutoCommit(false);
//                try {

                    stat.setString(1, personRequest.getSurName());
                    stat.setString(2, personRequest.getGivenName());
                    stat.setString(3, personRequest.getPatromymic());
                    stat.setDate(4, java.sql.Date.valueOf(personRequest.getDateofBirth()));

                    stat.setInt(5, personRequest.getStreetCode());
                    //Çהוסü ןנמבכולû
                    stat.setString(6, personRequest.getBuilding());
                    stat.setString(7, personRequest.getExtension());
                    stat.setString(8, personRequest.getApartment());
                    ResultSet rs = stat.executeQuery();
                    if(rs.next()) {
                        response.setRegistered(true);
                        response.setTemporal(rs.getBoolean("temporal"));
                    }
           //         con.commit();
//                }catch(SQLException e){
//                    con.rollback();
//                    throw e;
//                }
            }catch(SQLException e){

            e.printStackTrace();
            throw new PersonCheckException(e);
        }


        return response;
    }
    private Connection getConnection() throws SQLException {
         return DriverManager.getConnection(
                 "jdbc:postgresql://localhost:5432/city_register",
                    "postgres",
                    "TERMIT006WIN"
                 );
    }
}
