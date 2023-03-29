import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Market {
    private List<Product> productList = new ArrayList();

    // initialize the market;
    public void initialize(){
        Weapon w1 = new Weapon();
        w1.initialize("Sword", 500, 1, 800, 1);
        productList.add(w1);
        Weapon w2 = new Weapon();
        w2.initialize("Bow", 300, 2, 500, 2);
        productList.add(w2);
        Weapon w3 = new Weapon();
        w3.initialize("Scythe", 1000, 6, 1100, 2);
        productList.add(w3);
        Weapon w4 = new Weapon();
        w4.initialize("Axe", 550, 5, 850, 1);
        productList.add(w4);
        Weapon w5 = new Weapon();
        w5.initialize("TSwords", 1400, 8, 1600, 2);
        productList.add(w5);
        Weapon w6 = new Weapon();
        w6.initialize("Dagger", 200, 1, 250, 1);
        productList.add(w6);

        Armor a1 = new Armor();
        a1.initialize("Platinum_Shield", 150, 1, 200);
        productList.add(a1);
        Armor a2 = new Armor();
        a2.initialize("Breastplate", 350, 3, 600);
        productList.add(a2);
        Armor a3 = new Armor();
        a3.initialize("Full_Body_Armor", 1000, 8, 1100);
        productList.add(a3);
        Armor a4 = new Armor();
        a4.initialize("Wizard_Shield", 1200, 10, 1500);
        productList.add(a4);
        Armor a5 = new Armor();
        a5.initialize("Guardian_Angel", 1000, 10, 1000);
        productList.add(a5);

        Potion p1 = new Potion();
        p1.initialize("Healing_Potion", 250, 1, 100, true, false, false, false, false);
        productList.add(p1);
        Potion p2 = new Potion();
        p2.initialize("Strength_Potion", 200, 1, 75, false, false, true, false, false);
        productList.add(p2);
        Potion p3 = new Potion();
        p3.initialize("Magic_Potion", 350, 2, 100, false, true, false, false, false);
        productList.add(p3);
        Potion p4 = new Potion();
        p4.initialize("Luck_Elixir", 500, 4, 65, false, false, false, false, true);
        productList.add(p4);
        Potion p5 = new Potion();
        p5.initialize("Mermaid_Tears", 850, 5, 100, true, true, true, false, true);
        productList.add(p5);
        Potion p6 = new Potion();
        p6.initialize("Ambrosia", 1000, 8, 150, true, true, true, true, true);
        productList.add(p6);

        IceSpell is1 = new IceSpell();
        is1.initialize("Snow_Cannon", 500, 2, 650, 250);
        productList.add(is1);
        IceSpell is2 = new IceSpell();
        is2.initialize("Ice_Blade", 250, 1, 450, 100);
        productList.add(is2);
        IceSpell is3 = new IceSpell();
        is3.initialize("Frost_Blizzard", 750, 5, 850, 350);
        productList.add(is3);
        IceSpell is4 = new IceSpell();
        is4.initialize("Arctic_Storm", 700, 6, 800, 300);
        productList.add(is4);

        FireSpell fs1 = new FireSpell();
        fs1.initialize("Flame_Tornado", 700, 4, 850, 300);
        productList.add(fs1);
        FireSpell fs2 = new FireSpell();
        fs2.initialize("Breath_of_Fire", 350, 1, 450, 100);
        productList.add(fs2);
        FireSpell fs3 = new FireSpell();
        fs3.initialize("Heat_Wave", 450, 2, 600, 150);
        productList.add(fs3);
        FireSpell fs4 = new FireSpell();
        fs4.initialize("Lava_Comet", 800, 7, 1000, 550);
        productList.add(fs4);
        FireSpell fs5 = new FireSpell();
        fs5.initialize("Hell_Storm", 600, 3, 950, 600);
        productList.add(fs5);

        LightningSpell ls1 = new LightningSpell();
        ls1.initialize("Lightning_Dagger", 400, 1, 500, 150);
        productList.add(ls1);
        LightningSpell ls2 = new LightningSpell();
        ls2.initialize("Thunder_Blast", 750, 4, 950, 400);
        productList.add(ls2);
        LightningSpell ls3 = new LightningSpell();
        ls3.initialize("Electric_Arrows", 550, 5, 650, 200);
        productList.add(ls3);
        LightningSpell ls4 = new LightningSpell();
        ls4.initialize("Spark_Needles", 500, 2, 600, 200);
        productList.add(ls4);

        //show_products();
    }

    // to search and return a certain product;
    public Product get_product(String s){
        for(Product e : productList){
            if(e.getName().equals(s)){
                return e;
            }
        }
        return null;
    }

    // to search a product;
    public boolean search_prod(String s){
//        System.out.println("Please enter the name of the product you wanna buy: ");
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
        int index = -1;
        for(Product p: productList){
            if(p.getName().equals(s)){
                index = productList.indexOf(p);
            }
        }
        if(index == -1){
            //System.out.println("Sorry, your input is invalid, please try again.");
            return false;
        } else return true;
    }

    // for a market to sell a product;
    public void sell(Product p){
        productList.remove(p);
    }
    // for a market to buy products from hero;
    public void buy_from_hero(Product p){
        productList.add(p);
    }

    // for market to show the products they have;
    public void show_products(){
        productList.get(0).print_title();
        for(Product p: productList){
            p.print_info();
        }
    }
}
