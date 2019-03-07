package controller;

import model.Parking;
import view.View;

public class Controller {
    private Parking parking;
    private View view;

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void execute(String command){

    }

    public void onShowAllCars(){
        view.showCars(parking);
    }
}
