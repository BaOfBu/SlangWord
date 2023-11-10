package view;

import Main.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSuccessfulPopup{
    JFrame frame = new JFrame();
    public AddSuccessfulPopup(){
        JPanel UltimateContainer = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Add successfully",SwingConstants.CENTER);
        UltimateContainer.add(label,BorderLayout.NORTH);
        JPanel containerCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setName("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Confirm")){
                    frame.dispose();
                }
            }
        });
        containerCenter.add(confirmButton);
        UltimateContainer.add(containerCenter,BorderLayout.CENTER);
        frame.getContentPane().add(UltimateContainer);
        frame.pack();
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
