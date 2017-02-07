import java.util.Random;

public class Ship {
    int[] position;
    int size, serialNumber;
    boolean isGorizontal;
    Random random = new Random();
    int randomLine = random.nextInt(Field.SIZE);
    int[] coordinats = new int[2];

    boolean isGorizontal() {
//        if (random.nextInt(2) == 0) {
//            isGorizontal = true;
//        } else {
//            isGorizontal = false;
//        }
        isGorizontal = random.nextInt(2) == 0;
        return isGorizontal;
    }

    int[] initShip() {
        size = random.nextInt(4) + 1; // от 0 до 3 + 1, значит от 1 до 4
        position = new int[size];
        position[0] = random.nextInt(Field.SIZE - position.length + 1); /*помещаем в 0-ю позицию массива рандомное число от 0 до размер поля - размер корабля + 1, что бы корабль мог инициализироваться в крайнем правом положении */

        for (int i = 1; i < position.length; i++) { //прибавляем к стартовой точке по 1, для инициализации(вставки) на поле
            position[i] = position[i-1] + 1;
        }

        if (isGorizontal()) {
            coordinats[0] = position[0];
            coordinats[1] = randomLine;
        } else {
            coordinats[0] = randomLine;
            coordinats[1] = position[0];
        }

        return position;
    }
}
