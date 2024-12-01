import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Connection_With_ODBC_JDBC {
    public static void main(String[] args) {
        try {
            // Loading the ODBC driver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // Establishing the connection to the database
            Connection con = DriverManager.getConnection("jdbc:odbc:ds", "System", "Manager");

            // Creating a statement object
            Statement st = con.createStatement();

            // Executing an SQL update (inserting data into the "student" table)
            String sql = "INSERT INTO student (column1, column2, column3) VALUES (value1, value2, value3)";
            st.executeUpdate(sql);

            // Closing the resources
            st.close();
            con.close();

            System.out.println("Data inserted successfully!");

        } catch (ClassNotFoundException | SQLException e) {
            // Handling exceptions
            e.printStackTrace();
        }
    }
}
