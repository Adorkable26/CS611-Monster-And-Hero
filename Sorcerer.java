public class Sorcerer extends Hero{


    @Override
    // when a Sorcerer levels up -> dexterity and agility value will be increased;
    public void levelUp() {
        super.levelUp();
        super.DexterityLevelUp();
        super.AgilityLevelUp();
    }
}
