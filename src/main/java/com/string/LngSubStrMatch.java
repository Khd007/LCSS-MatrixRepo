package com.string;
import java.util.*;
import java.lang.String;
/**
 * @author khalid Hamid
 * @since 21/6/2016
 * @version 1.0
*/
public class LngSubStrMatch {
	public static void main(String st[]){
		/**
		 *This is main method, it takes no argument:
         * Input two string gives there Longest common Sub-String and outputs two strings
         * in specific way, like ex:
         * String1= computer
         * String2= inputout
         * gives LCSS = put and
         * output: newString1=  ##computer###
         *         newString2=  in###put##out
		 */
		  Scanner obj= new Scanner(System.in);
		  
		  //Asking user to input two strings.
		  System.out.println("Enter first String");
		  String str1= obj.nextLine();
		  System.out.println("Enter Second String");
		  String str2=obj.nextLine();
		  
		  //Declaring new two Strings for storing results.
		  String newStr1 = "";
		  String newStr2 = "";
		  
		  //Getting lengths of two input Strings.
		  int row = str1.length();
		  int col = str2.length();
		  
		  //Declaring an integer 2D-Array for counting the occurance of common sub-strings.
		  int[][] checker = new int[row+1][col+1];
		  
		  //Declaring max to store longest Common Substring.
		  int max = 0;
		  int r = 0;
		  int c = 0;
		  //This for loop makes the entry in integer array "checker".Entering '0' at checker[i,j] if no match is found and entering '1'
		  //if match is found.
		  for(int i = 1; i <= row; i++){
		        for(int j = 1; j <= col; j++){
		            if(str1.charAt(i-1) == str2.charAt(j-1)){
		                //Incrementing count for sub-strings
		            	checker[i][j] = checker[i-1][j-1] +1;
		                if(checker[i][j] > max){
		                	//updating Longest Sub-String if it is longer then previous one.
		                    max = checker[i][j];
		                    r = i;
		                    c = j;
		                }
		            }
		        }
		    }
		  //using string builder object to build Longest common sub-string.  
		  StringBuilder sb = new StringBuilder();
		  	  while(true){
		          if(checker[r][c] == 0){
		          //breaking out of this block if Checker[r,c] is '0'
		           break;
		          }
		       // Appending each character in reverse order.
		       sb.append(str1.charAt(r-1));
		       r--;
		       c--;
		      }
		  	//Outputting the Longest common sub-string by using string builder reverse method.  
		    System.out.println( "Largest common Sub-String is : "+ sb.reverse().toString());
		   
		    //Converting String builder object to String object.
		    String tem= sb.toString();
			//Getting length of LCSS. 
		    int len = tem.length();
			//Getting index of LCSS in string 1.  
		    int num1= str1.indexOf(tem);
			 //Getting index of LCSS in string 2.
		     int num2= str2.indexOf(tem);
			
			//putting hash values for non matching chars on left of string2.
			for(int k=0;k<num2;k++)
			    newStr1=newStr1+"#";
			//copying sub-string from index 0 to index LCSS in string1.
			newStr1=newStr1 + str1.substring(0,num1);
	        newStr1=newStr1+tem;
			newStr1=newStr1+str1.substring(num1+len,row);
			
			//putting hash values for each non matching char on right of string1.
			for(int i=num2+len;i<col;i++)
				newStr1=newStr1+"#";
			//copying sub-string from index 0 to index of LCSS in string2.
			newStr2=newStr2+ str2.substring(0,num2);
			//putting hash values for each non-matching chars on left of sting 2 upto index of LCSS in String1. 
			for(int j=0;j<num1;j++)
				newStr2=newStr2+"#";
			//copying LCSS in string2
			newStr2=newStr2+tem;
			//putting hash values for each non-matching chars on right depending on length of string1.
			for(int i=num1+len;i<row;i++)
				newStr2=newStr2+"#";
			//copying rest of non-matching chars on right.
			newStr2=newStr2+str2.substring(num2+len,col);
		//finally outputting the resultant Strings.
		System.out.println( "New String 1: "+newStr1);
		System.out.println("New String 2: "+newStr2);
   }
}