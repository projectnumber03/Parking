package model;

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

    @Override
    public void run() {
        try{
            switch (state){
                case parking:
                    semaphore.acquire();
                    System.out.printf("Автомобиль с номером %s заезжает на парковку\n", plate);
                    Thread.sleep(delay);
                    parkingPlaces.add(this);
                    System.out.printf("Автомобиль с номером %s припаркован\n", plate);
                    semaphore.release();
                    break;
                case unparking:
                    semaphore.acquire();
                    System.out.printf("Автомобиль с номером %s выезжает с парковки\n", plate);
                    Thread.sleep(delay);
                    parkingPlaces.remove(this);
                    System.out.printf("Автомобиль с номером %s покинул парковку\n", plate);
                    semaphore.release();
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
