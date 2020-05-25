/*
 * By Anika Jallipalli
 * Date: 3/1/2020
 * Purpose: implement the Comparable<T> interface
 * 
 * PMR in README.txt
 */
public class MyMath3 extends Homework3
{
	//constructor
	MyMath3()
	{
		super();
	}

	//implemented create assignment method
	public void createAssignment(int p) 
	{
		pagesRead = p;
		typeHomework = "Math";
	}

	//other methods
	//to string
	public String toString()
	{
		return typeHomework + " - must read " + pagesRead + " pages";
	}
	
	//implement doReading
	public void doReading()
	{
		pagesRead -= 2;
	}

}
