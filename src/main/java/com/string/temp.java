package com.string;
import java.util.*;


/**
 * Created by khalid on 5/24/16.
 */
public class temp {
    public static void main(String arg[]) {
        Scanner obj= new Scanner(System.in);
        int size= obj.nextInt();
        int[][] matrix= new int[size][size];
        int num=1;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                matrix[i][j]=num ;
                num+=1;
            }
        }
        int levl;
        int c = size/2;
        int x=c;
        int y=c;

        // Printing inwards to outwards. Works only for odd sized 2D array with one element in center
        for (levl = 1; c + levl <= size; levl++) {
            for (; y <= c + levl && y < size; y++) // go right
                System.out.println(matrix[x][y] +" ");


            // Since we always start from the center going towards right, top row (going left to right)
            // will always be the last remaining row to print
            if (x == 0 && y == size) // we are done
                break;

            for (x++, y--; x <= c + levl && x < size; x++)  // go down
                System.out.print ( matrix[x][y] +" ");
            for (x--, y--; y >= c - levl; y--)    // go left
                System.out.print(matrix[x][y] +" ");
            for (x--, y++; x >= c - levl; x--)     // go up
                System.out.print(matrix[x][y] + " ");
            x++;
            y++;
        }
        System.out.println("\n");

    }
}