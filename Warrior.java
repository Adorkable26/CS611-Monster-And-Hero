public class Warrior extends Hero{
//    @Override
//    public void initialize() {
//        super.initialize();
//    }

    @Override
    // a Warrior levels up, its strength and agility value will also level up;
    public void levelUp() {
        super.levelUp();
        super.StrengthLevelUp();
        super.AgilityLevelUp();
    }
}
