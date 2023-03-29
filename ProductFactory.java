public class ProductFactory {

    // This method is to help create an instance of a certain product without knowing it in advance;
    public Product create_Product(String productType){
        if(productType == null){
            return null;
        }
        if(productType.equals("Weapon")){
            return new Weapon();
        } else if(productType.equals("Armor")){
            return new Armor();
        } else if(productType.equals("Potion")){
            return new Potion();
        } else if(productType.equals("Spell")){
            return new Spell();
        }
        return null;
    }




}
