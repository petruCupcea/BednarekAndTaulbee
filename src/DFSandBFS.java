import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class DFSandBFS extends Matrix{
         LinkedList<Integer> adj[];
         int allEdges;

//initializez lista pentru DFS
    void initList(int peaks) {

          this.adj = new LinkedList[peaks];
          for (int i = 0; i < peaks; i++) {
              this.adj[i] = new LinkedList();
          }
        }

    void addEdgeDFS(int v, int w)
    {
        this.adj[v].add(w); // Add w to v's list.
    }

    void setAllEdges() {
        this.allEdges = 0;
        for(int i = 0; i < this.numberOfPeaks; i++) {
            for (int j = 0; j < this.numberOfPeaks; j++) {
                if (i == j) {
                    this.allEdges += this.kirchhoffMatrix[i][j];
                }
            }
        }
    }


//      functia care returneaza masivul dupa parcurgerea in latimea a unui graf
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            boolean visited[] = new boolean[V];
            Queue<Integer> q = new LinkedList<Integer>();
            // cream result pentru a pastra rezultatul
            ArrayList<Integer> result = new ArrayList<Integer>();
            //Nodul de start va fi tot timpul 0 deci visited[0] = true;
            visited[0] = true;
            q.add(0);
            while(q.size() != 0){
                int s = q.poll();
                result.add(s);
                for(int i = 0; i < adj.get(s).size(); i++){
                    int num = adj.get(s).get(i);
                    if(!visited[num]){
                        visited[num] = true;
                        q.add(num);
                    }
                }
            }
            return result;
        }

//      functia de afisare a bfs
        void printBFS() {
            ArrayList<Integer> result = this.bfsOfGraph(this.numberOfPeaks, this.adjArray);
                    System.out.println("Rezultatul parcurgerii in latime:");
                    System.out.println(result);
            }


    void DFSUtil(int v, boolean visited[])
    {
        // seteaza varful curent cu visited adica true
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = this.adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

//    functia de aflare si afisare a parcurgerii grafului in adancime
    void DFS()
    {
        this.readPeaksForDFS();
        System.out.println("Dati varful de la care sa inceapa citirea in adancime: ");
        int peak = scan.nextInt();
        //
        //
        boolean visited[] = new boolean[this.numberOfPeaks];

        // Apel al utilitatea recursiva de afisare si de setare a varfului peak ca visited
        this.DFSUtil(peak, visited);
    }

        void readPeaksForDFS() {

            System.out.println("Dati numarul de varfuri");


            this.readPeaksAdj();
            this.setAdjacencyMatrix();
            this.setKirchhoffMatrix();

            this.initList(this.numberOfPeaks);
            this.setAllEdges();
            System.out.println("Dati toate varfurile si adiacenta lor 0 1 1 0 1 2 2 1 etc");


              for(int i = 0; i < this.allEdges; i++) {
                  System.out.println("Dati muchia: x, y");
                  int x = scan.nextInt();
                  int y = scan.nextInt();
                  this.addEdgeDFS(x,y);
              }
        }
}

