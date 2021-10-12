public class Matrix extends Graph{

    int[][] adjacencyMatrix;
    int[][] kirchhoffMatrix;


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

        printMatrix(adjacencyMatrix,"Adjacency");
    }


//Matricea lui Khirchoff din adiacenta
    void setKirchhoffMatrix() {
      this.kirchhoffMatrix = new int[this.numberOfPeaks][this.numberOfPeaks];

      for(int i = 0; i < this.numberOfPeaks; i++) {
          for(int j = 0; j < this.numberOfPeaks; j++) {
              if( i == j ) {
                  this.kirchhoffMatrix[i][j] = this.adjArray.get(i).size();
              } else {
                  this.kirchhoffMatrix[i][j] = this.adjacencyMatrix[i][j] * -1;
              }
          }
      }

      this.printMatrix(kirchhoffMatrix,"Kirchhoff");
    }


//functia de afisare pentru matricea de adiacenta si Khirchoff
    void printMatrix(int[][] matrix,String name) {
        System.out.println(name);
        for(int i = 0; i < this.numberOfPeaks; i++) {
            for(int j = 0; j < this.numberOfPeaks; j++) {
                //if pentru afisarea corecta a matricelor
                if(  matrix[i][j] >=0 ){
                    System.out.print("  " + matrix[i][j]);
                } else {
                    System.out.print(" " + matrix[i][j]);
                }
            }
            System.out.println("");
        }
    }


}
