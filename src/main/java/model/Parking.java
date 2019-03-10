package model;

import controller.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Parking {
    private final int parkingSize;
    private final Stack<Ticket> tickets = new Stack<>();
    private final List<Car> parkedCars = Collections.synchronizedList(new ArrayList<>());
    private Semaphore semaphore = new Semaphore(2);
    private int space;

    public Parking(int parkingSize) {
        this.parkingSize = parkingSize;
        space = parkingSize;
        IntStream.range(1, space + 1).forEach(x -> tickets.push(new Ticket(space + 1 - x)));
    }

    public void park(Controller controller){
        Car car = new Car(parkedCars, semaphore);
        car.setState(Car.State.parking);
        car.setTicket(tickets.pop());
        car.setController(controller);
        space--;
        new Thread(car).start();
    }

    public void unPark(int ticketNumber, Controller controller){
        Car car = getCarByTicket(ticketNumber);
        if(car != null){
            car.setState(Car.State.unparking);
            tickets.push(car.getTicket());
            car.setController(controller);
            space++;
            new Thread(car).start();
        }
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public int getSpace() {
        return space;
    }

    public int getParkingSize() {
        return parkingSize;
    }

    private Car getCarByTicket(int ticketNumber){
        for (Car car : parkedCars){
            if(car.getTicket().getValue() == ticketNumber) return car;
        }
        return null;
    }
}
