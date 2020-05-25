/*
 * By Anika Jallipalli
 * Date: 3/1/2020
 * Purpose: mirror your homework and then to create instances for different subject matter
 * 
 * PMR in README.txt
 */
public class MyJava extends Homework
{
	//constructor
	MyJava()
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
}