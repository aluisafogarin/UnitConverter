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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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

    private ComponentCreator componentCreator = new ComponentCreator();
    private JPanel panelTop;
    private JPanel panelTypeConversion;
    private JPanel panelConvertFrom;
    private JPanel panelConvertTo;
    private JPanel panelBottom;

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
    private JComboBox toUnitBox = new JComboBox<>();

    private String fromUnitClass;
    private String toUnitClass;
    private double value = 0;
    private double newValue = 0;

    ProgramWindow(String title) throws HeadlessException {
        super(title);
        setWindow();
        setMenus();
        bindMenus();
        setLayout();
        bindPanel();
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        // Menu item treatment
        if (event.getSource() == this.menuItemAbout) {
            System.out.println(event.getSource());
            System.out.println("CLICOU NO ABOUT");
        }
        if (event.getSource() == this.menuItemClose)
            exit();
        if (event.getSource() == this.menuItemDisclaimer) {
            System.out.println(event.getSource());
            System.out.println("CLICOU NO DISCLAIMER");
        }
        // if (actionEvent.getSource() == this.menuItemHelp);
        if (event.getSource() == this.menuItemLangEN)
            System.out.println("CLICOU NO EN");
        if (event.getSource() == this.menuItemLangPT)
            System.out.println("CLICOU NO PT");

        if (event.getSource() == this.inputValue) {
            this.value = (double) (Integer.parseInt(inputValue.getText()));
            verifyEntry();
            //int intValue = (int) newValue;
            outputValue.setText(String.valueOf(newValue));
            //System.out.println(intValue);
        }

        if (event.getSource() == this.fromUnitBox) {
            fromUnitClass = (fromUnitBox.getSelectedItem().toString());
            verifyEntry();
        }

        if (event.getSource() == this.toUnitBox) {
            toUnitClass = (toUnitBox.getSelectedItem().toString());
            verifyEntry();
        }
    }

    public void verifyEntry() {
        if (fromUnitClass != null && toUnitClass != null && value != 0) {
            try {
                ConversionManagement control = new ConversionManagement(fromUnitClass, toUnitClass);
                newValue = control.manager(value);
            } catch(InstantiationException e) {
                System.out.println("Error to instantiate object: " + e.getMessage());
            } 
            catch(ClassNotFoundException e) {
                System.out.println("Error to load " + e.getClass() + " : " + e.getMessage());
            } 
            catch(ClassCastException e) {
               System.out.println("Error during class cast process: " + e.getMessage());
            } 
            catch (IllegalAccessException e) {
                System.out.println("Illegal access: " + e.getMessage());
            }
        }
    }

    public void bindItems(ActionListener listener, JMenu menu) {
        for (Component c : menu.getMenuComponents()) {
            if (c instanceof JMenuItem) 
                ((JMenuItem) c).addActionListener(this);
        }
    }

    public void bindMenus() {
        for (Component c : this.getJMenuBar().getComponents()) {
            if (c instanceof JMenu) {
                bindItems(this, (JMenu) c);
            }
        }
    }

    public void bindItemsPanel(ActionListener listener, JPanel panel) {
        for (Component c : panel.getComponents()) {
            if (c instanceof JComboBox) {
                ((JComboBox) c).addActionListener(this);
            }
            if (c instanceof JTextField) {
                ((JTextField) c).addActionListener(this);
            }
        }
    }

    public void bindPanel() {
        for (Component c : this.getContentPane().getComponents()) {
            if (c instanceof JPanel) {
                bindItemsPanel(this, (JPanel) c);
            }
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void start() throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.setVisible(true);
        //controler.manager();
    }

    private void setWindow() {
        this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.5),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.5));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1));
    }

    private void setMenus() {

        menuFile = componentCreator.createMenu("File", 'F');
        menuHelp = componentCreator.createMenu("Help", 'H');
        menuConfig = componentCreator.createMenu("Config", 'C');
        menuLanguage = componentCreator.createMenu("Language", 'L');

        menuItemHelp = componentCreator.createMenuItem("Help", 'H');
        menuItemAbout = componentCreator.createMenuItem("About", 'A');
        menuItemDisclaimer = componentCreator.createMenuItem("Disclaimer", 'D');
        menuItemClose = componentCreator.createMenuItem("Exit", 'X');
        menuItemLangEN = componentCreator.createMenuItem("English");
        menuItemLangPT = componentCreator.createMenuItem("Português");

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
        panelTop = componentCreator.createPanel();
        panelTop.setLayout(new FlowLayout());
        panelTop.setBackground(Color.GRAY);

        labelHeader = componentCreator.createLabel(Infos.systemName, 20, true);
        labelHeader.setHorizontalAlignment(SwingConstants.CENTER);
        panelTop.add(labelHeader);

        this.add(panelTop, BorderLayout.NORTH);
    }

    private void setConvertFromPanel() {
        DynamicLoader.setClassesName();
        panelConvertFrom = componentCreator.createPanel();
        panelConvertFrom.setBackground(Color.LIGHT_GRAY);
        panelConvertFrom.setLayout(new FlowLayout());

        labelConvertFrom = componentCreator.createLabel("Convert From", 16, false);
        inputValue = componentCreator.createTextField(true);
        fromUnitBox = componentCreator.createComboBox(DynamicLoader.getClassesNames());
        fromUnitBox.addItemListener(null);

        panelConvertFrom.add(labelConvertFrom);
        panelConvertFrom.add(inputValue);
        panelConvertFrom.add(fromUnitBox);

        this.add(panelConvertFrom, BorderLayout.CENTER);
    }

    private void setConvertToPanel() {
        panelConvertTo = componentCreator.createPanel();
        panelConvertTo.setBackground(Color.LIGHT_GRAY);
        panelConvertTo.setLayout(new FlowLayout());

        labelConvertTo = componentCreator.createLabel("To", 16, false);
        outputValue = componentCreator.createTextField(false);
        toUnitBox = componentCreator.createComboBox(DynamicLoader.getClassesNames());

        panelConvertTo.add(labelConvertTo);
        panelConvertTo.add(outputValue);
        panelConvertTo.add(toUnitBox);

        this.add(panelConvertTo, BorderLayout.CENTER);
    }

    private void setPanelBottom() {
        panelBottom = componentCreator.createPanel();
        panelBottom.setBackground(Color.GRAY);
        panelBottom.setLayout(new FlowLayout());

        labelBottom = componentCreator.createLabel("Bottom", 12, false);
        panelBottom.add(labelBottom);

        this.add(panelBottom, BorderLayout.SOUTH);
    }

}