import java.util.ArrayList;


public class BednarekIterations extends OperationsForSets{
  ArrayList<ArrayList<Integer>> LPrime;

  BednarekIterations() {
    this.LPrime = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> L= new ArrayList<ArrayList<Integer>>();
    this.calculateArrayL(0, L);
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

    System.out.println("Iteratia k: ");
    System.out.println(k+1);
    System.out.println("Multimea Y : ");
    System.out.println(Y.get(k+1));

    if(k == 0) {
      L.add(new ArrayList<Integer>());
      L.add(new ArrayList<Integer>());
      L.get(0).add(0);
    }

    // Step 3
    ArrayList<ArrayList<Integer>> IPrime = this.calculateIPrime(L, Y.get(k+1));

    //Step 4
    ArrayList<ArrayList<Integer>> I = new ArrayList<ArrayList<Integer>>();
    I = this.calculateI(IPrime);
    System.out.println("Multimea I : ");
    System.out.println(I);

    // Step 5
    this.LPrime.addAll(this.calculateLPrime(L , Y.get(k+1), X.get(k+1), I));
    this.LPrime = includeInBiggerSet(this.LPrime);

    // Step 6
    L = this.includeInBiggerSet(this.LPrime);
    System.out.println("Multimea L : ");
    System.out.println(L);

    // Step 7
    if (k < X.size()-2) {
      k++;
      this.calculateArrayL(k, L);
    }
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
