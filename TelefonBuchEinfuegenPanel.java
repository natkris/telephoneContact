package telf_contact;


import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;

public class TelefonBuchEinfuegenPanel
        extends JPanel implements ActionListener {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    TelefonBuch telBuch;
    JTextField tfEinfuegenName;
    JTextField tfEinfuegenZusatz;
    JTextField tfEinfuegenTelNr;
    JButton buttonEinfuegen;

    public TelefonBuchEinfuegenPanel(TelefonBuch tb) {
        telBuch = tb;
        
		JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
		panel1.add(new JLabel("Name"));
		panel1.add(new JLabel("Zusatz"));
		panel1.add(new JLabel("TelefonNummer"));
		
        JPanel panel2 = new JPanel(); 
        panel2.setLayout(new GridLayout(3, 1)); 
        tfEinfuegenName = new JTextField("", 20);
        panel2.add(tfEinfuegenName);
        tfEinfuegenZusatz = new JTextField("", 20);
        panel2.add(tfEinfuegenZusatz);
        tfEinfuegenTelNr = new JTextField("", 20);
        panel2.add(tfEinfuegenTelNr);

        Border border = BorderFactory.createTitledBorder("Einfuegen");
        this.setBorder(border);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(panel1);
        this.add(panel2);
        buttonEinfuegen = new JButton("Einfuegen");
        this.add(buttonEinfuegen);
        buttonEinfuegen.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ...
    	Object source = e.getSource();
    	String na = tfEinfuegenName.getText();
    	String zu = tfEinfuegenZusatz.getText();
    	String te = tfEinfuegenTelNr.getText();
    	if(source == buttonEinfuegen){
    		if(na.equals("") || te.equals(""))
    		{
    			JOptionPane.showMessageDialog(this, "Neue Datei konnte nicht erfolgreich eingefuegt werden");
    		} else {
    				JOptionPane.showMessageDialog(this, "Neue Datei wurde erfolgreich eingefuegt");
    				telBuch.insert(na, zu, te);
    				}
    	}
    	
    }
}