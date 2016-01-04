import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame implements ActionListener{
	
	private JPanel frame;
	private JPanel grid;
	private JPanel buttonPanel;
	private mazeButtons buttons[];
	private JButton Generate, reset, solve;
	private Controller control = new Controller();
	
	public MainFrame()
	{
		//sets up main frame
		super("Maze");
		setSize(1200,950);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		//sets up the background frame that everything is on
		frame = new JPanel();
		frame.setLayout(new BorderLayout(0,0));
		setContentPane(frame);
		
		//sets up the top panel with buttons
		buttonPanel = new JPanel();
		frame.add(buttonPanel, BorderLayout.NORTH);
		Generate = new JButton("Generate");
		Generate.setEnabled(true);
		Generate.addActionListener(this); 
		buttonPanel.add(Generate);
		reset = new JButton("Reset");
		reset.setEnabled(true);
		reset.addActionListener(this);
		buttonPanel.add(reset);
		solve = new JButton("Solve");
		solve.setEnabled(true);
		solve.addActionListener(this);
		buttonPanel.add(solve);
		
		//sets up the grid where the actual maze will be
		grid = new JPanel();
		grid.setLayout(new GridLayout(25,25));
		frame.add(grid, BorderLayout.CENTER);
		buttons = new mazeButtons[625];
		for(int i = 0 ; i < 625 ; i++)
		{
			buttons[i] = new mazeButtons();
			grid.add(buttons[i]);
			buttons[i].setEnabled(true);
			buttons[i].setImage(control.getColor(i));
		}
	}
	
	public static void main(String[] args)
	{
		new MainFrame();
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == Generate)
		{
			int x = 0;
			while(!control.isDone() && control.wallSize())
			{
				x = control.create();
				if(x != -1)
					buttons[x].setImage('w');
			}
		}
		if(e.getSource() == reset)
		{
			control = new Controller();
			for(int i = 0 ; i < 625 ; i++)
				buttons[i].setImage(control.getColor(i));
		}
		if(e.getSource() == solve)
		{
			control.solve();
			for(int i = 0 ; i < 625 ; i++)
				buttons[i].setImage(control.getColor(i));
		}
	}
	
}
