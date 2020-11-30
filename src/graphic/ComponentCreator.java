package graphic;

import java.awt.Font;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Class with methots that creates JFrame components.
 */
public class ComponentCreator extends JFrame {

    private static final long serialVersionUID = 1L;

    
    /** 
     * JButton creator.
     * @param text Text on JButton.
     * @return JButton Object.
     */
    JButton createButton(String text) {
        JButton object = new JButton(text);
        return object;
    }

    
    /** 
     * JMenu creator.
     * @param text Text on menu.
     * @param shortcut Shortcut.
     * @return JMenu Object.
     */
    JMenu createMenu(String text, char shortcut) {
        JMenu object = new JMenu(text);
        object.setMnemonic(shortcut);
        return object;
    }

    
    /** 
     * JMenuItem creator.
     * @param text Text on menu item.
     * @param shortcut Shortcut
     * @return JMenuItem Object.
     */
    JMenuItem createMenuItem(String text, char shortcut) {
        JMenuItem object = new JMenuItem(text);
        object.setMnemonic(shortcut);
        return object;
    }

    
    /** 
     * JMenuItem creator without shortcut.
     * @param text Text on menu item.
     * @return JMenuItem Object.
     */
    JMenuItem createMenuItem(String text) {
        JMenuItem object = new JMenuItem(text);
        return object;
    }

    
    /** 
     * JTextField creator.
     * @param editable Verify if its editable or not.
     * @return JTextField Object.
     */
    JTextField createTextField(boolean editable) {
        JTextField object = new JTextField(15);
        if (editable)
            object.setEditable(true);
        else
            object.setEditable(false);
        return object;
    }

    
    /** 
     * JLabel creator.
     * @param text Text on the label.
     * @param size Size of the label.
     * @param bold If it is bold or not.
     * @return JLabel Object.
     */
    JLabel createLabel(String text, int size, boolean bold) {
        JLabel object = new JLabel(text);
        if (bold)
            object.setFont(new Font("Verdana", Font.BOLD, size));
        else
            object.setFont(new Font("Verdana", Font.PLAIN, size));

        object.setHorizontalAlignment(SwingConstants.CENTER);
        object.setVerticalAlignment(SwingConstants.CENTER);
        return object;
    }

    
    /** 
     * JPanel creator.
     * @return JPanel Object.
     */
    JPanel createPanel() {
        JPanel object = new JPanel();
        object.setBorder(BorderFactory.createEtchedBorder());
        return object;
    }

    
    /** 
     * JComboBox creator.
     * @param items Option items.
     * @return JComboBox<String> Object.
     */
    JComboBox<String> createComboBox(ArrayList<String> items) {
        JComboBox<String> object = new JComboBox<String>();
        for (String item : items) {
            if (!item.equals("BaseConverter") && !item.equals("MeasureType"))
                object.addItem(item);
        }
        return object;
    }
    
}
