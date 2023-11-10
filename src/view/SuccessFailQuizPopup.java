package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuccessFailQuizPopup {
    JFrame frame = new JFrame();
    public SuccessFailQuizPopup(String text){
        JPanel UltimateContainer = new JPanel(new BorderLayout());
        JLabel label = new JLabel(text,SwingConstants.CENTER);
        UltimateContainer.add(label,BorderLayout.NORTH);
        JPanel containerCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton confirmButton = new JButton("Continue");
        confirmButton.setName("Continue");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Continue")){
                    frame.dispose();
                }
            }
        });
        containerCenter.add(confirmButton);
        UltimateContainer.add(containerCenter,BorderLayout.CENTER);
        frame.getContentPane().add(UltimateContainer);
        frame.pack();
        frame.setSize(300,150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
