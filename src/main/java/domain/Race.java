package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Race {

    private int round;
    private int finalRound;
    private List<Car> participants;
    private boolean end;
    private List<Car> winners = new ArrayList<>();

    private static final Integer MAX_RANDOM_INTEGER = 9;
    private static final Integer MIN_RANDOM_INTEGER = 0;
    private static final Integer MOVE_STANDARD = 4;

    public Race(List<Car> participants, Integer finalRound) {
        this.participants = participants;
        this.finalRound = finalRound;
    }

    public List<Car> participants() {
        return this.participants;
    }

    public Board currentBoard() {
        return new Board(round, participants);
    }

    public void nextRound() {
        if (end) {
            throw new RuntimeException("이미 끝난 레이싱입니다.");
        }
        this.round++;
        this.participants.forEach(car -> {
            if (generateRandomInteger() >= MOVE_STANDARD) {
                car.moveAhead();
            }
        });
        if (round >= finalRound) {
            Optional<Car> first = this.participants.stream()
                    .max(Comparator.naturalOrder());
            this.end = true;
            this.winners = this.participants.stream()
                    .filter(car -> car.position().equals(first.get().position()))
                    .collect(Collectors.toList());
        }
    }

    private Integer generateRandomInteger() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_INTEGER - MIN_RANDOM_INTEGER) + MIN_RANDOM_INTEGER;
    }

    public boolean end() {
        return this.end;
    }

    public boolean processing() {
        return !this.end;
    }

    public List<Car> winners() {
        if (processing()) {
            throw new RuntimeException("아직 경기가 진행중입니다.");
        }
        return this.winners;
    }
}
