import java.util.ArrayList;

public class PeaksCoverage extends Graph {
        int biggestSize;
        int index;

//    gasesc varful cu cele mai multe muchii
    void findBiggestSize() {

        this.biggestSize = this.adjArray.get(0).size();

        for (int i = 0; i< this.adjArray.size(); i++) {
           if ( this.biggestSize < this.adjArray.get(i).size()) {
               this.biggestSize = this.adjArray.get(i).size();
               this.index = i;
            } else {
               this.index = -1;
           }
        }
    }

    void printPeaksCoverage(boolean verify) {
         if (verify) {
             System.out.println( " " + this.index + " ");
         }
    }

    void setMinusEdgesArray() {
        boolean verify = false;

        for (int i =0; i < this.numberOfEdges; i++) {
            for (int j = 0; j < 2; j++) {
                if ( this.edgesArray[i][j] == this.index) {
                    this.edgesArray[i][0] = -1;
                    this.edgesArray[i][1] = -1;
                    verify = true;
                }
            }
        }
        this.printPeaksCoverage(verify);
    }

    boolean setStopCondition() {
        boolean stopValue = true;

        for (int i =0; i < this.numberOfEdges; i++) {
            for (int j = 0; j < 2; j++) {
                if ( this.edgesArray[i][j] >= 0) {
                   stopValue = false;
                }
            }
        }

        return stopValue;
    }


    void setPeaksCoverage() {
        if (this.setStopCondition()) {
            System.out.println("stop");
        } else {
            this.findBiggestSize();
            System.out.println("=================>" + this.index);
            System.out.println("=================>" + this.adjArray.get(this.index));
            if (this.index != -1) {
                this.adjArray.remove(this.index);
            }
            this.setMinusEdgesArray();
            this.setPeaksCoverage();
        }
    }



}
