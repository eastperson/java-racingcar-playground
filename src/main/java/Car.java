public class Car {
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
}
