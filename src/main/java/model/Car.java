package model;

import util.NumberGenerator;

import java.util.List;

public class Car implements Runnable{
    private final String plate = NumberGenerator.generate();
    public static int delay;
    private Ticket ticket;
    private State state;
    private List<Car> parkingPlaces;

    protected enum State{
        parking, unparking
    }

    public Car(List<Car> parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    public String getPlate() {
        return plate;
    }

    void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    void setState(State state) {
        this.state = state;
    }

    @Override
    public void run() {
        try{
            switch (state){
                case parking:
                    System.out.println("Автомобиль с номером " + plate + " заезжает на парковку");
                    Thread.sleep(delay);
                    parkingPlaces.add(this);
                    System.out.println("Автомобиль с номером " + plate + " припаркован");
                    break;
                case unparking:
                    System.out.println("Автомобиль с номером " + plate + " выезжает с парковки");
                    Thread.sleep(delay);
                    parkingPlaces.remove(this);
                    System.out.println("Автомобиль с номером " + plate + " покинул парковку");
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
