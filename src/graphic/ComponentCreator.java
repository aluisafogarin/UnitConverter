package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Insets;
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

public class ComponentCreator extends JFrame {

    private static final long serialVersionUID = 1L;

    JButton createButton(String text) {
        JButton object = new JButton(text);
        return object;
    }

    JMenu createMenu(String text, char shortcut) {
        JMenu object = new JMenu(text);
        object.setMnemonic(shortcut);
        return object;
    }

    JMenuItem createMenuItem(String text, char shortcut) {
        JMenuItem object = new JMenuItem(text);
        object.setMnemonic(shortcut);
        return object;
    }

    JMenuItem createMenuItem(String text) {
        JMenuItem object = new JMenuItem(text);
        return object;
    }

    JTextField createTextField(boolean editable) {
        JTextField object = new JTextField(15);
        if (editable)
            object.setEditable(true);
        else
            object.setEditable(false);
        return object;
    }

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

    JPanel createPanel() {
        JPanel object = new JPanel();
        object.setBorder(BorderFactory.createEtchedBorder());
        return object;
    }

    JComboBox<String> createComboBox(ArrayList<String> items) {
        JComboBox<String> object = new JComboBox<String>();
        for (String item : items) {
            if (!item.equals("BaseConverter") && !item.equals("MeasureType"))
                object.addItem(item);
        }
        return object;
    }
    
}
