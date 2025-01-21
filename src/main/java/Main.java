import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название машины №1: ");
        car1.name = scanner.next();
        car1.speed = getSpeed(scanner, "машины №1");

        System.out.println("Введите название машины №2: ");
        car2.name = scanner.next();
        car2.speed = getSpeed(scanner, "машины №2");

        System.out.println("Введите название машины №3: ");
        car3.name = scanner.next();
        car3.speed = getSpeed(scanner, "машины №3");

        System.out.println("Данные автомобилей успешно введены!");

        List<Car> winners = Race.findWinner(car1, car2, car3);

        if (winners.size() == 1) {
            System.out.println("Победитель в гонке: " + winners.getFirst().name);
        } else {
            System.out.println("Победители в гонке: ");
            for (Car winner : winners) {
                System.out.println(winner.name);
            }
        }
    }

    private static int getSpeed(Scanner scanner, String carNumber) {
        int speed;
        while (true) {
            System.out.println("Введите скорость (только целое число от 0 до 250) для " + carNumber + ":");
            try {
                speed = scanner.nextInt();
                if (speed < 0 || speed > 250) {
                    System.out.println("Введена некорректная скорость. Пожалуйста, введите значение от 0 до 250.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введено не целое число. Пожалуйста, введите целое число.");
                scanner.next();
            }
        }
        return speed;
    }
}