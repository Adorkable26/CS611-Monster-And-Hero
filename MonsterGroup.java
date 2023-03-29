import java.util.ArrayList;
import java.util.List;

public class MonsterGroup{
    private List<Monster> monsterList = new ArrayList();

//    public void initialize(HeroParty hp){
//        MonsterFactory monsterFactory = new MonsterFactory();
//        int n = hp.get_hero_number();
//        int[] level = new int[n];
//        level = hp.get_level_list();
//        for(int i = 0; i < n; i++){
//            Monster monster = monsterFactory.create_Monster(level[i]);
//            monster.initialize();
//            monster.setLevel(level[i]);
//            monsterList.add(monster);
//        }
//        show_monster_list();
//    }

    // set the monster list;
    public void set_monster_list(List<Monster> mList){
        monsterList = mList;
    }

    // reset the monster's level according to the hero party's level;
    public void reset_level(HeroParty hp){
        int level[] = hp.get_level_list();
        for(int i = 0; i < level.length; i++){
            monsterList.get(i).setLevel(level[i]);
        }
    }

    // show the monster group;
    public void show_monster_list(){
        monsterList.get(0).show_title();
        for(Monster m : monsterList){
            m.show_info();
        }
    }

    // to check if all the monster's hit points are 0;
    public boolean check_HP(){
        int flag = -1;
        for(Monster m : monsterList){
            if(m.getHit_points() == 0){
                flag = 1;
            }
        }
        if(flag == 1) return true;
        else return false;
    }

    // get the number of the monster list;
    public int getNum(){
        return monsterList.size();
    }

    // return the monster list;
    public List<Monster> get_monster_list(){
        return monsterList;
    }

    // search and return certain Monster;
    public Monster search(String s){
        for(Monster m : monsterList){
            if(m.getName().equals(s)) {
                return m;
            }
        }
        return null;
    }

    // return the list of levels of the monster group;
    public int get_level(){
        int level = 0;
        for(Monster m : monsterList){
            level += m.getLevel();
        }
        return level;
    }



//    public void beAttacked(Monster m, int dmg){
//        m.beAttacked(dmg);
//        if(m.isDefeated()){
//            monsterList.remove(m);
//        }
//    }

}
