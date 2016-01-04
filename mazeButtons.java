import javax.swing.ImageIcon;
import javax.swing.JButton;

public class mazeButtons extends JButton {
	
	ImageIcon black, white, purple, start, finish, blue;
	
	public mazeButtons()
	{
		black = new ImageIcon("avatar_629c47e86c3e_128.png");
		white = new ImageIcon("WHITE SMALL-7.png");
		purple = new ImageIcon("square-xxl.png");
		start = new ImageIcon("tour_startbutton (1).png");
		finish = new ImageIcon("10320413_918887748144885_7836130975188357903_n (1).png");
		blue = new ImageIcon("blueStar-b.png");
	}

	public void setImage(char set)
	{
		if(set == 'b' || set == 'p')
			setIcon(black);
		else if(set == 'w')
			setIcon(white);
		else if(set == 's')
			setIcon(start);
		else if(set == 'f')
			setIcon(finish);
		else if(set == 'l')
			setIcon(blue);
		else
			setIcon(purple);
	}
}
