public class OperationCastSpell implements Strategy{

    @Override
    // strategy pattern, override the doOperation function to accomplish the Case a spell operation;
    public void doOperation(Hero h, Monster m){
        h.useSpell(h.get_spell(),m);
    }
}
