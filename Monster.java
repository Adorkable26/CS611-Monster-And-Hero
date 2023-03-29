import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;

public class Monster extends Role{
    private int damage_val;
    private int defense_val;
    //private double dodge_chance = 0.3;

//    public Monster(String n, int l, int hp, int dmg, int dfs){
//        super.setName(n);
//        super.setLevel(l);
//        super.setHit_points(hp);
//        damage_val = dmg;
//        defense_val = dfs;
//    }

    public Monster(){}

    // initialize the monster;
    public void initialize(String n, int l, int dmg, int dfs, int dod){
        super.setName(n);
        super.setLevel(l);
        damage_val = dmg;
        defense_val = dfs;
        super.setDodge_chance(dod);
    }

    // set the hero level;
    public void setLevel(Hero[] hero){
        int max_level = 0, cur_level = 0;
        for(Hero h : hero){
            cur_level = h.getLevel();
            if(cur_level > max_level) max_level = cur_level;
        }
        super.setLevel(max_level);
    }

    //set damage value;
    public void setDamage_val(int damage_val) {
        this.damage_val = damage_val;
    }

    // set defense value;
    public void setDefense_val(int defense_val) {
        this.defense_val = defense_val;
    }

    // return damage value;
    public int getDamage_val() { return damage_val;}

    // return defense value;
    public int getDefense_val() { return defense_val;}
    // reduce damage value;
    public void reduce_damage(double d){
        damage_val -= d;
    }

    //reduce defense value;
    public void reduce_defense(double d){
        defense_val -= d;
    }

    // reduce dodge chance;
    public void reduce_dodge_chance(int d){
        int dod = super.getDodge_chance();
        dod -= d;
        super.setDodge_chance(dod);
    }

    // show basic info;
    @Override
    public void show_info(){
        System.out.println(super.getName() + "\t" + damage_val + "\t" + defense_val + "\t" + super.getDodge_chance());
    }

    // show the titles of the basic info;
    @Override
    public void show_title(){
        System.out.println("Name\tLevel\tDamage\tDefense\tDodge chance");
    }

    // if a monster is attacked, do some related actions;
    public void beAttacked(int hp_reduc){
        if(!dodge()){
            int hp = super.getHit_points();
            hp -= hp_reduc;
            if(hp < 0) hp = 0;
            super.setHit_points(hp);
        }
    }

    // check if the monster is defeated, if is, returns true; else returns false;
    public boolean isDefeated(){
        if(super.getHit_points() == 0){
            return true;
        } else return false;
    }

    // attack the hero;
    public void attack(Hero h){
        if(!h.dodge()){
            h.beAttacked(damage_val);
        }
    }

//    public boolean dodge(){
//        int n = (int) dodge_chance * 10;
//        int[] dodge = new int [10];
//        for(int i = 0; i < dodge.length; i++){
//            if(i < 3){
//                dodge[i] = 1;
//            } else dodge[i] = 0;
//        }
//        Random r = new Random();
//        int i = r.nextInt(10);
//        if(dodge[i] == 1){
//            return true;
//        } else return false;
//    }

}
