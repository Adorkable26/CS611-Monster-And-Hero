public class SpellFactory {

    // This method is to help create an instance of a certain spell without knowing it in advance;
    public Spell create_Spell(String spellType){
        if(spellType == null){
            return null;
        }
        if(spellType.equals("Ice")){
            return new IceSpell();
        } else if(spellType.equals("Fire")){
            return new FireSpell();
        } else if(spellType.equals("Lightning")){
            return new LightningSpell();
        }
        return null;
    }
}
