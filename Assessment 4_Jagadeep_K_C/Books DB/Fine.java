package LibManagement;

import java.sql.*;

public class Fine {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            
            con = DBConnection.getConnection();
            

            String updateQuery =
                    "update members m " +
                    "join borrows b on m.member_id = b.member_id " +
                    "set m.fine_amount = 500 " +
                    "where m.membership_type = 'Basic' and b.status = 'Overdue'";

            pstmt = con.prepareStatement(updateQuery);
            int rows = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rows);

            String selectQuery =
                    "select m.first_name, m.last_name, m.membership_type, " +
                    "b.status, m.fine_amount " +
                    "from members m " +
                    "join borrows b on m.member_id = b.member_id " +
                    "where m.membership_type = 'Basic' and b.status = 'Overdue'";

            stmt = con.createStatement();
            rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                System.out.println(rs.getString("first_name") + " | " +rs.getString("last_name") + " | " + rs.getString("membership_type") + " | " +rs.getString("status") + " | " + rs.getDouble("fine_amount"));
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
