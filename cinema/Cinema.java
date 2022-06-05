package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    private final int rows;
    private final int seatInRows;
    private final int numberOfSeats;
    private final char[][] seats;
    private int price1 = 10;
    private int price2 = 8;
    private int purchasedTickets = 0;
    private int currentIncome = 0;


    public Cinema(int rows, int seatInRows) {
        this.rows = rows;
        this.seatInRows = seatInRows;
        this.numberOfSeats = rows * seatInRows;
        this.seats = new char[rows][seatInRows];
        for (char[] seat : seats) {
            Arrays.fill(seat, 'S');
        }
    }

    public void display() {
        System.out.print("Cinema:\n ");
        for (int i = 1; i <= seats[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(" " + seats[i][j]);
            }
            System.out.println();
        }
    }

    public void buyTicket(int row, int col) {
        int price = checkPrice(row);
        seats[row - 1][col - 1] = 'B';
        purchasedTickets++;
        currentIncome += price;
        System.out.println("\nTicket price: $" + price);
    }

    private int checkPrice(int row) {
        int price;
        if (numberOfSeats <= 60) {
            price = price1;
        } else if (row <= rows / 2) {
            price = price1;
        } else {
            price = price2;
        }
        return price;
    }

    public void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public void printStatistics() {
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%%%n",  100.0d * purchasedTickets / numberOfSeats);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + calculateTotalIncome());
    }

    private int calculateTotalIncome() {
        if (numberOfSeats <= 60) {
            return numberOfSeats * price1;
        }
        int frontRows = rows / 2;
        int rearRows = rows - frontRows;
        return seatInRows * (frontRows * price1 + rearRows * price2);
    }

    private boolean verifySeat(int row, int col) {

        if (row < 1 || row > rows || col < 1 || col > seatInRows) {
            System.out.println("\nWrong input!\n");
            return false;
        } else if (seats[row - 1][col - 1] == 'B') {
            System.out.println("\nThat ticket has already been purchased!\n");
            return false;
        }
        return true;
    }

    public Seat takeInput(Scanner sc) {
        int row;
        int col;
        do {
            System.out.println("Enter a row number:");
            row = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter a seat number in that row:");
            col = sc.nextInt();
            sc.nextLine();
        } while (!verifySeat(row, col));
        return new Seat(row, col);
    }
}