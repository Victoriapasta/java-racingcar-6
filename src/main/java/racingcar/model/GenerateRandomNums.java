package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNums {

    public int randomNumsGenerator() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
