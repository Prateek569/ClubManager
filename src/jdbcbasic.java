import com.mysql.cj.protocol.Resultset;

// access database
// make connection
// execute statement
// store result


import java.sql.*;

public class jdbcbasic {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/<Database name>"; //world is the database we are working on
        String username = "<your username>";
        String pass = "<your password>";
        Class.forName("com.mysql.cj.jdbc.Driver");

        String querry  = "select name from student where stu_id = 2";
        Connection con = DriverManager.getConnection(url,username,pass);  //creating connection with database

        Statement st = con.createStatement(); // we can use prepare statement to insert dynamically
        // in prepare statement we just set the values of ? (question mark) which we have mentioned in the querry
        ResultSet rs = st.executeQuery(querry); //result set is used to fetch data in tabular form whole row is selected


        // to update use execute update which returns no of rows affected
        // rs is the pointer to current row
        rs.next();
        // now select your particular column value either by column no or column name
        String res = rs.getString("name");
        System.out.println(res);
        st.close();
        con.close();
    }

}
