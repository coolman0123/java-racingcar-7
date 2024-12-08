package racingcar.util;

public class InputParser {
    public String[] parseRacerList(String input) {
        String[] racerList = input.split(",");

        return racerList;
    }
}
