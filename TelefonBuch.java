package telf_contact;


import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.List;
import java.awt.Component;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

//import javafx.application.*;

public class TelefonBuch {

    private TreeMap<String,String> telBuch = new TreeMap<String,String>();

    public boolean insert(String name, String zusatz, String telNr) {
    	Component myFrame = null;
    	
    	//Wenn data nicht in dem TreeMap vorkommt
    	if(!telBuch.containsKey(name)){
    		if(zusatz.equals("")){
    			telBuch.put(name, telNr);
    			System.out.println(name+ " " +telNr);
    		}else
    			telBuch.put(name + " " + zusatz, telNr);
    	}else{
    		JOptionPane.showMessageDialog(myFrame, "Data ist schon im TelefonBuch gespeichert");

    			}
        return true; 
    }

    public boolean remove(String name, String zusatz) {
    	
    	String key;
    	
    	if(zusatz.equals("")){
    		key = name;
    		if(telBuch.containsKey(key)){
    			telBuch.remove(key);
    			return true;
    		}else
    			return false;
    		
    	} else
    		key = name + "" + zusatz;
    		if(telBuch.containsKey(key)){
    			telBuch.remove(key);
    			return true;
    		} else 
    			return false;
    }


    public String exactSearch(String name, String zusatz) {
    	String key;
    	
    	if (zusatz.equals(""))
    		key = name;
    	else
    		key = name + " " + zusatz;

    	if(telBuch.containsKey(key)){
    		return telBuch.get(key);
    	} else
    		return null;
    }
    
    public List<String> prefixSearch(final String s){
    	LinkedList<String> list = new LinkedList<String>();
    	
    	if(s.length() > 0){
    		Set<Map.Entry<String, String>> set = telBuch.entrySet();
    		for(Map.Entry<String, String> me : set){
    			if(me.getKey().startsWith(s)){
    				list.add(me.getKey() + " " + me.getValue());
    			}
    		}
    				
    	}
    	
    	return list;
    	
    }

    public void read(File f) {
        LineNumberReader in = null;
        try {
            telBuch.clear();
            in = new LineNumberReader(new FileReader(f));
            String line;
            while ((line = in.readLine()) != null) {
                String[] sf = line.split(" ");
                if (sf.length == 2) {
                    insert(sf[0], "", sf[1]); // leerer Zusatz
                } else if (sf.length == 3) {
                    insert(sf[0], sf[1], sf[2]);
                }
            }
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(TelefonBuch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(File f) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(f);
            for (Entry<String, String> eintrag : telBuch.entrySet()) {
                String s = eintrag.getKey().replace('#', ' ') + " " + eintrag.getValue();
                out.println(s);
            }
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(TelefonBuch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
