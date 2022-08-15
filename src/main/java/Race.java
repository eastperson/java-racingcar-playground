import java.util.List;

public class Race {

    private List<Car> participants;

    public Race(List<Car> participants) {
        this.participants = participants;
    }

    public List<Car> participants() {
        return this.participants;
    }
}
