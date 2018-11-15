package myMath;

public class Test {

	public static void test1()
	{
		Monom m1 = new Monom(2,2);
		System.out.println("print 2.0*x^2 :"+m1);
		Monom m2 = new Monom(m1);
		System.out.println("print 2.0*x^2 :"+m2);
		Monom m3 = new Monom(1.5,1);
		System.out.println("print 1.5*x^1 :"+m3);
		Monom m4 = new Monom(m3);
		System.out.println("print 1.5*x^1 :"+m4);
		Monom m5 = new Monom(1,0);
		System.out.println("print 1.0*x^0 :"+m5);
		Polynom_able _polynom = new Polynom();
		_polynom.add(m1);
		_polynom.add(m2);
		_polynom.add(m3);	
		_polynom.add(m4);
		_polynom.add(m5);
		System.out.println("_polynom print 1.0*x^0+3.0*x^1+4*x^2 :"+_polynom);

		Polynom_able polynom1 = new Polynom("-1.9*x^-1+-200*x^3+0.003*x^1+200*x^3");
		System.out.println("polynom1 print 0 :"+polynom1);
		Polynom_able polynom2 = new Polynom("-1.9*x^1+-200*x^3+0.003*x^1+200*x^3");
		System.out.println("polynom2 print -1.897*x^1 :"+polynom2);
		Polynom_able polynom3 = new Polynom("0.0*x^0+-0*x^2+0.001*x^0+-0.002*x^1");
		System.out.println("polynom3 print 0.001*x^0+-0.002*x^1 :"+polynom3);

		_polynom.add(new Monom(0,1));
		_polynom.add(new Monom(12,3));
		System.out.println("_polynom print 1.0*x^0+3.0*x^1+4*x^2+12.0*x^3 :"+_polynom);
		_polynom.add(polynom3);
		System.out.println("_polynom print 1.001*x^0+2.998*x^1+4.0*x^2+12.0*x^3 :"+_polynom);
		_polynom.add(_polynom.copy());
		System.out.println("_polynom print 2.002*x^0+5.996*x^1+8.0*x^2+24.0*x^3 :"+_polynom);

		Polynom_able zeroPol = new Polynom("-12*x^2+4*x^6+-0.1*x^0+0*x^3+12*x^2+-4*x^6+0.1*x^0");
		System.out.println("zeroPol print 0 :"+zeroPol);
		double x = 12.3;
		double y1 =_polynom.f(x);
		System.out.println("_polynom f(x) print 45946.8808 :"+y1);
		double y2 = zeroPol.f(x);
		System.out.println("zeroPol f(x) print 0.0 :"+y2);

		_polynom.substract(polynom2);
		System.out.println("_polynom print 2.002*x^0+7.893*x^1+8.0*x^2+24.0*x^3 :"+_polynom);
		polynom3.substract(zeroPol);
		System.out.println("polynom3 print 0.001*x^0+-0.002*x^1 :"+polynom3);
		zeroPol.substract(polynom3);
		System.out.println("zeroPol print -0.001*x^0+0.002*x^1 :"+zeroPol);
		zeroPol.add(polynom3);

		polynom1.multiply(polynom3.copy());
		System.out.println("polynom1 print 0 :"+polynom1);
		polynom2.multiply(polynom3);
		System.out.println("polynom2 print -0.001897*x^1+0.003794*x^2 :"+polynom2);


		boolean b1 = _polynom.equals(polynom3);
		System.out.println("print false :"+b1);
		boolean b2 = _polynom.equals(zeroPol);
		System.out.println("print false :"+b2);
		boolean b3 = _polynom.equals(_polynom.copy());
		System.out.println("print true :"+b3);
		boolean b4 = zeroPol.equals(new Polynom("1567*x^0+-1000*x^0+-567*x^0"));
		System.out.println("print true :"+b4);

		System.out.println("print true :"+zeroPol.copy().isZero());
		System.out.println("print true :"+polynom1.isZero());
		System.out.println("print false :"+polynom2.isZero());

		Polynom_able polynomDer1 = _polynom.derivative();
		System.out.println("polynomDer print :"+polynomDer1);
		System.out.println("_polynom print 2.002*x^0+7.893*x^1+8.0*x^2+24.0*x^3 :"+_polynom);
		Polynom_able polynomDer2 = zeroPol.derivative();
		System.out.println("polynomDer2 print 0:"+polynomDer2);
	}
	public static void test2()
	{
		Polynom_able p1 = new Polynom("-1*x^3+2*x^2+-0*x^0");
		Polynom_able p2 = new Polynom("1*x^3+-8.2*x^2+-0.009*x^1");
		System.out.println("p1 print 2.0*x^2+-1.0*x^3 :"+p1);
		System.out.println("p2 print 2.0*x^2+-1.0*x^3 :"+p2);
		double root1 = p1.root(1, 2.5 , 0.001);
		System.out.println("root1 - print number close to 2 :"+root1);
		System.out.print("root2 - print error massege and Infinity :");
		double root2 = p2.root(1, 2.5 , 0.001);
		System.out.println(root2);
		double root3 = p2.root(5, 10, 0.025);
		System.out.println("root3 - print number close to 8 :"+root3);

		System.out.println("p1 print area close to 2.25 :"+p1.area(-1, 2, 0.001));
		System.out.println("p2 print area close to 0 :"+p2.area(-10, 5, 0.01));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		test1();
//		test2();
		

//		Monom m1 = new Monom("1");
//		System.out.println(m1);
//		Polynom p1 = new Polynom("x^2+2x-4");
//		System.out.println(p1);
//		Monom m2 = new Monom(2,1);
//		System.out.println(m2);
//		m2.add(m1);
//		System.out.println(m2);
//		Polynom p2 = new Polynom("x");
//		System.out.println(p2);
//		Polynom_able p221 = new Polynom("x^3+-8.2x^2+-0.009x^1");
//		System.out.println(p221);
		
		
		Polynom p = new Polynom("x^2+4");
		p.FunctionGraph(-4, 2);
		
		Polynom p1 = new Polynom("x");
//		p1.FunctionGraph(-100, 100);
		
		Polynom p2 = new Polynom("x^3");
//		p2.FunctionGraph(-2, 2);
		
		Polynom p3 = new Polynom("0.2x^4-1.5x^3+3.0x^2-x-5");
		//p3.FunctionGraph(-2, 6);


		
	}





	}
	
