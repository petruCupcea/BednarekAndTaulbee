import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DFSandBFS extends Graph{


        // functia care returneaza masivul dupa parcurgerea in latimea a unui graf
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


        void printBFS() {
            ArrayList<Integer> result = this.bfsOfGraph(this.numberOfPeaks, this.adjArray);
                    System.out.println("Rezultatul parcurgerii in latime:");
                    System.out.println(result);
            }


}

