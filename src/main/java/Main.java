import android.provider.Settings;

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

        Car winner = Race.findWinner(car1, car2, car3);
        System.out.println("Победитель в гонке: " + winner.name);
    }

    private static int getSpeed(Scanner scanner, String carNumber) {
        int speed;
        while (true) {
            System.out.println("Введите скорость (только целое число от 0 до 250) для " + carNumber + ":");
            speed = scanner.nextInt();
            if (speed < 0 || speed > 250) {
                System.out.println("Введена некорректная скорость.");
            } else {
                break;
            }
        }
        return speed;
    }
}

class Car {
    String name;
    int speed;
}

class Race {
    public static Car findWinner(Car car1, Car car2, Car car3){
        if (car1.speed > car2.speed && car1.speed > car3.speed) {
            return car1;
        } else if (car2.speed > car1.speed && car2.speed > car3.speed) {
            return car2;
        }
        else {
            return car3;
        }
    }
}