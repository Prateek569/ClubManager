package manager;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
      Scanner sc = new Scanner(System.in);
        int i;
        do {
            System.out.println("welcome to club management");
            System.out.println("press 1 to add club");
            System.out.println("press 2 to add member");
            System.out.println("press 3 to show club id");
            System.out.println("press 4 to to transactions");
            System.out.println("press 5 to view clubs");
            System.out.println("press 6 to check balance");
            System.out.println("press 7 to exit");

            i = sc.nextInt();

            handle(i);

        }while(i < 7 && i > 0);

    }

    private static void handle(int i) throws SQLException, ClassNotFoundException {
        worker w = new worker();

        switch (i) {
            case 1 -> w.addClub();
            case 2 -> w.addMember();
            case 3 -> w.showClubId();
            case 4 -> w.transactions();
            case 5 -> w.viewClubList();
            case 6 -> w.CheckBalance();
            default -> System.out.println("enter valid response");
        }
    }
}
