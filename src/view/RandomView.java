package view;

import Main.Program;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class RandomView extends JPanel {
    private String randomWord = null;
    private List<String> keyList = null;

    private String[] columns = {"No.","Keyword","Definition"};
    private String[][] datas = new String[][]{};
    JTable result = new JTable(1,3);
    
    private void randomInit(){
        int size = keyList.size();
        int randIdx = new Random().nextInt(size);
        String randomWord = keyList.get(randIdx);
    }

    private void setTableSize(){
        result.setFillsViewportHeight(true);
        result.setAutoResizeMode(5);
        result.setRowHeight(40);
        result.setFont(new Font("Serif", Font.BOLD, 20));
    }
    public RandomView(){
        //set up for random
        HashMap<String, List<String>> map = Program.dictionary;
        Set<String> keySet = map.keySet();
        keyList = new ArrayList<>(keySet);

        setLayout(new BorderLayout());
        setTableSize();
        randomInit();

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
        List<String> definition = Program.dictionary.get(randomWord);
        if(definition == null){
            return false;
        }
        else{
            datas = new String[definition.size()][3];
            for(int i = 0; i < definition.size() ; i++){
                datas[i] = new String[]{Integer.toString(i+1), randomWord, definition.get(i)};
            };
            return true;
        }
    }
    private JPanel addSearch(){
        JPanel search = new JPanel(new FlowLayout());
        search.setSize(700,200);
        JButton buttonSearch = new JButton("Random");
        buttonSearch.setSize(150,100);
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Random")) {
                    // set the text of the label to the text of the field
                    randomInit();
                    boolean flag = setDatas();
                    if(flag){
                        result.setModel(new DefaultTableModel(datas,columns));
                    }
                    else{
                        CantFindWordPopup temp = new CantFindWordPopup(randomWord);
                    }
                }
            }
        });
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
        panel.setSize(700,500);
        return panel;
    }


}
