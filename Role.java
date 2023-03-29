import java.util.Random;
import java.util.Scanner;

public class Role {
    private String name;
    private int level = 1;
    private int hit_points;
    private int dodge_chance;

//    public void initialize(){
//        System.out.print("Please enter your name: ");
//        Scanner sca = new Scanner(System.in);
//        String str = sca.nextLine();
//        setName(str);
//    }

    // to set level;
    public void setLevel(int l) {
        level = l;
    }

    // to set name;
    public void setName(String n) {
        name = n;
    }

    //to initialize the hit points;
    public void initHP(){
        hit_points = level * 100;
    }

    //to set hit points;
    public void setHit_points(int h) {
        hit_points = h;
    }

    // to level up;
    public void levelUp(){ level++;}

    // reset the hp when leveling up;
    public void HpLevelUp() { hit_points = level * 100;}

    // reset the hp when leveling up;
    public String getName() { return name;}

    // return level;
    public int getLevel() { return level;}

    // return hp;
    public int getHit_points() { return hit_points;}

    // once a role be attacked, hp loses damage value;
    public void beAttacked(double dmg){
        hit_points -= dmg;
    }

    // show basic information of a role;
    public void show_info(){
        System.out.println(name + "\t" + level + "\t" + hit_points);
    }

    // show title information of a role;
    public void show_title(){}

    //set the dodge chance;
    public void setDodge_chance(int d){ dodge_chance = d;}

    //return dodge chance;
    public int getDodge_chance() { return dodge_chance;}

    // the dodge method, according to the dodge chance, randomly generates a number from (0,100),
    // if the number less than dodge chance, then assume that the role just dodges the damage and returns ture, otherwise
    // returns false;
    public boolean dodge(){
        Random r = new Random();
        int i = r.nextInt(100);
        if(dodge_chance < i){
            return true;
        } else return false;
    }

}
