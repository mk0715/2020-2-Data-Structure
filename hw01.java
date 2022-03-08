import java.util.*;

// offset

/**
 * Maze Class
 * 
 */

class Maze {

   private int[][] maze;   // 2 dim array for maze
   private int[][] mark;   // 2 dim array for visit marking
   public int [][] stack; 
   public static int [][] move = { {1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1} };    

   public Maze(int m, int p) {
      maze = new int[m + 2][p + 2];
      mark = new int[m + 2][p + 2];
      for(int i = 0; i < m + 2; i++)
         for(int j = 0; j < p + 2; j++) {
            maze[i][j] = 1;
            mark[i][j] = 0;
         }
      stack = new int[(m+2)*(p+2)][3]; 
      }

   // create the maze structure
   public void SetWall(int i, int j, int val) {
      maze[i][j] = val;
   }


   public void Path(int m, int p) {
      mark[1][1] = 1; 
      stack[0][0] = 1; 
      stack[0][1] = 1; 
      stack[0][2] = 0; 

      int top = 0 ,i, j, mov,g,h;

      while(top >= 0){
         i = stack[top][0];
         j = stack[top][1];
         mov = stack[top][2];
         top--;
         
         while(mov < 8) {
            g = i + move[mov][0]; 
            h = j + move[mov][1]; 
            if (g == m && h == p) {
               for (int n=0; n<=top; n++){
                  System.out.print("("+stack[n][0] + ",");
                  System.out.println(stack[n][1]+")");
            }
            System.out.println("(" + i + "," + j + ")");
            System.out.println("(" + m + "," + p + ")");
            return;
            }

            if (maze[g][h] == 0 && mark[g][h] == 0) {
               mark[g][h] = 1; 
               top++;
               stack[top][0] = i;
               stack[top][1] = j;
               stack[top][2] = mov;
               mov = -1; 
               i = g;
               j = h;
            }
            mov++;
         } 
      } 
      System.out.println("No path in the maze.");
   } 


}; 
