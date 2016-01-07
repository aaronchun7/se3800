package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import calculator.Calculation;
import calculator.Calculator;
import static org.testng.Assert.*;

public class testCalculator {

	
	/**
	 * Tests add() method.
	 * @author chuna
	 * @throws Exception 
	 */
	@Test
	public void testGetUserInput() throws Exception{
		Calculator.clear();
//		Calculator.getUserInput("add 1 2 3\n"
//				+ "sub 1 2 3\n"
//				+ "mult 1 2 3\n"
//				+ "div 10 5 2\n"
//				+ "wumbo\n"
//				+ "add 1 2 3\n"
//				+ "sub 1 2 3\n"
//				+ "mult 1 !2 3\n"
//				+ "div 10 5 2#\n"
//				+ "hist\n"
//				+ "clear\n"
//				+ "help\n"
//				+ "lsdjfl\n"
//				+ "quit");
		Scanner in = new Scanner("add 1 2 3\n"
				+ "sub 1 2 3\n"
				+ "mult 1 2 3\n"
				+ "div 10 5 2\n"
				+ "wumbo\n"
				+ "add 1 2 3\n"
				+ "sub 1 2 3\n"
				+ "mult 1 !2 3\n"
				+ "div 10 5 2#\n"
				+ "hist\n"
				+ "clear\n"
				+ "help\n"
				+ "lsdjfl\n"
				+ "quit");
		Calculator.setScanner(in);
		Calculator.getUserInput();
	}
	
	/**
	 * Tests add() method.
	 * @author chuna
	 */
	@SuppressWarnings("serial")
	@Test
	public void testAdd(){
		List <Integer> l = new ArrayList<Integer>(){{add(1);add(2);add(3);}};
		assert(Calculator.add(l) == 6);
		l = new ArrayList<Integer>(){{add(Integer.MAX_VALUE);add(1);}};
		assert(Calculator.add(l) == Integer.MAX_VALUE);
		l = new ArrayList<Integer>(){{add(Integer.MIN_VALUE);add(-1);}};
		assert(Calculator.add(l) == Integer.MIN_VALUE);
		l = new ArrayList<Integer>(){{add(4);add(-5);add(6);}};
		assert(Calculator.add(l) == 5);
	}

	/**
	 * Tests sub() method.
	 * @author kuczynskij
	 */
	@SuppressWarnings("serial")
	@Test
	public void testSub(){
		List <Integer> l = new ArrayList<Integer>(){{add(1);add(2);add(3);}};
		assert(Calculator.sub(l) == -4);
		l = new ArrayList<Integer>(){{add(Integer.MAX_VALUE);add(-1);}};
		assert(Calculator.sub(l) == Integer.MAX_VALUE);
		l = new ArrayList<Integer>(){{add(Integer.MIN_VALUE);add(1);}};
		assert(Calculator.sub(l) == Integer.MIN_VALUE);
		l = new ArrayList<Integer>(){{add(4);add(-5);add(6);}};
		assert(Calculator.sub(l) == 3);
	}

	/**
	 * Tests mult() method.
	 * @author chuna
	 */
	@SuppressWarnings("serial")
	@Test
	public void testMult(){
		List <Integer> l = new ArrayList<Integer>(){{add(4);add(2);add(3);}};
		assert(Calculator.mult(l) == 24);
		l = new ArrayList<Integer>(){{add(Integer.MIN_VALUE);add(2);}};
		assert(Calculator.mult(l) == Integer.MIN_VALUE);
		l = new ArrayList<Integer>(){{add(Integer.MAX_VALUE);add(2);}};
		assert(Calculator.mult(l) == Integer.MAX_VALUE);
 		l = new ArrayList<Integer>(){{add(4);add(-5);add(6);}};
		assert(Calculator.mult(l) == -120);
	}

