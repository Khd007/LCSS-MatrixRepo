package com.string;
import java.util.*;
/**
 * Created by khalid on 5/24/16.
 */
public class Matrix {
    public static void main(String arg[]){
        Scanner obj= new Scanner(System.in);
        System.out.println("Enter size of matrix ");
        int size= obj.nextInt();
        int[][] matrix= new int[size][size];
        int num=1;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                matrix[i][j]=num ;
                num+=1;
            }
        }
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("\n");
        }
        int levl;
        int c = size/2;
        int x=c;
        int y=c;
        // starting fron middle to right
        for (levl = 1; c + levl <= size; levl++) {
            for (; y <= c + levl && y < size; y++) // go right
                System.out.print(matrix[x][y] +" ");


            // when we reach top right most element we are done
            if (x == 0 && y == size)
                break;
            // go down
            for (x++, y--; x <= c + levl && x < size; x++)
                System.out.print ( matrix[x][y] +" ");
            // go left
            for (x--, y--; y >= c - levl; y--)
                System.out.print(matrix[x][y] +" ");
            // go up
            for (x--, y++; x >= c - levl; x--)
                System.out.print(matrix[x][y] + " ");
            x++;
            y++;
        }


    }
}
