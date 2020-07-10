package database;

import java.sql.*;

public class connect {

    String url = "jdbc:mysql://localhost:3306/<Database Name>";
    String username = "<username>";
    String pass = "<password>";
    Connection con;

    public connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url,username,pass);
    }


    public void addClub(String name) throws SQLException {
        String querry  = "INSERT INTO `clublist` (`name`) VALUES ('" + name + "')";
        Statement st = con.createStatement();
        int rs = st.executeUpdate(querry);
        System.out.println("club added" + rs);
    }

    public void addMember(String name, int c_id, int phno, String email, int acno) throws SQLException {
        String querry  = "INSERT INTO `members` ( `name`, `c_id`, `phone`, `emali`, `account_no`, `balance`) VALUES ( ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(querry);
        st.setString(1,name);
        st.setInt(2,c_id);
        st.setInt(3,phno);
        st.setString(4,email);
        st.setInt(5,acno);
        st.setInt(6,0);
        st.executeUpdate();
        System.out.println("member added");


    }

    public void ShowClub(String name) throws SQLException {
        String querry  = "select c_id from clublist where name = " + "\"" + name + "\"";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(querry);
        rs.next();
        int res = rs.getInt("c_id");
        System.out.println("club id : " + res);
    }

    public void showBalance(int m_id) throws SQLException {
        String querry  = "select balance from members where m_id = " + m_id;

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(querry);
        rs.next();
        int res = rs.getInt("balance");
        System.out.println("balance : " + res);
    }

    public void viewClubDetails(int id) throws SQLException {
        String querry = "select name from members where c_id = "+ id;

        int i =1;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(querry);
        while(rs.next()) {
            String res = rs.getString("name");
            System.out.println("member "+ i + " : " + res);
            i++;
        }
    }

    public void addMoney(int id, int amt) throws SQLException {

        String querry  = "select balance from members where m_id = " + id;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(querry);
        rs.next();

        int res = rs.getInt("balance");

        int newbalance = res+amt;
        querry = "update members set balance = "+  newbalance + " where m_id = " + id;
        System.out.println(querry);
        st.executeUpdate(querry);
        System.out.println("new balance : " + newbalance);
    }

    public void deductMoney(int id, int amt) throws SQLException {

            String querry  = "select balance from members where m_id = " + id;
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(querry);
            rs.next();
            int res = rs.getInt("balance");

            int newbalance;
            if(res < amt) System.out.println("low balance cannot deduct");
            else {
                newbalance = res-amt;
                querry = "update members set balance = "+  newbalance + " where m_id = " + id;
                System.out.println(querry);
                st.executeUpdate(querry);
                System.out.println("new balance : " + newbalance);
            }

        }
}

