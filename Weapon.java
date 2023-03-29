public class Weapon extends Product{
    private int damage_val;
    private int req_hands;

    // initialize the Product;
    public void initialize(String n, double p, int l, int d, int h) {
        super.initialize(n, p, l);
        setDamage_val(d);
        setHands_num(h);
    }

    // set damage value;
    public void setDamage_val(int d) {
        damage_val = d;
    }

    // set the needed hands number when using the weapon;
    public void setHands_num(int h) {
        req_hands = h;
    }

    // return the damage value
    public int getDamage_val() { return damage_val;}

    // return hands number;
    public int getHands_num() { return req_hands;}

    // use waepon on monster;
    public void use(Monster m){
        m.beAttacked(damage_val);
    }

    @Override
    // print the title of the information of the weapons;
    public void print_title() {
        System.out.println("Name\tPrice\tRequired Level\tDamage\tRequired Hands");
    }

    @Override
    // print the information of the weapons;
    public void print_info(){
        System.out.println(getName() + "\t" + getPrice() + "\t" + getLevel() + "\t" + damage_val + "\t" + req_hands);
    }

    @Override
    // return the type --- weapon;
    public String get_type(){
        return "Weapon";
    }
}
