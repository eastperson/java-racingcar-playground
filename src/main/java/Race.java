import java.util.List;
import java.util.Random;

public class Race {

    private int round;
    private List<Car> participants;

    private static final Integer MAX_RANDOM_INTEGER = 9;
    private static final Integer MIN_RANDOM_INTEGER = 0;
    private static final Integer MOVE_STANDARD = 4;

    public Race(List<Car> participants) {
        this.participants = participants;
    }

    public List<Car> participants() {
        return this.participants;
    }

    public Board currentBoard() {
        return new Board(round, participants);
    }

    public void nextRound() {
        this.round++;
        this.participants.forEach(car -> {
            if (generateRandomInteger() >= MOVE_STANDARD) {
                car.moveAhead();
            }
        });
    }

    private Integer generateRandomInteger() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_INTEGER - MIN_RANDOM_INTEGER) + MIN_RANDOM_INTEGER;
    }
}
