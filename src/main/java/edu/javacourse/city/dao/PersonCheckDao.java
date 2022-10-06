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
            " CURRENT_DATE >= ap.start_date AND (CURRENT_DATE<=ap.end_date OR ap.end_date is null)"+
            " AND UPPER(pp.sur_name)=UPPER(?) AND UPPER(pp.given_name)=UPPER(?) AND UPPER(pp.patronymic)=UPPER(?) " +
            " AND pp.date_of_bith= ? AND aa.street_code= ? AND UPPER(aa.building)=UPPER(?)";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder){
        this.connectionBuilder=connectionBuilder;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }


    public PersonResponse checkPerson(PersonRequest personRequest)throws PersonCheckException {
        PersonResponse response = new PersonResponse();

        String sql = SQL_REQUEST;
        if (personRequest.getExtension() != null) {
            sql += " AND UPPER(aa.extenssion)= UPPER(?)";
        }

        else {
            sql += " AND aa.extenssion IS null ";
        }
        if(personRequest.getApartment()!=null){
            sql+=" AND UPPER(aa.apartment)=upper(?)";
        }
        else {
            sql+=" AND aa.apartment IS null ";
        }
        try(Connection con=getConnection();
            PreparedStatement stat = con.prepareStatement(sql))
            {   //con.setAutoCommit(false);
//                try {
                    int count=1;
                    stat.setString(count++, personRequest.getSurName());
                    stat.setString(count++, personRequest.getGivenName());
                    stat.setString(count++, personRequest.getPatromymic());
                    stat.setDate(count++, java.sql.Date.valueOf(personRequest.getDateofBirth()));

                    stat.setInt(count++, personRequest.getStreetCode());
                    //Çהוסü ןנמבכולû
                    stat.setString(count++, personRequest.getBuilding());
                    if(personRequest.getExtension()!=null) {
                        stat.setString(count++, personRequest.getExtension());
                    }
                    if(personRequest.getApartment()!=null) {
                        stat.setString(count++, personRequest.getApartment());
                    }
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
            throw new PersonCheckException();
        }


        return response;
    }

}
