package cinema;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the number of seats in each row:");
        int seatsInRows = sc.nextInt();
        sc.nextLine();
        Cinema cinema = new Cinema(rows, seatsInRows);

        int option;
        while (true) {
            System.out.println();
            cinema.printMenu();
            option = sc.nextInt();
            sc.nextLine();
            System.out.println();
            if (option == 1) {
                cinema.display();
            } else if (option == 2) {
                Seat seat = cinema.takeInput(sc);
                cinema.buyTicket(seat.getRow(), seat.getSeatInRows());
            } else if (option == 3) {
                cinema.printStatistics();
            } else if (option == 0) {
                break;
            }
        }


    }
}
