/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Auxiliares;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author jobren8
 */
public class RenderCheckBox extends JCheckBox implements TableCellRenderer {

    private JComponent component = new JCheckBox();

    /**
     * Constructor de clase
     */
    public RenderCheckBox() {
        setOpaque(false);
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //Obtenermo el componente y lo centramos
        ((JCheckBox) component).setHorizontalAlignment(SwingConstants.CENTER);
        //Determinar si la fila esta seleccionada y asignar el color
        if (isSelected) {
            //Color de fondo del checkbox con la fila seleccionada
            this.setOpaque(true);
            ((JCheckBox) component).setBackground((new Color(51, 153, 255)));
        } else {
            //Color de fondo del checkbox con la fila sin seleccionar
            ((JCheckBox) component).setBackground(new Color(255, 255, 255));
        }
        //obtiene valor boolean y coloca valor en el JCheckBox
        boolean b = ((Boolean) value).booleanValue();
        ((JCheckBox) component).setSelected(b);
        return ((JCheckBox) component);
    }
}
