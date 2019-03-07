package view;

import model.Parking;

public class View {

    public void showParkedCars(Parking parking){
        System.out.println("================================================");
        System.out.println("Припаркованные автомобили:");
        parking.getParkedCars().forEach(x -> System.out.printf("\tНомер: %s | Парковочный билет: %d\n", x.getPlate(), x.getTicket().getValue()));
        System.out.println("================================================");
    }

    public void showFreeSpace(Parking parking){
        System.out.printf("Свободных мест: %d\n", parking.getSpace());
    }
}
