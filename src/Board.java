package com.example.racegame;

import com.example.racegame.car.Car;
import com.example.racegame.car.RacingCar;

import java.util.*;


// 판정하고 출력을 나눌 필요가 있어보임
public class Board {

    private static int nowRound = 1;

    public void showRoundBoard(List<Car> carContainer){
        List<String> result = boardData(carContainer);
        System.out.println(nowRound++ + "라운드=================================================");
        for (String status : result){
            System.out.println(status);
        }
    }

    public void showResultBoard(List<Car> carContainer){
        Iterator<Car> iterator = carContainer.iterator();
        List<RacingCar> rCarList = new ArrayList<>();

        while (iterator.hasNext()){
            RacingCar rCar = (RacingCar) iterator.next();
            rCarList.add(rCar);
        }

        rCarList.sort(Comparator.comparing(RacingCar::getDistance, Comparator.reverseOrder()));

        System.out.println("우승자는 ==========================================");
        for(RacingCar rCar : rCarList){
            if (rCarList.get(0).getDistance() == rCar.getDistance()){
                System.out.print(rCar.getName() + " ");
            }
        }
    }
    private List<String> boardData(List<Car> carContainer){
        Iterator<Car> rCar = carContainer.iterator();
        List<String> raceStatus = new ArrayList<>();

        while(rCar.hasNext()){
            RacingCar car = (RacingCar) rCar.next();
            StringBuilder sb = new StringBuilder(car.getName());

            for (int i=0; i < car.getDistance(); i++){
                sb.insert(0, "-");
            }
            raceStatus.add(sb.toString());
        }
        return raceStatus;
    }
}
