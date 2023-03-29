public class Dragon extends Monster{
    public Dragon(){}

    // The constructor of class Dragon;
    public Dragon(String n, int l, int hp, int dmg, int dfs, int dod){
        //super(n, l, hp, dmg, dfs, dod);
        super.setDamage_val((int)(1.2 * dmg));
    }
}
