package view;

import Main.Program;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class RandomQuizKeywordView extends JPanel {
    private String randomKeyword = null;
    List<String> keyList;
    public RandomQuizKeywordView(){
        HashMap<String, List<String>> map = Program.dictionary;
        Set<String> keySet = map.keySet();
        keyList = new ArrayList<>(keySet);
        setLayout(new BorderLayout());

        // add title
        add(addTitle(),BorderLayout.NORTH);

        // search
        JPanel container = new JPanel();
        container.setSize(700,700);
        container.setLayout(new BoxLayout(container,BoxLayout.PAGE_AXIS));
        container.setBorder(BorderFactory.createLineBorder(Color.black));
        container.add(addKeyword());
        //container.add(addAnswer());
        add(container,BorderLayout.CENTER);
    }

    private void randomInit(){
        int size = keyList.size();
        int randIdx = new Random().nextInt(size);
        randomKeyword = keyList.get(randIdx);
    }

    private JPanel addTitle(){
        JPanel title = new JPanel();
        String text = "RANDOM QUIZ KEYWORD";
        title.setName(text);
        JLabel jlabel = new JLabel(text);
        jlabel.setFont(new Font("Verdana", Font.BOLD,25));
        title.setSize(700,100);
        title.add(jlabel);
        return title;
    }

    private JPanel addKeyword(){
        JPanel container = new JPanel(new FlowLayout());
        JLabel label = new JLabel();
        JButton randomButton = new JButton("RANDOM");
        randomButton.setSize(150,100);
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("RANDOM")) {
                    randomInit();
                    label.setText(randomKeyword);
                }
            }
        });
        container.add(label);
        container.add(randomButton);
        return container;
    }
}
