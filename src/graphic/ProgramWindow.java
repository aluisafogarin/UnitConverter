package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import program.ConversionManagement;
import program.DynamicLoader;

/**
 * Interface base.
 */
public class ProgramWindow extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private ComponentCreator componentCreator = new ComponentCreator();
    private JPanel panelTop;
    private JPanel panelConvertFrom;
    private JPanel panelConvertTo;
    private JPanel panelBottom;

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuHelp;
    private JMenuItem menuItemDisclaimer;
    private JMenuItem menuItemClose;
    private JMenuItem menuItemHelp;
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

    /**
     * Class constructor.  
     */
    ProgramWindow(String title) throws HeadlessException {
        super(title);
        setWindow();
        setMenus();
        bindMenus();
        setLayout();
        bindPanel();
    }

    
    /** 
     * Add functionalities to events.
     * @param event Triggered event.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.menuItemAbout) {
            new DialogWindow(this, Infos.languageInfos.getAbout(), Infos.getAbout());
        }

        if (event.getSource() == this.menuItemClose)
            exit();

        if (event.getSource() == this.menuItemDisclaimer) {
            new DialogWindow(this, Infos.languageInfos.getDisclaimer() + Infos.getLongVersion(), 
                Infos.getTextFromFile(Infos.disclaimerFile));
        }
        
        if (event.getSource() == this.menuItemHelp) {
            new DialogWindow(this, Infos.languageInfos.getHelp() + Infos.getLongVersion(), 
                Infos.getTextFromFile(Infos.helpFile));
        }

        if (event.getSource() == this.inputValue) {
            this.value = (double) (Integer.parseInt(inputValue.getText()));
            verifyEntry();
            outputValue.setText(String.valueOf(newValue));
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

    /**
     * Verify if all fields were completed.
     */
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

    
    /** 
     * Makes easier to get events from items. 
     * @param listener Event triggered.
     * @param menu Name of menu.
     */
    public void bindItems(ActionListener listener, JMenu menu) {
        for (Component c : menu.getMenuComponents()) {
            if (c instanceof JMenuItem) 
                ((JMenuItem) c).addActionListener(this);
        }
    }

    /**
     * Build menus
     */
    public void bindMenus() {
        for (Component c : this.getJMenuBar().getComponents()) {
            if (c instanceof JMenu) {
                bindItems(this, (JMenu) c);
            }
        }
    }

    
    /** 
     * Makes easier to get events from items on panels.
     * @param listener Event.
     * @param panel Name of panel.
     */
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

    /**
     * Builds panels.
     */
    public void bindPanel() {
        for (Component c : this.getContentPane().getComponents()) {
            if (c instanceof JPanel) {
                bindItemsPanel(this, (JPanel) c);
            }
        }
    }

    /**
     * Exit the GUI Window.
     */
    public void exit() {
        System.exit(0);
    }

    
    /** 
     * Makes GUI visible.
     * @throws ClassNotFoundException In case dynamic class loader don't find a class.
     * @throws IllegalAccessException In case there's no acess to some file.
     * @throws InstantiationException In case dynamic class loader failed.
     */
    public void start() throws 
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.setVisible(true);
    }

    /**
     * Set params to GUI Window.
     */
    private void setWindow() {
        this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.5),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.5));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1));
    }

    /**
     * Set all menus from GUI.
     */
    private void setMenus() {

        menuFile = componentCreator.createMenu(Infos.languageInfos.getFile(), 'F');
        menuHelp = componentCreator.createMenu(Infos.languageInfos.getHelp(), 'H');

        menuItemHelp = componentCreator.createMenuItem(Infos.languageInfos.getHelp(), 'H');
        menuItemAbout = componentCreator.createMenuItem(Infos.languageInfos.getAbout(), 'A');
        menuItemDisclaimer = componentCreator.createMenuItem(Infos.languageInfos.getDisclaimer(), 'D');
        menuItemClose = componentCreator.createMenuItem(Infos.languageInfos.getExit(), 'X');

        menuFile.add(menuItemDisclaimer);
        menuFile.add(menuItemClose);

        menuHelp.add(menuItemAbout);
        menuHelp.add(menuItemHelp);

        menuBar = new JMenuBar();
        menuBar.add(menuFile);
        menuBar.add(menuHelp);

        this.setJMenuBar(menuBar);
    }

    /**
     * Calls methods to build panels of the GUI.
     */
    private void setLayout() {
        setPanelTop();
        setConvertFromPanel();
        setConvertToPanel();
        setPanelBottom();
    }

    /**
     * Build panel top.
     */
    private void setPanelTop() {
        panelTop = componentCreator.createPanel();
        panelTop.setLayout(new FlowLayout());
        panelTop.setBackground(Color.GRAY);

        labelHeader = componentCreator.createLabel(Infos.systemName, 20, true);
        labelHeader.setHorizontalAlignment(SwingConstants.CENTER);
        panelTop.add(labelHeader);

        this.add(panelTop, BorderLayout.NORTH);
    }

    /**
     * Build convert from panel.
     */
    private void setConvertFromPanel() {
        DynamicLoader.setClassesName();
        panelConvertFrom = componentCreator.createPanel();
        panelConvertFrom.setBackground(Color.LIGHT_GRAY);
        panelConvertFrom.setLayout(new FlowLayout());

        labelConvertFrom = componentCreator.createLabel(Infos.languageInfos.getConvertFrom(), 16, false);
        inputValue = componentCreator.createTextField(true);
        fromUnitBox = componentCreator.createComboBox(DynamicLoader.getClassesNames());
        fromUnitBox.addItemListener(null);

        panelConvertFrom.add(labelConvertFrom);
        panelConvertFrom.add(inputValue);
        panelConvertFrom.add(fromUnitBox);

        this.add(panelConvertFrom, BorderLayout.CENTER);
    }

    /**
     * Build convert to panel. 
     */
    private void setConvertToPanel() {
        panelConvertTo = componentCreator.createPanel();
        panelConvertTo.setBackground(Color.LIGHT_GRAY);
        panelConvertTo.setLayout(new FlowLayout());

        labelConvertTo = componentCreator.createLabel(Infos.languageInfos.getConvertTo(), 16, false);
        outputValue = componentCreator.createTextField(false);
        toUnitBox = componentCreator.createComboBox(DynamicLoader.getClassesNames());

        panelConvertTo.add(labelConvertTo);
        panelConvertTo.add(outputValue);
        panelConvertTo.add(toUnitBox);

        this.add(panelConvertTo, BorderLayout.CENTER);
    }

    /**
     * Build bottom panel. 
     */
    private void setPanelBottom() {
        panelBottom = componentCreator.createPanel();
        panelBottom.setBackground(Color.GRAY);
        panelBottom.setLayout(new FlowLayout());

        labelBottom = componentCreator.createLabel(Infos.getShortVersion(), 12, false);
        panelBottom.add(labelBottom);

        this.add(panelBottom, BorderLayout.SOUTH);
    }

}