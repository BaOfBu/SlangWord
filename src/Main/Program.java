package Main;

import controller.SidebarController;
import view.HomepageView;
import view.SidebarView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class Program {
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(()->new HomepageView().setVisible(true));
    }
}
