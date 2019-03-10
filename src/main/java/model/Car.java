package model;

import controller.Controller;
import util.NumberGenerator;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Car implements Runnable{
    private final String plate = NumberGenerator.generate();
    public static int delay;
    private Ticket ticket;
    private State state;
    private List<Car> parkingPlaces;
    private Semaphore semaphore;
    private Controller controller;

    protected enum State{
        parking, unparking
    }

    public Car(List<Car> parkingPlaces, Semaphore semaphore) {
        this.parkingPlaces = parkingPlaces;
        this.semaphore = semaphore;
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

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        try{
            switch (state){
                case parking:
                    semaphore.acquire();
                    controller.onCarStartParking(this);
                    Thread.sleep(delay);
                    parkingPlaces.add(this);
                    controller.onCarEndParking(this);
                    semaphore.release();
                    break;
                case unparking:
                    semaphore.acquire();
                    controller.onCarStartUnparking(this);
                    Thread.sleep(delay);
                    parkingPlaces.remove(this);
                    controller.onCarEndUnparking(this);
                    semaphore.release();
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
