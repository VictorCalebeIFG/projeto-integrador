package com.api.projetointegrador.Repository;

import com.api.projetointegrador.Model.User;

import java.sql.*;

public class UserRepository {
    PreparedStatement query;
    Connection connection;
    public UserRepository() throws SQLException {
        Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoIntegrador", "root", "V@caburra02");
        query = conection.prepareStatement("INSERT INTO user (login, email, nome_artistico, senha) VALUES (?, ?, ?,?)");
    }

    public void saveUser(User user) throws SQLException {
        query.setString(1,user.getLogin());
        query.setString(2,user.getEmail());
        query.setString(3,user.getNome_artistico());
        query.setString(4,user.getSenha());
        query.execute();
    }

    public User getuser(String login) throws SQLException {
        Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoIntegrador", "root", "V@caburra02");
        User user = null;
        PreparedStatement query = conection.prepareStatement("SELECT * FROM USER WHERE login = ?");
        query.setString(1,login);
        ResultSet resultSet = query.executeQuery();

        if (resultSet.next()){
            String login_ = resultSet.getString("login");
            String email_ = resultSet.getString("email");
            String nome_artistico_ = resultSet.getString("nome_artistico");
            String senha_ = resultSet.getString("senha");
            
            user = new User(login_,email_,nome_artistico_,senha_);
        }


        return user;
    }


}
