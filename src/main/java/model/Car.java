package model;

import util.NumberGenerator;

public class Car {
    private final String plate = NumberGenerator.generate();
    private Ticket ticket;

    public String getPlate() {
        return plate;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
