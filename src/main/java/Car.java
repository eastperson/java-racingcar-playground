import java.util.Objects;

public class Car implements Comparable<Car> {
    private String name;
    private int position;

    public Car(String name) {
        String trimName = name.trim();
        validate(trimName);
        this.name = trimName;
    }

    private void validate(String trimName) {
        if (trimName == null || trimName.length() < 1) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열이 올 수 없습니다.");
        }
        if (trimName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String name() {
        return this.name;
    }

    public Integer position() {
        return this.position;
    }

    public void moveAhead() {
        this.position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }
}
