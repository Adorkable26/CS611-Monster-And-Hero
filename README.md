# CS611-Monster-And-Hero
<A brief description of each file and what it does>
1. <Main.class> in this file, an instance of Game is created, this is where the initial game starts.
	
2. <Game.class> encapsulates all the methods and operations of this game, the Main.class only need to
	contain few lines of the codes that the whole game could run.
	
3. <Role.class> is the super class of the <Monster.class> and <Hero.classes>, the two classes are 
	generated from this class because there are something in common, so I encapsulated 
	some members and methods in this class for them to use.
4. <Hero.class> contains all the operations of heroes;
5. <HeroParty.class> creates a list of heroes (hero party) and contains all the operations of Hero Party.
6. <HeroFactory.class> uses the Factory Pattern and helps to create instances of different types of Heroes.
7. <Warrior.class> <Sorcerer.class> <Paladins.class> are three types of heroes, they are subclasses 
	of the Hero class;
8. <Monster.class> contains all the operations of monster.
9. <MonsterGroup.class> creates a list of monsters and contains all the operations of Monster Group.
10. <MonsterFactory.class> uses the Factory Pattern and helps to create instances of different types of monsters.
11. <Product.class> is the super class of <Weapon.class> <Armor.class> <Spell.class> <Potion.class>.
12. <Weapon.class> encapsulates all the operations of weapons.
13. <Armor.class> encapsulates all the operations of armors.
14. <Spell.class> encapsulates all the operations of spells.
15. <Potion.class> encapsulates all the operations of potions.
16. <IceSpell.class> <FireSpell.class> <LightningSpell.class> are extends from <Spell.class>.
17. <ProductFactory.class> uses the Factory Pattern and helps to create instances of different types of Products.
18. <SpellFactory.class> uses the Factory Pattern and helps to create instances of different types of Spells.
19. <Market.class> accomplishes a market and its methods.
20. <Cell.class> is the super class of <InaccessibleCell.class> <MarketCell.class> <CommonCell.class>.
21. <MarketCell.class> is a cell with the market, heroes could enter the cell and choose whether to go to the market.
22. <CommonCell.class> contains all the methods that are related to this cell, the battle begins on this cell.
23. <Map.class> is to show the 8*8 cells on it.
24. <Battle.class> encapsulates all the details of the battles, a common cell has an instance of battle.
25. <Dragon.class> <Exoskeleton.class> <Spirits.class> are extended from <Monster.class>.
26. <OperationAttack.class> <OperationCastSpell.class> <OperationEquip.class> <OperationUsePotion.class> use Strategy
	Pattern to handle the operations of heroes.
27. <OperationFactory.class> uses the Factory Pattern and helps to create instances of different types of Operations
28. <Context.class> accomplishes the Strategy Pattern and operations.
29. <Inventory.class> has the list of products, is designed for hero, which encapsulates methods related to the hero's
	inventory.



## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "main" after unzipping the files
2. Run the following instructions:
<Example below>
javac -d bin src/*.java
java -cp bin Main

## Input/Output Example
---------------------------------------------------------------------------

<Output:>
	Welcome to Legends: Monsters and Heroes!
	How many heroes do you want to play with?
<Input:> 3
<Output:>What kind of hero do you want to choose?
<Input:> Warrior
<Output:>
	(A list of Warriors)
	Please enter the Hero's name: 
<Input:> Eunoia_Cyn
...

<Output:>
Name	Level	Mana	Strength	Agility	Dexterity	Starting money	Starting experience

Eunoia_Cyn	1	400	700	800	600	2500.0	6

Kalabar	1	800	850	400	600	2500.0	6

Kalabar	1	800	850	400	600	2500.0	6
Your current location is: (1, 1)
----------------------------------------
    |    |  X |    |  M |  X |  M |    |
----------------------------------------
    |    |    |  X |    |  X |  X |    |
----------------------------------------
    |  X |    |  M |    |  X |    |    |
----------------------------------------
    |    |  X |    |  X |  M |    |  M |
----------------------------------------
    |  M |    |    |  M |    |  M |  X |
----------------------------------------
    |  M |    |  X |    |    |  X |    |
----------------------------------------
  X |    |  M |    |  M |  M |  M |    |
----------------------------------------
    |  M |    |  M |    |  M |    |  M |
----------------------------------------
<Output:> Please enter your move: 
	
<Input:> d
	
<Output:>
Your current location is: (2, 1)
Name	Level	Damage	Defense	Dodge chance
DocOck	600	600	55
Merrsha	1000	900	55
Casper	100	100	50
The monster group is created!
The battle begins!
Eunoia_CynIt's your turn, do you want to display the statistics? (Yes / No)
...
<Output: >
Eunoia_CynIt's your turn, please enter your activity: (Attack / Spell / Potion / Equip)
<Input: > Attack
<Output: > Please enter the name of the Monster you are gonna attack:
<Input: > DocOck
...
<Output: > Eunoia_CynIt attacked DocOck for 100 damage!
...

