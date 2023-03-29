import java.util.HashMap;
import java.util.Map;

public class Potion extends Product{
    private int effect_amount;
    Map func = new HashMap();
    

    // to initialize a potion;
    public void initialize(String n, double p, int l, int e, boolean hp, boolean mp, boolean stg, boolean dex, boolean agi) {
        super.initialize(n, p, l);
        setEffect_amount(e);
        func.put("HP", hp);
        func.put("MP", mp);
        func.put("Strength", stg);
        func.put("Dexterity", dex);
        func.put("Agility", agi);
    }

    // to set the effect amount;
    public void setEffect_amount(int e) {
        effect_amount = e;
    }

    // to return the effect amount;
    public int getEffect_amount(){  return effect_amount;}

    // to return the map;
    public boolean getMap(String s){
        return (boolean)func.get(s);
    }

    @Override
    // to print the title of the basic information of potions;
    public void print_title() {
        System.out.println("Name\tPrice\tRequired Level\tAttribute Increase\tAttribute Affected");
    }

    @Override
    // to print the basic info of potions;
    public void print_info(){
        System.out.println(getName() + "\t" + getPrice() + "\t" + getLevel() + "\t" + effect_amount);
    }

    @Override
    // to return the type ---- potion;
    public String get_type(){
        return "Potion";
    }

}
