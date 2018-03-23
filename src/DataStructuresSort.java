import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class DataStructuresSort {
	

	public static int[] list;
	static int arrayOrder = 0;
	
	public static void main (String args[]){
		
		
		
		JFrame mySort = new JFrame("Sort");
		mySort.setVisible(true);
		mySort.setTitle("Sort");
		mySort.setSize(550,500);
		mySort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mySort.setLayout(new GridBagLayout());	
		
		SortGui gui = new SortGui();
		mySort.add(gui);
		mySort.pack(); 
		
		
		
		//create array button action listener
		gui.getCreateArray().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				int arraySize = gui.getSliderValue();
				int[] list = new int[arraySize];
				
				//in order
				if(arrayOrder == 0) {
					GenerateList.inOrder(list);
					
				}
				//almost order
				else if(arrayOrder == 1) {
					GenerateList.almostOrder(list);
					
				}
				//reverse order
				else if(arrayOrder == 2) {
					GenerateList.reverseOrder(list);
					
				}
				//random order
				else if(arrayOrder == 3) {
					GenerateList.randomOrder(list);
			
				}
				
				for(int i = 0; i < list.length; i++) {
					System.out.println(list[i]);
				}
	
			}	
			
		});
		
		
		gui.getInOrder().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {			
				arrayOrder = 0;
			}
			
			
		});
		
		gui.getAlmostOrder().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				arrayOrder = 1;			
			}
			
			
		});
		
		gui.getReverseOrder().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				arrayOrder = 2;		
				
			}
			
			
		});
		gui.getRandomOrder().addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				arrayOrder = 3;					
			}
			
			
		});
		
		
		
	}
	
	
}
