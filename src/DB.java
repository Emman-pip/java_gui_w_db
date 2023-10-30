import java.io.*;
import java.sql.*;
import java.util.LinkedList;

public class DB {
    String url = "jdbc:mysql://localhost:3306/medicalDB";
    String pass = "108996eE@emman";
    String username = "root";

    public static void update(String Id, String name, String diagnosis, String prescription, String description)
            throws Exception {
        DB db = new DB();
        String url = db.url;
        String username = db.username;
        String pass = db.pass;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, pass);
        Statement st = con.createStatement();

        String query = String.format(
                "UPDATE patient_data SET name = '%s', diagnosis = '%s', prescription = '%s', description = '%s' WHERE patient_id = %s",
                name, diagnosis, prescription, description, Id);

        // System.out.println(query);
        int rs = st.executeUpdate(query);
        con.close();
    }

    public static void del(int Id) throws Exception {
        DB db = new DB();
        String url = db.url;
        String username = db.username;
        String pass = db.pass;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, pass);
        Statement st = con.createStatement();
        String query = String.format("DELETE FROM patient_data where patient_id = %d", Id);

        int rs = st.executeUpdate(query);
        // System.out.println(query);
        con.close();
    }

    public static void insert(String name, String diagnosis, String prescription, String description) throws Exception {
        DB db = new DB();
        String url = db.url;
        String username = db.username;
        String pass = db.pass;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, pass);
        Statement st = con.createStatement();

        String query = String.format(
                "INSERT INTO patient_data(name, diagnosis, prescription, description) VALUES ('%s', '%s', '%s', '%s')",
                name, diagnosis, prescription, description);
        System.out.println(query);
        int rs = st.executeUpdate(query);
        con.close();
    }

    public static LinkedList<String[]> select() throws Exception {
        DB db = new DB();
        String url = db.url;
        String username = db.username;
        String pass = db.pass;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, pass);
        Statement st = con.createStatement();

        String query = "SELECT * FROM patient_data";
        ResultSet rs = st.executeQuery(query);
        LinkedList<String[]> data = new LinkedList<String[]>();
        while (rs.next()) {
            String[] list = { Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5) };
            data.add(list);
        }
        System.out.println(data);
        con.close();
        return data;
    }

    public static LinkedList<String> selectWithID(String id) throws Exception {
        DB db = new DB();
        String url = db.url;
        String username = db.username;
        String pass = db.pass;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, pass);
        Statement st = con.createStatement();

        String query = "SELECT * FROM patient_data WHERE patient_id = " + id;
        ResultSet rs = st.executeQuery(query);
        LinkedList<String> data = new LinkedList<String>();
        while (rs.next()) {
            data.add("" + rs.getInt(1));
            data.add(rs.getString(2));
            data.add(rs.getString(3));
            data.add(rs.getString(4));
            data.add(rs.getString(5));

        }
        System.out.println(data);
        con.close();
        return data;
    }

    public static void main(String[] args) throws Exception {
    }
}