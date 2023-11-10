package view;

import Main.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SidebarFrame extends JFrame {

    private static JFrame sidebarFrame = null; // singleton
    private static JPanel content = null;
    public SidebarFrame(JPanel ContentReplace){
        setUp(ContentReplace);
    }
    private void setUp(JPanel ContentReplace){
        if(sidebarFrame == null) {
            //Create and set up the window.
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //add sidebar
            SidebarView sidebar = new SidebarView();
            add(sidebar, BorderLayout.WEST);

            if(content == null) {
                content = ContentReplace;
                add(content, BorderLayout.CENTER);
            }
            //Display the window.
            sidebarFrame = this;
            pack();
            setSize(1000,800);
            setLocationRelativeTo(null);
            setVisible(true);


            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    try {
                        BufferedWriter fout = new BufferedWriter(new FileWriter(new File("./resources/newSlangword.txt")));
                        fout.write("KEY`VALUE");
                        fout.newLine();
                        Program.dictionary.forEach(
                                (key, value) ->
                                {
                                    String definition = "";
                                    String prefix = "";
                                    for(String element:value){
                                        definition = definition + prefix;
                                        prefix = "|";
                                        definition = definition + element;
                                    }
                                    try {
                                        fout.write(key + "`" + definition);
                                        fout.newLine();
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                });
                        fout.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        BufferedWriter fout = new BufferedWriter(new FileWriter(new File("./resources/history.txt")));
                        for(String item:Program.history){
                            fout.write(item);
                            fout.newLine();
                        }
                        fout.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    super.windowClosing(e);
                }
            });
        }
    }
    public static JFrame getInstance(JPanel ContentReplace){
        sidebarFrame.getContentPane().removeAll();
        sidebarFrame.getContentPane().setLayout(new BorderLayout());
        SidebarView sidebar = new SidebarView();
        sidebarFrame.getContentPane().add(sidebar, BorderLayout.WEST);
        sidebarFrame.getContentPane().add(ContentReplace);
        sidebarFrame.revalidate();
        sidebarFrame.repaint();
        return sidebarFrame;
    }
}
