package com.example.racegame;

import com.example.racegame.car.Car;
import com.example.racegame.car.RacingCar;

import java.util.Iterator;
import java.util.List;

public class Flag {

    public List<Car> roundFlag(List<Car> carContainer){
        for (Car car : carContainer){
            car.drive();
        }
        return carContainer;
    }

    public boolean keepFlag(List<Car> carContainer){

        Iterator<Car> iterator = carContainer.iterator();
        RacingCar rCar = (RacingCar) iterator.next();
        return rCar.getRound() > 0;
    }
}
