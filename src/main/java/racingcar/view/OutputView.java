package racingcar.view;

public class OutputView {
    public void requestCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public void requestnumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printWinnerList(String[] winnerList) {
        System.out.println("최종 우승자 : " + winnerList);
    }
}
