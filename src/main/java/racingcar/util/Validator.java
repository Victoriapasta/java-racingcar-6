package racingcar.util;

import java.util.List;

public class Validator extends IllegalArgumentException{

    private Validator() {
    }

    public static void overMaxCarName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
