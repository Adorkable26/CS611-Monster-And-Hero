public class Spell extends Product{
    public int damage_val;
    public int mana_cost;

    // initialize the spell;
    public void initialize(String n, double p, int l, int d, int m) {
        super.initialize(n, p, l);
        setDamage_val(d);
        setMana_cost(m);
    }

    // set damage value;
    public void setDamage_val(int d){
        damage_val = d;
    }

    // set mana_cost;
    public void setMana_cost(int m){
        mana_cost = m;
    }

    // set damage value;
    public int getDamage_val() { return damage_val;}

    // return mana cost;
    public int getMana_cost() { return mana_cost;}

    // return type;
    public String getType(){ return null;}

    // print the information that a hero's mana cost isn't enough for using this product;
    public void manaCannotUse(){
        System.out.println("Sorry, your mana isn't enough for using this product.");
    }

    @Override
    // print the title of the information of the spells;
    public void print_title() {
        System.out.println("Name\tPrice\tDamage\tRequired Level\tMana Cost");
    }

    @Override
    // print the information of the spells;
    public void print_info(){
        System.out.println(getName() + "\t" + getPrice() + "\t" + damage_val + "\t" + getLevel() + "\t" + mana_cost);
    }

    @Override
    // return type, which is "spell"
    public String get_type(){
        return "Spell";
    }

}
