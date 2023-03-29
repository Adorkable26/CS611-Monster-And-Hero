import java.util.Scanner;

public class MarketCell implements Cell{

    boolean has_hero = false;
    private Market market = new Market();
    @Override
    // if hero party enters, asks if they want to enter the market and if yes, do some related stuff;
    public void hero_enter(HeroParty hp) {
        has_hero = true;
        System.out.println("This is the Market Cell, do you want to enter the market? (Please enter Y/N)");
        Scanner sca = new Scanner(System.in);
        String s = sca.nextLine();
        if(s.equals("Y")){
            market.initialize();
            sell_to_hero(hp);
        } else if (!s.equals("Y") || !s.equals("N")) {
            System.out.println("Sorry, your input is invalid, please try agian!");
            hero_enter(hp);
        }
    }

    // check if the hero party leaves;
    public void hero_leave(){
        has_hero = false;
    }

    @Override
    // The market cell is movable;
    public boolean isMovable(){ return true;}

    // ask each hero if they want to sell or buy some products;
    public int sell_or_buy() {
        int flag = -1;
        System.out.println("Do you want to buy or sell? (Please enter buy / sell / no)");
        Scanner sca = new Scanner(System.in);
        String s = sca.nextLine();
        if (s.equals("buy") || s.equals("Buy")) {
            flag = 1;
        } else if(s.equals("sell") || s.equals("Sell")){
            flag = 2;
        }else if(s.equals("no") || s.equals("No")) {
            flag = 0;
        } else {
            System.out.println("Sorry, your input is invalid, please try again.");
            sell_or_buy();
        }
        return flag;
    }

    // ask want the heroes want to buy from the hero party;
    public void sell_to_hero(HeroParty hp){
        for(Hero e : hp.get_hero_list()){
            System.out.println("Hello, " + e.getName());
            int flag = sell_or_buy();
            if(flag == 1){
                market.show_products();
                System.out.println("Please enter the name of the product you wanna buy: ");
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                if(market.search_prod(s)){
                    Product p = market.get_product(s);
                    e.buy(p);
                    market.sell(p);
                    System.out.println(e.getName() + ", your purchase is done successfully! Your inventory is shown below.");
                    e.show_inventory();
                }
            } else if (flag == 2) {
                Product p = e.get_product();
                e.sell(p);
                market.buy_from_hero(p);
            }
        }
    }

    // print the cell in the map;
    @Override
    public void show(){
        if(!has_hero) System.out.print("  M |");
        else System.out.print(" P  |");
    }

}
