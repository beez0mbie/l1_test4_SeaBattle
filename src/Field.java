public class Field {
    public static final int SIZE = 5; // final -- константа
    public static final int SHIPS_AMOUNT = 3;
    char[][] cells = new char[SIZE][SIZE]; //из локальной(main) мы перенесли в поля класса
    Ship[] ships = new Ship[SHIPS_AMOUNT];
    int hit = 0;
    boolean isIntersect;
    boolean isIntersectTwoShips;

    void init() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[i][j] = '~';
            }
        }
    }

    public void initShips() {
        for (int i = 0; i < SHIPS_AMOUNT; i++) {
            Ship tempShip = new Ship();
            // проверка
            do {
                isIntersect = false;
                tempShip.initShip();
                for (int j = 0; j < i; j++) {
                    if (isIntersectTwoShips(tempShip)) {
                        isIntersect = true;
                    }
                }
            } while (isIntersect);
            tempShip.serialNumber = i;
            drawShip(tempShip);
            ships[i] = tempShip;
            System.out.println(ships[i].coordinats[0] + " " + ships[i].coordinats[1] + " " + ships[i].isGorizontal() + " " + ships[i].size);
        }
    }

    void drawShip(Ship ship) {
        if (ship.isGorizontal) {
            for (int i : ship.position) {
                cells[ship.randomLine][i] = 'X';
            }
        } else {
            for (int i : ship.position) {
                cells[i][ship.randomLine] = 'X';
            }
        }
    }

    boolean isIntersectTwoShips(Ship ship) {
        isIntersectTwoShips = false;
        if (ship.isGorizontal) {
            for (int i : ship.position) {
                if (cells[ship.randomLine][i] == 'X') {
                    isIntersectTwoShips = true;
                }
            }
        } else {
            for (int i : ship.position) {
                if (cells[i][ship.randomLine] == 'X') {
                    isIntersectTwoShips = true;
                }
            }
        }
        return isIntersectTwoShips;
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

    void doShoot(int shoot2, int shoot) { //вначале перепутал вертикаль с горизонталью, поэтому так
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
        boolean isNotGameOver = false;
        for (char[] g1 : cells) {
            for (char g2 : g1) {
                if (g2 == 'X') {
                    isNotGameOver = true;
                }
            }
        }
        return isNotGameOver;
    }
}
