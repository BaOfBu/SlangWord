package view;

import Main.Program;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HistoryView extends JPanel{
    JTable result = new JTable(5,3);
    private String[][] datas = new String[][]{};
    private String[] columns = {"No.","Keyword","Definition"};
    private void setTableSize(){
        result.setFillsViewportHeight(true);
        result.setAutoResizeMode(5);
        result.setRowHeight(40);
        result.setFont(new Font("Serif", Font.BOLD, 20));
    }
    public HistoryView(){
        setLayout(new BorderLayout());
        setTableSize();

        // add credit
        add(addTitle(),BorderLayout.NORTH);

        // search
        JPanel container = new JPanel();
        container.setSize(700,700);
        container.setLayout(new BoxLayout(container,BoxLayout.PAGE_AXIS));
        container.setBorder(BorderFactory.createLineBorder(Color.black));
        container.add(addResult());
        add(container,BorderLayout.CENTER);
    }

    private JPanel addTitle(){
        JPanel title = new JPanel();
        String text = "HISTORY";
        title.setName(text);
        JLabel jlabel = new JLabel(text);
        jlabel.setFont(new Font("Verdana", Font.BOLD,25));
        title.setSize(700,100);
        title.add(jlabel);
        return title;
    }

    private void setDatas(){
        List<String> history = Program.history;
        datas = new String[history.size()][3];
        for(int i = 0; i < history.size(); i++){
            datas[i] = new String[]{Integer.toString(i+1), history.get(i), String.join(", ",Program.dictionary.get(history.get(i)))};
        }
    }

    private JPanel addResult(){
        JPanel panel = new JPanel(new BorderLayout());

        result.getColumnModel().getColumn(0).setPreferredWidth(100);
        result.getColumnModel().getColumn(0).setHeaderValue(columns[0]);
        result.getColumnModel().getColumn(1).setHeaderValue(columns[1]);
        result.getColumnModel().getColumn(2).setHeaderValue(columns[2]);

        setDatas();
        result.setModel(new DefaultTableModel(datas,columns));

        panel.add(new JScrollPane(result),BorderLayout.CENTER);
        panel.setSize(700,500);
        return panel;
    }
}
