import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Controller {

	private Board b1;
	private ArrayList<Integer> wallList; //list of all the cells that are a wall
	private ArrayList<Integer> pathList; //list of all the cells that are part of the path
	private int done, flag;
	
	public Controller()
	{
		b1 = new Board();	
		pathList = new ArrayList<Integer>(400);
		wallList = new ArrayList<Integer>(400); 
		pathList.add(26); //start of maze
		done = 0;
		flag = 0;
		b1.setColor(26, 's');
		b1.setColor(598, 'f');
		setWall(26);
	}
	
	public int create()
	{
		Random rand = new Random();
		int randomInt = rand.nextInt(wallList.size());
		int number = wallList.get(randomInt);
		wallList.remove(randomInt);
		if(checkCell(number))
		{
			if(number == 598)
				done = 1;
			b1.setColor(number, 'w');
			setWall(number);
			return number;
		}
		else
		{
			return -1;
		}
	}
	
	public boolean wallSize()
	{
		if(wallList.size() < 1)
			return false;
		return true;
	}
	
	public boolean isDone()
	{
		if(done == 1)
			return true;
		return false;
	}

	public void setWall(int number)
	{
		int[] temp = b1.getDirection(number);
		for(int i = 0 ; i < 4 ; i++)
		{
			if(b1.getColor(temp[i]) == 'b')
			{
				wallList.add(temp[i]);
			}
		}
	}
	
	public boolean checkCell(int path)
	{
		int[] temp = b1.getDirection(path);
		int counter = 0;
		for(int i = 4 ; i < 8 ; i++) //checks the corner directions
		{
			if(b1.getColor(temp[i]) == 'w')
				counter++;
		}
		if(wallList.contains(path) || counter > 1)
		{
			while(wallList.contains(path))
				wallList.remove(wallList.indexOf(path));
			b1.setColor(path, 'p');
			return false;
		}
		return true;
	}
	
	public char getColor(int number)
	{
		return b1.getColor(number);
	}
	
	public void solve()
	{
		solveHelp(26);
		b1.setColor(598, 'f');
		
	}
	
	public void solveHelp(int number) //recursively finds the path through the maze
	{
		if(number == 598)
		{
			flag = 1;
			return;
		}
		int[] temp = b1.getDirection(number);
		loop:
		for(int i = 0 ; i < 4 ; i++)
		{
			if(b1.getColor(temp[i]) == 'w' || b1.getColor(temp[i]) == 'f')
			{
				b1.setColor(temp[i], 'l');
				solveHelp(temp[i]);
				if(flag == 1) break loop;
				b1.setColor(temp[i], 'w');
			}
		}
	}
}
