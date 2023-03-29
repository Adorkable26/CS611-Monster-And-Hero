import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    // This class encapsulates all the details of this role play game, for users to play this game, all they need to do
    // is to first create an instance of this class, and then call some certain functions of this class;
    HeroParty hp = new HeroParty();
    Map map = new Map();
    Battle battle = new Battle();
    MonsterGroup mg = new MonsterGroup();
    boolean game_over = false;
//    private Strategy strategy;
//    private OperationFactory operationFactory;
//
//    public void makeAction(Hero h, Monster m, String s){
//        strategy = operationFactory.getStrategy(s);
//        strategy.doOperation(h,m);
//    }
    private List<Hero> heroList = new ArrayList();

    private int[] location = new int[2];
    private int[] new_location = new int[2];

    // HeroFactory is used for creating instances of Heroes;
    HeroFactory heroFactory = new HeroFactory();

    // For each player to choose their hero;
    public void choose_hero(){
        System.out.println("What kind of hero do you want to choose? (Please enter Warrior / Sorcerer / Paladin)");
        Scanner sca = new Scanner(System.in);
        String s = sca.nextLine();
        heroFactory.show_available_hero(s);
    }

    //
    public void initialize(){
        System.out.println("Welcome to Legends: Monsters and Heroes!");
        System.out.println("How many heroes do you want to play with? (The party size should be between 1 and 3)");
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        if(n <= 3 || n >= 1){
            for(int i = 0; i < n; i++){
                choose_hero();
                System.out.println("Please enter the Hero's name: ");
                Scanner sca1 = new Scanner(System.in);
                String s = sca1.nextLine();
                Hero h = heroFactory.create_hero(s);
                hp.add_hero(h);
                map.initialize();
            }
            hp.show_hero_list();
            hp.print_current_location();
            map.show_map();
        } else {
            System.out.println("Sorry, your input is invalid, please try again.");
            initialize();
        }
    }

    // This function is for the hero party to move on the map, once they move to each cell, a certain action will be triggered
    // corresponding to its type;
    public void move(){
        enter_move();
        Cell cell = map.get_entered_cell(new_location);
        if(cell.isMovable()){
            hp.move(new_location);
            map.show_map();
            hp.print_current_location();
            cell.hero_enter(hp);
        } else {
            System.out.println("Sorry, this tile is inaccessible, please try again!");
            this.move();
        }
        cell.hero_leave();
    }

    // This function is for the players to input their moves, and the function would also check if their input is correct or not:
    // if the input is correct, the new location of the hero party would be updated; if not, this function would ask for another input.
    public void enter_move(){
        location = hp.getLocation();
        new_location = location;
        System.out.println("Please enter your move: ");
        Scanner sca = new Scanner(System.in);
        String s = sca.nextLine();
        if(s.equals("W") || s.equals("w")){
            new_location[0]--;
        } else if (s.equals("A") || s.equals("a")) {
            new_location[1]--;
        } else if (s.equals("S") || s.equals("s")) {
            new_location[0]++;
        } else if (s.equals("D") || s.equals("d")) {
            new_location[1]++;
        } else {
            System.out.println("Sorry, your input is invalid, please try again!");
            //enter_move();
        }
        if(new_location[0] > 8 || new_location[1] > 8 || new_location[0] < 1 || new_location[1] < 1){
            System.out.println("Sorry, your input is invalid, please try again!");
            //enter_move();
        }

//        else if(!map.get_entered_cell(new_location).isMovable()){
//            map.get_entered_cell(new_location).hero_enter(hp);
//        } else {
//            hp.setLocation(new_location[0], new_location[1]);
//            hp.print_current_location();
//        }
    }

    // This function is for the rounds to run automatically;
    public void round(){
        do {
            move();
        } while (hp.check_HP());
        //battle.begin(hp);
    }


}
