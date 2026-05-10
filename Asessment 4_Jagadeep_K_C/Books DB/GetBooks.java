package LibManagement;

import java.sql.*;

public class GetBooks {

    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            
            con = DBConnection.getConnection();
            

            String query = "select * from books";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getInt("book_id") + " | " + rs.getString("title") + " | " + rs.getString("author") + " | " + rs.getString("isbn") + " | " + rs.getDouble("price"));
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
      
    }
}
