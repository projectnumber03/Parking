package view;

import model.Car;
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

    public void showNotEnoughSpace(){
        System.out.println("Для автомобилей недостаточно места");
    }

    public void showCommandError(){
        System.out.println("Ошибка выполнения команды");
    }

    public void showParkingStartMessage(Car car){
        System.out.printf("Автомобиль с номером %s заезжает на парковку\n", car.getPlate());
    }

    public void showParkingEndMessage(Car car){
        System.out.printf("Автомобиль с номером %s припаркован\n", car.getPlate());
    }

    public void showUnparkingStartMessage(Car car){
        System.out.printf("Автомобиль с номером %s выезжает с парковки\n", car.getPlate());
    }

    public void showUnparkingEndMessage(Car car){
        System.out.printf("Автомобиль с номером %s покинул парковку\n", car.getPlate());
    }

    public void showCommandList(){
        System.out.println("Команды:\n" +
                "p:N - (park) чтобы припарковать машину, в командной строке вводится, где N - количество машин на въезд\n" +
                "u:N - (unpark) чтобы выехать с парковки. N - номер парковочного билета\n" +
                "u:[1..n] - (unpark) чтобы выехать с парковки нескольким машинам, где в квадратных скобках, через запятую передаются номера парковочных билетов\n" +
                "l - (list) список машин, находящихся на парковке. Для каждой машины выводится ее порядковый номер и номер билета\n" +
                "c - (count) количество оставшихся мест на парковке\n" +
                "e - (exit) выход из приложения");
    }
}
