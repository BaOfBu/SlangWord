package Main;

import view.HomepageView;
import view.SidebarFrame;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Program {
    public static HashMap<String,List<String>> dictionary = new HashMap<>();
    //public static HashMap<String,List<String>> orgDictionary = new HashMap<>();
    public static List<String> history = new ArrayList<String>();
    private static void ReadFile() throws Exception{
        File f = new File("./resources/newSlangword.txt");
        String pathname = "./resources/slang.txt";
        if(f.exists() && !f.isDirectory()) {
//            System.out.println("tồn tại");
            pathname = "./resources/newSlangword.txt";
        }
        BufferedReader fout = new BufferedReader(new FileReader(new File(pathname)));
        fout.readLine(); // columns' name
        String line;
        while (!((line = fout.readLine()) == null)) {
            String[] values = line.split("`");
            List<String> temp = new ArrayList<String>(Arrays.asList(values[1].split("\\s*\\|\\s*")));

            List<String> definition = new ArrayList<>();
            definition.addAll(temp);
            dictionary.put(values[0], definition);
        }
        fout.close();

        //read history
        f = new File("./resources/history.txt");
        pathname = "./resources/history.txt";
        if(f.exists() && !f.isDirectory()) {
            fout = new BufferedReader(new FileReader(new File(pathname)));
            while (!((line = fout.readLine()) == null)) {
                history.add(line);
            }
            fout.close();
        }
    }

    public static void ResetDictionary() throws Exception{
        String pathname = "./resources/slang.txt";
        dictionary = new HashMap<>();
        BufferedReader fout = new BufferedReader(new FileReader(new File(pathname)));
        fout.readLine(); // columns' name
        String line;
        while (!((line = fout.readLine()) == null)) {
            String[] values = line.split("`");
            List<String> temp = new ArrayList<String>(Arrays.asList(values[1].split("\\s*\\|\\s*")));

            List<String> definition = new ArrayList<>();
            definition.addAll(temp);
            dictionary.put(values[0], definition);
        }
        //orgDictionary = (HashMap<String, List<String>>) dictionary.clone();
        fout.close();
    }

    public static void main(String[] args) throws Exception {
        ReadFile();
        //System.out.println(dictionary.size());
        SwingUtilities.invokeLater(()->new SidebarFrame(new HomepageView()).setVisible(true));
    }
}
