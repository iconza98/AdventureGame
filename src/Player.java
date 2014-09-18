import java.util.ArrayList;

/**
 * Created by ikanisamani on 8/28/14.
 */
public class Player {

    private static final int MAX_MOVE = 5;

    private int location_x;
    private int location_y;
    ArrayList<String> backpack;

    public Player() {
        this.location_x = 0;
        this.location_y = 0;
        backpack = new ArrayList<String>();
        backpack.add("brass lantern");
        backpack.add("rope");
        backpack.add("rations");
        backpack.add("staff");
    }

    public void travel(String direction) {
        // switch cases for direction
        String[] tempArray = direction.toLowerCase().split(" +");
        char letter = tempArray[0].charAt(0);
        char compassLocation = tempArray[1].charAt(0);
        System.out.println("first letter is:" + letter);
        switch (letter) {
            case 'g': travelDirection(compassLocation);
                break;
            case 'i' : inventory();
                break;
            default:
                System.out.println("Invaild Input");
                break;

        }

    }
    public void travelDirection(char d) {
        switch (d) {
            case 'n': goNorth();
                break;
            case 's': goSouth();
                break;
            case 'w': goWest();
                break;
            case 'e' : goEast();
                break;
            default:
                System.out.println("Invalid direction entered");
        }

    }
    public void goNorth(){
        if(location_x == 0) {
            System.out.println("You have gone the furthest south, cannot continue south");
        } else {
            --location_x;
        }

    }
    public void goSouth() {
        if(location_x < MAX_MOVE) {
            ++location_x;
        } else {
            System.out.println("You have gone the furthest north, cannot continue north");
        }
    }
    public void goWest() {
        if(location_y == 0) {
            System.out.println("You have gone the furthest west, cannot continue west");
        } else {
            --location_y;
        }

    }
    public void goEast() {
        if(location_y <= MAX_MOVE) {
            ++location_y;
        } else {
            System.out.println("You have gone the furthest east, cannot continue east");
        }
    }
    public void inventory() {
        for(String s: backpack) {
            System.out.println(s);
        }
        System.out.println("You are at location " + location_y + ',' + location_x);
    }
    public void addItem(String s) {
        backpack.add(s);
        System.out.println(s + " has been added to your inventory");
    }
}
