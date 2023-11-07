package com.example.racegame.factory;

import com.example.racegame.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface CarFactory {

    default List<Car> orderCarList(){
        Scanner sc = new Scanner(System.in);
        List<Car> carContainer = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carList = sc.next();
        String[] carName = carList.split(",");
        carNameValid(carName);

        System.out.println("주행할 횟수를 입력하세요.");
        int round = sc.nextInt();

        for (int i=0; i < carName.length; i++){
            carContainer.add(createCar(carName[i], round));
        }

        return carContainer;
    };

    private void carNameValid(String[] carName){
        for (String name : carName){
            if (name.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 다섯자리 이하로 입력해야합니다.");
            }
        }
    }

    private Car createCar(String name, int round){
        Car car = createProduct();
        car.setting(name, round);
        return car;
    }

    public Car createProduct();
}
