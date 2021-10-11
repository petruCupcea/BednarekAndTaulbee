

public class BednarekAndTaulbee extends Graph{
    int[] peaksArray;
    int[] stableSets;
    int[] noAdjArray;


    //crearea Xk care e un array de toate varfurile
    void initPeaksArray(int k) {
        this.peaksArray = new int[this.numberOfPeaks];

        for(int i = 0; i < k+1; i++) {
           this.peaksArray[i] = i;
        }
    }

    void setNoAdjArray( int k) {
        int index;
        this.noAdjArray = new int[this.adjArray.get(k).size()];

        this.initPeaksArray(k);

        for(int i = 0; i < this.adjArray.get(k).size(); i++) {
            for (int j = 0; j < this.peaksArray.length; j++) {
                if (this.adjArray.get(k).get(i) == this.peaksArray[j]) {
                    this.deleteArrayIndex(this.peaksArray, j);
                }
            }
        }
        this.noAdjArray = this.peaksArray;
    }


    void printNoAdjArray() {

        for (int i = 0; i < this.noAdjArray.length; i++) {
            System.out.println(this.noAdjArray[i]);
        }
    }



}


