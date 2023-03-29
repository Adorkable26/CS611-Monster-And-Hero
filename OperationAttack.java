public class OperationAttack implements Strategy{

    @Override
    // strategy pattern, override the doOperation function to accomplish the Attack operation;
    public void doOperation(Hero h, Monster m){
        h.useWeapon(h.get_weapon(),m);
    }
}
