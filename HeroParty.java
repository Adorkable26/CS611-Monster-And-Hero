import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class HeroParty{
    private List<Hero> heroList = new ArrayList();
    private int[] location = new int[]{1, 1};
    private int[] move = new int[]{1, 1};


//    public void initialize(){
//        System.out.println("How many heroes do you want to play with? (The party size should be between 1 and 3)");
//        Scanner sca = new Scanner(System.in);
//        int n = sca.nextInt();
//        if(n < 1 || n > 3){
//            System.out.println("Sorry, your input is invalid, please try again.");
//            initialize();
//        }
//
//        HeroFactory heroFactory = new HeroFactory();
//        for(int i = 0; i < n; i++){
//            System.out.println("Please enter the type of the hero: ");
//            sca = new Scanner(System.in);
//            String s = sca.nextLine();
//            Hero hero = heroFactory.create_hero(s);
//            hero.initialize();
//            heroList.add(hero);
//        }
//        show_hero_list();
//        setLocation(0,0);
//        print_current_location();
//    }

    // to add hero to the heroList;
    public void add_hero(Hero h){
        heroList.add(h);
    }

    // print the hero list;
    public void show_hero_list(){
        heroList.get(0).show_title();
        for(Hero h : heroList){
            System.out.println();
            h.show_info();
        }
    }

    // to return the number of the heroes in the hero list;
    public int get_hero_number(){
        return heroList.size();
    }

    // to return the current location of hero party;
    public int[] getLocation(){ return location;}

    // to move the hero party to a new location;
    public void move(int[] move){ location = move;}

    // to enter the move and check if it's correct;
    public void enter_move(){
        move = location;
        System.out.println("Please enter your move: ");
        Scanner sca = new Scanner(System.in);
        String s = sca.nextLine();
        if(s.equals("W") || s.equals("w")){
            move[0]--;
        } else if (s.equals("A") || s.equals("a")) {
            move[1]--;
        } else if (s.equals("S") || s.equals("s")) {
            move[0]++;
        } else if (s.equals("D") || s.equals("d")) {
            move[1]++;
        } else {
            System.out.println("Sorry, your input is invalid, please try again!");
            enter_move();
        }
        if(move[0] > 8 || move[1] > 8 || move[0] < 1 || move[1] < 1){
            System.out.println("Sorry, your input is invalid, please try again!");
            enter_move();
        }
    }

    // print the current location of hero party;
    public void print_current_location(){
        System.out.println("Your current location is: (" + location[0] + ", " + location[1] + ")");
    }

    // To check the hero party, if all the heroes are defeated, then returns false, otherwise returns true.
    public boolean check_HP(){
        int flag = -1;
        for(Hero h : heroList){
            if(h.getHit_points() != 0){
                flag = 1;
            }
        }
        if(flag == 1) return true;
        else return false;
    }

    // for each hero in the hero party who isn't fainted, call the hero's win() method;
    public void win(int level){
        for(Hero h : heroList){
            if(!h.isFainted()){
                h.win(level);
            }
            else h.revive();
        }
    }

    // hero party loses the game;
    public void lose(){
        System.out.println("Sorry, the game is over. Heroes you lose.");
    }

    // when each round ends, each hero in the hero party who isn't fainted would regain some values;
    public void regain(MonsterGroup mg){
        for(Hero h: heroList){
            if(!h.isFainted()) h.regain(mg);
        }
    }

    // to return the list of levels of the heroes, is for initializing the monster group to the same level of the heroes;
    public int[] get_level_list(){
        int n = get_hero_number();
        int[] level = new int[n];
        for(int i = 0; i < n; i++){
            level[i] = heroList.get(i).getLevel();
        }
        return level;
    }

    // return the hero list;
    public List<Hero> get_hero_list(){
        return heroList;
    }

    // to search and return a certain hero;
    public Hero search(String s){
        for(Hero h : heroList){
            if(h.getName().equals(s)) {
                return h;
            }
        }
        return null;
    }



}

