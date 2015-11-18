package telf_contact;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;

import java.util.List;

public class TelefonBuchSuchenLoeschenPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	TelefonBuch telBuch;
	JTextField tfNameSuchen, tfZusatzSuchen;
	JButton buttonAnwenden;
	JComboBox<String> comboSuche;
	public static JTextArea tArea;
	JPanel pSuchen;
	JPanel ausgabePanel;
	
    public TelefonBuchSuchenLoeschenPanel(TelefonBuch tb) {
    	telBuch = tb;
    	
    	pSuchen = new JPanel();
    	ausgabePanel = new JPanel();
    	
    	//Panel-Suchen-Loeschen-A
    	JPanel panelA = new JPanel();
    	panelA.setLayout(new GridLayout(2, 1));
    	panelA.add(new JLabel("Name"));
    	panelA.add(new JLabel("Zusatz"));
    	
    	//Panel-Suchen-Loeschen-B
    	JPanel panelB = new JPanel();
    	panelB.setLayout(new GridLayout(2, 1));
    	tfNameSuchen = new JTextField("", 20);
    	tfZusatzSuchen = new JTextField("", 20);
    	panelB.add(tfNameSuchen);
    	panelB.add(tfZusatzSuchen);
    	
    	//Panel Suchen-Loeschen
    	Border border = BorderFactory.createTitledBorder("Suchen/Loeschen");
    	pSuchen.setBorder(border);
    	pSuchen.setLayout(new BoxLayout(pSuchen, BoxLayout.LINE_AXIS));
    	pSuchen.add(panelA);
    	pSuchen.add(panelB);
    	
    	//Combobox bei der Suche/Loeschen deffinieren
    	String comboListe[] = {"Exakte-Suche", "Prefix-Suche", "Loeschen"};
    	comboSuche = new JComboBox<String>(comboListe);
    	comboSuche.setSelectedIndex(0);
    	
    	//Knopf zum Betaetigen
    	buttonAnwenden = new JButton("Anwenden");
    	buttonAnwenden.setLayout(new GridLayout(1, 1));
//    	anPanel.add(buttonAnwenden);
    	
    	pSuchen.add(comboSuche);
    	pSuchen.add(buttonAnwenden);
    	
    	tArea = new JTextArea(20, 1);
    	border = BorderFactory.createEtchedBorder();
    	tArea.setBorder(border);
    	
//    	Panel Textarea-Ausgabe
    	border = BorderFactory.createTitledBorder("Ausgabe");
    	ausgabePanel.setBorder(border);
    	ausgabePanel.setLayout(new BorderLayout());
    	ausgabePanel.add(BorderLayout.CENTER, new JScrollPane(tArea));
    	
    	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    	this.add(pSuchen);
    	this.add(ausgabePanel);
    	
    	comboSuche.addActionListener(this);
    	buttonAnwenden.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	String name = tfNameSuchen.getText();
    	String zusatz = tfZusatzSuchen.getText();
    	String ausgabe;
    	
    	
    	
    	tArea.setText("");
    	if(e.getSource() == buttonAnwenden){
    		//Exact
    		if(comboSuche.getSelectedItem().toString().equals("Exakte-Suche")){
    			ausgabe = telBuch.exactSearch(name, zusatz);
    			if(ausgabe != null){
    				tArea.setText(name + " " + zusatz + " " + ausgabe);
    			} else {
    				JOptionPane.showMessageDialog(this, name + " " + zusatz + " " + "konnte nicht gefunden werden ");
    			}
    		//Prefix
    		} else if(comboSuche.getSelectedItem().toString().equals("Prefix-Suche") ){
    				List<String> list = telBuch.prefixSearch(name);
    				for(String s : list)
    					tArea.append(s + "\n");
    		
    		//Delete		
    		} else if(comboSuche.getSelectedItem().toString().equals("Loeschen")){
    			if(telBuch.remove(name, zusatz)){
    				JOptionPane.showMessageDialog(this, name + " " + zusatz + " " + "wurde erfolgreich entfernt" );
    				
    			} else {
    				JOptionPane.showMessageDialog(this, name + " " + zusatz + " " + "konnte nicht entfernt werden ");
    				}
    			}
    	} 
    	tfNameSuchen.setText(""); 
    	tfZusatzSuchen.setText("");
    	
    }
}