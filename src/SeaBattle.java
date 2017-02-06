public class SeaBattle {
    public static void main(String[] args) {
        Field field = new Field(); // дали право работать со всеми не статическими методами
        Player player = new Player();
        int shoot_x;
        int shoot_y;
        field.init();
        field.initShips();

        do {
            field.showField();
//            int[] player = player.getShoot();
            System.out.println("диапазон до " + Field.SIZE);
            shoot_x = player.getShoot();
            shoot_y = player.getShoot();
            System.out.printf("Выстрел: \n%s по горизонтали \n%s по вертикали\n\n", shoot_x, shoot_y);
            field.doShoot(shoot_x, shoot_y);
        } while (field.isNotGameOver());

        field.showField();
        System.out.println("game over");
    }
}
