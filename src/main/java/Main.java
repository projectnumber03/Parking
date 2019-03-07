import controller.Controller;
import model.Car;
import model.Parking;
import view.View;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(5);
        parking.park(new Car("001f"));
        parking.park(new Car("002f"));
        parking.park(new Car("003f"));
        parking.park(new Car("004f"));
        parking.park(new Car("005f"));
        Controller controller = new Controller();
        View view = new View();
        controller.setView(view);
        view.setController(controller);
        controller.setParking(parking);
        controller.onShowAllCars();
    }
}
