package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Parking {
    private final int parkingSize;
    private final Stack<Ticket> tickets = new Stack<>();
    private final List<Car> parkedCars = new ArrayList<>();
    private int space;

    public Parking(int parkingSize) {
        this.parkingSize = parkingSize;
        space = parkingSize;
        IntStream.range(1, space + 1).forEach(x -> tickets.push(new Ticket(space + 1 - x)));
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void park(Car car){
        if (parkedCars.size() < parkingSize){
            car.setTicket(tickets.pop());
            parkedCars.add(car);
            space--;
        }
    }

    public void unPark(int ticketNumber){
        Car car = getCarByTicket(ticketNumber);
        tickets.push(car.getTicket());
        parkedCars.remove(car);
        space++;
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public int getSpace() {
        return space;
    }

    public Car getCarByTicket(int ticketNumber){
        for (Car car : parkedCars){
            if(car.getTicket().getValue() == ticketNumber) return car;
        }
        return null;
    }
}
