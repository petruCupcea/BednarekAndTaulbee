import java.util.ArrayList;

public class BednarekIterations {

  int k = 0;


  BednarekIterations() {
    ArrayList<ArrayList<Integer>> inputData = this.getInputData();
    ArrayList<ArrayList<Integer>> X = this.calculateArrayX(inputData.size());
    ArrayList<ArrayList<Integer>> Y = this.calculateArrayY(inputData, X);
//    int L = this.calculateArrayL(inputData, X, Y);
    System.out.println("Date de intrare:");
    System.out.println(inputData);
    System.out.println("Multimile X :");
    System.out.println(X);
    System.out.println("Multimile Y :");
    System.out.println(Y);
  }


  void deleteArrayIndex(int[] array, int k) {
    for (int i = k; i < array.length - 1; i++) {
      array[i] = array[i+1];
    }
  }

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
  ArrayList<Integer> calculateIPrime(ArrayList<Integer> L ,ArrayList<Integer> Y) {
    ArrayList<Integer> Iprime = new ArrayList<Integer>();



    return Iprime;
  }


//  int [] calculateArrayL(inputData, X, Y) {
//    int arrayL[] = {x1};
//    this.calculateElementL(arrayL, X, Y, numberOfPeaks);
//
//    return arrayL;
//  }


//  void calculateElementL(int arrayL[], X, Y, numberOfPeaks) {
//    // Step 3
//    Iprime = this.calculateIprime(arrayL, Y);
//    // Step 4
//    I = this.calculateI(Iprime);
//    // Step 5
//    Lprime = this.calculateLprime(arrayL, Y);
//    // Step 6
//    L[k+1] = this.calculateLItem(Lprime);
//    arrayL.add(L);
//
//    // Step 7
//    if (this.k < numberOfPeaks) {
//      this.k++;
//      this.calculateElementL(arrayL, X, Y, numberOfPeaks);
//    }
//  }

}
