package view;

import domain.Board;
import domain.Car;
import domain.Race;
import domain.StringToCars;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class ResultView {
    public static void main(String[] args) throws InterruptedException {
        ResultView resultView = new ResultView();
        resultView.start();
    }

    public void start() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        StringToCars stringToCars = new StringToCars(carNames);
        System.out.println("시도할 회수는 몇회인가요?");
        Integer finalRound = Integer.parseInt(scanner.nextLine());
        Race race = new Race(stringToCars.toCars(), finalRound);
        while (race.processing()) {
            race.nextRound();
            Board board = race.currentBoard();
            System.out.println("실행결과");
            for (Board.CarCurrentData data : board.currentData()) {
                String process = currentProcess(data.getPosition());
                System.out.println(data.getName() + " : " + process);
            }
            System.out.println();
            Thread.sleep(1000);
        }
        List<Car> winners = race.winners();
        String winnerNames = getWinnersName(winners);
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    private String getWinnersName(List<Car> winners) {
        StringJoiner winnerNames = new StringJoiner(" ,");
        for (Car winner : winners) {
            winnerNames.add(winner.name());
        }
        return winnerNames.toString();
    }

    private String currentProcess(Integer position) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < position; i++) {
            str.append("-");
        }
        return str.toString();
    }

}
