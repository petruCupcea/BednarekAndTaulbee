import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BednarekAndTaulbee obj = new BednarekAndTaulbee();
        Matrix obj1 = new Matrix();
        DFSandBFS obj2 = new DFSandBFS();
        PeaksCoverage obj3 = new PeaksCoverage();


//      Bednarek And Taulbee rulare doar Yk+1
//        obj.readPeaksAdj();
//        System.out.println("Yk+1 = ");
//        for (int i = 1; i < obj.numberOfPeaks; i++) {
//            obj.setNoAdjArray(i);
//            obj.printNoAdjArray();
//
//        }


//        Matricile de adiacenta kirchhoff si incidenta
//        obj1.readPeaksAdj();
//        obj1.setAdjacencyMatrix();
//        obj1.kirchhoffMatrixFromAdjacency();
//        obj1.setKirchhoffMatrix();
//        obj1.setIncidentMatrix();
//        obj1.incidentMatrixfromAdjacency();

//        Rulare pentru afisarea a algoritmului de citire a grafului in latime (incepe de la 0)
//        obj2.readPeaksAdj();
//        obj2.printBFS();

//         algoritmul de citire a grafului in adancime (functioneaza de la varful citit de la tastatura)
//        obj2.DFS();

          obj3.readPeaksAdj();
          obj3.setPeaksCoverage();

    }
}
