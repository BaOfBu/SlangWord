package controller;

import view.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SidebarController implements MouseListener {
    private static String[] title = {"SLANG DICTIONARY","SEARCH BY KEYWORD","SEARCH BY DEFINITION",
            "VIEW HISTORY", "ADD", "EDIT", "DELETE", "RESET", "RANDOM",
            "RANDOM KEYWORD", "RANDOM DEFINITION"};
    @Override
    public void mouseClicked(MouseEvent e) {
        String event = e.getComponent().getName();
        switch (event){
            case("SLANG DICTIONARY"):{
                SidebarFrame frame = (SidebarFrame) SidebarFrame.getInstance(new HomepageView());
                break;
            }
            case("SEARCH BY KEYWORD"):{
                SidebarFrame frame = (SidebarFrame) SidebarFrame.getInstance(new SearchKeywordView());
                break;
            }
            case("SEARCH BY DEFINITION"):{
                SidebarFrame frame = (SidebarFrame) SidebarFrame.getInstance(new DefinitionSearchView());
                break;
            }
            case("VIEW HISTORY"):{
                SidebarFrame frame = (SidebarFrame) SidebarFrame.getInstance(new HistoryView());
                break;
            }
            case("ADD"):{
                SidebarFrame frame = (SidebarFrame) SidebarFrame.getInstance(new AddView());
                break;
            }
            case("EDIT"):{
                SidebarFrame frame = (SidebarFrame) SidebarFrame.getInstance(new EditView());
                break;
            }
            case("DELETE"):{
                SidebarFrame frame = (SidebarFrame) SidebarFrame.getInstance(new DeleteView());
                break;
            }
            case("RESET"):{
                SidebarFrame frame = (SidebarFrame) SidebarFrame.getInstance(new ResetView());
                break;
            }
            case("RANDOM"):{
                SidebarFrame frame = (SidebarFrame) SidebarFrame.getInstance(new RandomView());
                break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
