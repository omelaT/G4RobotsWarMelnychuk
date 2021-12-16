import java.util.*;

public class Robot {

    int health = 100;
    private String robotName;
    private Set<String> unusedCommands = new HashSet<>();

    public Robot(int health, String robotName) {
        this.health = health;
        this.robotName = robotName;
        initCommands();
    }

    public int getHealth() {
        return health;
    }

    public String getRobotName() {
        return robotName;
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public boolean removeCommand(String command) {
        return unusedCommands.remove(command.toUpperCase());
    }

    public boolean containCommand(String command) {
        return unusedCommands.contains(command);
    }

    private void initCommands() {

        List<String> tmpList = new ArrayList<>(MainClass.commands);

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(tmpList.size());
            unusedCommands.add(tmpList.remove(randomIndex));
        }
    //    System.out.println(unusedCommands); // проверка сгенерированных команд для атаки

    }
}
