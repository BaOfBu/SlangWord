package controller;

import view.SidebarView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SidebarController implements MouseListener {
    private static String[] title = {"Search by keyword","Search by definition",
            "view history", "add", "edit", "delete", "reset", "random",
            "random keyword", "random definition"};
    @Override
    public void mouseClicked(MouseEvent e) {
        String event = e.getComponent().getName();
        switch (event){
            case("Search by keyword"):{

                break;
            }
            case("Search by definition"):{

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
