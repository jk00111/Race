package com.example.racegame.factory;

import com.example.racegame.car.Car;
import com.example.racegame.car.RacingCar;

public class RacingcarFactory implements CarFactory{

    @Override
    public Car createProduct() {
        return new RacingCar();
    }
}
