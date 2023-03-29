public class Product {
    private String name;
    private double price;
    private int level;

    // to initialze products;
    public void initialize(String n, double p, int l){
        setName(n);
        setPrice(p);
        setLevel(l);
    }

    // to set the name of a product;
    public void setName(String n){
        name = n;
    }

    // to set price of a product;
    public void setPrice(double p){
        price = p;
    }

    // to setLevel of a product;
    public void setLevel(int l){
        level = l;
    }
    //public void setManaCost(int m){ manaCost = m;}

    // to return the name of a product;
    public String getName() { return name;}

    // to return the price of a product;
    public double getPrice() { return price;}

    // to return the level of a product;
    public int getLevel() { return level;}

    // to return the type of a product;
    public String get_type(){
        return null;
    }

    //public int getManaCost(){ return manaCost;}

    //to print the information that a hero cannot buy a product because its level isn't high enough;
    public void levelCannotBuy(){
        System.out.println("Sorry, your level isn't high enough, you couldn't buy this product.");
    }

    //to print the information that a hero cannot use a product because its level isn't high enough;
    public void levelCannotUse(){
        System.out.println("Sorry, your level isn't high enough, you couldn't use this product.");
    }

    // to print the title of the information of a product;
    public void print_title(){}

    // to print information of a product;
    public void print_info(){}
}
