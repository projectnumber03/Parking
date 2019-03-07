package view;

import controller.Controller;
import model.Parking;

public class View {
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void showParkedCars(Parking parking){
        System.out.println("================================================");
        System.out.println("Припаркованные автомобили:");
        parking.getParkedCars().stream().forEach(x -> System.out.println("\tНомер: " + x.getPlate() + " | Парковочный билет: " + x.getTicket().getValue()));
        System.out.println("================================================");
    }

    public void showFreeSpace(Parking parking){
        System.out.println("Свободных мест: " + parking.getSpace());
    }
}
