package view;

import Main.Program;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddView extends JPanel {
    private boolean safe2add = false;
    private String searchWord = null;
    private String newDefinition = null;
    private String[] columns = {"No.","Keyword","Definition"};
    private String[][] datas = new String[][]{};
    JTable result = new JTable(5,3);

    private void setTableSize(){
        result.setFillsViewportHeight(true);
        result.setAutoResizeMode(5);
        result.setRowHeight(40);
        result.setFont(new Font("Serif", Font.BOLD, 20));
    }
    public AddView(){
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

        add(addAddButton(),BorderLayout.SOUTH);
    }

    private JPanel addTitle(){
        JPanel title = new JPanel();
        String text = "ADD SLANGWORD";
        title.setName(text);
        JLabel jlabel = new JLabel(text);
        jlabel.setFont(new Font("Verdana", Font.BOLD,25));
        title.setSize(700,100);
        title.add(jlabel);
        return title;
    }

    private boolean setDatas(){
        List<String> definition = Program.dictionary.get(searchWord);
        if(definition == null){
            return false;
        }
        else{
            datas = new String[definition.size()][3];
            for(int i = 0; i < definition.size() ; i++){
                datas[i] = new String[]{Integer.toString(i), searchWord, definition.get(i)};
            };
            return true;
        }
    }
    private JPanel addSearch(){
        JPanel search = new JPanel(new FlowLayout());
        search.setSize(700,200);
        JTextField textFieldKey = new JTextField(8);
        textFieldKey.setFont(new Font("Serif", Font.BOLD, 20));
        JTextField textFieldValue = new JTextField(24);
        textFieldValue.setFont(new Font("Serif", Font.BOLD, 20));
        JButton buttonSearch = new JButton("AddSlangword");
        buttonSearch.setSize(150,100);
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("AddSlangword")) {
                    // set the text of the label to the text of the field
                    searchWord = textFieldKey.getText();
                    newDefinition = textFieldValue.getText();
                    boolean flag = setDatas();
                    if(flag){
                        safe2add = false;
                        result.setModel(new DefaultTableModel(datas,columns));
                    }
                    else{
                        safe2add = true;
                        ArrayList<String> Definition = new ArrayList<String>(
                                Arrays.asList(newDefinition));
                        Program.dictionary.put(searchWord,Definition);
                        AddSuccessfulPopup temp = new AddSuccessfulPopup();
                        textFieldKey.setText("");
                        textFieldValue.setText("");
                    }

                    // set the text of field to blank

                }
            }
        });
        search.add(textFieldKey);
        search.add(textFieldValue);
        search.add(buttonSearch);

        return search;
    }

    private JPanel addResult(){
        JPanel panel = new JPanel(new BorderLayout());

        result.getColumnModel().getColumn(0).setPreferredWidth(100);
        result.getColumnModel().getColumn(0).setHeaderValue(columns[0]);
        result.getColumnModel().getColumn(1).setHeaderValue(columns[1]);
        result.getColumnModel().getColumn(2).setHeaderValue(columns[2]);

        panel.add(new JScrollPane(result),BorderLayout.CENTER);
        panel.setSize(700,200);
        return panel;
    }

    private JPanel addAddButton(){
        JPanel panel = new JPanel(new FlowLayout());

        JButton addButton = new JButton("Continue to add above word");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Continue to add above word")) {
                    if(safe2add){
                        ArrayList<String> strList = new ArrayList<String>(
                                Arrays.asList(newDefinition));
                        Program.dictionary.put(searchWord,strList);
                    }
                    else{
                        OverwritePopup temp = new OverwritePopup(searchWord,newDefinition);
                    }
                }
            }
        });
        panel.add(addButton);
        return panel;
    }

}
