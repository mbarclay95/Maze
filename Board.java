
public class Board {
	
	private Node[] cells;
	
	public Board()
	{
		cells = new Node[625];
		for(int i = 0 ; i < 625 ; i++)
		{
			cells[i] = new Node();
		}
		for(int i = 1 ; i < 24 ; i++) //sets all the whole board to black
			for(int j = 1 ; j < 24 ; j++)
			{
				cells[(25*i)+j].create((25*i)+j); 
			}
		for(int i = 0 ; i < 25 ; i++) //sets the perimeter to purple
		{
			cells[25*i].setColor('n');
			cells[(25*(1+i))-1].setColor('n');
			cells[i].setColor('n');
			cells[600+i].setColor('n');
		}
	}
	
	public char getColor(int number)
	{
		return cells[number].getColor();
	}
	
	public void setColor(int number, char color1)
	{
		cells[number].setColor(color1);
	}
	
	public int[] getDirection(int number)
	{
		//System.out.println("Board" + Arrays.toString(cells[number].getDirection()));
		return cells[number].getDirection();
	}
}
