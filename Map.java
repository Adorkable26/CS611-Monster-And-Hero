import java.util.*;

public class Map {
    int n = 8;
    private List<Cell> cellList = new ArrayList();

    // according to the data provided, initialize a map;
    public void initialize(){
        int in = (int)(n * n * 0.2);
        int m = (int)(n * n * 0.3);
        int c = 64 - in - m;
        CellFactory cellFactory = new CellFactory();
        for(int j = 0; j < in; j++){
            Cell cell = cellFactory.create_Cell("Inaccessible");
            cellList.add(cell);
        }
        for(int j = 0; j < m; j++){
            Cell cell = cellFactory.create_Cell("Market");
            cellList.add(cell);
        }
        for(int j = 0; j < c; j++){
            Cell cell = cellFactory.create_Cell("Common");
            cellList.add(cell);
        }
        Collections.shuffle(cellList);
        MarketCell mc = new MarketCell();
        cellList.set(0, mc);
    }

    // return the cell which the hero party enters;
    public Cell get_entered_cell(int[] new_location){
        int m = new_location[0];
        int n = new_location[1];
        int index = (m - 1) * 8 + n - 1;
        return cellList.get(index);
    }

    // print map on the terminal;
    public void show_map(){
        System.out.println("----------------------------------------");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cellList.get(i * 8 + j).show();
            }
            System.out.println("\n----------------------------------------");
        }
    }


}
