import model.Parking;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(10);
        parking.getTickets().stream().forEach(x -> System.out.println(x.getValue()));
    }
}
