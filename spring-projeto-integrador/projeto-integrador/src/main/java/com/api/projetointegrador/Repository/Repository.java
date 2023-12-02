package com.api.projetointegrador.Repository;

import java.sql.*;

public class Repository {

    Connection conection ;

    public Repository() throws SQLException {

    }
    public PreparedStatement createQuery(String query) throws SQLException {
        Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoIntegrador", "root", "V@caburra02");
        return conection.prepareStatement(query);
    }


}
