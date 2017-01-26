import java.util.Random;

/**
 * Created by a.shmelkov on 10.11.2016.
 */
public class Field {
    public static final int SIZE = 5; // final -- константа
    public static final int SHIPS_AMOUNT = 2;
    char[][] cells = new char[SIZE][SIZE]; //из локальной(main) мы перенесли в поля класса
    Random random = new Random();
    Ship[] ships = new Ship[SHIPS_AMOUNT];
//    int[][] ship.position = new int[2][];// = ship.initShip(); //= new int[ship.position.length];
    int[] randomLine;
    int hit = 0;



    void init() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = '~';
            }
        }
    }

    void drawShip(Ship ship) {
        randomLine[ship.serialNumber] = random.nextInt(SIZE);
//        ship[0].initShip();
//        ship[1].initShip();
//        ship.isGorizontal();
//        shipPosition[1] = ship.initShip();
//        System.out.println(shipPosition[1]);
//        int shipPosition = 4; // локальную переменную из других методов не видно
//        cells[shipPosition][shipPosition] = 'X';
//        for (int i = 0; i < shipPosition.length; i++) {
//            cells[randomLine][shipPosition[i]] = 'X';
//        }
        if (ship.isGorizontal) {
            for (int i : ship.position) {
                cells[randomLine[ship.serialNumber]][i] = 'X';  //появляется горизонтальный 3х палубный корабль на рандомной линии поля
            }
//            gorizontalOrNot = true;
        } else {
            for (int i : ship.position) {
                cells[i][randomLine[ship.serialNumber]] = 'X';  //появляется вертикальный 3х палубный корабль на рандомном слобце поля
            }
//            gorizontalOrNot = false;
        }
    }

    void showField() {
        for (int i = 0; i < cells.length; i++) {
            char[] cell = cells[i];
            for (int j = 0; j < cell.length; j++) {
                System.out.printf("%2c", cells[i][j]); // печатаем массив разделенный пробелами, что бы получилось красиво
            }
            System.out.println();
        }
    }

    void doShoot(int shoot, int shoot2) {
        switch (cells[shoot][shoot2]) {
            case '~':
                System.out.println("Промах");
                cells[shoot][shoot2] = '*';
                break;
            case '*':
                System.out.println("Уже стреляли");
                break;
            case 'X':
                hit++;
                if (hit == ships[0].position.length) {
                    System.out.println("Корабль убит");
                    cells[shoot][shoot2] = '^';
                } else {
                    System.out.println("Корабль ранен");
                    cells[shoot][shoot2] = '^';
                }
                break;
            default:
                System.out.println("ERROR");
        }
    }

    boolean isNotGameOver() {
//        boolean q;
//        q = false;
//        if (ships[0].isGorizontal) {
//            for (int i : ships[0].position) {
//                if (cells[randomLine[ship.serialNumber]][i] == 'X') {
//                    return true;
//                }
//            }
//            return false;
//        } else {
//            for (int i : ships[0].position) {
//                if (cells[i][randomLine[ship.serialNumber]] == 'X') {
//                    return true;
//                }
//            }
//            return false;
//        }
//        return cells[shipPosition[1]][shipPosition[1]] == 'X';
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (cells[i][j] == 'X') {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }


    boolean isIntersectTwoShips(Ship ship1, Ship ship2) {
        if (ship2.position[0] + ship2.size < ship1.position[0]) {
            return false;
        }
        if (ship1.position[0] + ship1.size < ship2.position[0]) {
            return false;
        }
        return true;
    }

    public void initShips() {
        for (int i = 0; i < SHIPS_AMOUNT; i++) {
            Ship tempShip = new Ship();
             // проверка
            boolean isIntersect;
            do {
                isIntersect = false;
                tempShip.initShip(); // цикл может стать бесконечным
                tempShip.isGorizontal();
                for (int j = 0; j < i; j++) {
                    if (isIntersectTwoShips(tempShip, ships[j])) {
                        isIntersect = true;
                    }
                }
            } while (isIntersect);
            tempShip.serialNumber = i;
            drawShip(tempShip);
            ships[i] = tempShip;
        }
    }
}
