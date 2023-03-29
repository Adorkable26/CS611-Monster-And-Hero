public class Spirit extends Monster{

    public Spirit(){}

    // constructor
    public Spirit(String n, int l, int hp, int dmg, int dfs, int dod){
        //super(n, l, hp, dmg, dfs, dod);
        super.setDodge_chance((int)(1.2 * dod));
    }

}
