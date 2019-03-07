package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Parking {
    private final int space;
    private final Stack<Ticket> tickets = new Stack<>();
    private final List<Car> parkedCars = new ArrayList<>();

    public Parking(int space) {
        this.space = space;
        IntStream.range(1, space + 1).forEach(x -> tickets.push(new Ticket(x)));
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void park(Car car){
        if (parkedCars.size() < space){
            car.setTicket(tickets.pop());
            parkedCars.add(car);
        }
    }

    public void unPark(int ticketNumber){

    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }
}
