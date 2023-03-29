import java.util.Scanner;

public class Battle {
    private MonsterGroup monsterGroup = new MonsterGroup();
    private HeroParty heroParty = new HeroParty();
    //MonsterFactory is used to create monsters;
    private MonsterFactory monsterFactory = new MonsterFactory();

    // This function is to create monster group at the beginning of each battle;
    public void create_monster(){
        monsterFactory.setMonsterList();
        int n = heroParty.get_hero_number();
        monsterGroup.set_monster_list(monsterFactory.get_n_monsters(n));
        monsterGroup.reset_level(heroParty);
        monsterGroup.show_monster_list();
        //monsterGroup.initialize(heroParty);
        System.out.println("The monster group is created!");
    }

    // This function is to set the Hero Party, create monsters as well as begin the first round of the battle;
    public void begin(HeroParty hp){
        heroParty = hp;
        create_monster();
        System.out.println("The battle begins!");
        round();
    }

    // This function is to check if the fights are over, if it is, then returns true; else, returns false.
    public boolean fight_ends(){
        if(monsterGroup.check_HP() || heroParty.check_HP()) return true;
        else return false;
    }

    // This function includes the details of each round, first it's the hero's turn, then, it's the monster's , after
    // both of the groups finishes their turns, check if the fight ends, if so, then check which teams wins and do the
    // corresponding actions; if not, then start the new round, until the fight ends.
    public void round(){
        hero_turn();
        monster_turn();
        if(fight_ends()){
            if(monsterGroup.check_HP()) {
                int level = monsterGroup.get_level();
                heroParty.win(level);
                heroParty.regain(monsterGroup);
            }
            else heroParty.lose();
        } else round();
        heroParty.regain(monsterGroup);
    }

    // This function includes what the heroes do when it's their turn;
    public void hero_turn(){
        for(Hero h : heroParty.get_hero_list()){
//            if(!h.isFainted()){
                System.out.println(h.getName() + "It's your turn, do you want to display the statistics? (Yes / No)");
                Scanner sca = new Scanner(System.in);
                String s = sca.nextLine();
                if(s.equals("Yes") || s.equals("yes") || s.equals("YES")){
                    display_statistics();
                }
                System.out.println(h.getName() + "It's your turn, please enter your activity: (Attack / Spell / Potion / Equip)");
                sca = new Scanner(System.in);
                s = sca.nextLine();
                Context context = new Context();
                Monster m = search_monster();
                context.makeAction(h,m,s);
                if(m.isDefeated()){
                    monsterGroup.get_monster_list().remove(m);
                }
            //}

//            if(s.equals("Attack") || s.equals("attack") || s.equals("ATTACK")){
//                h.useWeapon(h.get_weapon(), search_monster());
//            } else if (s.equals("Spell") || s.equals("spell") || s.equals("SPELL")) {
//                h.useSpell(h.get_spell(), search_monster());
//            } else if (s.equals("Potion") || s.equals("potion") || s.equals("POTION")) {
//                h.usePotion(h.get_potion());
//            } else if (s.equals("Equip") || s.equals("equip") || s.equals("EQUIP")) {
//                choose_equip(h);
//            } else{
//                System.out.println("Sorry, your input is invalid, please try again.");
//                hero_turn();
//            }
        }
    }

    // This function includes what the monsters do when it's their turn;
    public void monster_turn(){
        // Monsters will first attack the Hero with the highest level;
        Hero h = new Hero();
        for(Monster p : monsterGroup.get_monster_list()){
            int index = 0;
            int level = 0;
            for(Hero e : heroParty.get_hero_list()){
                if(e.getLevel() > level){
                    level = e.getLevel();
                    index = heroParty.get_hero_list().indexOf(e);
                }
            }
            h = heroParty.get_hero_list().get(index);
            p.attack(h);
        }
    }


    // For Hero to display some statistics of a Hero / Monster.
    public void display_statistics(){
        System.out.println("Whose information you want it to be displayed?");
        Scanner sca = new Scanner(System.in);
        String s = sca.nextLine();
        Monster m = monsterGroup.search(s);
        Hero h = heroParty.search(s);
        if(m != null){
            m.show_title();
            m.show_info();
        } else if (h != null) {
            h.show_title();
            h.show_info();
        } else{
            System.out.println("Sorry, your input is invalid, please try again.");
            display_statistics();
        }
    }

    // For Hero to enter the equipment type, Armor / Weapon
    public void choose_equip(Hero h){
        System.out.println("Please enter the Product you want to equip: (Weapon / Armor)");
        Scanner sca = new Scanner(System.in);
        String s = sca.nextLine();
        if(s.equals("Armor") || s.equals("armor") || s.equals("ARMOR")){
            h.equip_armor();
        } else if (s.equals("Weapon") || s.equals("weapon") || s.equals("WEAPON")) {
            h.equip_weapon();
        } else {
            System.out.println("Sorry, your input is invalid, please try again.");
            choose_equip(h);
        }
    }

    // To search and get the Monster from the monster group;
    public Monster search_monster(){
        monsterGroup.show_monster_list();
        System.out.println("Please enter the name of the Monster you are gonna attack: ");
        Scanner sca = new Scanner(System.in);
        String s = sca.nextLine();
        for(Monster m : monsterGroup.get_monster_list()){
            if(m.getName().equals(s)){
                return m;
            }
        }
        return null;
        //System.out.println("Sorry, your input is invalid, please try again.");
    }

//    public Weapon search_weapon(Hero h){
//        h.show_inventory();
////        System.out.println("Please enter the name of the Weapon you are gonna use: ");
////        Scanner sca = new Scanner(System.in);
////        String s = sca.nextLine();
//        return h.get_weapon();
//        //System.out.println("Sorry, your input is invalid, please try again.");
//    }
}
