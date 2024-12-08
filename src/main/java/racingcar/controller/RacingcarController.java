package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    InputParser inputParser = new InputParser();

    public void run() {
        outputView.requestCarName();
        String cars = inputView.readCars();

        outputView.requestnumberOfAttempts();
        int attemptNum = inputView.readnumberOfAttempts();

        String[] racerNameList = inputParser.parseRacerList(cars);
        List<Car> racingCar = new ArrayList<>();
        for (String name : racerNameList) {
            racingCar.add(new Car(name, 0));
        }

        raceStart(racingCar, attemptNum);

        List<Car> winner = pickWinner(racingCar);

        System.out.print("최종 우승자 : ");
        List<String> names = winner.stream()
                .map(Car::getName) // 이름만 추출
                .collect(Collectors.toList());
        System.out.print(String.join(", ", names));


    }

    public void raceStart(List<Car> racingCar, int AttemptNum) {
        System.out.println("실행 결과");

        for (int i = 0; i < AttemptNum; i++) {
            for (Car car : racingCar) {
                int moveNum = Randoms.pickNumberInRange(0, 9);
                car.move(moveNum);
                System.out.println(car.showRace());
            }
            System.out.println();

        }
    }

    public List<Car> pickWinner(List<Car> racingCar) {

        int maxScore = racingCar.stream()
                .mapToInt(Car::getRaceCount)
                .max()
                .orElseThrow(() -> new NoSuchElementException("차 없음"));
        return racingCar.stream()
                .filter(car -> car.getRaceCount() == maxScore)
                .collect(Collectors.toList());
    }
}
