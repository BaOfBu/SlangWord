package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchKeyword extends JPanel {
    private String searchWord = null;
    private String[] columns = {"No.","Keyword","Definition"};
    public SearchKeyword(){
        setLayout(new BorderLayout());

        // add credit
        add(addTitle(),BorderLayout.NORTH);

        // search
        JPanel center = new JPanel();
        center.setBorder(BorderFactory.createLineBorder(Color.black));
        center.add(addSearch());
        center.add(addResult());
        add(center,BorderLayout.CENTER);
    }

    private JPanel addTitle(){
        JPanel credit = new JPanel();
        String text = "Search by keyword";
        credit.setName(text);
        JLabel jlabel = new JLabel(text);
        jlabel.setFont(new Font("Verdana", Font.BOLD,25));
        credit.add(jlabel);
        return credit;
    }

    private JPanel addSearch(){
        JPanel search = new JPanel(new FlowLayout());
        JTextField textField = new JTextField(32);
        JButton buttonSearch = new JButton("Search");
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Search")) {
                    // set the text of the label to the text of the field
                    searchWord = textField.getText();

                    // set the text of field to blank
                    textField.setText("");
                }
            }
        });
        search.add(textField);
        search.add(buttonSearch);
        return search;
    }

    private JTable addResult(){
        JTable result = new JTable(null,columns);
        return result;
    }
}
