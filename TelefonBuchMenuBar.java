package telf_contact;

import javax.swing.*;

import java.io.*;
import java.awt.event.*;
import java.awt.*;


public class TelefonBuchMenuBar extends JMenuBar implements ActionListener {
    private static final long serialVersionUID = 1L;
    private TelefonBuch telBuch;
    Container container;
    JFileChooser fc = new JFileChooser();
    JMenuItem menuItem1, menuItem2, menuItem3;
    JMenu menu;
    JMenuBar mainMenuBar;
    
    public TelefonBuchMenuBar(TelefonBuch tb) {
        telBuch = tb;
        mainMenuBar = new JMenuBar();
        
        //Wie das MenuBar aussehen wird
        mainMenuBar.setOpaque(true);
        mainMenuBar.setPreferredSize(new Dimension(200, 20));
        
        menu = new JMenu("Datei");
        menu.setMnemonic(KeyEvent.VK_A);
        mainMenuBar.add(menu);
        
        menuItem1 = new JMenuItem("Telefonbuch lesen...");
        menuItem1.setMnemonic(KeyEvent.VK_T);
        menuItem1.addActionListener(this);
        menu.add(menuItem1);
        
        menuItem2 = new JMenuItem("Telefonbuch speichern...");
        menuItem2.setMnemonic(KeyEvent.VK_T);
        menuItem2.addActionListener(this);
        menu.add(menuItem2);
        
        menuItem3 = new JMenuItem("Telefonbuch beenden...");
        menuItem3.setMnemonic(KeyEvent.VK_T);
        menuItem3.addActionListener(this);
        menu.add(menuItem3);
        
        this.add(menu);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setSelectedFile(new File(System.getProperty("user.dir")));
    }

	public void actionPerformed(ActionEvent e) {
        // ...
    	Object source = e.getSource();
    	Component myFrame = null;
    	
    	//read
    	if(source == menuItem1){
    		fc.showOpenDialog(this);
    		if(fc.getSelectedFile() != null){
    			telBuch.read(fc.getSelectedFile());
    		} 
    	}
    	
    	//save
    	if(source == menuItem2){
    		fc.showSaveDialog(this);
    		if(fc.getSelectedFile() != null){
    			telBuch.save(fc.getSelectedFile());
    		}
    	}
    	
    	//exit
    	if(source == menuItem3){
    		int n = JOptionPane.showConfirmDialog(myFrame, "Soll Telefonbuch beendet werden?"
    														, "Bitte best�tigen!!!"
    														, JOptionPane.YES_NO_OPTION);
    		if(n == JOptionPane.YES_OPTION){
    			System.exit(0);	
    			} else if(n == JOptionPane.NO_OPTION){
    			return;
    			} else {
    			JOptionPane.showMessageDialog(myFrame, "Frage wurde nicht beantwortet, zurueck zum Telefonbuch");
    		}
    		
    	}
    	
    
    	
    }
    
}
