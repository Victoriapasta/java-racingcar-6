package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;

public class OutputView {

    public void showResultMessage() {
        System.out.println("실행 결과");
    }

    public void showEachPlay(List<CarDto> carsDto) {
        carsDto.forEach(carDto ->
                System.out.println(carDto.getName() + " : " + "-".repeat(carDto.getDistance())));
        System.out.println();
    }

    public void showWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        winners.forEach(winner -> {
            System.out.print(winner);
            if (winners.indexOf(winner) != winners.size() - 1) {
                System.out.print(", ");
            }
        });
        System.out.println();
    }
}
