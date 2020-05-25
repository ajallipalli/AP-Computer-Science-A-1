/*
 * By Anika Jallipalli
 * Date: 3/1/2020
 * Purpose: add an interface to process pages from your homework
 * 
 * PMR in README.txt
 */
public class MyEnglish2 extends Homework2
{
	//constructor
	MyEnglish2()
	{
		super();
	}

	//implemented create assignment method
	public void createAssignment(int p) 
	{
		pagesRead = p;
		typeHomework = "English";
	}

	//other methods
	//to string
	public String toString()
	{
		return typeHomework + " - must read " + pagesRead + " pages";
	}
	
	//implement doReading()
	public void doReading()
	{
		pagesRead -= 1;
	}
}