import controller.Controller;
import model.Car;
import model.Parking;
import view.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(Integer.valueOf(args[0]));
        Car.delay = Integer.valueOf(args[1]) * 1000;
        Controller controller = new Controller();
        View view = new View();
        controller.setView(view);
        controller.setParking(parking);
        Scanner scan = new Scanner(System.in);

        while (true){
            controller.execute(scan.nextLine());
        }
    }
}
