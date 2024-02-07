package racingcar.dto;

import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarDto {

    private String name;
    private int distance;

    private CarDto(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public static List<CarDto> createCarsDto(Cars cars) {
        List<CarDto> carDtoList = new ArrayList<>();

        String name = cars.getName();
        int distance = cars.getDistance();
        CarDto carDto = new CarDto(name, distance);
        carDtoList.add(carDto);

        return carDtoList;
    }
}
