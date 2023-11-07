package com.example.racegame;

import com.example.racegame.car.Car;
import com.example.racegame.factory.CarFactory;
import com.example.racegame.factory.RacingcarFactory;

import java.util.List;

public class Circuit {

    private List<Car> readyRace(){
        CarFactory[] factory = {
                new RacingcarFactory(),
        };
        return factory[0].orderCarList();
    }

    private void startRace(){
        List<Car> carContainer = readyRace();
        progressRace(carContainer);
    }

    private void progressRace(List<Car> carContainer){
        Flag flag = new Flag();
        carContainer = flag.roundFlag(carContainer);

        Board board = new Board();
        board.showRoundBoard(carContainer);

        if (flag.keepFlag(carContainer)) {
            progressRace(carContainer);
        }else{
            endRace(carContainer);
        }
    }

    private void endRace(List<Car> carContainer){
        Board board = new Board();
        board.showResultBoard(carContainer);
    }

    public static void main(String[] args) {
        Circuit circuit = new Circuit();
        circuit.startRace();
    }
}
