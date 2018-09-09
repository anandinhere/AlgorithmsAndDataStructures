package datastructsimpl;

import java.util.HashSet;


public class SExpression {

	

	// Complete the SExpression function below.

    static String SExpressionEval(String nodes) {

            

        boolean adj[][] = new boolean[26][26];

        HashSet<Character> set = new HashSet<>();

        

        boolean E2 = false;

        

        // the string is (B,D) (D,E) (A,B) (C,F) (E,G) (A,C) 

        

        for(int i = 1; i <= nodes.length(); i+=6){

            int u = nodes.charAt(i) - 'A';

            int v = nodes.charAt(i + 2) - 'A';

            if(adj[u][v])

                E2 = true;

            adj[u][v] = true;

            set.add(nodes.charAt(i));

            set.add(nodes.charAt(i + 2));

        }

        

        for(int i = 0; i < 26; i++){

            int noOfChildren = 0;

            for(int j = 0; j < 26; j++){

                if(adj[i][j])

                    noOfChildren++;

            }

            if(noOfChildren > 2)

                return "E1";

        }

        

        if(E2)

            return "E2";

        

        int noOfRoot = 0;

        

        char root = ' ';

        

        for(char ch : set){

            for(int i = 0; i < 26; i++){

                if(adj[i][ch - 'A'])

                    break;

                if(i == 25){

                    noOfRoot++;

                    root = ch;

                    boolean visited[] = new boolean[26];

                    if(Cycle(ch,adj,visited))

                        return "E3";

                }     

            }

        }

        

        if(noOfRoot == 0)

            return "E3";

        if(noOfRoot > 1)

            return "E4";

        if(root == ' ')

            return "E5";

        

        return generateSExpression(root,adj);

        


    }


    static boolean Cycle(char ch,boolean adj[][], boolean visited[]){

        if(visited[ch - 'A'])

            return true;

        visited[ch - 'A'] = true;

        

        //follow dfs 

        for(int i = 0;i < 26; i++){

            if(adj[ch - 'A'][i]){

                if(Cycle((char)(i+'A'),adj,visited))

                    return true;

            }

        }

        return false;

    }


    static String generateSExpression(char root, boolean adj[][]){

        

        // we call follow dfs to find the s expression

        String lc ="",rc = "";

        

        for(int i = 0;i < 26; i++){

            if(adj[root - 'A'][i]){

                lc = generateSExpression((char)(i+'A'),adj);

                for(int j = i+1; j < 26; j++){

                    if(adj[root - 'A'][j]){

                        rc = generateSExpression((char)(j+'A'),adj);

                        break;

                    }

                }

                break;

            }

        }

        return "(" +root+lc+rc+")";

    }


	public static void main(String[] args) {

		// TODO Auto-generated method stub

		

		String s= "(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)";

		System.out.println(SExpressionEval(s));


	}


}
