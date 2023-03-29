public class Exoskeleton extends Monster{

    public Exoskeleton(){}

    // The constructor of class Exoskeleton;
    public Exoskeleton(String n, int l, int hp, int dmg, int dfs, int dod){
        //super(n, l, hp, dmg, dfs, dod);
        super.setDefense_val((int)(1.2 * dfs));
    }
}
