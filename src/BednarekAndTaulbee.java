public class BednarekAndTaulbee extends Matrix{

    int[] stableSets;
    int[] noAdjArray;
    int[] xJ;


//functia de creare a multimii Yk in dependenta de iteratia k
    void setNoAdjArray( int k) {
        int index;

        int temp = 0;
        this.initPeaksArray(k);

        for(int i = 0; i < this.adjArray.get(k).size(); i++) {
            for (int j = 0; j < this.peaksArray.length; j++) {
                if (this.adjArray.get(k).get(i) == this.peaksArray[j]) {
                    this.deleteArrayIndex(this.peaksArray, j);
                    temp++;
                }

            }
        }
//creez matricea Yk prin copierea din array-ul modificat Xk minus nr de elemente care au fost sterse
        this.noAdjArray = new int[this.peaksArray.length - temp];

        for (int i = 0; i < this.peaksArray.length - temp; i++){
            this.noAdjArray[i] = this.peaksArray[i];
        }

    }

//afisare
    void printNoAdjArray() {
        for (int i = 0; i < this.noAdjArray.length; i++) {
            System.out.print(" " + this.noAdjArray[i] + " ");
        }
        System.out.println();

    }


}


