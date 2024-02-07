package racingcar.controller;

import racingcar.dto.CarDto;
import racingcar.model.Cars;
import racingcar.model.GenerateRandomNums;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carList = initCars(inputView.inputCarNames());
        List<Cars> setCars = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            setCars.add(new Cars(carList.get(i), 0));
        }

        int trialNumber = inputView.inputTrialNumber();
        outputView.showResultMessage();
        for (int i = 0; i < trialNumber; i++) {
            eachPlay(setCars);
            for (int j = 0; j < setCars.size(); j++) {
                outputView.showEachPlay(CarDto.createCarsDto(setCars.get(j)));
            }
        }
        outputView.showWinner(setWinner(setCars));
    }

    public List<String> initCars(String startMessage) {
        List<String> carList = Arrays.asList(startMessage.split(","));
        Validator.overMaxCarName(carList);
        return carList;
    }

    public int randomNumsGenerate() {
        GenerateRandomNums generateRandomNums = new GenerateRandomNums();
        return generateRandomNums.randomNumsGenerator();
    }

    public void eachPlay(List<Cars> setCars) {
        for (int i = 0; i < setCars.size(); i++) {
            if (randomNumsGenerate() >= 4) {
                setCars.get(i).updateDistance();
            }
        }
    }

    public List<String> setWinner(List<Cars> cars) {
        int maxDistance = cars.get(0).getDistance();
        List<String> winner = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            if (maxDistance < cars.get(i).getDistance()) {
                maxDistance = cars.get(i).getDistance();
            }
        }

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getDistance() == maxDistance) {
                winner.add(cars.get(i).getName());
            }
        }
        return winner;
    }
}
