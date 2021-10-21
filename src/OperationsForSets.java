import java.util.ArrayList;

public class OperationsForSets {


  ArrayList<Integer> intersectionOfSets(ArrayList<ArrayList<Integer>> firstSet, ArrayList<Integer> secondSet) {
    ArrayList<Integer> result = new ArrayList<Integer>();

    for (int i = 0; i < firstSet.size(); i++) {
      for (int j = 0; j < secondSet.size(); j++) {
        if (firstSet.get(i).get(j) == secondSet.get(j)) {
          result.add(firstSet.get(i).get(j));
        }
      }
    }

    return result;
  }

  ArrayList<ArrayList<Integer>> includeInBiggerSet(ArrayList<ArrayList<Integer>> set) {

    ArrayList<ArrayList<Integer>> includeSet = new ArrayList<ArrayList<Integer>>();

    if (set.size() <= 1) {
      return set;
    }

    int setToInclude = -1;
    for (int i = 0; i < set.size(); i++) {
      for (int j = i + 1; j < set.size(); j++) {
        if (this.compareRows(set.get(i), set.get(j))) {
          setToInclude = -1;
          break;
        } else {
          setToInclude = i;
        }
      }
      if (setToInclude > -1) {
        includeSet.add(set.get(setToInclude));
      }
    }
    includeSet.add(set.get(set.size() - 1));

    return includeSet;
  }

  boolean compareRows(ArrayList<Integer> row1, ArrayList<Integer> row2) {
    boolean include = false;
    int k = 0;


    for (int j = 0; j < row2.size(); j++) {
      if (k < row1.size() && row1.get(k) == row2.get(j)) {
        k++;
      }

      if (k == row1.size()) {
        include = true;
      }
    }
    return include;
  }

//  boolean compareRows(ArrayList<Integer> row1, ArrayList<Integer> row2) {
//    boolean valueExists = false;
//
//
//    for (int i = 0; i < row1.size(); i++) {
//      for (int j = 0; j < row2.size(); j++) {
//        if (row1.get(i) == row2.get(j)) {
//          valueExists = true;
//
//          break;
//        } else {
//          valueExists = false;
//        }
//      }
//
//      if (valueExists == false) {
//        break;
//      }
//    }
//
//    return valueExists;
//  }

}