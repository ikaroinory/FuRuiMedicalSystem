/*
 * Created by JFormDesigner on Mon May 23 20:17:08 CST 2022
 */

package team.arcticfox.frms.form.mainpage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import net.miginfocom.swing.*;

/**
 * @author IkaroInory
 */
public class MainPage extends JFrame {
    public MainPage() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menuFile = new JMenu();
        menuItem1 = new JMenuItem();
        menuAccount = new JMenu();
        menuItemRegister = new JMenuItem();
        menuItemSignIn = new JMenuItem();
        menuItemSignOut = new JMenuItem();
        menuHelp = new JMenu();
        menuItemCheckUpdate = new JMenuItem();
        menuItemAbout = new JMenuItem();
        scrollPaneTree = new JScrollPane();
        tree1 = new JTree();
        tabbedPane = new JTabbedPane();
        panelWelcomeVisit = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setVisible(true);
        setTitle("Main Page - FuRui Medical System");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[220!,fill]" +
            "[1048:1048,fill]",
            // rows
            "[590:590,fill]"));

        //======== menuBar1 ========
        {

            //======== menuFile ========
            {
                menuFile.setText("File");
                menuFile.setMnemonic('F');

                //---- menuItem1 ----
                menuItem1.setText("Exit");
                menuItem1.setMnemonic('X');
                menuFile.add(menuItem1);
            }
            menuBar1.add(menuFile);

            //======== menuAccount ========
            {
                menuAccount.setText("Account");
                menuAccount.setMnemonic('A');

                //---- menuItemRegister ----
                menuItemRegister.setText("Register");
                menuAccount.add(menuItemRegister);
                menuAccount.addSeparator();

                //---- menuItemSignIn ----
                menuItemSignIn.setText("Sign In");
                menuAccount.add(menuItemSignIn);

                //---- menuItemSignOut ----
                menuItemSignOut.setText("Sign Out");
                menuItemSignOut.setEnabled(false);
                menuAccount.add(menuItemSignOut);
            }
            menuBar1.add(menuAccount);

            //======== menuHelp ========
            {
                menuHelp.setText("Help");
                menuHelp.setMnemonic('H');

                //---- menuItemCheckUpdate ----
                menuItemCheckUpdate.setText("Check Update");
                menuHelp.add(menuItemCheckUpdate);
                menuHelp.addSeparator();

                //---- menuItemAbout ----
                menuItemAbout.setText("About");
                menuItemAbout.setMnemonic('A');
                menuHelp.add(menuItemAbout);
            }
            menuBar1.add(menuHelp);
        }
        setJMenuBar(menuBar1);

        //======== scrollPaneTree ========
        {

            //---- tree1 ----
            tree1.setModel(new DefaultTreeModel(
                new DefaultMutableTreeNode("FuRui Medical System") {
                    {
                        add(new DefaultMutableTreeNode("Home Page"));
                        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("FuRui Medical Database");
                            node1.add(new DefaultMutableTreeNode("Drugs"));
                            node1.add(new DefaultMutableTreeNode("Medical Devices"));
                            node1.add(new DefaultMutableTreeNode("Others"));
                        add(node1);
                        node1 = new DefaultMutableTreeNode("Search Tools");
                            node1.add(new DefaultMutableTreeNode("Tools1"));
                            node1.add(new DefaultMutableTreeNode("Tools2"));
                        add(node1);
                    }
                }));
            scrollPaneTree.setViewportView(tree1);
        }
        contentPane.add(scrollPaneTree, "cell 0 0");

        //======== tabbedPane ========
        {

            //======== panelWelcomeVisit ========
            {
                panelWelcomeVisit.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[1035,fill]",
                    // rows
                    "[70:70,fill]" +
                    "[453:453,top]"));

                //---- label1 ----
                label1.setText("Welcome!");
                label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 36));
                panelWelcomeVisit.add(label1, "cell 0 0");

                //---- label2 ----
                label2.setText("<html>\n    Welcome to FuRui Medical System! Please Sign in first.<br/>\n    <br/>\n    No account?<br/>\n    Click <b style=\"color:red\">Account - Register</b> at the top of the window to register your account.<br/>\n</html>");
                panelWelcomeVisit.add(label2, "cell 0 1");
            }
            tabbedPane.addTab("Welcome Page", panelWelcomeVisit);
        }
        contentPane.add(tabbedPane, "cell 1 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menuFile;
    private JMenuItem menuItem1;
    private JMenu menuAccount;
    private JMenuItem menuItemRegister;
    private JMenuItem menuItemSignIn;
    private JMenuItem menuItemSignOut;
    private JMenu menuHelp;
    private JMenuItem menuItemCheckUpdate;
    private JMenuItem menuItemAbout;
    private JScrollPane scrollPaneTree;
    private JTree tree1;
    private JTabbedPane tabbedPane;
    private JPanel panelWelcomeVisit;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