	/**
	 * Tests div() method.
	 * @author kuczynskij
	 * @throws Exception 
	 */
	@SuppressWarnings("serial")
	@Test
	public void testDiv(){
		try{
			List <Integer> l = new ArrayList<Integer>(){{add(4);add(2);add(3);}};
			assert(Calculator.div(l) == 0);
			l = new ArrayList<Integer>(){{add(Integer.MIN_VALUE);add(1);}};
			assert(Calculator.div(l) == Integer.MIN_VALUE);
			l = new ArrayList<Integer>(){{add(Integer.MAX_VALUE);add(1);}};
			assert(Calculator.div(l) == Integer.MAX_VALUE);
	 		l = new ArrayList<Integer>(){{add(4);add(-5);add(6);}};
			assert(Calculator.div(l) == 0);
		}catch(Exception e){
			assert(false);
		}
	}

	/**
	 * Tests the div() for Exception (divide by zero).
	 * @author chuna
	 * @throws Exception
	 */
	@SuppressWarnings("serial")
	@Test(expectedExceptions = Exception.class)
	public void testZeroDivide() throws Exception{
		List <Integer> l = new ArrayList<Integer>(){{add(4);add(0);add(6);}};
		Calculator.div(l);
		assert(false);
	}
	
	/**
	 * Tests hist() method.
	 * @author chuna
	 */
	@SuppressWarnings("serial")
	@Test
	public void testHist(){
		Calculator.clear();
		String expectedAns = "There is no history to display.";
		assert(Calculator.hist().equals(expectedAns));
		List <Integer> l = new ArrayList<Integer>(){
			{add(10);add(5);add(2);}};
		Calculator.add(l);
		Calculator.sub(l);
		Calculator.mult(l);
		try {
			Calculator.div(l);
		} catch (Exception e) {
			assert(false);
		}
		expectedAns = "1 | div | 10 5 2 | 1\n"
				+ "2 | mult | 10 5 2 | 100\n"
				+ "3 | sub | 10 5 2 | 3\n"
				+ "4 | add | 10 5 2 | 17";
		assert(Calculator.hist().equals(expectedAns));
	}

	/**
	 * Tests clear() method.
	 * @author kuczynskij
	 */
	@SuppressWarnings("serial")
	@Test
	public void testClear(){
		List <Integer> l = new ArrayList<Integer>(){{add(4);add(2);add(3);}};
		Calculator.add(l);
		Calculator.sub(l);
		Calculator.add(l);
		assert(Calculator.getHistory().size() > 0);
		Calculator.clear();
		assert(Calculator.getHistory().size() == 0);
	}

	/**
	 * Tests reuse() method.
	 * @author chuna
	 */
	@SuppressWarnings("serial")
	@Test
	public void testReuse(){
		Calculator.clear();
		List <Integer> l = new ArrayList<Integer>(){
			{add(10);add(5);add(2);}};
		Calculator.add(l);
		Calculator.sub(l);
		Calculator.mult(l);
		try {
			Calculator.div(l);
		} catch (Exception e) {
			assert(false);
		}
		assert(Calculator.reuse(4, null) == 17); // add
		assert(Calculator.reuse(3, null) == 3); // sub
		assert(Calculator.reuse(2, null) == 100); // mult
		assert(Calculator.reuse(1, null) == 1); // div
		// Now for the no spot in history found
		Calculation calc = new Calculation("add");
		System.out.println("History size is " + Calculator.getHistory().size());
		assert(Calculator.reuse(5, calc) == 0); // add id = 0
		calc = new Calculation("sub");
		assert(Calculator.reuse(6, calc) == 0); // sub id = 0
		calc = new Calculation("mult");
		assert(Calculator.reuse(0, calc) == 1); // mult id = 1
		calc = new Calculation("div");
		assert(Calculator.reuse(-1, calc) == 1); // div id = 1
	}

	/**
	 * Tests wumbo() method.
	 * @author kuczynskij
	 */
	@Test
	public void testWumbo(){
		if(Calculator.getWumbo()){
			Calculator.wumbo();
			assert(Calculator.getWumbo() == false);
			Calculator.wumbo();
			assert(Calculator.getWumbo() == true);
		}else{
			Calculator.wumbo();
			assert(Calculator.getWumbo() == true);
			Calculator.wumbo();
			assert(Calculator.getWumbo() == false);
		}
	}
}
