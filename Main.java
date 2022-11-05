/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author imdah
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        //ekleme
        //insert into city(Name, CountryCode, District, Population) values ('Düzce','TUR','Düzce', 5000)
        // silme
        //delete from city where id= 4080   
        //güncelleme
        //update city set Population = 6000 where name = 'Düzce'    

        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            //  System.out.println("Bağlantı Kuruldu");

            connection = helper.getConnection();
            String sql = "delete from city where id =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4083);
            int result = statement.executeUpdate();
            System.out.println("Kayıt Silindi : ");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            helper.showErrorMessage(e);
        } finally {
            statement.close();

            connection.close();
        }

    }

    public static void selectDemo() throws SQLException {

        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;

        try {
            //  System.out.println("Bağlantı Kuruldu");

            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code, Name, Region, Continent from country");
            ArrayList<Country> countrys = new ArrayList<Country>();
            while (resultSet.next()) {
                //System.out.println(resultSet.getString("Name")); // iptal
                countrys.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Region"),
                        resultSet.getString("Continent")));

            }

            System.out.println(countrys.size());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            helper.showErrorMessage(e);
        } finally {

            connection.close();
        }

    }

    public static void insertData() throws SQLException {

        //ekleme
        //insert into city(Name, CountryCode, District, Population) values ('Düzce','TUR','Düzce', 5000)
        // silme
        //delete from city where id= 4080   
        //güncelleme
        //update city set Population = 6000 where name = 'Düzce'    
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            //  System.out.println("Bağlantı Kuruldu");

            connection = helper.getConnection();
            String sql = "insert into city(Name, CountryCode, District, Population) values (?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "Osmaniye");
            statement.setString(2, "TUR");
            statement.setString(3, "Turkiye");
            statement.setInt(4, 123456);
            int result = statement.executeUpdate();

            System.out.println("Kayıt eklendi : " + result);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            helper.showErrorMessage(e);
        } finally {
            statement.close();

            connection.close();
        }

    }
    
    
    public static void updateData() throws SQLException{
    
      //ekleme
        //insert into city(Name, CountryCode, District, Population) values ('Düzce','TUR','Düzce', 5000)
        // silme
        //delete from city where id= 4080   
        //güncelleme
        //update city set Population = 6000 where name = 'Düzce'    

        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            //  System.out.println("Bağlantı Kuruldu");

            connection = helper.getConnection();
            String sql = "update city set population=1500, district = 'Akdeniz' where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4500);
            int result = statement.executeUpdate();
            System.out.println("Kayıt Güncellendi : ");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            helper.showErrorMessage(e);
        } finally {
            statement.close();

            connection.close();
        }

    
    
    }

}
