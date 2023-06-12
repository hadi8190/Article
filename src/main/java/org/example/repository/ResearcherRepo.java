package org.example.repository;

import org.example.model.Researcher;
import org.example.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResearcherRepo {
    private static final String INSERT_QUERY = "insert into researcher(user_name,national_code,password ) values (?,?,?)";
    private static final String SELECT_BY_NATIONAL_CODE_QUERY = "select * from researcher where national_code=?";
    private static final String SELECT_QUERY = "select * from researcher where (national_code = ? and password=?)";
    private static final String UPDATE_PASSWORD_QUERY = "update researcher set password = ? where id = ?";


    public static void createResearcher(Researcher researcher){
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, researcher.getUserName());
            preparedStatement.setString(2, researcher.getNationalCode());
            preparedStatement.setString(3, researcher.getPassword());

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Researcher findResearcherByNationalCode(String inputNationalCode) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NATIONAL_CODE_QUERY);
            preparedStatement.setString(1, inputNationalCode);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt(1);
                String username = resultSet.getString(2);
                String nationalCode = resultSet.getString(3);
                String password = resultSet.getString(4);
                return new Researcher(id,username,nationalCode,password);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static Researcher findResearcher(String inputNationalCode,String inputPassword) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, inputNationalCode);
            preparedStatement.setString(2, inputPassword);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt(1);
                String username = resultSet.getString(2);
                String nationalCode = resultSet.getString(3);
                String password = resultSet.getString(4);
                return new Researcher(id,username,nationalCode,password);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void updateResearcherPassword(Researcher researcher,String newPassword){
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD_QUERY);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, researcher.getResearcherId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}

