package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Parking {
    private final int parkingSize;
    private final Stack<Ticket> tickets = new Stack<>();
    private final List<Car> parkedCars = Collections.synchronizedList(new ArrayList<>());
    private int space;

    public Parking(int parkingSize) {
        this.parkingSize = parkingSize;
        space = parkingSize;
        IntStream.range(1, space + 1).forEach(x -> tickets.push(new Ticket(space + 1 - x)));
    }

    public void park(Car car){
        car.setState(Car.State.parking);
        car.setTicket(tickets.pop());
        space--;
        new Thread(car).start();
    }

    public void unPark(int ticketNumber){
        Car car = getCarByTicket(ticketNumber);
        if(car != null){
            car.setState(Car.State.unparking);
            tickets.push(car.getTicket());
            parkedCars.remove(car);
            space++;
            new Thread(car).start();
        }else System.out.println("Автомобиля с данным талоном нет на стоянке");
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
