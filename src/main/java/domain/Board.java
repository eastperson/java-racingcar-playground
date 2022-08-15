package domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int round;
    private List<CarCurrentData> currentData;

    public Board(int round, List<Car> cars) {
        this.round = round;
        this.currentData = map(cars);
    }

    private List<CarCurrentData> map(List<Car> cars) {
        List list = new ArrayList();
        cars.forEach(car -> {
            list.add(new CarCurrentData(car.name(), car.position()));
        });
        return list;
    }

    public Integer round() {
        return this.round;
    }

    public List<CarCurrentData> currentData() {
        return this.currentData;
    }

    public static class CarCurrentData {
        private String name;
        private int position;

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        public CarCurrentData(String name, int position) {
            this.name = name;
            this.position = position;
        }
    }
}
