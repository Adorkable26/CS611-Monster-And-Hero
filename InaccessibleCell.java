public class InaccessibleCell implements Cell{

    // to implement the interface Cell, a hero can't enter an InaccessibleCell, therefore do nothing in this method;
    @Override
    public void hero_enter(HeroParty hp) {}

    // to return the boolean value that this cell is not movable;
    @Override
    public boolean isMovable() {
        return false;
    }

    // to print the cell on the map;
    @Override
    public void show(){
        System.out.print("  X |");
    }

    // implement the hero_leave() function, because hero party can't enter in, thus there's nothing in this method;
    @Override
    public void hero_leave(){}
}
