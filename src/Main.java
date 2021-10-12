import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        BednarekAndTaulbee obj = new BednarekAndTaulbee();
        Matrix obj1 = new Matrix();

//        obj.readPeaksAdj();
//        obj.setNoAdjArray(3);
//        obj.printNoAdjArray();


        obj1.readPeaksAdj();
        obj1.setAdjacencyMatrix();
        obj1.setKirchhoffMatrix();

    }
}
