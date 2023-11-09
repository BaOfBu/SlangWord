package view;

import Main.Program;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchKeywordView extends JPanel {
    private String searchWord = null;
    private String[] columns = {"No.","Keyword","Definition"};
    private String[][] datas = new String[][]{};
    JTable result = new JTable(5,3);

    private void setTableSize(){
        result.setFillsViewportHeight(true);
        result.setAutoResizeMode(5);
        result.setRowHeight(40);
        result.setFont(new Font("Serif", Font.BOLD, 20));
    }
    public SearchKeywordView(){
        setLayout(new BorderLayout());
        setTableSize();

        // add credit
        add(addTitle(),BorderLayout.NORTH);

        // search
        JPanel container = new JPanel();
        container.setSize(700,700);
        container.setLayout(new BoxLayout(container,BoxLayout.PAGE_AXIS));
        container.setBorder(BorderFactory.createLineBorder(Color.black));
        container.add(addSearch());
        container.add(addResult());
        add(container,BorderLayout.CENTER);
    }

    private JPanel addTitle(){
        JPanel title = new JPanel();
        String text = "Search by keyword";
        title.setName(text);
        JLabel jlabel = new JLabel(text);
        jlabel.setFont(new Font("Verdana", Font.BOLD,25));
        title.setSize(700,100);
        title.add(jlabel);
        return title;
    }

    private boolean setDatas(){
        String definition = Program.dictionary.get(searchWord);
        if(definition == null){
            return false;
        }
        else{
            datas = new String[][]{{"1", searchWord, definition}};
            return true;
        }
    }
    private JPanel addSearch(){
        JPanel search = new JPanel(new FlowLayout());
        search.setSize(700,200);
        JTextField textField = new JTextField(32);
        textField.setFont(new Font("Serif", Font.BOLD, 20));
        JButton buttonSearch = new JButton("Search");
        buttonSearch.setSize(150,100);
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Search")) {
                    // set the text of the label to the text of the field
                    searchWord = textField.getText();
                    boolean flag = setDatas();
                    if(flag){
                        Program.history.addFirst(searchWord);
                        result.setModel(new DefaultTableModel(datas,columns));
                    }

                    // set the text of field to blank
                    textField.setText("");
                }
            }
        });
        search.add(textField);
        search.add(buttonSearch);

        return search;
    }

    private JPanel addResult(){
        JPanel panel = new JPanel(new BorderLayout());

        result.getColumnModel().getColumn(0).setPreferredWidth(100);
        result.getColumnModel().getColumn(0).setHeaderValue(columns[0]);
        result.getColumnModel().getColumn(1).setHeaderValue(columns[1]);
        result.getColumnModel().getColumn(2).setHeaderValue(columns[2]);

        String definition = Program.dictionary.get(searchWord);

        panel.add(new JScrollPane(result),BorderLayout.CENTER);
        panel.setSize(700,500);
        return panel;
    }
}
