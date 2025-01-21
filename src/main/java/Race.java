import java.util.ArrayList;
import java.util.List;

class Race {
    public static List<Car> findWinner(Car car1, Car car2, Car car3) {
        List<Car> winners = new ArrayList<>();
        int maxSpeed = Math.max(car1.speed, Math.max(car2.speed, car3.speed));

        if (car1.speed == maxSpeed) {
            car1.distance = car1.speed * 24;
            winners.add(car1);
        }
        if (car2.speed == maxSpeed) {
            car2.distance = car2.speed * 24;
            winners.add(car2);
        }
        if (car3.speed == maxSpeed) {
            car3.distance = car3.speed * 24;
            winners.add(car3);
        }
        return winners;
    }
}