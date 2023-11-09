package Main;

import view.HomepageView;
import view.SidebarFrame;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Program {
    public static HashMap<String,String> dictionary = new HashMap<String,String>();
    public static HashMap<String,String> orgDictionary = new HashMap<String,String>();
    public static List<String> history = new ArrayList<String>();
    private static void ReadFile() throws Exception{
        BufferedReader fout = new BufferedReader(new FileReader(new File("resources/slang.txt")));
        fout.readLine(); // columns' name
        String line;
        while ((line = fout.readLine()) != null) {
            String[] values = line.split("`");
            dictionary.put(values[0],values[1]);
        }
        orgDictionary = (HashMap<String, String>) dictionary.clone();
        fout.close();
    }
    public static void main(String[] args) throws Exception {
        ReadFile();
        System.out.println(dictionary.size());
        SwingUtilities.invokeLater(()->new SidebarFrame(new HomepageView()).setVisible(true));
    }
}
