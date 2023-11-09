package Main;

import controller.SidebarController;
import view.HomepageView;
import view.SidebarFrame;
import view.SidebarView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class Program {
    public static HashMap<String,String> dictionary = new HashMap<String,String>();
    public Program() throws Exception{
        BufferedReader fout = new BufferedReader(new FileReader(new File("slang.txt")));
        fout.readLine(); // columns' name
        String line;
        while ((line = fout.readLine()) != null) {
            String[] values = line.split("`");
            dictionary.put(values[0],values[1]);
        }
        fout.close();
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(()->new SidebarFrame(new HomepageView()).setVisible(true));
    }
}
