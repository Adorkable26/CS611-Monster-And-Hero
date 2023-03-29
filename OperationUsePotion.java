public class OperationUsePotion implements Strategy{

    @Override
    // strategy pattern, override the doOperation function to accomplish the use a potion operation;
    public void doOperation(Hero h, Monster m){
        h.usePotion(h.get_potion());
    }
}
