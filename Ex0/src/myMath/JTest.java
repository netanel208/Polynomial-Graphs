package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author 
 *
 */
class JTest {

	public static Monom m = new Monom("-12x^2");
	@Test
	public void testAddToZeroPolynom() {
		
	}
	
	@Test
	public void testMonomStringConstructor1() {
	    Monom m1 = new Monom("2");
	    Monom m2 = new Monom("2");
	    boolean b = m1.equals(m2);
	    assertEquals(true, b);
	}
	@Test
	public void testMonomStringConstructor2() {
		Monom m1 = new Monom("2");
	    Monom m2 = new Monom(2,0);
	    boolean b = m1.equals(m2);
	    assertEquals(true, b);
	}
	@Test
	public void testMonomStringConstructor3() {
		Monom m1 = new Monom("2x");
	    Monom m2 = new Monom(2,1);
	    boolean b = m1.equals(m2);
	    assertEquals(true, b);
	}
	@Test
	public void testMonomStringConstructor4() {
		Monom m1 = new Monom("-2.9087x");
	    Monom m2 = new Monom(-2.9087,1);
	    boolean b = m1.equals(m2);
	    assertEquals(true, b);
	}
	@Test
	public void testMonomStringConstructor5() {
		Monom m1 = new Monom("x^3");
	    Monom m2 = new Monom(-2.9087,1);
	    boolean b = m1.equals(m2);
	    assertEquals(false, b);
	}
	@Test
	public void testMonomStringConstructor6() {
		Monom m1 = new Monom("-x^3");
	    Monom m2 = new Monom(-1,3);
	    boolean b = m1.equals(m2);
	    assertEquals(true, b);
	}
	@Test
	public void testMonomCopyConstructor1()
	{
		Monom m1 = new Monom("-3x");
		Monom m2 = new Monom(m1);
		boolean b = m1.equals(m2);
		assertEquals(true,b);
	}
	@Test
	public void testMonomfx1()
	{
		double actual = m.f(2);
		double expected = -12*Math.pow(2, 2);
		assertEquals(expected, actual);
	}
	@Test
	public void testMonomfx2()
	{
		double actual = m.f(0);
		double expected = -12*Math.pow(0, 2);
		assertEquals(expected, actual);
	}
	@Test
	public void testMonomAdd1()
	{
		Monom m1 = new Monom("-3.99x^2");
		m1.add(m);
		Monom m2 = new Monom("-15.99x^2");
		boolean result = m2.equals(m1);
		assertTrue(result);
	}
	@Test
	public void testMonomSubstract1()
	{
		Monom m1 = new Monom("-3.99x^2");
		m1.substract(m);
		Monom m2 = new Monom("8.01x^2");
		boolean result = m2.equals(m1);
		assertTrue(result);
	}
	@Test
	public void testMonomMultiply()
	{
		Monom m1 = new Monom("-3.0x");
		m1.multiply(m);
		Monom m2 = new Monom("36x^3");
		boolean result = m2.equals(m1);
		assertTrue(result);
	}
	@Test
	public void testMonomMultiplyWithZero()
	{
		Monom m1 = new Monom("0");
		m1.multiply(m);
		Monom m2 = new Monom("0");
		boolean result = m2.equals(m1);
		assertTrue(result);
	}
	@Test
	public void testMonomDerivative()
	{
		Monom m1 = new Monom("3x^5");
		m1.derivative();
		Monom m2 = new Monom("15x^4");
		boolean result = m2.equals(m1);
		assertTrue(result);
	}
	@Test
	public void testMonomEquals()
	{
		Monom m1 = new Monom("-11x");
		Monom m2 = new Monom(-11,1);
		boolean ans = m1.equals(m2);
		assertTrue(ans);
	}
	@Test
	public void testMonomEqualsZero()
	{
		Monom m1 = new Monom("0");
		Monom m2 = new Monom(0,0);
		boolean ans = m1.equals(m2);
		assertTrue(ans);
	}
	@Test
	public void testPolynomStringConstructor1()
	{
		Polynom_able p1 = new Polynom("x");
		Polynom_able p2 = new Polynom("1x");
		boolean ans = p2.equals(p1);
		assertTrue(ans);
	}
	@Test
	public void testPolynomStringConstructor2()
	{
		Polynom_able p1 = new Polynom("x");
		Polynom_able p2 = new Polynom("0");
		p2.add(new Monom("1x"));
		boolean ans = p2.equals(p1);
		assertTrue(ans);
	}
	@Test
	public void testPolynomStringConstructo3()
	{
		Polynom_able p1 = new Polynom("x^2+4x-4");
		Polynom_able p2 = new Polynom("-2");
		p2.add(new Monom("-2"));
		p2.add(new Monom("x^2"));
		p2.add(new Monom("4x^1"));
		boolean ans = p2.equals(p1);
		assertTrue(ans);
	}
	@Test
	public void testPolynomStringConstructo4()
	{
		Polynom_able p1 = new Polynom("x^2+4x-4");
		Polynom_able p2 = new Polynom("2");
		p2.add(new Monom("2"));
		p2.add(new Monom("-x^2"));
		p2.add(new Monom("-4x"));
		p2.add(p1);
		boolean ans = p2.equals(new Polynom("0"));
		assertTrue(ans);
	}
	@Test
	public void testPolynomArea1()
	{
		Polynom_able p1 = new Polynom("-1x^3+2x^2+-0x^0");
		double ans = p1.area(-1, 2, 0.001);
		int intAns = (int)ans;
		assertEquals(2, intAns);  //area close to 2
	}
	@Test
	public void testPolynomArea2()
	{
		Polynom_able p2 = new Polynom("1x^3+-8.2x^2+-0.009x^1");
		double ans = p2.area(-10, 5, 0.01);
		int intAns = (int)ans;
		assertEquals(0, intAns);  //area close to 0
	}
	@Test
	public void testPolynomToString()
	{
		Polynom_able p1 = new Polynom("1x^3+-8.2x^2+-0.009x^1");
		String str = "-0.009x^1+-8.2x^2+1.0x^3";
		boolean b = str.equals(p1.toString());
				assertTrue(b);
	}
	/**
	 * This test checks the Derivative function 
	 * By calculates the derivative of polynom and check if the result 
	 * is the same as what we expected to receive
	 */
	@Test
	void testDerivativePolynom() {
		Polynom_able p1 = new Polynom("x-1+x^3");
		Polynom_able derivative=p1.derivative();
		Polynom expected = new Polynom("3x^2+1");
		boolean ans =derivative.equals(expected);
		assertTrue(ans);
	}

