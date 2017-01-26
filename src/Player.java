import java.util.Scanner;

/**
 * Created by a.shmelkov on 10.11.2016.
 */
public class Player {
    int shoot;

    int getShoot() {
        Scanner scanner = new Scanner(System.in);
        do {
            if (scanner.hasNextInt()) {
                shoot = scanner.nextInt();
                break;
            } else {
                System.out.println("Введите числа еще раз");
                scanner.nextLine();
            }
        } while (true);
        return shoot;
    }
}
