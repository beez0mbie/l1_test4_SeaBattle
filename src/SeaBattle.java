public class SeaBattle {
    public static void main(String[] args) {
        Field field = new Field(); // дали право работать со всеми не статическими методами
        Player player = new Player();
        int shootX,shootY;
        field.init();
        field.initShips();

        while (field.isNotGameOver()){
            field.showField();
//            int[] player = player.getShoot();
            System.out.println("диапазон до " + Field.SIZE);
            shootY = player.getShoot();
            shootX = player.getShoot();
            System.out.printf("Выстрел: \n%s по горизонтали \n%s по вертикали\n\n", shootX, shootY);
            field.doShoot(shootX, shootY);
        }

        field.showField();
        System.out.println("game over");
    }
}
