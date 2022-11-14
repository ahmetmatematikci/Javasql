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

         //Aşağıdaki methodların çağırlması
        
        /*
        insertDemo();
        updateData();
        selectDemo();
        deletedata();
        
        */
 

    }
    
    public static void deleteData() throws SQLException {
    
    
         Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {

           connection = helper.getConnection();
            String sql = "delete from city where id = ?";
            statement = connection.prepareStatement(sql);
           statement.setInt(1,4097);
           
            int result = statement.executeUpdate();

            System.out.println("KayÄ±t silindi : " + result);


        } catch (SQLException ex) {
            //Logger.getLogger(JDBCCalismalari.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Oturum yok");
            helper.showErrorMessage(ex);
        } finally {

            try {
                connection.close();
                statement.close();
            } catch (SQLException ex) {
                helper.showErrorMessage(ex);

            }
        }
    
    }
    
    
    public static  void updateData() throws SQLException {
    
           Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {

           connection = helper.getConnection();
            String sql = "update city set population=?, district= ? where id = ?";
            statement = connection.prepareStatement(sql);
           statement.setInt(1,80000);
           statement.setString(2,"ISkenderun");
           statement.setInt(3, 4097);
            int result = statement.executeUpdate();

            System.out.println("KayÄ±t güncelledini : " + result);


        } catch (SQLException ex) {
            //Logger.getLogger(JDBCCalismalari.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Oturum yok");
            helper.showErrorMessage(ex);
        } finally {

            try {
                connection.close();
                statement.close();
            } catch (SQLException ex) {
                helper.showErrorMessage(ex);

            }
        }
    
    
    }
    
    
    public static void insertDemo() throws SQLException {
    
    
       Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {

           connection = helper.getConnection();
            String sql = "insert into city(Name, CountryCode, District, Population) values (?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "Osmaniye");
            statement.setString(2, "TUR");
            statement.setString(3, "Turkiye");
            statement.setInt(4, 123456);
            int result = statement.executeUpdate();

            System.out.println("KayÄ±t eklendi : " + result);


        } catch (SQLException ex) {
            //Logger.getLogger(JDBCCalismalari.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Oturum yok");
            helper.showErrorMessage(ex);
        } finally {

            try {
                connection.close();
                statement.close();
            } catch (SQLException ex) {
                helper.showErrorMessage(ex);

            }
        }
    
    
    
    }
    

    public static void selectDemo() throws SQLException {

        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;

        try {

            connection = helper.getConnection();
            statement = connection.createStatement();
            String sql = "select Code, Name, Region, Continent from country ";

            resultSet = statement.executeQuery(sql); //hata
            ArrayList<Country> contries = new ArrayList<Country>();

            while (resultSet.next()) {
                contries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }
            System.out.println(contries.size());

        } catch (SQLException ex) {
            //Logger.getLogger(JDBCCalismalari.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Oturum yok");
            helper.showErrorMessage(ex);
        } finally {

            try {
                connection.close();
            } catch (SQLException ex) {
                helper.showErrorMessage(ex);

            }
        }

    }

}
