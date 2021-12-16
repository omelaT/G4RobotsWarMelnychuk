
import java.util.*;

public class MainClass {

    public static List<String> commands = new ArrayList<>();

    static {
        commands.add("Q");
        commands.add("W");
        commands.add("E");
        commands.add("A");
        commands.add("S");
        commands.add("D");
        commands.add("Z");
        commands.add("X");
        commands.add("C");
    }

    //логика игры
    private static boolean gameFlow(Robot robotAttacker,Robot robotDefender, Scanner scan) {  // принимаю на вход робота1, 2 и ввод с консоли
        System.out.println("Robot " + robotAttacker.getRobotName()+ " attacks");
        String command = scan.nextLine(); // считываю команду

        if (command.equalsIgnoreCase("L")) {  // exit game
            System.out.println("Exit game");
            return false;
        }

        if (!commands.contains(command.toUpperCase())) {   //ввод команды не из списка игры
            System.out.println("there is no such command");
            return true;
        } else if (robotAttacker.containCommand(command.toUpperCase())) {  //команда из списка робота, которая наносит урон ( СГЕНЕРИРОВАННАЯ!)
            robotDefender.setHealth(robotDefender.getHealth() - 20);
            System.out.println(" Damage. minus 20  " + "health of the " + robotDefender.getRobotName() + " robot = " + robotDefender.getHealth());
            robotAttacker.removeCommand(command.toUpperCase()); // удаляем команду из списка робота после использования
            if (robotDefender.getHealth() <= 0) {
                System.out.println("Robot " + robotAttacker.getRobotName() + " win the game ");
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the NAME of the First Robot ");
        String firstRobotName = scan.nextLine();
        System.out.println("Enter the NAME of the Second Robot");

        String secondRobotName = scan.nextLine();
        System.out.println("First Robot NAME - " + firstRobotName + " " + " Second Robot Name- " + secondRobotName);
        System.out.println("Let's the game begin!");
        System.out.println(" You have such  commands :  Q, W, E, A, S, D, Z,X, C - some of this commands  will cause damage. For END GAME enter L command");


        Robot firstRobot = new Robot(100, firstRobotName);  //создаю робот 1
        Robot secondRobot = new Robot(100, secondRobotName); // создаю робот 2
        boolean shouldContinue = true;  // флаг продолжения программы
        boolean firstRobotTurn = true;  // флаг для смены робота

        while (shouldContinue) {  // пока флаг продолжения программы ТРУ  делаем:
            Robot attackRobot = firstRobotTurn ? firstRobot : secondRobot;  // выбираем текущего робота  = если тру, то первый робот
            Robot defenderRobot = !firstRobotTurn ? firstRobot : secondRobot;  // выбираем текущего робота  = если  тру, то второй робот
            shouldContinue = gameFlow(attackRobot, defenderRobot, scan);  //  вход в логику игры
            firstRobotTurn = !firstRobotTurn;   //смена очереди пиу-пиу
        }

    }
}








