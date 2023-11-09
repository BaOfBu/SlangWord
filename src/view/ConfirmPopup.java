package view;

import Main.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmPopup{
    JFrame frame = new JFrame();
    public ConfirmPopup(String searchWord){
        JPanel UltimateContainer = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Do you want to delete this word ?");
        UltimateContainer.add(label,BorderLayout.NORTH);
        JPanel containerCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setName("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Confirm")){
                    Program.dictionary.remove(searchWord);
                    frame.dispose();
                }
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setName("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Cancel")){
                    frame.dispose();
                }
            }
        });
        containerCenter.add(cancelButton);
        containerCenter.add(confirmButton);
        UltimateContainer.add(containerCenter,BorderLayout.CENTER);
        frame.getContentPane().add(UltimateContainer);
        frame.pack();
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
