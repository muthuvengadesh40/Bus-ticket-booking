import java.io.*;
import java.util.*;

public class DataHandler {
    private static final String BUS_FILE = "buses.dat";
    private static final String BOOKING_FILE = "bookings.dat";

    public static List<Bus> loadBuses() {
        File file = new File(BUS_FILE);
        if (!file.exists()) {
            List<Bus> sample = new ArrayList<>();
            sample.add(new Bus(101, "Chennai", "Bangalore", 40, 500));
            sample.add(new Bus(102, "Madurai", "Coimbatore", 30, 350));
            sample.add(new Bus(103, "Trichy", "Salem", 25, 250));
            saveBuses(sample);
            return sample;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Bus>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Failed to load buses.");
            return new ArrayList<>();
        }
    }

    public static void saveBuses(List<Bus> buses) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BUS_FILE))) {
            oos.writeObject(buses);
        } catch (IOException e) {
            System.out.println("Failed to save buses.");
        }
    }

    public static List<Booking> loadBookings() {
        File file = new File(BOOKING_FILE);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Booking>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Failed to load bookings.");
            return new ArrayList<>();
        }
    }

    public static void saveBookings(List<Booking> bookings) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BOOKING_FILE))) {
            oos.writeObject(bookings);
        } catch (IOException e) {
            System.out.println("Failed to save bookings.");
        }
    }
}
