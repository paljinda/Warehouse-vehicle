import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by paljinda on 5/11/2015.
 */


public class VehicleStore {

    public void insert() {
        Vehicle vehicle = new Vehicle();
//        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter values for this cycle");
        vehicle.insert();
        Connection conn= null;

        String dbUserName= "root";
        String dbPassword = "";
        String dbUrl = "jdbc:mysql://localhost/vehiclestore";

        try {

            Class forNam = Class.forName("com.mysql.jdbc.Driver");

            try {
                forNam.newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(VehicleStore.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(VehicleStore.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
            System.out.println("Database connection establish...!");

            Statement st = conn.createStatement();
           String insertSql = "INSERT into vehicle  "+ "VALUES('" + vehicle.warehouse + "','" + vehicle.make + "','" + vehicle.model + "','" + vehicle.registrationNumber + "'," + vehicle.seat + "," + vehicle.transmission + "," + vehicle.wheel + ",'" + vehicle.startMode + "','" + vehicle.color + "'," + vehicle.speedLimit + "," + 18 + ")";
            System.out.println(insertSql);
// String insertSql = "INSERT into vehicle (Warehouse, Make, Model, Registration Number, Seat, Transmission, Wheel, Start Mode, Color, Speed Limit, Speed) "+ "VALUES(" + vehicle.warehouse + "," + vehicle.make + "," + vehicle.model + "," + vehicle.registrationNumber + "," + vehicle.seat + "," + vehicle.transmission + "," + vehicle.wheel + "," + vehicle.startMode + "," + vehicle.color + "," + 45 + "," + 18 + ")";
            int val = st.executeUpdate(insertSql);
            System.out.println("One raw get affected...");

        } catch (SQLException ex) {
            System.out.println("Cannot connect to database server...!!");
            Logger.getLogger(VehicleStore.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(conn != null){
                try{
                    conn.close();
                    System.out.println ("Database connection terminated...!!!");
                } catch (SQLException ex) {
                    Logger.getLogger(VehicleStore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }


    public void select() {
        Vehicle vehicle = new Vehicle();
//        Scanner user_input = new Scanner(System.in);
        String reg;
        System.out.println("Enter registration number of vehicle");
        Scanner user_value = new Scanner(System.in);
        reg = user_value.next();
//        vehicle.insert();
        Connection conn= null;

        String dbUserName= "root";
        String dbPassword = "";
        String dbUrl = "jdbc:mysql://localhost/vehiclestore";

        try {

            Class forNam = Class.forName("com.mysql.jdbc.Driver");

            try {
                forNam.newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(VehicleStore.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(VehicleStore.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
            System.out.println("Database connection establish...!");

            Statement st = conn.createStatement();
            String insertSql = "SELECT * FROM vehicle WHERE Registration_Number='" + reg + "'";
            System.out.println(insertSql);
// String insertSql = "INSERT into vehicle (Warehouse, Make, Model, Registration Number, Seat, Transmission, Wheel, Start Mode, Color, Speed Limit, Speed) "+ "VALUES(" + vehicle.warehouse + "," + vehicle.make + "," + vehicle.model + "," + vehicle.registrationNumber + "," + vehicle.seat + "," + vehicle.transmission + "," + vehicle.wheel + "," + vehicle.startMode + "," + vehicle.color + "," + 45 + "," + 18 + ")";
            ResultSet rs = st.executeQuery(insertSql);

            while(rs.next())
            {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));
                System.out.println(rs.getString(7));
                System.out.println(rs.getString(8));
                System.out.println(rs.getString(9));
                System.out.println(rs.getString(10));
                System.out.println(rs.getString(11));
            }
            System.out.println("Want to change speed to start press 1");
            System.out.println("Want to change speed to stop press 2");
            System.out.println("Want to change speed by value press 3");
            System.out.println("If you dont Want to change speed press 4");
            int x;
            x= user_value.nextInt();

            if(x==1)
            {
                String insertSq = "UPDATE vehicle SET speed = " + 100 + " WHERE Registration_Number='" + reg + "'";
                System.out.println(insertSq);
               int z = st.executeUpdate(insertSq);
            }

            if(x==2)
            {
                String insertSq = "UPDATE vehicle SET speed = " + 0 + " WHERE Registration_Number='" + reg + "'";
                System.out.println(insertSq);
                int z = st.executeUpdate(insertSq);
            }

            if(x==3)
            {
                int y;
                Scanner input = new Scanner(System.in);
                System.out.println("Enter value by which to increase the speed");
                y = input.nextInt();
                String insertSq = "UPDATE vehicle SET speed = speed + " + y + " WHERE Registration_Number='" + reg + "'";
                System.out.println(insertSq);
                int z = st.executeUpdate(insertSq);
            }
            insertSql = "SELECT * FROM vehicle WHERE Registration_Number='" + reg + "'";
            rs = st.executeQuery(insertSql);

            while(rs.next())
            {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));
                System.out.println(rs.getString(7));
                System.out.println(rs.getString(8));
                System.out.println(rs.getString(9));
                System.out.println(rs.getString(10));
                System.out.println(rs.getString(11));
            }
            if(x==4)
            {
                return;
            }

//            System.out.println("Want to change speed to start press 4");

        } catch (SQLException ex) {
            System.out.println("Cannot connect to database server...!!");
            Logger.getLogger(VehicleStore.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(conn != null){
                try{
                    conn.close();
                    System.out.println ("Database connection terminated...!!!");
                } catch (SQLException ex) {
                    Logger.getLogger(VehicleStore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
