
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class connection {
    private Connection con;
    Statement statement;

    public connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bms_db";
            con = DriverManager.getConnection(url, "root", "");
            statement = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Database connection: " + e.getMessage());
        }
    } 
    public String date(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String StringTime = dateTime.format(formate);
        return StringTime; 
    }
}