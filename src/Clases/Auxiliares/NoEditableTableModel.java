package Clases.Auxiliares;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoBren8
 */

//Creamos una clase que extienda de DefaultTableModel, para evitar que las celdas sea editable
public class NoEditableTableModel extends DefaultTableModel
{
    //Variables
    private int columnaEditable = -1;
    
    public boolean isCellEditable (int row, int column)
   {
       if (column == columnaEditable)
           return true;
       else
           return false;
   }
    
    public void setColumnaEditable (int columna)
    {
        this.columnaEditable = columna;
    }
}
