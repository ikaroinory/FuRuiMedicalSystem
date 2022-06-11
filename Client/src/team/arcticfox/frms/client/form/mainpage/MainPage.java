/*
 * Created by JFormDesigner on Mon May 23 20:17:08 CST 2022
 */

package team.arcticfox.frms.client.form.mainpage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;

import net.miginfocom.swing.*;
import team.arcticfox.frms.client.environment.Environment;
import team.arcticfox.frms.client.function.Account;
import team.arcticfox.frms.data.ShoppingItem;

/**
 * @author IkaroInory
 */
public class MainPage extends JFrame {
    public MainPage() {
        initComponents();

        EventHandler.initialize(this);
    }

    private void menuItemExitActionListener(ActionEvent e) {
        EventHandler.exit();
    }

    private void menuItemRegisterActionListener(ActionEvent e) {
        EventHandler.showRegisterForm();
    }

    private void menuItemSignInActionListener(ActionEvent e) {
        EventHandler.showSignInForm();
    }

    private void menuItemAboutActionListener(ActionEvent e) {
        EventHandler.showAboutForm(this);
    }

    private void menuItemSignOutActionListener(ActionEvent e) {
        signOutInitialize();
    }

    private void buttonRefreshActionListener(ActionEvent e) {
        EventHandler.refresh(this);
    }

    private void buttonViewDetailsActionListener(ActionEvent e) {
        EventHandler.showView(this);
    }

