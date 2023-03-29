import java.util.Random;

public class CommonCell implements Cell{

    boolean has_hero = false;

    // This function is overridden to make some actions when a hero group enters, for example, roll a dice and to see
    // if a battle should begin.
    @Override
    public void hero_enter(HeroParty hp) {
        has_hero = true;
        if(roll_a_dice(hp)){
            Battle battle = new Battle();
            battle.begin(hp);
        } else {
            hp.enter_move();
        }
    }

    // Override this function to set the heroes are left;
    @Override
    public void hero_leave(){
        has_hero = false;
    }

    // Override this function to show that this kind of cell is available for heroes to enter;
    @Override
    public boolean isMovable(){ return true;}

    // Roll a dice by using Random;
    public boolean roll_a_dice(HeroParty hp){
        Random random = new Random();
        boolean b = random.nextBoolean();
        //System.out.println(b);
        return b;
    }

    // This function is used to print the cell;
    @Override
    public void show(){
        if(!has_hero) System.out.print("    |");
        else System.out.print(" P  |");
    }


}
