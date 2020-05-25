/*
 * By Anika Jallipalli
 * Date: 3/1/2020
 * Purpose: implement the Comparable<T> interface
 * 
 * PMR in README.txt
 */
public class MyJava3 extends Homework3
{
	//constructor
	MyJava3()
	{
		super();
	}

	//implemented create assignment
	public void createAssignment(int p) 
	{
		pagesRead = p;
		typeHomework = "Java";
	}

	//other methods
	//to string
	public String toString()
	{
		return typeHomework + " - must read " + pagesRead + " pages";
	}
	
	//implements doReading()
	public void doReading()
	{
		pagesRead -= 4;
	}
}