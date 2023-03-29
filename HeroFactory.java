public class HeroFactory {

    // This method is used to create object of type Hero.
//    public Hero hero_type(String heroType){
//        if(heroType == null){
//            return null;
//        }
//        if(heroType.equals("Warrior")){
//            return new Warrior();
//        } else if(heroType.equals("Sorcerer")){
//            return new Sorcerer();
//        } else if(heroType.equals("Paladin")){
//            return new Paladin();
//        }
//        return null;
//    }

    // to create certain heroes;
    public Hero create_hero(String name){
        if(name.equals("Gaerdal_Ironhand")){
            Warrior warrior = new Warrior();
            warrior.initialize("Gaerdal_Ironhand", 100, 700, 500, 600, 7);
            return warrior;
        } else if (name.equals("Sehanine_Monnbow")) {
            Warrior warrior = new Warrior();
            warrior.initialize("Sehanine_Monnbow", 600, 700, 800, 500, 8);
            return warrior;
        } else if (name.equals("Muamman_Duathall")) {
            Warrior warrior = new Warrior();
            warrior.initialize("Muamman_Duathall", 300, 900, 500, 750, 6);
            return warrior;
        } else if (name.equals("Flandal_Steelskin")) {
            Warrior warrior = new Warrior();
            warrior.initialize("Flandal_Steelskin", 200, 750, 650, 700, 7);
            return warrior;
        } else if (name.equals("Undefeated_Yoj")) {
            Warrior warrior = new Warrior();
            warrior.initialize("Undefeated_Yoj", 400, 800, 400, 700, 7);
            return warrior;
        } else if (name.equals("Eunoia_Cyn")) {
            Warrior warrior = new Warrior();
            warrior.initialize("Eunoia_Cyn", 400, 700, 800, 600, 6);
            return warrior;
        } else if (name.equals("Rillifane_Rallathil")) {
            Sorcerer sorcerer = new Sorcerer();
            sorcerer.initialize("Rillifane_Rallathil", 1300, 750, 450, 500, 9);
            return sorcerer;
        } else if (name.equals("Segojan_Earthcaller")) {
            Sorcerer sorcerer = new Sorcerer();
            sorcerer.initialize("Segojan_Earthcaller", 900, 800, 500, 650, 5);
            return sorcerer;
        } else if (name.equals("Reign_Havoc")) {
            Sorcerer sorcerer = new Sorcerer();
            sorcerer.initialize("Reign_Havoc", 800, 800, 800, 800, 8);
            return sorcerer;
        } else if (name.equals("Reverie_Ashels")) {
            Sorcerer sorcerer = new Sorcerer();
            sorcerer.initialize("Reverie_Ashels", 900, 800, 700, 400, 7);
            return sorcerer;
        } else if (name.equals("Kalabar")) {
            Sorcerer sorcerer = new Sorcerer();
            sorcerer.initialize("Kalabar", 800, 850, 400, 600, 6);
            return sorcerer;
        } else if (name.equals("Skye_Soar")) {
            Sorcerer sorcerer = new Sorcerer();
            sorcerer.initialize("Skye_Soar", 1000, 700, 400, 500, 5);
            return sorcerer;
        } else if (name.equals("Parzival")) {
            Paladin paladin = new Paladin();
            paladin.initialize("Parzival", 300, 750, 650, 700, 7);
            return paladin;
        } else if (name.equals("Sehanine_Moonbow")) {
            Paladin paladin = new Paladin();
            paladin.initialize("Sehanine_Moonbow", 300, 750, 700, 700, 7);
            return paladin;
        } else if (name.equals("Skoraeus_Stonebones")) {
            Paladin paladin = new Paladin();
            paladin.initialize("Skoraeus_Stonebones", 250, 650, 600, 350, 4);
            return paladin;
        } else if (name.equals("Garl_Glittergold")) {
            Paladin paladin = new Paladin();
            paladin.initialize("Garl_Glittergold", 100, 600, 500, 500, 5);
            return paladin;
        } else if (name.equals("Amaryllis_Astra")) {
            Paladin paladin = new Paladin();
            paladin.initialize("Amaryllis_Astra", 500, 500, 500, 500, 5);
            return paladin;
        } else if (name.equals("Caliber_Heist")) {
            Paladin paladin = new Paladin();
            paladin.initialize("Caliber_Heist", 400, 400, 400, 400, 8);
            return paladin;
        } else return null;

    }

    // to show the heroes that are available to choose;
    public void show_available_hero(String heroType){
        if(heroType.equals("Warrior")){
            System.out.println("Name\tmana\tstrength\tagility\tdexterity\tstarting money\tstarting experience");
            System.out.println("Gaerdal_Ironhand    100     700     500     600     1354    7");
            System.out.println("Sehanine_Monnbow    600     700     800     500     2500    8");
            System.out.println("Muamman_Duathall    300     900     500     750     2546    6");
            System.out.println("Flandal_Steelskin   200     750     650     700     2500    7");
            System.out.println("Undefeated_Yoj      400     800     400     700     2500    7");
            System.out.println("Eunoia_Cyn          400     700     800     600     2500    6");
        } else if(heroType.equals("Sorcerer")){
            System.out.println("Name\tmana\tstrength\tagility\tdexterity\tstarting money\tstarting experience");
            System.out.println("Rillifane_Rallathil     1300    750     450     500     2500    9");
            System.out.println("Segojan_Earthcaller     900     800     500     650     2500    5");
            System.out.println("Reign_Havoc             800     800     800     800     2500    8");
            System.out.println("Reverie_Ashels          900     800     700     400     2500    7");
            System.out.println("Kalabar                 800     850     400     600     2500    6");
            System.out.println("Skye_Soar               1000    700     400     500     2500    5");
        } else if(heroType.equals("Paladin")){
            System.out.println("Name\tmana\tstrength\tagility\tdexterity\tstarting money\tstarting experience");
            System.out.println("Parzival             300     750     650     700     2500    7");
            System.out.println("Sehanine_Moonbow     300     750     700     700     2500    7");
            System.out.println("Skoraeus_Stonebones  250     650     600     350     2500    4");
            System.out.println("Garl_Glittergold     100     600     500     400     2500    5");
            System.out.println("Amaryllis_Astra      500     500     500     500     2500    5");
            System.out.println("Caliber_Heist        400     400     400     400     2500    8");
        }
    }
}
