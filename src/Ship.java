import java.util.Random;

public class Ship {
    //    int[] position; // выделяем память для массива
    int[] position;
    int size;
    boolean isGorizontal;
    int serialNumber;
    Random random = new Random();

    boolean isGorizontal() {
        if (random.nextInt(2) == 0) {
            isGorizontal = true;
        } else {
            isGorizontal = false;
        }
        return isGorizontal;
    }

    int[] initShip() {
        size = random.nextInt(4) + 1;
        position = new int[size];
        position[0] = random.nextInt(Field.SIZE - position.length + 1); /*помещаем в 0-ю позицию массива
рандомное число от 0 до размер поля - размер корабля + 1, что бы корабль мог инициализироваться в крайнем правом положении */

        for (int i = 1; i < position.length; i++) { //прибавляем к стартовой точке по 1, для инициализации(вставки) на поле
            position[i] = position[i-1] + 1;
        }
        return position;
//        position = random.nextInt(Field.SIZE - size + 1);
    }


}
