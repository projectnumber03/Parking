package controller;

import model.Car;
import model.Parking;
import view.View;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Controller {
    private Parking parking;
    private View view;

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void execute(String command){
        switch (command){
            case "l":
                onShowParkedCars();
                break;
            case "c":
                onShowFreeSpace();
                break;
            case "e":
                System.exit(0);
                break;
        }
        try{
            if(command.startsWith("p:")){
                int numberOfCars = Integer.valueOf(command.substring(2));
                IntStream.range(0, numberOfCars).forEach(x -> onParkCar());
            }else if(command.startsWith("u:[") && command.endsWith("]")){
                String[] numbersOfTickets = command.substring(3, command.length() - 1).split(",");
                Arrays.stream(numbersOfTickets).mapToInt(Integer::valueOf).forEach(this::onUnparkCar);
            }else if(command.startsWith("u:")){
                int numberOfTicket = Integer.valueOf(command.substring(2));
                onUnparkCar(numberOfTicket);
            }
        }catch (Exception e){
            System.out.println("Ошибка выполнения команды");
        }
    }

    private void onShowParkedCars(){
        view.showParkedCars(parking);
    }

    private void onShowFreeSpace(){
        view.showFreeSpace(parking);
    }

    public void onParkCar(){
        parking.park(new Car());
    }

    public void onUnparkCar(int ticketNumber){
        parking.unPark(ticketNumber);
    }
}
