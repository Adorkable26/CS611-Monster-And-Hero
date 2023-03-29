public class OperationEquip implements Strategy{

    @Override
    // strategy pattern, override the doOperation function to accomplish the equip operation;
    public void doOperation(Hero h, Monster m){
        h.choose_equip();
    }
}
