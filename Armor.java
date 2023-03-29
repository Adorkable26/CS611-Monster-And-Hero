public class Armor extends Product{
    private int dmg_reduction_val;

    // This function is to set the damage reduction value of Armor;
    public void setDmg_reduction_val(int d) {
        dmg_reduction_val = d;
    }

    // This function is to return the damage reduction value of Armor;
    public int getDmg_reduction_val() { return dmg_reduction_val;}

    // This function is to initialize an Armor;
    public void initialize(String n, double p, int l, int dmg) {
        super.initialize(n, p, l);
        setDmg_reduction_val(dmg);
    }

    // This function overrides the print_title(...) of the super class, to print its own title;
    @Override
    public void print_title() {
        System.out.println("Name\tPrice\tRequired Level\tDamage Reduction");
    }

    // This function overrides the print_info(...) of the super class, to print its own info;
    @Override
    public void print_info(){
        System.out.println(super.getName() + "\t" + super.getPrice() + "\t" + super.getLevel() + "\t" + dmg_reduction_val);
    }

    // This function is used to get the type, Armor is the Armor type;
    public String get_type(){
        return "Armor";
    }
}
