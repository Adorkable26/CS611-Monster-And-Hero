public class OperationFactory {

    public Strategy getStrategy(String s){
        if(s.equals("Attack") || s.equals("attack") || s.equals("ATTACK")){
            return new OperationAttack();
        } else if (s.equals("Spell") || s.equals("spell") || s.equals("SPELL")) {
            return new OperationCastSpell();
        } else if (s.equals("Potion") || s.equals("potion") || s.equals("POTION")) {
            return new OperationUsePotion();
        } else if (s.equals("Equip") || s.equals("equip") || s.equals("EQUIP")) {
            return new OperationEquip();
        } else{
            return null;
        }
    }
}
