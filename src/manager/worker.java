package manager;

import database.connect;
import java.sql.SQLException;
import java.util.Scanner;

public class worker {

    Scanner sc = new Scanner(System.in);
    connect con;

    public worker() throws SQLException, ClassNotFoundException {
        con = new connect();
    }

    public void addClub() throws SQLException {
        String name;
        System.out.println("enter name of club to be added");
        name = sc.nextLine();

        con.addClub(name);

    }

    public void addMember() throws  SQLException {
        System.out.println("Enter name ,email, club_id, phone ,  ac_no");

        String name = sc.nextLine();
        System.out.println("name : " + name);
        String email = sc.nextLine();
        System.out.println("email added");
        int c_id = sc.nextInt();
        System.out.println("cid added");
        int phno = sc.nextInt();
        System.out.println("phno added");
        int acno = sc.nextInt();
        System.out.println("acc no added");

        con.addMember(name, c_id, phno, email, acno);
    }

    public void showClubId() throws  SQLException {
        System.out.println("enter name of club");
        String name = sc.nextLine();
        con.ShowClub(name);
    }

    public void CheckBalance() throws SQLException {
        System.out.println("enter member id");
        int m_id = sc.nextInt();
        con.showBalance(m_id);
    }

    public void viewClubList() throws  SQLException  {
        System.out.println("enter club_id");
        int id = sc.nextInt();
        con.viewClubDetails(id);
    }

    public void transactions() throws SQLException {
        System.out.println("press 1 to add money and 2 to deduct");
        int i = sc.nextInt();
        if(i == 1) addMoney();
        else deduct();

    }

    private void deduct() throws SQLException {
        System.out.println("enter member id and amount");
        int id = sc.nextInt();
        int amt = sc.nextInt();
        con.deductMoney(id, amt);
    }

    private void addMoney() throws SQLException  {
        System.out.println("enter member id and amount");
        int id = sc.nextInt();
        int amt = sc.nextInt();
        con.addMoney(id, amt);

    }
}