	/**
	 * This test checks the Multiply function 
	 * By calculates the multiply of two polynom and check if the result 
	 * is the same as what we expected to receive
	 */
	@Test
	void testMultiplyPolynom() {
		Polynom_able p1 = new Polynom("x-1");
		Polynom_able p2 = new Polynom("x+1");
		p1.multiply(p2);
		Polynom_able expected=new Polynom ("x^2-1");
		boolean ans =p1.equals(expected);
		assertTrue(ans);
	}
	
	/**
	 * This test checks the CopyPolynom function 
	 * By create new polynom , copy it and compare to the old  one
	 */
	@Test
	void testCopyPolynom() {
		Polynom_able p1 = new Polynom("x^2+5x+9");
		Polynom_able p2 = p1.copy();
		boolean ans =p1.equals(p2);
		assertTrue(ans);
	}
	/**
	 * This test checks the Add function
	 * By add two polynoms and check if the result 
	 * is the same as what we expected to receive
	 */
	@Test
	void testAddPolynom() {
		Polynom_able p1 = new Polynom("1x^0+3x^1+4x^2+12.0x^3");
		Polynom_able p2 = new Polynom("0.001x^0-0.002x^1");
		p1.add(p2);
		Polynom_able expected=new Polynom ("1.001x^0+2.998x^1+4.x^2+12x^3");
		boolean ans =p1.equals(expected);
		assertTrue(ans);

	}

	/**
	 * This test checks the Substract function
	 * By subtracts two polynoms and check if the result 
	 * is the same as what we expected to receive
	 */
	@Test
	void testSubstractPolynom() {
		Polynom_able p1 = new Polynom("x^3-5x^2+6x+9");
		Polynom_able p2 = new Polynom("x^3-4x^2+9");
		p1.substract(p2);
		Polynom_able expected=new Polynom ("-x^2+6x");
		boolean ans =p1.equals(expected);
		assertTrue(ans);

	}
	
	/**
	 * This test checks the F function
	 * By Places a value X in the polynomial and checks whether
	 * this is the result we expected to receive
	 */
	@Test
	void testFPolynom() {
		Polynom p1 = new Polynom( "x^2+5x+5");
		double x= 0.5;
		double res =p1.f(x);
		double expected =7.75;
		assertEquals(expected, res);
	}

	
	/**
	 * This test checks the Root function
	 * By using the root function on Polynom and check if the result close to what we expected to receive
	 * We check that the result we received and what we expected is a distance of Epsilon
	 */
	@Test
	void testRootPolynom() {

		double eps =0.001;
		
		Polynom_able p1 = new Polynom("x^2-4");
		double res =(p1.root(0, 4, eps));
		double expected =2;
		boolean ans =  (Math.abs(expected-res) <=eps );
		assertTrue(ans);
		
		
		Polynom_able p2 = new Polynom("x^3-8.2x^2-0.009x");
		double res2 =(p2.root(5, 10, eps));
		double expected2 =8.2;
		boolean ans2 =  (Math.abs(expected2-res2) <=eps );
		assertTrue(ans2);
		

	}

}
