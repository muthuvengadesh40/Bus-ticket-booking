import java.io.Serializable;

public class Bus implements Serializable {
    private int busNumber;
    private String from;
    private String to;
    private int totalSeats;
    private int seatsFilled;
    private double fare;

    public Bus(int busNumber, String from, String to, int totalSeats, double fare) {
        this.busNumber = busNumber;
        this.from = from;
        this.to = to;
        this.totalSeats = totalSeats;
        this.seatsFilled = 0;
        this.fare = fare;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public boolean checkSeatAvailability() {
        return seatsFilled < totalSeats;
    }

    public void bookSeat() {
        seatsFilled++;
    }

    public void showDetails() {
        System.out.println("Bus No: " + busNumber + " | " + from + " → " + to + 
            " | Fare: ₹" + fare + " | Available: " + (totalSeats - seatsFilled));
    }
}

