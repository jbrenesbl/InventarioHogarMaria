package Clases.Auxiliares;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author jobren8
 */
public class CeldaCheckBox extends DefaultCellEditor {

//    private JComponent component = new JCheckBox();
//    private boolean value; // valor de la celda Falso-> Sin Marcar
    /**
     * Constructor de clase
     */
    public CeldaCheckBox() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected,
            int row, int column) {
        //Alineacion de la celda
        ((JCheckBox) editorComponent).setHorizontalAlignment(SwingConstants.CENTER);
        //Color de fondo en modo edicion
        ((JCheckBox) editorComponent).setBackground(new Color(51, 153, 255));
        delegate.setValue(value);
        if (editorComponent instanceof JCheckBox) {
            //in order to avoid a "flashing" effect when clicking a checkbox
            //in a table, it is important for the editor to have as a border
            //the same border that the renderer has, and have as the background
            //the same color as the renderer has. This is primarily only
            //needed for JCheckBox since this editor doesn't fill all the
            //visual space of the table cell, unlike a text field.
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component c = renderer.getTableCellRendererComponent(table, value,
                    isSelected, true, row, column);
            if (c != null) {
                editorComponent.setOpaque(true);
                //editorComponent.setBackground(c.getBackground());
                if (c instanceof JComponent) {
                    editorComponent.setBorder(((JComponent) c).getBorder());
                }
            } else {
                editorComponent.setOpaque(false);
            }
        }
        return editorComponent;
    }
}