import java.util.ArrayList;

public class BednarekIterations extends OperationsForSets{

  BednarekIterations() {
    ArrayList<ArrayList<Integer>> L = new ArrayList<ArrayList<Integer>>();
    L.add(new ArrayList<Integer>());
    L.get(0).add(0);
    L = this.calculateArrayL(0, L);
  }

  ArrayList<ArrayList<Integer>> getInputData() {
    int size = 5;
    ArrayList<ArrayList<Integer>> inputData = new ArrayList<ArrayList<Integer>>(size);
    for (int i = 0; i < size; i++) {
      inputData.add(new ArrayList<Integer>());
    }

    this.addEdge(inputData, 0, 1);
    this.addEdge(inputData, 1, 2);
    this.addEdge(inputData, 2, 3);
    this.addEdge(inputData, 2, 4);

    return inputData;
  }


  void addEdge(ArrayList<ArrayList<Integer>> adjArray, int p1, int p2) {
    adjArray.get(p1).add(p2);
    adjArray.get(p2).add(p1);
  }


  // Step 1
  ArrayList<ArrayList<Integer>> calculateArrayX(int numberOfPeaks) {
    ArrayList<ArrayList<Integer>> X = new ArrayList<ArrayList<Integer>>(numberOfPeaks);
     for (int i = 0; i < numberOfPeaks; i++) {
       X.add(new ArrayList<Integer>(i + 1));
       for (int j = 0; j <= i; j++) {
          X.get(i).add(j);
       }
     }

     return X;
  }


  // Step 2
  ArrayList<ArrayList<Integer>> calculateArrayY(ArrayList<ArrayList<Integer>> inputData, ArrayList<ArrayList<Integer>> X) {
    ArrayList<ArrayList<Integer>> Y = new ArrayList<ArrayList<Integer>>();

    Y.add(new ArrayList<Integer>());
    Y.get(0).add(0);

    for (int i = 1; i < 5; i++) {
      Y.add(this.getYLine(inputData.get(i), X.get(i)));
    }

    return Y;
  }

  //Step 3
  ArrayList<ArrayList<Integer>> calculateIPrime(ArrayList<ArrayList<Integer>> L ,ArrayList<Integer> YRow) {
    ArrayList<ArrayList<Integer>> Iprime = new ArrayList<ArrayList<Integer>>();

    for(int i = 0; i < L.size(); i++) {
      Iprime.add(new ArrayList<Integer>());
      Iprime.add(this.intersectionOfSets(L.get(i), YRow));
    }

    return Iprime;
  }

  //Step4
  ArrayList<ArrayList<Integer>> calculateI(ArrayList<ArrayList<Integer>> set) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    result = includeInBiggerSet(set);

    return result;
  }

  ArrayList<ArrayList<Integer>> calculateLPrime(ArrayList<ArrayList<Integer>> L,
                                                ArrayList<Integer> Y,
                                                ArrayList<Integer> X,
                                                ArrayList<ArrayList<Integer>> I) {
     ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
     ArrayList<Integer> tempRow = new ArrayList<Integer>();


     for(int i = 0; i < L.size(); i++) {
       tempRow = this.intersectionOfSets(L.get(i), Y);

       if (compareRows(L.get(i), Y)) {
         result.addAll(this.reunionWithNextPeak(L.get(i), X.get(X.size()-1) ));
       } else if(this.compareRowWithSet(tempRow, I)){
         result.addAll(this.reunionWithNextPeak(tempRow, X.get(X.size()-1) ));
       } else {
         result.add(L.get(i));
       }
     }

     return result;
  }

//functia de baza
  ArrayList<ArrayList<Integer>> calculateArrayL(int k, ArrayList<ArrayList<Integer>> L) {

    //Step 1 and Step 2
    ArrayList<ArrayList<Integer>> inputData = this.getInputData();
    ArrayList<ArrayList<Integer>> X = this.calculateArrayX(inputData.size());
    ArrayList<ArrayList<Integer>> Y = this.calculateArrayY(inputData, X);

    System.out.println("Date de intrare:");
    System.out.println(inputData);
    System.out.println("Multimile X :");
    System.out.println(X);
    System.out.println("Multimile Y :");
    System.out.println(Y);

    // Step 3
    ArrayList<ArrayList<Integer>> IPrime = this.calculateIPrime(L, Y.get(k+1));

    System.out.println("Iprime : ");
    System.out.println(IPrime);

    //Step 4
    ArrayList<ArrayList<Integer>> I = new ArrayList<ArrayList<Integer>>();
    I = this.calculateI(IPrime);
    System.out.println("I : ");
    System.out.println(I);

    // Step 5
    ArrayList<ArrayList<Integer>> LPrime = new ArrayList<ArrayList<Integer>>();
    LPrime = this.calculateLPrime(L , Y.get(k+1), X.get(k+1), I);
    System.out.println("LPrime : ");
    System.out.println(LPrime);
//    // Step 6
    L = this.includeInBiggerSet(LPrime);
    System.out.println("L : ");
    System.out.println(L);
//    // Step 7
//    if (this.k < numberOfPeaks) {
//      this.k++;
//      this.calculateElementL(arrayL, X, Y, numberOfPeaks);
//    }

    return L;
  }


  //functia folosita pentru a afla fiecare linie a Y
  ArrayList<Integer> getYLine (ArrayList<Integer> inputDataLine, ArrayList<Integer> XLine) {
    int tempValue = 0;
    int[] XLineArray = new int[XLine.size()];
    ArrayList<Integer> result = new ArrayList<Integer>();

    for (int i = 0; i < XLineArray.length; i++) {
      XLineArray[i] = XLine.get(i);
    }

    for(int i = 0; i < inputDataLine.size(); i++) {
      for(int j = 0; j < XLine.size(); j++) {
        if (inputDataLine.get(i) == XLineArray[j]) {
          this.deleteArrayIndex(XLineArray, j);
          tempValue++;
        }
      }
    }

    for (int i = 0; i < XLineArray.length - tempValue; i++) {
      result.add(XLineArray[i] );
    }

    return result;
  }

  void deleteArrayIndex(int[] array, int k) {
    for (int i = k; i < array.length - 1; i++) {
      array[i] = array[i+1];
    }
  }

}
