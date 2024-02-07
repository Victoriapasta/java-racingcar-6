package racingcar.model;

import java.util.List;

public class Cars implements Car {

    private String name;
    private int distance;

    public Cars(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    public void updateDistance() {
        this.distance++;
    }
}
