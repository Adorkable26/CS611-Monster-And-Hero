public interface Cell {

    // The subclasses need to override this function, this function should include what the 3 kinds of cells do when a
    // hero party enters them;
    public abstract void hero_enter(HeroParty hp);

    // The subclasses also need to override this function, to check if the Cell is movable or not;
    public abstract boolean isMovable();

    // Overriding this function makes showing the cells on map comes true;
    public abstract void show();

    // The subclasses override this function to set the flag that the heroes have left;
    public abstract void hero_leave();
}
