package racingcar.model;

public class Car {
    public String getName() {
        return name;
    }

    private String name;


    private int raceCount;


    public Car(String name, int raceCount) {
        this.name = name;
        this.raceCount = raceCount;
    }

    public String showRace() {
        String nowRace = name + " : " + "-".repeat(raceCount);
        return nowRace;
    }

    public int getRaceCount() {
        return raceCount;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            raceCount += 1;
        }
    }
}
