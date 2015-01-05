/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Keyean
 */
public class Driver {
    
     private BufferedWriter output;
     private ArrayList<Integer> startState = new ArrayList<Integer>();
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Driver problem = new Driver();
    }
    
    public Driver()
    {
         System.out.println("The purpose of this program is to solve "
                + "the eight puzzle problem using informed and uniformed searches.");
        Begin();
    }
    
    /**
     * Prints a welcome message and ask for a text file name in order to begin the search.
     */
    public void Begin()
    {
       Scanner keyboard = new Scanner(System.in);
       System.out.print("Please enter a text file:");
      // String file = keyboard.next();
      try{
          FileReader inputFile = new FileReader("test9.txt");
          BufferedReader bufferReader = new BufferedReader(inputFile);
          Scanner game = new Scanner(bufferReader);
          // Stores the number from bufferReader into 2D array.
          while(game.hasNextInt())
          {
        	  	startState.add(game.nextInt());
          }
       }
      catch(FileNotFoundException ex){
            System.out.println ("Unable to find the text file, please try again.");
            Begin();
        }
      
      State start = new State();
      start.loadState(startState);
      start.addPath(start);
      System.out.println();
      
      System.out.println("Please enter a search Type: BFS "); //Ask for the type of searches.
      System.out.println("Initial State:");
      System.out.println(start.toString());
      //file = keyboard.next();
      Searches(start);
    }
    
    /**
     * Searches
     */
    public void Searches(State start)
    {
    	BFS bfs = new BFS(start);
    }
}