    private void tableMedicineListKeyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER)
            EventHandler.showView(this);
    }

    private void thisWindowClosed(WindowEvent e) {
        Environment.exit(0);
    }

    private void buttonAddToCartActionListener(ActionEvent e) {
        EventHandler.addToCart(this);
    }

    private void buttonViewCartActionListener(ActionEvent e) {
        EventHandler.showCart();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar = new JMenuBar();
        menuFile = new JMenu();
        menuItemSettings = new JMenuItem();
        menuItemExit = new JMenuItem();
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
        labelWelcomeTitleVisit = new JLabel();
        labelWelcomeContentVisit = new JLabel();
        panelWelcome = new JPanel();
        labelWelcomeTitle = new JLabel();
        labelWelcomeContent = new JLabel();
        panelMedicineList = new JPanel();
        scrollPaneMedicineList = new JScrollPane();
        tableMedicineList = new JTable();
        panelButton = new JPanel();
        buttonRefresh = new JButton();
        buttonViewDetails = new JButton();
        buttonAddToCart = new JButton();
        buttonViewCart = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("Main Page - FuRui Medical System");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[220!,fill]" +
                        "[1100:1100,fill]",
                // rows
                "[590:590,fill]"));

        //======== menuBar ========
        {

            //======== menuFile ========
            {
                menuFile.setText("File");
                menuFile.setMnemonic('F');

                //---- menuItemSettings ----
                menuItemSettings.setText("Settings");
                menuItemSettings.setMnemonic('T');
                menuItemSettings.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.ALT_DOWN_MASK));
                menuFile.add(menuItemSettings);

                //---- menuItemExit ----
                menuItemExit.setText("Exit");
                menuItemExit.setMnemonic('X');
                menuItemExit.addActionListener(e -> menuItemExitActionListener(e));
                menuFile.add(menuItemExit);
            }
            menuBar.add(menuFile);

            //======== menuAccount ========
            {
                menuAccount.setText("Account");
                menuAccount.setMnemonic('A');

                //---- menuItemRegister ----
                menuItemRegister.setText("Register");
                menuItemRegister.addActionListener(e -> menuItemRegisterActionListener(e));
                menuAccount.add(menuItemRegister);
                menuAccount.addSeparator();

                //---- menuItemSignIn ----
                menuItemSignIn.setText("Sign In");
                menuItemSignIn.addActionListener(e -> menuItemSignInActionListener(e));
                menuAccount.add(menuItemSignIn);

                //---- menuItemSignOut ----
                menuItemSignOut.setText("Sign Out");
                menuItemSignOut.setEnabled(false);
                menuItemSignOut.addActionListener(e -> menuItemSignOutActionListener(e));
                menuAccount.add(menuItemSignOut);
            }
            menuBar.add(menuAccount);

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
                menuItemAbout.addActionListener(e -> menuItemAboutActionListener(e));
                menuHelp.add(menuItemAbout);
            }
            menuBar.add(menuHelp);
        }
        setJMenuBar(menuBar);

        //======== scrollPaneTree ========
        {

            //---- tree1 ----
            tree1.setModel(new DefaultTreeModel(
                    new DefaultMutableTreeNode("FuRui Medical System") {
                        {
                            add(new DefaultMutableTreeNode("Home Page"));
                            DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("FuRui Medical Database");
                            node1.add(new DefaultMutableTreeNode("Drugs"));
                            node1.add(new DefaultMutableTreeNode("Rx"));
                            node1.add(new DefaultMutableTreeNode("OTC"));
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

                //---- labelWelcomeTitleVisit ----
                labelWelcomeTitleVisit.setText("Welcome!");
                labelWelcomeTitleVisit.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 36));
                panelWelcomeVisit.add(labelWelcomeTitleVisit, "cell 0 0");

                //---- labelWelcomeContentVisit ----
                labelWelcomeContentVisit.setText("<html>\n    Welcome to FuRui Medical System! Please Sign in first.<br/>\n    <br/>\n    No account?<br/>\n    Click <b style=\"color:red\">Account - Register</b> at the top of the window to register your account.<br/>\n</html>");
                panelWelcomeVisit.add(labelWelcomeContentVisit, "cell 0 1");
            }
            tabbedPane.addTab("Welcome Page", panelWelcomeVisit);

            //======== panelWelcome ========
            {
                panelWelcome.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[1035:1035,fill]",
                        // rows
                        "[70:70,fill]" +
                                "[453:453,top]"));

                //---- labelWelcomeTitle ----
                labelWelcomeTitle.setText("Welcome!");
                labelWelcomeTitle.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 36));
                panelWelcome.add(labelWelcomeTitle, "cell 0 0");

                //---- labelWelcomeContent ----
                labelWelcomeContent.setText("<html>\n    Welcome to FuRui Medical System, <b style=\"color:red\">%username%</b>!<br/>\n</html>");
                panelWelcome.add(labelWelcomeContent, "cell 0 1");
            }
            tabbedPane.addTab("Welcome Page", panelWelcome);

            //======== panelMedicineList ========
            {
                panelMedicineList.setLayout(new MigLayout(
                        "hidemode 3",
                        // columns
                        "[1048:1048,fill]",
                        // rows
                        "[500:500,fill]" +
                                "[41:41,fill]"));

                //======== scrollPaneMedicineList ========
                {

                    //---- tableMedicineList ----
                    tableMedicineList.setModel(new DefaultTableModel(
                            new Object[][]{
                                    {null, null, null, null, null, null, null},
                            },
                            new String[]{
                                    "Id", "Medicine Name", "Approval No", "Manufacturer", "Type", "Price", "Amount"
                            }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[]{
                                Integer.class, String.class, String.class, String.class, String.class, Double.class, Integer.class
                        };
                        boolean[] columnEditable = new boolean[]{
                                false, false, false, false, false, false, false
                        };

                        @Override
                        public Class<?> getColumnClass(int columnIndex) {
                            return columnTypes[columnIndex];
                        }

                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    {
                        TableColumnModel cm = tableMedicineList.getColumnModel();
                        cm.getColumn(0).setResizable(false);
                        cm.getColumn(0).setMinWidth(45);
                        cm.getColumn(0).setMaxWidth(45);
                        cm.getColumn(0).setPreferredWidth(45);
                        cm.getColumn(2).setMinWidth(135);
                        cm.getColumn(2).setMaxWidth(135);
                        cm.getColumn(2).setPreferredWidth(135);
                        cm.getColumn(4).setResizable(false);
                        cm.getColumn(4).setMinWidth(80);
                        cm.getColumn(4).setMaxWidth(80);
                        cm.getColumn(4).setPreferredWidth(80);
                        cm.getColumn(5).setMinWidth(100);
                        cm.getColumn(5).setMaxWidth(100);
                        cm.getColumn(5).setPreferredWidth(100);
                        cm.getColumn(6).setMinWidth(100);
                        cm.getColumn(6).setMaxWidth(100);
                        cm.getColumn(6).setPreferredWidth(100);
                    }
                    tableMedicineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    tableMedicineList.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            tableMedicineListKeyPressed(e);
                        }
                    });
                    scrollPaneMedicineList.setViewportView(tableMedicineList);
                }
                panelMedicineList.add(scrollPaneMedicineList, "cell 0 0");

                //======== panelButton ========
                {
                    panelButton.setLayout(new FlowLayout());

                    //---- buttonRefresh ----
                    buttonRefresh.setText("Refresh");
                    buttonRefresh.addActionListener(e -> buttonRefreshActionListener(e));
                    panelButton.add(buttonRefresh);

                    //---- buttonViewDetails ----
                    buttonViewDetails.setText("View Details");
                    buttonViewDetails.addActionListener(e -> buttonViewDetailsActionListener(e));
                    panelButton.add(buttonViewDetails);

                    //---- buttonAddToCart ----
                    buttonAddToCart.setText("Add To Cart");
                    buttonAddToCart.addActionListener(e -> buttonAddToCartActionListener(e));
                    panelButton.add(buttonAddToCart);

                    //---- buttonViewCart ----
                    buttonViewCart.setText("View Cart");
                    buttonViewCart.addActionListener(e -> buttonViewCartActionListener(e));
                    panelButton.add(buttonViewCart);
                }
                panelMedicineList.add(panelButton, "cell 0 1");
            }
            tabbedPane.addTab("Medicine List", panelMedicineList);
        }
        contentPane.add(tabbedPane, "cell 1 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem menuItemSettings;
    private JMenuItem menuItemExit;
    private JMenu menuAccount;
    private JMenuItem menuItemRegister;
    private JMenuItem menuItemSignIn;
    private JMenuItem menuItemSignOut;
    private JMenu menuHelp;
    private JMenuItem menuItemCheckUpdate;
    private JMenuItem menuItemAbout;
    private JScrollPane scrollPaneTree;
    private JTree tree1;
    JTabbedPane tabbedPane;
    JPanel panelWelcomeVisit;
    private JLabel labelWelcomeTitleVisit;
    private JLabel labelWelcomeContentVisit;
    JPanel panelWelcome;
    private JLabel labelWelcomeTitle;
    private JLabel labelWelcomeContent;
    private JPanel panelMedicineList;
    private JScrollPane scrollPaneMedicineList;
    JTable tableMedicineList;
    private JPanel panelButton;
    private JButton buttonRefresh;
    private JButton buttonViewDetails;
    private JButton buttonAddToCart;
    private JButton buttonViewCart;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void signInInitialize() {
        menuItemSignIn.setEnabled(false);
        menuItemSignOut.setEnabled(true);

        tabbedPane.removeAll();
        tabbedPane.addTab("Welcome Page", panelWelcome);
        tabbedPane.add("Medicine List", panelMedicineList);

        labelWelcomeContent.setText(labelWelcomeContent.getText().replaceAll("%username%", Environment.accountInfo.username));

        EventHandler.refresh(this);
    }

    public void signOutInitialize() {
        Account.signOut();

        menuItemSignIn.setEnabled(true);
        menuItemSignOut.setEnabled(false);

        tabbedPane.removeAll();
        tabbedPane.add("Welcome Page", panelWelcomeVisit);
    }
}
