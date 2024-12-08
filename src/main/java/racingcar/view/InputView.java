package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readCars() {
        String input = Console.readLine();
        return input;
    }

    public int readnumberOfAttempts() {
        int attemptNum = Integer.parseInt(Console.readLine());

        return attemptNum;
    }

}
