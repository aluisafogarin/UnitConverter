package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import program.ConversionManagement;
import program.DynamicLoader;

public class ProgramWindow extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    // private BaseWindow baseWindow;
    private JPanel panelTop;
    private JPanel panelWest;
    private JPanel panelConvertFrom;
    private JPanel panelConvertTo;
    private JPanel panelEast;
    private JPanel panelBottom;
    private JLabel statusLabel;

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuHelp;
    private JMenu menuConfig;
    private JMenu menuLanguage;
    private JMenuItem menuItemDisclaimer;
    private JMenuItem menuItemClose;
    private JMenuItem menuItemHelp;
    private JMenuItem menuItemLangPT;
    private JMenuItem menuItemLangEN;
    private JMenuItem menuItemAbout;
    private JTextField inputValue;
    private JTextField outputValue;
    private JLabel labelConvertFrom;
    private JLabel labelConvertTo;
    private JLabel labelHeader;
    private JLabel labelBottom;
    private JComboBox fromUnitBox = new JComboBox<>();
    private JComboBox toUnitBox;

    ProgramWindow(String title) throws HeadlessException {
        super(title);
        setWindow();
        setMenus();
        setLayout();
        // defineFromUnitBox(DynamicLoader.getClassesNames());
        // setupBaseWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    private JMenu createMenu(String text, char shortcut) {
        JMenu object = new JMenu(text);
        object.setMnemonic(shortcut);
        return object;
    }

    private JMenuItem createMenuItem(String text, char shortcut) {
        JMenuItem object = new JMenuItem(text);
        object.setMnemonic(shortcut);
        return object;
    }

    private JMenuItem createMenuItem(String text) {
        JMenuItem object = new JMenuItem(text);
        return object;
    }

    private JTextField createTextField() {
        JTextField object = new JTextField(15);
        return object;
    }

    private JLabel createLabel(String text, int size) {
        JLabel object = new JLabel(text);
        object.setFont(new Font("Verdana", Font.PLAIN, size));
        return object;
    }

    private JPanel createPanel() {
        int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        JPanel object = new JPanel();
        object.setBorder(BorderFactory.createEtchedBorder());
        return object;
    }

    private JComboBox<String> createComboBox(ArrayList<String> items) {
        JComboBox<String> object = new JComboBox<String>();
        for (String item : items) {
            object.addItem(item);
        }
        return object;
    }

    public void exit() {
        System.exit(0);
    }

    public void start() {
        this.setVisible(true);
    }

    private void setWindow() {
        this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.5),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.5));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1));
    }

    private void setMenus() {

        menuFile = createMenu("File", 'F');
        menuHelp = createMenu("Help", 'H');
        menuConfig = createMenu("Config", 'C');
        menuLanguage = createMenu("Language", 'L');

        menuItemHelp = createMenuItem("Help", 'H');
        menuItemAbout = createMenuItem("About", 'A');
        menuItemDisclaimer = createMenuItem("Disclaimer", 'D');
        menuItemClose = createMenuItem("Exit", 'X');
        menuItemLangEN = createMenuItem("English");
        menuItemLangPT = createMenuItem("Português");

        menuFile.add(menuItemDisclaimer);
        menuFile.add(menuItemClose);

        menuConfig.add(menuLanguage);
        menuLanguage.add(menuItemLangEN);
        menuLanguage.add(menuItemLangPT);

        menuHelp.add(menuItemAbout);
        menuHelp.add(menuItemHelp);

        menuBar = new JMenuBar();
        menuBar.add(menuFile);
        menuBar.add(menuConfig);
        menuBar.add(menuHelp);

        this.setJMenuBar(menuBar);
    }

    private void setLayout() {
        setPanelTop();
        setConvertFromPanel();
        setConvertToPanel();
        setPanelBottom();
    }

    private void setPanelTop() {
        //setLayout(new BorderLayout());
    
        JPanel panelTop = createPanel();
        panelTop.setLayout(new FlowLayout());
        panelTop.setBackground(Color.GRAY);

        labelHeader = createLabel(Infos.systemName, 20);
        labelHeader.setHorizontalAlignment(SwingConstants.CENTER);
        panelTop.add(labelHeader);

        this.add(panelTop, BorderLayout.NORTH);
    }
/* 
    private void setCenterPanel() {
        JPanel panelCenter = createPanel();
        panelCenter.setLayout(new GridLayout(2,1)
    } */

    private void setConvertFromPanel() {
        JPanel panelConvertFrom = createPanel();
        panelConvertFrom.setBackground(Color.LIGHT_GRAY);
        panelConvertFrom.setLayout(new FlowLayout());

        labelConvertFrom = createLabel("Convert From", 16);
        inputValue = createTextField();
        fromUnitBox = createComboBox(DynamicLoader.getClassesNames());

        panelConvertFrom.add(labelConvertFrom);
        panelConvertFrom.add(inputValue);
        panelConvertFrom.add(fromUnitBox);

        this.add(panelConvertFrom, BorderLayout.CENTER);
    }

    private void setConvertToPanel() {
        JPanel panelConvertTo = createPanel();
        panelConvertTo.setBackground(Color.LIGHT_GRAY);
        panelConvertTo.setLayout(new FlowLayout());

        labelConvertTo = createLabel("To", 16);
        outputValue = createTextField();
        toUnitBox = createComboBox(ConversionManagement.getAvailableClasses());

        panelConvertTo.add(labelConvertTo);
        panelConvertTo.add(outputValue);
        panelConvertTo.add(toUnitBox);

        this.add(panelConvertTo, BorderLayout.CENTER);
    }

    private void setPanelBottom() {
        //setLayout(new BorderLayout());

        JPanel panelBottom = createPanel();
        panelBottom.setBackground(Color.GRAY);
        panelBottom.setLayout(new FlowLayout());

        labelBottom = createLabel("Bottom", 12);
        panelBottom.add(labelBottom);

        this.add(panelBottom, BorderLayout.SOUTH);
    }

}