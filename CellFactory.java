public class CellFactory {

    // This class and method are used to create object of type Cell.
    public Cell create_Cell(String cellType){
        if(cellType == null){
            return null;
        }
        if(cellType.equals("Inaccessible")){
            return new InaccessibleCell();
        } else if(cellType.equals("Common")){
            return new CommonCell();
        } else if(cellType.equals("Market")){
            return new MarketCell();
        } else {
            return null;
        }
    }
}
