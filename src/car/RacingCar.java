package com.example.racegame.car;

public class RacingCar implements Car {

    private String name;
    private int round;
    private int distance;

    @Override
    public void setting(String name, int round) {
        setName(name);
        setRound(round);
    }

    @Override
    public void drive() {
        setRound(getRound()-1);
        int drivenDinstance = 0;

        if ((int)(Math.random() * 10) > 4){
            drivenDinstance = getDistance() + 1;
            setDistance(drivenDinstance);
        }
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setRound(int round) {
        this.round = round;
    }

    private void setDistance(int distance) {
        this.distance = distance;
    }
    public String getName() {
        return name;
    }

    public int getRound() {
        return round;
    }

    public int getDistance() {
        return distance;
    }
}
