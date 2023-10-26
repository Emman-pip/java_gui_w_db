import java.io.*;
import java.sql.*;
import java.util.LinkedList;



public class DB{
    String url = "jdbc:mysql://localhost:3306/medicalDB";
    String pass = "108996eE@emman"; 
    String username = "root";

    public static void insert(String name, String diagnosis, String prescription, String description) throws Exception {
        DB db = new DB();
        String url = db.url;
        String username = db.username; 
        String pass = db.pass; 
 
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, pass);
        Statement st = con.createStatement();
        
        String query = String.format("INSERT INTO patient_data(name, diagnosis, prescription, description) VALUES ('%s', '%s', '%s', '%s')", name, diagnosis, prescription, description);
        System.out.println(query);
        int rs = st.executeUpdate(query);
        // con.commit();
        con.close();
    }
    public static LinkedList<String> select() throws Exception{
        DB db = new DB();
        String url = db.url;
        String username = db.username; 
        String pass = db.pass;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, pass);
        Statement st = con.createStatement();
        
        String query = "SELECT * FROM patient_data";
        ResultSet rs = st.executeQuery(query);
        LinkedList<String> data = new LinkedList<String>();
        while (rs.next()){
            data.add(rs.getInt(1) + " " +rs.getString(2) + " " +rs.getString(3) + " " +rs.getString(4) + " " +rs.getString(5));
        }
        // System.out.println(data);
        con.close();
        return data;
    }
    public static void main(String[] args) throws Exception{
        // insert("someoneNew", "something", "something", "something");
        // select();
    }
}