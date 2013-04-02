package Clases.Auxiliares;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoBren8
 */

//Creamos una clase que extienda de DefaultTableModel, para evitar que las celdas sea editable
public class NoEditableTableModel extends DefaultTableModel
{
    public boolean isCellEditable (int row, int column)
   {
       return false;
   }
}
