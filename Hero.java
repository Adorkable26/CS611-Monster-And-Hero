import javax.management.monitor.MonitorSettingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hero extends Role{
    private int exp_points = 0;
    private int mana_points;
    private int strength_val;
    private int dexterity_val;
    private int agility_val;
    private double gold = 2500;
    private int avail_hand_num = 2;

    private Inventory inventory = new Inventory();
    //private List<Product> inventory = new ArrayList<>();

    // To set the initial information of the heroes;
    public void initialize(String n, int m, int stg, int ag, int dex, int exp) {
        setName(n);
        mana_points = m;
        strength_val = stg;
        agility_val = ag;
        dexterity_val = dex;
        exp_points = exp;
        setLevel(1);
        initHP();
    }

    // Print the title of a hero's basic information;
    @Override
    public void show_title(){
        System.out.println("Name\tLevel\tMana\tStrength\tAgility\tDexterity\tStarting money\tStarting experience");
    }

    // Print the basic information of a hero;
    @Override
    public void show_info(){
        System.out.println(super.getName() + "\t" + getLevel() + "\t" + mana_points + "\t" + strength_val +"\t" +  agility_val +"\t" +  dexterity_val +"\t" +  gold +"\t" +  exp_points);
    }

    // To set the experience points for a hero;
    public void setExp_points(int exp_points) {
        this.exp_points = exp_points;
    }

    // To set the mana points for a hero;
    public void setMana_points(int mana_points) {
        this.mana_points = mana_points;
    }

    // To set the strength value for a hero;
    public void setStrength_val(int strength_val) {
        this.strength_val = strength_val;
    }

    // To set the dexterity value for a hero;
    public void setDexterity_val(int dexterity_val) {
        this.dexterity_val = dexterity_val;
    }

    // To set the agility value for a hero;
    public void setAgility_val(int agility_val) {
        this.agility_val = agility_val;
    }

    // To set the gold(money) for a hero;
    public void setGold(double gold) {
        this.gold = gold;
    }

    // To return the experience points of a hero;
    public int getExp_points() { return exp_points;}

    // To return the mana points of a hero;
    public int getMana_points() { return mana_points;}

    // To return the mana points of a hero;
    public int getStrength_val() { return strength_val;}

    // To return the dexterity value of a hero;
    public int getDexterity_val() { return dexterity_val;}

    // To return the agility points of a hero;
    public int getAgility_val() { return agility_val;}

    // To return the gold / money of a hero;
    public double getGold() { return gold;}

    // To set the dodge chance of a hero;
    public void setDodge_chance(){
        super.setDodge_chance((int)(agility_val * 0.002));
    }

    // To set up the mana points when leveling up;
    public void MpLevelUp(){ mana_points = (int) (mana_points * 1.1);}
    // To set up the strength value when leveling up;
    public void StrengthLevelUp(){ strength_val *= 1.05;}
    // To set up the dexterity value when leveling up;
    public void DexterityLevelUp(){ dexterity_val *= 1.05;}
    // To set up the agility value when leveling up;
    public void AgilityLevelUp(){ agility_val *= 1.05;}
    // To return the number of available hands;
    public int get_available_hand(){ return avail_hand_num;}


    // To calculate the leveling up needed experience points;
    public int calculate_level_exp(){
        int level = super.getLevel();
        if(level == 1) return 10;
        else{
            return (1+level) * level * 5;
        }
    }

    //To check whether the hero can level up;
    public boolean checkLevelUP(){
        if(exp_points > calculate_level_exp()) {
            levelUp();
            return true;
        } else return false;
    }

    // When leveling up, call all the leveling up corresponding functions to reset the values;
    public void levelUp(){
        super.levelUp();
        HpLevelUp();
        MpLevelUp();
        StrengthLevelUp();
        DexterityLevelUp();
        AgilityLevelUp();
    }

//    public void regain(int mon_level, int mon_num){
//        int hp = super.getHit_points();
//        hp *= 1.1;
//        super.setHit_points(hp);
//        mana_points *= 1.1;
//        gold = gold + 100 * mon_level;
//        exp_points = exp_points + 2 * mon_num;
//    }

    // To check if the hero's level is enough for using / buying some products;
    public boolean checkLevel(Product p){
        int hLevel = getLevel();
        int pLevel = p.getLevel();
        if(hLevel >= pLevel) return true;
        else return false;
    }

    // To check if the hero's mana points is enough for casting a spell;
    public boolean checkMana(Spell s){
        int sMana = s.getMana_cost();
        if(mana_points >= sMana) {
            mana_points -= sMana;
            return true;
        }
        else return false;
    }

    // For hero to use a Weapon w on a Monster m;
    public void useWeapon(Weapon w, Monster m){
        if(checkLevel(w)){
            w.use(m);
            inventory.remove(w);
        } else w.levelCannotUse();
        System.out.println(getName() + " attackes " + m.getName() + " for " + w.getDamage_val() + " damage!");
    }

    // For hero to use an Armor;
    public void useArmor(Armor a){
        if(checkLevel(a)){
            equip_armor();
        } else a.levelCannotUse();
        System.out.println(getName() + " uses " + a.getName() + " for " + a.getDmg_reduction_val() + " damage reduction!");
    }

    // For hero to use potion;
    public void usePotion(Potion p){
        if(checkLevel(p)){
            String[] string = {"HP","MP","Strength","Dexterity","Agility"};
            for(String s : string) {
                int e = p.getEffect_amount();
                if (p.getMap(s)) {
                    if (s.equals("HP")) {
                        int hp = super.getHit_points();
                        super.setHit_points(hp - e);
                    } else if (s.equals("MP")) {
                        mana_points -= e;
                    } else if (s.equals("Strength")) {
                        strength_val -= e;
                    } else if (s.equals("Dexterity")) {
                        dexterity_val -= e;
                    } else if (s.equals("Agility")) {
                        agility_val -= e;
                    }
                }
            }
        }else p.levelCannotUse();
        System.out.println(getName() + " uses potion to recover " + p.getEffect_amount() +  " points!");
//        if(checkLevel(p)){
//            int e = p.getEffect_amount();
//            String t = p.getType();
//            if(t.equals("HP")){
//                int hp = super.getHit_points();
//                super.setHit_points(hp - e);
//            } else if (t.equals("MP")) {
//                mana_points -= e;
//            } else if (t.equals("Strength")){
//                strength_val -= e;
//            } else if (t.equals("Dexterity")){
//                dexterity_val -= e;
//            } else if (t.equals("Agility")) {
//                agility_val -= e;
//            }
//        } else p.levelCannotUse();
    }

    // For hero to equip an Armor;
    public void equip_armor(){
        Armor a = get_armor();
        if(checkLevel(a)){
            System.out.println("Your Armor is equipped!");
        } else a.levelCannotUse();
    }

    // For hero to equip a weapon;
    public void equip_weapon(){
        Weapon w = new Weapon();
        w = get_weapon();
        int req_num = w.getHands_num();
        if(req_num > avail_hand_num){
            System.out.println("Sorry, you cannot equip this weapon.");
        } else avail_hand_num -= req_num;
    }


    //For hero to use Spell;
    public <T extends Spell> void useSpell(T s, Monster m){
        if(checkLevel(s)){
            if(checkMana(s)){
                int d = s.getDamage_val();
                String t = s.getType();
                d = (int) cal_spell_damage(d);
                if(t.equals("Ice")) m.reduce_damage(d);
                else if (t.equals("Fire")) {
                    m.reduce_defense(d);
                } else if (t.equals("Lightning")) {
                    m.reduce_dodge_chance(d);
                }
                System.out.println(getName() + " uses spell on " + m.getName() + " for " + s.getDamage_val() + " damage!");
                mana_points = mana_points - s.getMana_cost();
                inventory.remove(s);
            } else s.manaCannotUse();
        } else s.levelCannotUse();
    }

    // The function to calculate the spell's damage;
    public double cal_spell_damage(double d){
        return d + dexterity_val / 10000 * d;
    }

    public void buy(Product p){
        if(checkLevel(p)){
            double price = p.getPrice();
            gold = gold - price;
            inventory.add(p);
        } else p.levelCannotBuy();
    }

    // For hero to sell a product;
    public void sell(Product p){
//        System.out.println("Please enter the name of the product you wanna sell: ");
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        int index = -1;
//        for(Product p: inventory){
//            if(p.getName().equals(s)){
//                index = inventory.indexOf(p);
//            }
//        }
        //Product p = inventory.search_product();

        if(p == null){
            System.out.println("Sorry, your input is invalid, please try again.");
            sell(p);
        }else {
            double price = p.getPrice();
            gold = gold + price / 2;
            inventory.remove(p);
        }
    }

    // To search and return a certain product;
    public Product get_product(){
        Product p = inventory.search_product();
        return p;
    }

    // If a hero wins -> gets experience points and gain golds according to its level;
    public void win(int level){
        exp_points += level;
        gold += 100 * level;

    }

    //public void faint(){}

    // If a fainted hero revives, hero will get half of its initial hp and mp;
    public void revive(){
        int level = getLevel();
        int hp  = 100 * level / 2;
        setHit_points(hp);
        int mp = getMana_points();
        mp = mp / 2;
        setMana_points(mp);
    }

    //After a round ends, a hero could regain some mp and hp;
    public void regain(MonsterGroup mg){
        int hp = super.getHit_points();
        super.setHit_points((int)(1.1 * hp));
        mana_points *= 1.1;
        int level = super.getLevel();
        gold += 100 * level;
        int m_num = mg.getNum();
        exp_points += m_num * 2;
        if(checkLevelUP()) levelUp();
    }


//    public void turn(){
//        System.out.println(super.getName() + "It's your turn, please enter your activity: (Attack / Spell / Potion / Weapon)");
//        Scanner sca = new Scanner(System.in);
//        String s = sca.nextLine();
//        if(s.equals("Attack") || s.equals("attack") || s.equals("ATTACK")){
//            //useWeapon();
//        } else if (s.equals("Spell") || s.equals("spell") || s.equals("SPELL")) {
//            //useSpell();
//        }
//    }

//    public String select_monster(){
//        System.out.println("Please enter the name of the Monster you are gonna use the weapon / cast a spell: ");
//        Scanner sca = new Scanner(System.in);
//        String s = sca.nextLine();
//        return s;
//    }

    // to print the inventory
    public void show_inventory(){
        inventory.show();
    }

    public List<Product> get_inventory(){
        return inventory.get_inventory();
    }

    // search and return a certain weapon;
    public Weapon get_weapon(){
        inventory.get_all_weapon();
        return inventory.search_weapon();
    }

    //search and return a certain armor;
    public Armor get_armor(){
        inventory.get_all_armor();
        return inventory.search_armor();
    }

    // search and return a certain potion;
    public Potion get_potion(){
        inventory.get_all_potion();
        return inventory.search_potion();
    }

    // search and return a certain spell;
    public Spell get_spell(){
        inventory.get_all_spell();
        return inventory.search_spell();
    }

    // choose to equip a weapon or an armor;
    public void choose_equip(){
        System.out.println("Please enter the Product you want to equip: (Weapon / Armor)");
        Scanner sca = new Scanner(System.in);
        String s = sca.nextLine();
        if(s.equals("Armor") || s.equals("armor") || s.equals("ARMOR")){
            equip_armor();
        } else if (s.equals("Weapon") || s.equals("weapon") || s.equals("WEAPON")) {
            equip_weapon();
        } else {
            System.out.println("Sorry, your input is invalid, please try again.");
            choose_equip();
        }
    }

//    public void beAttacked(int dmg){
//        int hp = getHit_points();
//        hp -= dmg;
//        if(hp < 0){
//            hp = 0;
//        }
//        super.setHit_points(hp);
//    }

    // to check if the hero is fainted or not, if is, returns true, otherwise, returns false;
    public boolean isFainted(){
        if(getHit_points() == 0){
            return true;
        } else return false;
    }
}
