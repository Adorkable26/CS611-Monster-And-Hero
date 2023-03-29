import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterFactory {

    private List<Monster> monsterList = new ArrayList();

    // This method is used to create object of type Monster.
//    public Monster create_Monster(String monsterType){
//        if(monsterType == null){
//            return null;
//        }
//        if(monsterType.equals("Dragon")){
//            return new Dragon();
//        } else if(monsterType.equals("Exoskeleton")){
//            return new Exoskeleton();
//        } else if(monsterType.equals("Spirit")){
//            return new Spirit();
//        }
//        return null;
//    }

    // To initialize the list of Monsters
    public void setMonsterList(){
        Dragon dragon1 = new Dragon();
        dragon1.initialize("Desghidorrah", 3, 300, 400, 35);
        monsterList.add(dragon1);
        Dragon dragon2 = new Dragon();
        dragon2.initialize("Chrysophylax", 2, 200, 500, 20);
        monsterList.add(dragon2);
        Dragon dragon3 = new Dragon();
        dragon3.initialize("BunsenBurner", 4, 400, 500, 45);
        monsterList.add(dragon3);
        Dragon dragon4 = new Dragon();
        dragon4.initialize("Natsunomeryu", 1, 100, 200, 10);
        monsterList.add(dragon4);
        Dragon dragon5 = new Dragon();
        dragon5.initialize("TheScaleless", 7, 700, 600, 75);
        monsterList.add(dragon5);
        Dragon dragon6 = new Dragon();
        dragon6.initialize("Kas-Ethelinh", 5, 500, 500, 60);
        monsterList.add(dragon6);

        Exoskeleton exoskeleton1 = new Exoskeleton();
        exoskeleton1.initialize("Cyrrollalee", 7, 700, 800, 75);
        monsterList.add(exoskeleton1);
        Exoskeleton exoskeleton2 = new Exoskeleton();
        exoskeleton2.initialize("Brandobaris", 3, 350, 450, 30);
        monsterList.add(exoskeleton2);
        Exoskeleton exoskeleton3 = new Exoskeleton();
        exoskeleton3.initialize("WickedWitch", 2, 250, 350, 25);
        monsterList.add(exoskeleton3);
        Exoskeleton exoskeleton4 = new Exoskeleton();
        exoskeleton4.initialize("Kiaransalee", 8, 850, 950, 85);
        monsterList.add(exoskeleton4);
        Exoskeleton exoskeleton5 = new Exoskeleton();
        exoskeleton5.initialize("Merrshaullk", 10, 1000, 900, 55);
        monsterList.add(exoskeleton5);
        Exoskeleton exoskeleton6 = new Exoskeleton();
        exoskeleton6.initialize("DocOck", 6, 600, 600, 55);
        monsterList.add(exoskeleton6);

        Spirit spirit1 = new Spirit();
        spirit1.initialize("Andrealphus", 2, 600, 500, 40);
        monsterList.add(spirit1);
        Spirit spirit2 = new Spirit();
        spirit2.initialize("Blinky", 1, 450, 350, 35);
        monsterList.add(spirit2);
        Spirit spirit3 = new Spirit();
        spirit3.initialize("FallenAngel", 5, 800, 700, 50);
        monsterList.add(spirit3);
        Spirit spirit4 = new Spirit();
        spirit4.initialize("Ereshkigall", 6, 950, 450, 35);
        monsterList.add(spirit4);
        Spirit spirit5 = new Spirit();
        spirit5.initialize("Jormunngand", 8, 600, 900, 20);
        monsterList.add(spirit5);
        Spirit spirit6 = new Spirit();
        spirit6.initialize("Casper", 1, 100, 100, 50);
        monsterList.add(spirit6);
    }


    // to randomly return n monsters from the original monster list;
    public List<Monster> get_n_monsters(int n){
        int length = monsterList.size();
        List<Monster> mList = new ArrayList();
        Monster m = new Monster();
        for(int i = 0; i < n; i++){
            Random r = new Random();
            m = monsterList.get(r.nextInt(length));
            mList.add(m);
        }
        return mList;
    }

    // to show the initial monster list;
    public void show_monster_list(){
        monsterList.get(0).show_title();
        for(Monster m : monsterList){
            m.show_info();
        }
    }

//    public Monster create_Monster(int level){



//            return null;
//        }
//        if(monsterType.equals("Dragon")){
//            return new Dragon();
//        } else if(monsterType.equals("Exoskeleton")){
//            return new Exoskeleton();
//        } else if(monsterType.equals("Spirit")){
//            return new Spirit();
//        }
//        return null;
//    }

}
