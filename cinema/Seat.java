package cinema;

public class Seat {

    private final int row;
    private final int seatInRows;

    public Seat(int row, int col) {
        this.row = row;
        this.seatInRows = col;
    }

    public int getRow() {
        return row;
    }

    public int getSeatInRows() {
        return seatInRows;
    }
}
