public class Main {
    public static void main(String[] args) throws InterruptedException {
//        int breathInLength = 4600; // 5 and 5
        int breathInLength = 3600;// 4 in and 6 out
//        int breathOutLength = 4400;// 5 and 5
        int breathOutLength = 5600;// 4 in and 6 out
        int pause = 1700;
        Player player = new Player();
        do {
            // breath out
            // pause
            // breath in

//            player.playSound(0, breathOutLength, 20, 67, 72, 76);
//            Thread.sleep(999999999);
            Thread.sleep(400);
            System.out.println("breath out: "+ breathOutLength);
            player.playSound(0, breathOutLength, 20, 67, 71, 74);
            Thread.sleep(400);
            System.out.println("wait: " + pause);
            Thread.sleep(pause);
            Thread.sleep(400);
            System.out.println("breath in: "+ breathInLength);
            player.playSound(0, breathInLength, 20, 69, 74, 77);
        } while (true);
//        player.close();
    }
}
