public class Matrix extends Graph{




//functia de transformare in matricea de adiacenta a listei de array-uri adjArray
    void setAdjacencyMatrix() {
        this.initPeaksArray(this.numberOfPeaks);
        int temp = 0;

        this.adjacencyMatrix = new int[this.numberOfPeaks][this.numberOfPeaks];

        for(int i = 0; i < this.numberOfPeaks; i++) {
            temp = 0;
            for(int j = 0; j < this.numberOfPeaks; j++) {
                if(temp < this.adjArray.get(i).size() && this.adjArray.get(i).get(temp) == this.peaksArray[j]) {
                    this.adjacencyMatrix[i][j] = 1;
                    temp++;
                } else {
                    this.adjacencyMatrix[i][j] = 0;
                }
            }
        }

        printMatrix(adjacencyMatrix);
    }

//functia de afisare pentru matricea de adiacenta si incidenta
    void printMatrix(int[][] matrix) {
        for(int i = 0; i < this.numberOfPeaks; i++) {
            for(int j = 0; j < this.numberOfPeaks; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println("");
        }
    }


}
