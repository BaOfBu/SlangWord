package view;

import Main.Program;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public class RandomQuizDefinitionView extends JPanel {
    private String randomDefinition = "CS";
    private String realAnswer = null;
    List<String> answers = List.of(new String[]{"A", "B", "C", "D"});
    List<String> keyList;

    JButton[] buttons = null;
    public RandomQuizDefinitionView(){
        buttons = new JButton[4];
        for(int i = 0; i<4;i++){
            buttons[i] = new JButton(answers.get(i));
        }
        HashMap<String, List<String>> map = Program.dictionary;
        Set<String> keySet = map.keySet();
        keyList = new ArrayList<>(keySet);
        setLayout(new BorderLayout());

        // add title
        add(addTitle(),BorderLayout.NORTH);

        // random word quiz
        JPanel container = new JPanel();
        container.setSize(700,700);
        container.setLayout(new BoxLayout(container,BoxLayout.PAGE_AXIS));
        container.setBorder(BorderFactory.createLineBorder(Color.black));
        container.add(addKeyword());
        container.add(addAnswer());
        add(container,BorderLayout.CENTER);
    }

    private void randomInit(){
        int size = keyList.size();
        int randIdx = new Random().nextInt(size);
        realAnswer = keyList.get(randIdx);
        randomDefinition = Program.dictionary.get(realAnswer).get(0);
    }
    private void initAnswer(){
        int size = keyList.size();
        answers = new ArrayList<>();
        while(answers.size()<3){
            String randomTemp = keyList.get(new Random().nextInt(size));
            if(!randomDefinition.equals(randomTemp)){
                answers.add(randomTemp);
            }
        }
        answers.add(realAnswer);
        Collections.shuffle(answers);
        for(int i = 0 ; i<4 ; i++){
            buttons[i].setText(answers.get(i));
            buttons[i].setName(answers.get(i));
        }
    }

    private JPanel addTitle(){
        JPanel title = new JPanel();
        String text = "RANDOM QUIZ DEFINITION";
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
        label.setForeground(new Color(238, 78, 52));
        label.setFont(new Font("Verdana", Font.BOLD,18));
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("RANDOM")) {
                    randomInit();
                    initAnswer();
                    label.setText(randomDefinition);
                }
            }
        });
        container.add(label);
        container.add(randomButton);
        container.setPreferredSize(new Dimension(700,100));
        return container;
    }

    private JPanel addAnswer(){
        JPanel result = new JPanel(new BorderLayout());
        JPanel container = new JPanel(new GridLayout(2,2));
        for(int i = 0; i<4 ; i++){
            String text = answers.get(i);
            System.out.println(text);
            JButton button = buttons[i];
            button.setText(text);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = e.getActionCommand();
                    if (s.equals(realAnswer)) {
                        SuccessFailQuizPopup temp = new SuccessFailQuizPopup("RIGHT ANSWER");
                    }
                    else{
                        SuccessFailQuizPopup temp = new SuccessFailQuizPopup("WRONG ANSWER");
                    }
//                    randomInit();
//                    initAnswer();
                }
            });
            button.setName(text);
            button.setFont(new Font("Verdana", Font.BOLD,18));
            container.add(button);
        }
        container.setPreferredSize(new Dimension(700,400));
        result.add(container,BorderLayout.CENTER);
        result.setPreferredSize(new Dimension(700,400));
        return result;
    }
}
