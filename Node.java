
public class Node {
	
	private int[] direction = new int[8];
	private char color;
	
	public Node()
	{
		
	}
	
	//creates full square around the specific cell
	public void create(int number)
	{
		direction[0] = number + 1;
		direction[1] = number - 1;
		direction[2] = number - 25;
		direction[3] = number + 25;
		direction[4] = number - 24;
		direction[5] = number - 26;
		direction[6] = number + 24;
		direction[7] = number + 26;
		color = 'b';
	}
	
	public char getColor()
	{
		return color;
	}
	
	// b and p = black which is a wall
	//n = purple which is the outside borders
	//w = white which is the path
	//s = start
	//f = finish
	//l = blue which is the solved path
	public void setColor(char color1)
	{
		color = color1;
	}
	
	public int[] getDirection()
	{
		return direction;
	}
}
