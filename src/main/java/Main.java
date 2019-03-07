import controller.Controller;
import model.Parking;
import view.View;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(5);
        Controller controller = new Controller();
        View view = new View();
        controller.setView(view);
        view.setController(controller);
        controller.setParking(parking);

        controller.execute("p:5");

        controller.execute("l");
        controller.execute("c");

        controller.execute("u:[3,5]");

        controller.execute("l");
        controller.execute("c");

        controller.execute("p:1");

        controller.execute("l");
        controller.execute("c");
    }
}
