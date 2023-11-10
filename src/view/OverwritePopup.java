package view;

import Main.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class OverwritePopup {
    JFrame frame = new JFrame();
    public OverwritePopup(String key,String value){
        JPanel UltimateContainer = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Overwrite or add more definition to existed word",SwingConstants.CENTER);
        UltimateContainer.add(label,BorderLayout.NORTH);
        JPanel containerCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //overwrite button
        JButton overwriteButton = new JButton("Overwrite");
        overwriteButton.setName("Overwrite");
        overwriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Overwrite")){
                    ArrayList<String> definition = new ArrayList<String>(
                            Arrays.asList(value));
                    Program.dictionary.replace(key,definition);
                    frame.dispose();
                }
            }
        });
        // Add to existed definition
        JButton addButton = new JButton("Add More");
        addButton.setName("Add More");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Add More")){
                    Program.dictionary.get(key).add(value);
                    frame.dispose();
                }
            }
        });
        containerCenter.add(addButton);
        containerCenter.add(overwriteButton);
        UltimateContainer.add(containerCenter,BorderLayout.CENTER);
        frame.getContentPane().add(UltimateContainer);
        frame.pack();
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
