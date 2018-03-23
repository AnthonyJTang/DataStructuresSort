//sorting properties, panel of options for the sort
//buttons for type of array, slider for array size, button to do it

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

public class SortGui extends JPanel implements ChangeListener{
	JRadioButton inOrder, almostOrder, reverseOrder, randomOrder;
	JSlider listSize;
	JTextField listRes;
	private JButton createArray;
	private JButton startSort;
	private JTextArea outputArea;
	int sliderValue =10000;
	
	public SortGui() {
		setLayout(new GridBagLayout());
		
		inOrder = new JRadioButton("In Order");
		GridBagConstraints cOrder = new GridBagConstraints();
			cOrder.gridx = 0;
			cOrder.gridy = 0;
			cOrder.anchor = GridBagConstraints.WEST; //align to left side
		inOrder.setSelected(true); //make this one the default selected
		
		
		almostOrder = new JRadioButton("Almost Order");
		GridBagConstraints cAlmost = new GridBagConstraints();
			cAlmost.gridx = 1;
			cAlmost.gridy = 0;
		
		reverseOrder = new JRadioButton("Reverse Order");
		GridBagConstraints cReverse = new GridBagConstraints();
			cReverse.gridx = 0;
			cReverse.gridy = 1;
		
		randomOrder = new JRadioButton("Random Order");
		GridBagConstraints cRandom = new GridBagConstraints();
			cRandom.gridx = 1;
			cRandom.gridy = 1;
		
			//group so only one can be selected
		ButtonGroup orderType = new ButtonGroup();
			orderType.add(inOrder);
			orderType.add(reverseOrder);
			orderType.add(almostOrder);
			orderType.add(randomOrder);
		
		add(inOrder, cOrder);
		add(almostOrder, cAlmost);
		add(reverseOrder, cReverse);
		add(randomOrder, cRandom);

		//slider between 0 and 30000 with default value of 10000
		listSize = new JSlider(0, 30000, 10000);
		listSize.addChangeListener(this);
		GridBagConstraints cSlider = new GridBagConstraints();
			cSlider.gridx = 0;
			cSlider.gridy = 2;
			cSlider.fill = 80;
			cSlider.gridwidth = 80;
			cSlider.anchor = GridBagConstraints.WEST;
		add(listSize, cSlider);

		
		listRes = new JTextField(10);
		GridBagConstraints cSlideOut = new GridBagConstraints();
			cSlideOut.gridx = 80;
			cSlideOut.gridy = 2;
			cSlideOut.fill = GridBagConstraints.REMAINDER; //fill to remainder of pane
			cSlideOut.gridwidth = 20;
		add(listRes, cSlideOut);
		listRes.setText("10000");	//default value of slider.
		
		createArray = new JButton("Create List");
		GridBagConstraints cCreate = new GridBagConstraints();
			cCreate.gridy = 3;
			cCreate.fill = GridBagConstraints.BOTH; //expand as needed
			cCreate.gridwidth = 100;
		add(createArray, cCreate);		
		
		startSort = new JButton("SORT");
		GridBagConstraints cSort = new GridBagConstraints();
			cSort.gridy = 4;
			cSort.fill = GridBagConstraints.BOTH; //expand as needed
			cSort.gridwidth = 100;
		add(startSort, cSort);	
		
		outputArea = new JTextArea("\n\n\n\n");
		GridBagConstraints cOut = new GridBagConstraints();
			cOut.gridy = 5;
			cOut.fill = GridBagConstraints.BOTH; //expand as needed
			cOut.gridwidth = 100;
		add(outputArea, cOut);	
			
	}
	
	//handles the change event slider format
	public void stateChanged(ChangeEvent c) {
		  	JSlider source = (JSlider)c.getSource();
		    sliderValue = listSize.getValue();
		    listRes.setText(sliderValue + "");    
	}
	
	public int getSliderValue() {
	
		//make sure slider value and integer match. 
		try {
			int textFieldValue = Integer.valueOf( listRes.getText() ) ;
			
			if(sliderValue == textFieldValue){
				return sliderValue;
			}
			
			//if the text field value is valid, it replaces the slider value and 
			//adjusts the slider. 
			else if(textFieldValue > 0 && textFieldValue <= 30000) {
				sliderValue = textFieldValue;
				listSize.setValue(sliderValue);
				return sliderValue;
			}
			
			else {
				//return whatever the slider is at and ignore their invalid textfield input.
				return sliderValue;
			}
			
		} catch(NumberFormatException e) {
			System.out.println("non numeric in textbox");
			return sliderValue;
		}
	}
	

	public JRadioButton getInOrder() {
		return inOrder;
	}
	public JRadioButton getAlmostOrder() {
		return almostOrder;
	}
	public JRadioButton getReverseOrder() {
		return reverseOrder;
	}
	public JRadioButton getRandomOrder() {
		return randomOrder;
	}
	public JButton getCreateArray(){
		return createArray;
	}
}
