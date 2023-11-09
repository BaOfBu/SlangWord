package view;

import Main.Program;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ResetView extends JPanel {

    public ResetView(){
        setLayout(new BorderLayout());

        // add credit
        add(addTitle(),BorderLayout.NORTH);

        // search
        JPanel container = new JPanel();
        container.setSize(700,700);
        container.setLayout(new BoxLayout(container,BoxLayout.PAGE_AXIS));
        container.setBorder(BorderFactory.createLineBorder(Color.black));
        container.add(addReset());
        add(container,BorderLayout.CENTER);
    }

    private JPanel addTitle(){
        JPanel title = new JPanel();
        String text = "Reset Dictionary";
        title.setName(text);
        JLabel jlabel = new JLabel(text);
        jlabel.setFont(new Font("Verdana", Font.BOLD,25));
        title.setSize(700,100);
        title.add(jlabel);
        return title;
    }
    private JPanel addReset(){
        JPanel search = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton buttonReset = new JButton("Reset");
        buttonReset.setSize(150,100);
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Reset")) {
                    Program.dictionary = (HashMap<String, String>) Program.orgDictionary.clone();
                }
            }
        });
        search.add(buttonReset);

        return search;
    }
}
