public class Matrix extends Graph{

    int[][] adjacencyMatrix;
    int[][] kirchhoffMatrix;
    int[][] incidentMatrix;



//functia de transformare in matricea de adiacenta a listei de array-uri adjArray
    void setAdjacencyMatrix() {
        this.initPeaksArray(this.numberOfPeaks);
        int temp;

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
    void kirchhoffMatrixFromAdjacency() {
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


      this.printMatrix(kirchhoffMatrix,"Kirchhoff1");
    }


    //Matricea lui Khirchoff
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

        this.printMatrix(kirchhoffMatrix,"Kirchhoff2");
    }

//Matricea de incidenta
      void setIncidentMatrix() {
        this.incidentMatrix = new int[this.numberOfPeaks][this.numberOfEdges];

        for(int i = 0;i < this.numberOfPeaks; i++) {
            for(int j = 0; j < this.numberOfEdges; j++) {
                if(this.edgesArray[j][0] == i) {
                   this.incidentMatrix[i][j] = 1;
                } else if (this.edgesArray[j][1] == i){
                    this.incidentMatrix[i][j] = 1;
                } else {
                    this.incidentMatrix[i][j] = 0;
                }
            }
        }

        this.printIncidentMatrix();
      }

      void incidentMatrixfromAdjacency() {
        int k = 0;


        for (int i = 0; i < this.numberOfPeaks; i++) {
            for (int j = i; j < this.numberOfPeaks;j++) {
                if (this.adjacencyMatrix[i][j] == 1) {
                    this.incidentMatrix[i][k] = 1;
                    this.incidentMatrix[j][k] = 1;
                    k++;
                }
            }
        }
        this.printIncidentMatrix();
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
