package fr.loick.polytech.flu.views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
import java.util.Random;
import java.util.regex.Pattern;

/*
    @author : Ulysse RICCIO
*/

public class LauncherView extends JFrame {

    static final int FPS_MIN = 0;
    static final int FPS_MAX = 300;
    static final int FPS_INIT = 0;//50;    //initial frames per second
	
	static final int FPS_MIN1 = 1;
    static final int FPS_MAX1 = 5000;
    static final int FPS_INIT1 = 2500;//50;    //initial frames per second

    private boolean go;
    private JTextField testField1;
    private int step;
	private JTextField testField2;
	private JRadioButton radio1;
	private int step2;
	
	private boolean exit = false;


	 
    public LauncherView() {
        super("Option");
        go = false;
        step = 0;
	step2 = 2500;

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(l);

        testField1 = new JTextField("2500");

        JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL,
                FPS_MIN1, FPS_MAX1, FPS_INIT1);

	testField2 = new JTextField("000");

	JSlider framesPerSecond2 = new JSlider(JSlider.HORIZONTAL,
                FPS_MIN, FPS_MAX, FPS_INIT);

        JButton bouton1 = new JButton("Quitter");
        bouton1.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent e) {
                                          System.exit(0);
                                      }
                                  }
        );

        JButton bouton2 = new JButton("Jouer");
        bouton2.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent e) {
                                          go = true;
                                          System.out.println(go);
                                      }
                                  }
        );

        JButton bouton3 = new JButton("Aleatoire");
        bouton3.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent e) {
                                          Random rand = new Random();

                                          int n = rand.nextInt(5000) + 1;
                                          step2 = n;
                                          testField1.setText(Integer.toString(step2));
                                          framesPerSecond.setValue(step2);
                                          //50 is the maximum and the 1 is our minimum
                                      }
                                  }
        );

	JButton bouton4 = new JButton("Stop");
        bouton2.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent e) {
                                          exit = true;
                                      }
                                  }
        );

        JPanel panneau = new JPanel();
        panneau.add(bouton1);
        panneau.add(bouton2);
        panneau.add(bouton3);
	//panneau.add(bouton4);

        Border border = BorderFactory.createTitledBorder("Sélection");
        panneau.setBorder(border);
        ButtonGroup group = new ButtonGroup();
        radio1 = new JRadioButton("4-connected neighbourhoods", true);
        JRadioButton radio2 = new JRadioButton("8-connected neighbourhoods");
        group.add(radio1);
        panneau.add(radio1);
        group.add(radio2);
        panneau.add(radio2);

	
	JLabel textFieldLabel = new JLabel("Modification du nombre de steps : ");
	panneau.add(textFieldLabel);
	
        framesPerSecond.addChangeListener(new ChangeListener() {
                                              public void stateChanged(ChangeEvent e) {
                                                  JSlider source = (JSlider) e.getSource();
                                                  if (!source.getValueIsAdjusting()) {
                                                      int fps = (int) source.getValue();
                                                      System.out.println(fps);
                                                      step2 = fps;
                                                      Runnable run = new Runnable() {
                                                          public void run() {
                                                              testField1.setText(Integer.toString(step2));
                                                          }
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
        framesPerSecond.setMajorTickSpacing(1500);
        framesPerSecond.setMinorTickSpacing(1500);
        framesPerSecond.setPaintTicks(false);
        framesPerSecond.setPaintLabels(true);


        panneau.add(framesPerSecond);
        //panneau.add(boutonJouer);

        testField1.getDocument().addDocumentListener(new DocumentListener() {
                                                         public void changedUpdate(DocumentEvent e) {

                                                             boolean isNumber = Pattern.matches("[0-9]+", testField1.getText());
                                                             if (isNumber) {
                                                                 step2 = Integer.parseInt(testField1.getText());
                                                                 framesPerSecond.setValue(step2);
                                                             }
                                                         }

                                                         public void removeUpdate(DocumentEvent e) {
                                                             boolean isNumber = Pattern.matches("[0-9]+", testField1.getText());
                                                             if (isNumber) {
                                                                 step2 = Integer.parseInt(testField1.getText());
                                                                 framesPerSecond.setValue(step2);
                                                             }
                                                         }

                                                         public void insertUpdate(DocumentEvent e) {
                                                             boolean isNumber = Pattern.matches("[0-9]+", testField1.getText());
                                                             if (isNumber) {
                                                                 step2 = Integer.parseInt(testField1.getText());
                                                                 framesPerSecond.setValue(step2);
                                                             }
                                                         }
                                                     }
        );
        panneau.add(testField1);





	framesPerSecond.addChangeListener(new ChangeListener() {
                                              public void stateChanged(ChangeEvent e) {
                                                  JSlider source = (JSlider) e.getSource();
                                                  if (!source.getValueIsAdjusting()) {
                                                      int fps = (int) source.getValue();
                                                      System.out.println(fps);
                                                      step2 = fps;
                                                      Runnable run = new Runnable() {
                                                          public void run() {
                                                              testField1.setText(Integer.toString(step2));
                                                          }
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




	framesPerSecond2.addChangeListener(new ChangeListener() {
                                              public void stateChanged(ChangeEvent e) {
                                                  JSlider source = (JSlider) e.getSource();
                                                  if (!source.getValueIsAdjusting()) {
                                                      int fps = (int) source.getValue();
                                                      System.out.println(fps);
                                                      step = fps;
                                                      Runnable run = new Runnable() {
                                                          public void run() {
                                                              testField2.setText(Integer.toString(step));
                                                          }
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

	JLabel textFieldLabel2 = new JLabel("Vitesse entre les différentes steps : ");
	panneau.add(textFieldLabel2);

        framesPerSecond2.setMajorTickSpacing(100);
        framesPerSecond2.setMinorTickSpacing(100);
        framesPerSecond2.setPaintTicks(false);
        framesPerSecond2.setPaintLabels(true);


        panneau.add(framesPerSecond2);
        //panneau.add(boutonJouer);

        testField2.getDocument().addDocumentListener(new DocumentListener() {
                                                         public void changedUpdate(DocumentEvent e) {

                                                             boolean isNumber = Pattern.matches("[0-9]+", testField2.getText());
                                                             if (isNumber) {
                                                                 step = Integer.parseInt(testField2.getText());
                                                                 framesPerSecond2.setValue(step);
                                                             }
                                                         }

                                                         public void removeUpdate(DocumentEvent e) {
                                                             boolean isNumber = Pattern.matches("[0-9]+", testField2.getText());
                                                             if (isNumber) {
                                                                 step = Integer.parseInt(testField2.getText());
                                                                 framesPerSecond2.setValue(step);
                                                             }
                                                         }

                                                         public void insertUpdate(DocumentEvent e) {
                                                             boolean isNumber = Pattern.matches("[0-9]+", testField2.getText());
                                                             if (isNumber) {
                                                                 step = Integer.parseInt(testField2.getText());
                                                                 framesPerSecond2.setValue(step);
                                                             }
                                                         }
                                                     }
        );
        panneau.add(testField2);






        setContentPane(panneau);
        setSize(400, 400);
        setVisible(true);

    }

    public boolean getGo() {
        return go;
    }

    public void setGo(boolean go) {
        this.go = go;
    }

    public int getStep() {
        //System.out.println(testField1.getText() );

        return step2;
    }

	public int getStep1() {
        //System.out.println(testField1.getText() );

        return step;
    }
	public boolean get4Connected() {
        System.out.println(radio1.isSelected() );

        return radio1.isSelected();
    }

	public boolean getExit() {
	if ( exit )
	{
		exit = false;
        	return ( ! exit );
	}
	else
		return false;
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
