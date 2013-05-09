package Clases.Auxiliares;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author jobren8
 */
public class CeldaCheckBox extends DefaultCellEditor implements TableCellRenderer {

    private JComponent component = new JCheckBox();
    private boolean value = false; // valor de la celda Falso-> Sin Marcar

    /**
     * Constructor de clase
     */
    public CeldaCheckBox() {
        super(new JCheckBox());
    }

    /**
     * retorna valor de celda
     */
    @Override
    public Object getCellEditorValue() {
        return ((JCheckBox) component).isSelected();
    }

    /**
     * Segun el valor de la celda selecciona/deseleciona el JCheckBox
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        //Alineacion de la celda
        ((JCheckBox) component).setHorizontalAlignment(SwingConstants.CENTER);
        //Color de fondo en modo edicion
        ((JCheckBox) component).setBackground(new Color(51, 153, 255));
        //obtiene valor de celda y coloca en el JCheckBox
        boolean b = ((Boolean) value).booleanValue();
        ((JCheckBox) component).setSelected(b);
        return ((JCheckBox) component);
    }

    /**
     * cuando termina la manipulacion de la celda
     */
    @Override
    public boolean stopCellEditing() {
        value = ((Boolean) getCellEditorValue()).booleanValue();
        ((JCheckBox) component).setSelected(value);
        return super.stopCellEditing();
    }

    /**
     * retorna componente
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null) {
            return null;
        }
        return ((JCheckBox) component);
    }
}