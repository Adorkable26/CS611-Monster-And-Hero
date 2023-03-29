public class Paladin extends Hero{

    public void initialize() {
        //super.initialize();
    }

    @Override
    // for a paladin to level up, their strength and dexterity should also level up;
    public void levelUp() {
        super.levelUp();
        super.StrengthLevelUp();
        super.DexterityLevelUp();
    }
}
