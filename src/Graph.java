import java.util.ArrayList;
import java.util.Scanner;



public class Graph {

    Scanner scan = new Scanner(System.in);

    ArrayList<ArrayList<Integer>> adjArray;
    int numberOfPeaks;
    int numberOfEdges;
    int[] peaksArray;
    int[][] edgesArray;


//crearea Xk care e un array de toate varfurile
    void initPeaksArray(int k) {
        this.peaksArray = new int[k+1];

        for(int i = 0; i < k+1; i++) {
            this.peaksArray[i] = i;
        }
    }

//functia care adauga cate o muchie pas cu pas
     static void addEdge(ArrayList<ArrayList<Integer> > adjArray,int p1, int p2) {
         adjArray.get(p1).add(p2);
         adjArray.get(p2).add(p1);
    }

//afisearea varufurilor si adiagenta lor
    static void printPeaksAdj(ArrayList<ArrayList<Integer> > adjArray) {
        for (int i = 0; i < adjArray.size(); i++) {
            System.out.println("\n Varfurile adiacente cu varful " + i);
            System.out.print("varful" + i);
            for (int j = 0; j < adjArray.get(i).size(); j++) {
                System.out.print(" -> "+adjArray.get(i).get(j));
            }
            System.out.println();
        }
    }

//functia de citire a adiacentei varfurilor impreun cu nr de varfuri si nr de muchii
    void readPeaksAdj() {
        this.adjArray = new  ArrayList<ArrayList<Integer>>(this.numberOfPeaks);
        int peak1 = 0,peak2 = 0;

        System.out.println("Dati nr total de varfuri al G(X,U)");
        this.numberOfPeaks = scan.nextInt();
        System.out.println("Dati nr total de Muchii al G(X,U)");
        this.numberOfEdges = scan.nextInt();

        for (int i = 0; i < numberOfPeaks; i++)
            this.adjArray.add(new ArrayList<Integer>());

        this.edgesArray = new int[this.numberOfEdges][2];

        for (int i = 0; i < numberOfEdges; i++) {
            System.out.print(i + ". ");
            System.out.println("Dati varfurile muchiei in ordine crescatoare ");
            peak1 = scan.nextInt();
            peak2 = scan.nextInt();

            this.edgesArray[i][0] = peak1;
            this.edgesArray[i][1] = peak2;

            Graph.addEdge(this.adjArray,peak1,peak2);

        }
        Graph.printPeaksAdj(this.adjArray);
    }

//functia de stergere a unui element
    void deleteArrayIndex(int[] array, int k) {
        for (int i = k; i < array.length - 1; i++) {
            array[i] = array[i+1];
        }
    }

}
