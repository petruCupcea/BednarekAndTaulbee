import java.util.ArrayList;

public class OperationsForSets {


  ArrayList<Integer> intersectionOfSets(ArrayList<Integer> firstSet, ArrayList<Integer> secondSet) {
    ArrayList<Integer> result = new ArrayList<Integer>();

    for (int i = 0; i < firstSet.size(); i++) {
      for (int j = 0; j < secondSet.size(); j++) {
        if (firstSet.get(i) == secondSet.get(j)) {
          result.add(firstSet.get(i));
        }
      }
    }

    return result;
  }

  ArrayList<ArrayList<Integer>> includeInBiggerSet(ArrayList<ArrayList<Integer>> set) {

    ArrayList<ArrayList<Integer>> includeSet = new ArrayList<ArrayList<Integer>>();

    set = deleteEmptyRow(set);
    set = sortBySize(set);

    if (set.size() <= 1) {
      return set;
    }

    int setToInclude = -1;
    for (int i = 0; i < set.size() - 1; i++) {
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

  ArrayList<ArrayList<Integer>> sortBySize(ArrayList<ArrayList<Integer>> set) {
      ArrayList<Integer> tempSet = new ArrayList<Integer>();

      for(int i = 0; i < set.size()-1; i++) {
        for(int j = i+1; j < set.size(); j++) {
          if (set.get(i).size() > set.get(j).size()){
            tempSet = set.get(i);
            set.set( i, set.get(j));
            set.set(j, tempSet);
          }
        }
      }
      return set;
  }

  ArrayList<ArrayList<Integer>> deleteEmptyRow(ArrayList<ArrayList<Integer>> set) {
     for(int i = 0; i < set.size(); i++) {
       if(set.get(i).isEmpty()) {
         set.remove(i);
       }
     }

     return set;
  }

}