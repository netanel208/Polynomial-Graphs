
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Netanel
 *
 */
public class Monom implements function{




	public Monom(String str){

		double a=0; // coefficient
		int b=0; //  power

		str =str.toLowerCase();
		if ( str.contains("x") && str.contains("^")) { 
			int i = str.indexOf('x');
			if ( i==0) { // no coefficient for x like "x^b"
				a =1.0;
				try {
					b =Integer.parseInt(str.substring(2, str.length()));
				}
				catch(Exception e) {
					System.err.println("Invalid input");
					throw e;
				}
			}
			else {
				if ( str.contains("-") && str.indexOf('x')==1) { // for "-x^b" 
					if (str.contains("-"))
						a= -1.0;

					try {
						b =Integer.parseInt(str.substring(3, str.length()));
					}

					catch(Exception e) {
						System.err.println("Invalid input");
						throw e;
					}
				}
				else { // for all cases ax^b
					try {
						a =Double.parseDouble(str.substring(0, i));
					}
					catch(Exception e) {
						System.err.println("Invalid input");
						throw e;
					}
					try {
						b =Integer.parseInt(str.substring(i+2, str.length()));
					}

					catch(Exception e) {
						System.err.println("Invalid input");
						throw e;
					}

				}
			}
		}

		else {


			if ( !str.contains("^") && str.contains("x")) { // for  expressions like "3x" or "-x"
				if  (str.contains("-") && str.indexOf('x')==1 && str.length() == 2) { // for "-x" or
					a= -1.0;
					b= 1;
				}

				else if (str.indexOf('x')==0 && str.length() == 1) { // for "x"
					a= 1.0;
					b=1;

				}
				else { // for "8x"
					int i = str.indexOf('x');
					if(i == str.length()-1)
					{
						try {
							a =Double.parseDouble(str.substring(0, i));
						}
						catch(Exception e) {
							System.err.println("Invalid input");
							throw e;
						}

						b= 1;
					}
				}
			}

			else if (!str.contains("x") && !str.contains("^")) { // for free organ like "4"
				try {
					a =Double.parseDouble(str);

				}
				catch(Exception e) {
					System.err.println("Invalid input");
					throw e;
				}
				b =0;
			}
			else {
				System.err.println("Invalid input");
				throw new NumberFormatException();
			}
		}

		this.set_coefficient(a);
		this.set_power(b);

	}

	/**
	 * The constructor of the class, which receives two parameters: coefficient and power.
	 * @param a  should be non negativ integer
	 * @param b  real number
	 */

	public Monom(double a, int b){
		if(b >= 0)
		{
			this.set_coefficient(a);
			this.set_power(b);
		}
		else
		{
			System.err.println("Invalid input");
			throw new NumberFormatException();
		}
	}
	/**
	 * The constructor of the class, which receives Monom ot and send it parameters to the 
	 * other constructor
	 * @param ot
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	@Override
	/**
	 *@return   The function calculates the value of f (x) ie a*x^b and return it
	 */
	public double f(double x)
	{return this._coefficient*(Math.pow(x, this._power));}//f(x)=a*X^b

	/**
	 * 
	 * @return coefficient
	 */
	public double get_coefficient()
	{return _coefficient;}

	/**
	 * 
	 * @return power
	 */
	public int get_power()
	{return _power;}

	/**
	 * Compute connection coefficients of this with m
	 * @param m
	 */
	public void add(Monom m)
	{
		if(this.get_power() == m.get_power())
		{
			this.set_coefficient(this.get_coefficient()+m.get_coefficient());
		}
		else
		{
			this.set_coefficient(0);
			this.set_power(0);
			System.err.println("Exception: can't add Monoms with different powers!");
		}
	} //f(x)=(a1+a2)x^b

	/**
	 * Compute the subtraction of the coefficients of this with m
	 * @param m
	 */
	public void substract(Monom m)
	{
		if(this.get_power() == m.get_power()) {
			this.set_coefficient(this.get_coefficient()-m.get_coefficient());
		}
		else
		{
			this.set_coefficient(0);
			this.set_power(0);
			System.err.println("Exception: can't substract Monoms with different powers!");
		}
	}

	/**
	 * Compute the multiplication of two monom by multiplying the coefficients and connecting the powers
	 * @param m
	 */
	public void multiply(Monom m)
	{
		if(this._coefficient == 0 || m._coefficient ==0)
		{
			this.set_coefficient(0);
			this.set_power(0);
		}
		else
		{
			this.set_coefficient(this.get_coefficient()*m.get_coefficient());
			this.set_power(this.get_power()+m.get_power());
		}
	}

	/**
	 * Compute the derivative of the two monoms by multiplying the coefficient by a strong then lowering the power value at 1
	 */
	public void derivative()
	{
		this.set_coefficient(this._power*this._coefficient);
		this.set_power(this._power-1);
	}

	/**
	 * Checks whether the values of this monom are equal to monom m values
	 * @param m
	 * @return true if the values equals
	 */
	public boolean equals(Monom m)
	{
		if(this.get_coefficient() == m.get_coefficient() && this.get_power() == m.get_power())
			return true;
		return false;
	}

	/**
	 * @param a
	 */
	public void set_coefficient(double a)
	{this._coefficient = a;}

	/**
	 * @param p
	 */
	public void set_power(int p) 
	{
		if(p >= 0)
			this._power = p;
		else
		{
			System.err.println("Invalid input");
			throw new NumberFormatException();
		}
	}

	public String toString() {
		return this._coefficient+"x^"+this._power;
	}


	//****************** Private Methods and Data *****************



	private double _coefficient; // 
	private int _power; 
}
