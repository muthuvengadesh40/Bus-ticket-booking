import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static List<Bus> allBuses = new ArrayList<>();
    static List<Booking> allBookings = new ArrayList<>();

    public static void main(String[] args) {
        allBuses = DataHandler.loadBuses();
        allBookings = DataHandler.loadBookings();

        while (true) {
            showMenu();
            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    listAllBuses();
                    break;
                case 2:
                    handleBooking();
                    break;
                case 3:
                    showMyBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using the Bus Ticket System!");
                    DataHandler.saveBuses(allBuses);
                    DataHandler.saveBookings(allBookings);
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void showMenu() {
        System.out.println("\n---- BUS TICKET BOOKING SYSTEM ----");
        System.out.println("1. View All Buses");
        System.out.println("2. Book a Ticket");
        System.out.println("3. View My Bookings");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    static void listAllBuses() {
        System.out.println("\nAvailable Buses:");
        for (Bus bus : allBuses) {
            bus.showDetails();
        }
    }

    static void handleBooking() {
        System.out.print("Enter your name: ");
        String passengerName = input.nextLine();

        System.out.print("Enter bus number to book: ");
        int busNumber = input.nextInt();

        for (Bus bus : allBuses) {
            if (bus.getBusNumber() == busNumber) {
                if (bus.checkSeatAvailability()) {
                    bus.bookSeat();
                    Booking booking = new Booking(passengerName, busNumber);
                    allBookings.add(booking);
                    System.out.println("Ticket booked successfully!");
                    return;
                } else {
                    System.out.println("No seats available.");
                    return;
                }
            }
        }

        System.out.println("Invalid bus number.");
    }

    static void showMyBookings() {
        System.out.print("Enter your name to view bookings: ");
        String name = input.nextLine();
        boolean found = false;
        for (Booking booking : allBookings) {
            if (booking.getPassengerName().equalsIgnoreCase(name)) {
                booking.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No bookings found under your name.");
        }
    }
}
