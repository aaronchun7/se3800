package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is a simple terminal calculator application.
 * @maxcharacterline 70
 * @author Jimmy Kuczynski - kuczynskij
 * @author Aaron Chun - chunaa
 */
public class Calculator {
	
	//Scanner object to get user input.
	private static Scanner in;
	
	private static ArrayList<Calculation> history 
		= new ArrayList<>();
	
	private static Calculation calc;
	
	/**
	 * Runs the program.
	 * @param args
	 */
	public static void main(String [] args){
		help();
	}
	
	/**
	 * Displays a welcome text and the commands available. 
	 */
	private static void help(){
		System.out.println("Welcome to Team Wolfpack's fantastic "
				+ "terminal calculator!");
		System.out.println("Supported commands: add, sub, mult, div,"
				+ " hist, clear, reuse, wombo");
		in = new Scanner(System.in);
		getUserInput();
	}
	
	/**
	 * Gets user input.
	 * @author kuczynskij
	 */
	private static void getUserInput(){
		System.out.print("Enter command: ");
		String cmd = in.next();
		switch(cmd){
			case "add":
				add();
				break;
			case "sub":
				sub();
				break;
			case "mult":
				mult();
				break;
			case "div":
				div();
				break;
			case "hist":
				hist();
				break;
			case "clear":
				clear();
				break;
			case "reuse":
				//TODO
				break;
			case "wombo":
				//TODO
			break;
			case "help":
				help();
				break;
			case "quit":
				System.out.println("Thanks for using me I guess...");
				System.exit(0);
				break;
			default:
				 //Clear the buffer of any extra things input 
				 //after the incorrect command.
				in.nextLine();
				System.out.println("Woops, looks like you inputed an"
						+ " invalid command.");
				getUserInput();
				break;
		}	
	}
	
	/**
	 * Validates user input to ensure that a list of integers has
	 * been passed in. Then returns them as a List of Integers.
	 * @author kuczynskij & chuna
	 * @return l -> List of user inputed integers
	 */
	private static List<Integer> getIntegers(){
		List<Integer> l = new ArrayList<Integer>();		
		String intStr = in.nextLine().trim();
		System.out.println("This is the number input provided: " 
			+ intStr);
        String intStrArr [] = intStr.split(" ");
        try{
        	for (int i = 0; i < intStrArr.length; i++) {
//	            System.out.println("Item #" + i + " is " +
//	                    intStrArr[i]); TODO for debugging delete
	            int temp = Integer.parseInt(intStrArr[i]);
	            l.add(temp);
            }
        }catch(NumberFormatException nfe){
            System.out.println("There was an error in the numbers " 
            	+ "provided. Command did not finish executing.");
            getUserInput();
        }
		return l;
	}
	
	/**
	 * User Story #1
	 * Adds the a list of positive Integers.
	 * @author kuczynskij
	 * @param l - list of integers
	 * @return non-negative sum
	 */
	public static void add(){
		List<Integer> list = getIntegers();
		if (list != null){
			calc = new Calculation("add");
			calc.setInput(list);
			int sum = 0;
			for(Integer i : list){
				sum += i;
			}
			System.out.println("The sum is: " + sum);
			calc.setAns(sum);
		}
		history.add(calc);
		getUserInput();
	}
	
	/**
	 * User Story #2
	 * Subtracts the list of integers
	 * @author chuna
	 */
	public static void sub(){
		List<Integer> list = getIntegers();
		if(list != null){
			calc = new Calculation("sub");
			list = getIntegers();
			calc.setInput(list);
			int dif = list.get(0);
			for(int i = 1; i < list.size(); i++){
				dif -= list.get(i);
			}
			System.out.println("The difference is: " + dif);
			calc.setAns(dif);
		}
		history.add(calc);
		getUserInput();
	}
	
	/**
	 * User Story #3
	 * Multiples the a list of positive Integers.
	 * @author kuczynskij
	 * @param l - list of integers
	 * @return
	 */
	public static void mult(){
		List<Integer> list = getIntegers();
		if (list != null){
			calc = new Calculation("mult");
			calc.setInput(list);
			int product = 1;
			for(Integer i : list){
				product *= i;
			}
			System.out.println("The product is: " + product);
			calc.setAns(product);
		}
		history.add(calc);
		getUserInput();
	}
	
	/**
	 * User Story #4
	 * Divides the list of integers and uses integer division.
	 * Has a check for zero division
	 * @author chuna
	 */
	public static void div(){
		List<Integer> list = getIntegers();
		boolean divZero = false;
		if(list != null){
			calc = new Calculation("div");
			list = getIntegers();
			calc.setInput(list);
			int quot = list.get(0);
			for(int i = 1; i < list.size(); i++){
				if(list.get(i) != 0){
					quot /= list.get(i);
				}else{
					divZero = true;
					break;
				}
			}
			if(divZero){
				System.out.println("Error: Cannot divide by zero.");
				getUserInput();
			}
			System.out.println("The quotient is: " + quot);
			calc.setAns(quot);
		}
		history.add(calc);
		getUserInput();
	}
	
	/**
	 * User Story #5
	 * Prints out the previous computation history the user as input.
	 * @author kuczynskij
	 */
	public static void hist(){
		int h = history.size();
		if(h > 0){
			System.out.println("Printing out calculation history.");
			for(int i = 0; i <= h ;++i){
				System.out.println(history.get(h-i));
			}
		}else{
			System.out.println("There is no history to display.");
		}
	}
	
	/**
	 * User Story #6
	 * Clears the history list by assigning the history attribute to
	 * a new ArrayList.
	 * @author chuna
	 */
	public static void clear(){
		try{
			history = new ArrayList<Calculation>();
			System.out.println("The Calculation history has been"
					+ " cleared.");
		}catch(Exception e){
			System.out.println("Error: History may not have been "
					+ "cleared.");
		}
	}
	
	/**
	 * User Story #7
	 * Allows the user to use previous results in current 
	 * calculations.
	 * Ex: 5 + 3 = 8; -> 2 + result = 10
	 * @author kuczynskij
	 */
	public int reuse(){
		if (history.size() > 0){
			return history.get(history.size()).getAns();
		}else{
			//apply identity property
			//apply 0 to sub or add
			//apply 1 to mult or div
			String cmd = history.get(history.size()).getCmd();
			switch(cmd){
				case "add":
					return 0;
				case "sub":
					return 0;
				case "mult":
					return 1;
				case "div":
					return 1;
				default:
					return 0;
			}
		}
	}
	
	/**
	 * User Story #8
	 * @author chuna
	 */
	public void wombo(){
		//TODO
	}
}
