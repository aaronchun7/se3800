package test;

import org.testng.annotations.Test;

import calculator.Calculator;

import java.util.ArrayList;
import java.util.List;

public class testCalculator {

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
	 */
	@SuppressWarnings("serial")
	@Test
	public void testDiv(){
		List <Integer> l = new ArrayList<Integer>(){{add(4);add(2);add(3);}};
		assert(Calculator.div(l) == 0);
		l = new ArrayList<Integer>(){{add(Integer.MIN_VALUE);add(1);}};
		assert(Calculator.div(l) == Integer.MIN_VALUE);
		l = new ArrayList<Integer>(){{add(Integer.MAX_VALUE);add(1);}};
		assert(Calculator.div(l) == Integer.MAX_VALUE);
 		l = new ArrayList<Integer>(){{add(4);add(-5);add(6);}};
		assert(Calculator.div(l) == 0);
		l = new ArrayList<Integer>(){{add(4);add(-5);add(6);}};
		assert(Calculator.div(l) == 0);
	}

	/**
	 * Tests hist() method.
	 * @author chuna
	 */
	@Test
	public void testHist(){
		//TODO
	}

	/**
	 * Tests clear() method.
	 * @author kuczynskij
	 */
	@Test
	public void testClear(){
		@SuppressWarnings("serial")
		List <Integer> l = new ArrayList<Integer>(){{add(4);add(2);add(3);}};
		Calculator.add(l);
		Calculator.sub(l);
		Calculator.add(l);
		assert(Calculator.getHistory().size()-4 == 3);
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
		List <Integer> l = new ArrayList<Integer>(){{add(1);add(2);add(3);}};
		assert(Calculator.add(l) == 6);
		l = new ArrayList<Integer>(){{add(1);add(2);add(3);}};
		assert(Calculator.add(l) == 6);
	}

	/**
	 * Tests wumbo() method.
	 * @author kuczynskij
	 */
	@SuppressWarnings("serial")
	@Test
	public void testWumbo(){
		Calculator.wumbo();
		assert(Calculator.getWumbo() == true);
		Calculator.wumbo();
		assert(Calculator.getWumbo() == false);
	}
}
