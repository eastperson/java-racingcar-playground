import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringToCars {

    private List<Car> cars = new ArrayList<>();

    public StringToCars(String carNames) {
        String[] carNameArray = parseCarNames(carNames);
        for (String carName : carNameArray) {
            this.cars.add(new Car(carName));
        }
    }

    private String[] parseCarNames(String carNames) {
        if (carNames.contains(",")) {
            String[] carNameArray = carNames.split(",");
            return carNameArray;
        } else {
            return new String[]{ carNames };
        }
    }

    public List<Car> toCars() {
        return this.cars;
    }
}
