import java.util.ArrayList;

public class PeaksCoverage extends Graph {

  //    gasesc varful cu cele mai multe muchii
  int findBiggestSizeIndex() {
    int biggestSize = 0;
    int index = -1;

    for (int i = 0; i < this.adjArray.size(); i++) {
      if (biggestSize < this.adjArray.get(i).size() && this.adjArray.get(i).get(0) != -1) {
        biggestSize = this.adjArray.get(i).size();
        index = i;
      }
    }

    return index;
  }


  void deleteEdges(int index) {
    if (index == -1) {
      return;
    }
    boolean verify = false;

    for (int i = 0; i < this.numberOfEdges; i++) {
      for (int j = 0; j < 2; j++) {
        if (this.edgesArray[i][j] == index) {
          this.edgesArray[i][0] = -1;
          this.edgesArray[i][1] = -1;
          verify = true;
        }
      }
    }
    if (verify) {
      System.out.println(" " + index + " ");
    }
  }

  boolean setStopCondition() {
    boolean stopValue = true;

    for (int i = 0; i < this.numberOfEdges; i++) {
      for (int j = 0; j < 2; j++) {
        if (this.edgesArray[i][j] >= 0) {
          stopValue = false;
        }
      }
    }

    return stopValue;
  }

  void setMinusListRow(ArrayList<ArrayList<Integer>> arrayList, int k) {
    for (int i = 0; i < arrayList.get(k).size(); i++) {
      arrayList.get(k).set(i, -1);
    }
  }


  void setPeaksCoverage() {
    if (this.setStopCondition()) {
      System.out.println("stop");
    } else {
      int index = this.findBiggestSizeIndex();
      this.setMinusListRow(this.adjArray, index);
      this.deleteEdges(index);
      this.setPeaksCoverage();
    }
  }


}
