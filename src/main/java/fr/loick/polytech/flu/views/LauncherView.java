package fr.loick.polytech.flu.views;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.Random;

import java.util.regex.Pattern;

/*
	@author : Ulysse RICCIO
*/

public class LauncherView extends JFrame {

	private boolean go;
	private JTextField testField1;

		static final int FPS_MIN = 0;
static final int FPS_MAX = 300;
static final int FPS_INIT = 150;//50;    //initial frames per second

	private int step;

   public LauncherView() {
     super("Option");
	go = false;
	step = 300;

     WindowListener l = new WindowAdapter() {
       public void windowClosing(WindowEvent e){
         System.exit(0);
       }
     };
     addWindowListener(l);

testField1 = new JTextField ("150");

JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL,
                                      FPS_MIN, FPS_MAX, FPS_INIT);

    JButton bouton1 = new JButton("Quitter");
    bouton1.addActionListener( new ActionListener() {
       public void actionPerformed(ActionEvent e) {
         System.exit(0);
       }
    }
    );

	JButton bouton2 = new JButton("Jouer");
	bouton2.addActionListener( new ActionListener() {
       public void actionPerformed(ActionEvent e) {
        go=true;
	System.out.println(go);
       }
    }
    );

	JButton bouton3 = new JButton("Aleatoire");
	bouton3.addActionListener( new ActionListener() {
       public void actionPerformed(ActionEvent e) {
        Random rand = new Random();

	int  n = rand.nextInt(300) + 1;
	step = n;
	testField1.setText(Integer.toString(step));
	framesPerSecond.setValue(step);
	//50 is the maximum and the 1 is our minimum 
       }
    }
    );

     JPanel panneau = new JPanel();
panneau.add(bouton1);
panneau.add(bouton2);
panneau.add(bouton3);

    Border border = BorderFactory.createTitledBorder("Sélection");
    panneau.setBorder(border);
    ButtonGroup group = new ButtonGroup();
    JRadioButton radio1 = new JRadioButton("4-connected neighbourhoods", true);
    JRadioButton radio2 = new JRadioButton("8-connected neighbourhoods");
    group.add(radio1);
    panneau.add(radio1);
    group.add(radio2);
    panneau.add(radio2);

    

framesPerSecond.addChangeListener( new ChangeListener() {
public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider)e.getSource();
    if (!source.getValueIsAdjusting()) {
        int fps = (int)source.getValue();
	System.out.println(fps);
	step = fps;
	Runnable run=new Runnable(){
    	   public void run(){testField1.setText(Integer.toString(step));}
 };
SwingUtilities.invokeLater(run);
/*        if (fps == 0) {
            if (!frozen) stopAnimation();
        } else {
            delay = 1000 / fps;
            timer.setDelay(delay);
            timer.setInitialDelay(delay * 10);
            if (frozen) startAnimation();
        }*/
	}
    }
}
);

//Turn on labels at major tick marks.
framesPerSecond.setMajorTickSpacing(100);
framesPerSecond.setMinorTickSpacing(100);
framesPerSecond.setPaintTicks(false);
framesPerSecond.setPaintLabels(true);




    panneau.add(framesPerSecond);
	//panneau.add(boutonJouer);

testField1.getDocument().addDocumentListener(new DocumentListener() { 
public void changedUpdate(DocumentEvent e) {
    
	boolean isNumber = Pattern.matches("[0-9]+", testField1.getText());
	if ( isNumber )
	{	
		step = Integer.parseInt(testField1.getText());
		framesPerSecond.setValue(step);
	}
  }
  public void removeUpdate(DocumentEvent e) {
boolean isNumber = Pattern.matches("[0-9]+", testField1.getText());
	if ( isNumber )
	{	
		step = Integer.parseInt(testField1.getText());
		framesPerSecond.setValue(step);
	}
  }
  public void insertUpdate(DocumentEvent e) {
boolean isNumber = Pattern.matches("[0-9]+", testField1.getText());
	if ( isNumber )
	{	
		step = Integer.parseInt(testField1.getText());
		framesPerSecond.setValue(step);
	}
  }    
}
);
	panneau.add(testField1);


     
	setContentPane(panneau);
     setSize(400,400);
     setVisible(true);
   }

	public boolean getGo()
	{
		return go;
	}

	public void setGo( boolean go)
	{
		this.go = go;
	}

	public int getStep()
	{
		//System.out.println(testField1.getText() );
		
		return step;
	}

/*		public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider)e.getSource();
    if (!source.getValueIsAdjusting()) {
        int fps = (int)source.getValue();
        if (fps == 0) {
            if (!frozen) stopAnimation();
        } else {
            delay = 1000 / fps;
            timer.setDelay(delay);
            timer.setInitialDelay(delay * 10);
            if (frozen) startAnimation();
        }
    }
}*/


}
