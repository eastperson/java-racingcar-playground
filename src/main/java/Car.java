public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
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
