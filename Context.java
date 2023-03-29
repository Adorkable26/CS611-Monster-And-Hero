public class Context {
    private Strategy strategy;
    private OperationFactory operationFactory = new OperationFactory();

    // This function combines the Strategy Pattern and Factory Pattern to respond to the operations of heroes;
    public void makeAction(Hero h, Monster m, String s){
        strategy = operationFactory.getStrategy(s);
        strategy.doOperation(h,m);
    }
}
