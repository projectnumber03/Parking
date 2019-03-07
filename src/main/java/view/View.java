package view;

import controller.Controller;
import model.Parking;

public class View {
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void showCars(Parking parking){
        System.out.println("Припаркованные автомобили:");
        parking.getParkedCars().stream().forEach(x -> System.out.println("\tНомер: " + x.getPlate() + " | Парковочный билет: " + x.getTicket().getValue()));
    }
}
