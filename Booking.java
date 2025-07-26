import java.io.Serializable;

public class Booking implements Serializable {
    private String passengerName;
    private int busNumber;

    public Booking(String name, int busNumber) {
        this.passengerName = name;
        this.busNumber = busNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void displayDetails() {
        System.out.println("Passenger: " + passengerName + " | Bus No: " + busNumber);
    }
}
