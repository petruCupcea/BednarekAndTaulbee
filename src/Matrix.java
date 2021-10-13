public class Matrix extends Graph{

    int[][] adjacencyMatrix;
    int[][] kirchhoffMatrix;
    int[][] incidentMatrix;



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
      this.kirchhoffMatrix = new int[this.adjacencyMatrix[0].length][this.adjacencyMatrix[0].length];
      int[] array = new int[this.adjacencyMatrix[0].length];

      for(int i = 0; i < this.adjacencyMatrix[0].length; i++) {
          int temp = 0;
          for (int j = 0; j < this.adjacencyMatrix[0].length; j++) {
              if (this.adjacencyMatrix[i][j] == 1) {
                  temp++;
                  array[i] = temp;
              }
          }
      }

      for(int i = 0; i < this.adjacencyMatrix[0].length; i++) {
          for(int j = 0; j < this.adjacencyMatrix[0].length; j++) {
              if( i == j) {
                  this.kirchhoffMatrix[i][j] = array[i];
              }  else {
                  this.kirchhoffMatrix[i][j] = this.adjacencyMatrix[i][j] * -1;
              }
          }
      }


      this.printMatrix(kirchhoffMatrix,"Kirchhoff");
    }


//    //Matricea lui Khirchoff din adiacenta
//    void setKirchhoffMatrix() {
//        this.kirchhoffMatrix = new int[this.numberOfPeaks][this.numberOfPeaks];
//
//        for(int i = 0; i < this.numberOfPeaks; i++) {
//            for(int j = 0; j < this.numberOfPeaks; j++) {
//                if( i == j ) {
//                    this.kirchhoffMatrix[i][j] = this.adjArray.get(i).size();
//                } else {
//                    this.kirchhoffMatrix[i][j] = this.adjacencyMatrix[i][j] * -1;
//                }
//            }
//        }
//
//        this.printMatrix(kirchhoffMatrix,"Kirchhoff");
//    }

//Matricea de incidenta
      void setIncidentMatrix() {
        int edges = 0;
        int[][] tempMatrix = new int[this.adjacencyMatrix.length][this.adjacencyMatrix[0].length];
//creez o matrice temporara pentru a fi modificata
        tempMatrix = adjacencyMatrix;

//pentru valorile mai sus de diagonala le inmultesc cu j pentru a obtine carui varf ii apartine
        for(int i = 0; i < this.adjacencyMatrix.length;i++) {
            for(int j = i + 1; j < this.adjacencyMatrix[i].length; j++) {
                tempMatrix[i][j] = tempMatrix[i][j] * j;
            }
        }


//        aflu numarul de muchii din matricea de adiacenta
        for (int i = 0; i < tempMatrix.length; i++) {
            for (int j = i + 1; j < tempMatrix[i].length; j++) {
                if( tempMatrix[i][j] > 0) {
                    edges++;
                }
            }
        }

//        initializam matricea de incidenta incat deja avem numarul de muchii si o construim
        this.incidentMatrix = new int[this.adjacencyMatrix.length][edges];

          for (int i = 0; i < tempMatrix.length; i++) {
              for (int j = i + 1; j < tempMatrix[i].length; j++) {
                  int edgeNumber = tempMatrix[i][j];

                  if(edgeNumber  > 0 ) {
                      this.incidentMatrix[i][edgeNumber - 1] = 1;
                      this.incidentMatrix[j][edgeNumber - 1] = 1;
                  }
              }
          }
        printIncidentMatrix();
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

//    functia de afisare a matricii de incidenta
    void printIncidentMatrix() {
        System.out.println("Incident");
        for(int i = 0; i < this.incidentMatrix.length; i++) {
          for(int j = 0; j < this.incidentMatrix[i].length; j++) {
              System.out.print("  " + this.incidentMatrix[i][j]);
          }
          System.out.println("");
        }
    }


}
