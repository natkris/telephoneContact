package telf_contact;


import javax.swing.*;

public class TelefonBuchGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private TelefonBuch telBuch;
    
    
    public TelefonBuchGUI() {
        // TelefonBuch anlegen:
        telBuch = new TelefonBuch();

        // Menuleiste einbauen:
        this.setJMenuBar(new TelefonBuchMenuBar(telBuch));
        
     

        // mainPanel mit Umrandung versehen und das
        // Einfuegen- und  SuchenLoeschenPanel einbauen:
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        // ...
        mainPanel.add(new TelefonBuchEinfuegenPanel(telBuch));
        mainPanel.add(new TelefonBuchSuchenLoeschenPanel(telBuch));
        this.setContentPane(mainPanel);

        // Sonstige Eigenschaften des Hauptfenster setzen:
        this.setTitle("Telefonbuch");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.pack();
        
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TelefonBuchGUI();
    	

    	
    	
    }
}