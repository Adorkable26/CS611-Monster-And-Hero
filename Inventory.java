import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private List<Product> inventory = new ArrayList<>();

    // to add product in an inventory;
    public void add(Product p){
        inventory.add(p);
    }

    // to remove product from an inventory;
    public void remove(Product p){
        inventory.remove(p);
    }

    // to show the products inside the inventory;
    public void show(){
        for(Product p : inventory){
            p.print_title();
            p.print_info();
        }
    }

    // To return the Weapon List from the Inventory.
    public List<Weapon> get_all_weapon(){
        List<Weapon> wList = new ArrayList<>();
        Weapon w = new Weapon();
        w.print_title();
        for(Product p : inventory){
            if(p.get_type().equals("Weapon")){
                w = (Weapon)p;
                wList.add(w);
                p.print_info();
            }
        }
        return wList;
    }

    // To search for the target Weapon from the Weapon list, for hero to use.
    public Weapon search_weapon(){
        System.out.println("Please enter the name of the Weapon you want to use: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for(Weapon w : get_all_weapon()){
            if(w.getName().equals(s)){
                return w;
            }
        }
        return null;
    }

    // To return the Armor List from the inventory.
    public List<Armor> get_all_armor(){
        List<Armor> aList = new ArrayList<>();
        Armor a = new Armor();
        a.print_title();
        for(Product p : inventory){
            if(p.get_type().equals("Weapon")){
                a = (Armor)p;
                aList.add(a);
                p.print_info();
            }
        }
        return aList;
    }

    // To search for the target Armor from the Armor list, for hero to use.
    public Armor search_armor(){
        System.out.println("Please enter the name of the Armor you want to use: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for(Armor a : get_all_armor()){
            if(a.getName().equals(s)){
                return a;
            }
        }
        return null;
    }

    // To return the Potion List from the Inventory.
    public List<Potion> get_all_potion(){
        List<Potion> pList = new ArrayList<>();
        Potion p = new Potion();
        p.print_title();
        for(Product e : inventory){
            if(e.get_type().equals("Weapon")){
                p = (Potion) e;
                pList.add(p);
                e.print_info();
            }
        }
        return pList;
    }

    // To search for the target Potion from the Potion list, for hero to use.
    public Potion search_potion(){
        System.out.println("Please enter the name of the Potion you want to use: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for(Potion p : get_all_potion()){
            if(p.getName().equals(s)){
                return p;
            }
        }
        return null;
    }

    // To return the Spell List from the Inventory.
    public List<Spell> get_all_spell(){
        List<Spell> sList = new ArrayList<>();
        Spell s = new Spell();
        s.print_title();
        for(Product e : inventory){
            if(e.get_type().equals("Weapon")){
                s = (Spell) e;
                sList.add(s);
                e.print_info();
            }
        }
        return sList;
    }

    // To search for the target Spell from the Spell list, for hero to use.
    public Spell search_spell(){
        System.out.println("Please enter the name of the Spell you want to use: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for(Spell sp : get_all_spell()){
            if(sp.getName().equals(s)){
                return sp;
            }
        }
        return null;
    }

    // To search for the target Product from the Product list, used for selling.
    public Product search_product(){
        System.out.println("Please enter the name of the product you want to sell: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for(Product p : inventory){
            if(p.getName().equals(s)){
                return p;
            }
        }
        return null;
    }

    // to return the product list (inventory);
    public List<Product> get_inventory(){
        return inventory;
    }


}
