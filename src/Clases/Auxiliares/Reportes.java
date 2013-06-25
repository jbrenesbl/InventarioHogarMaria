package Clases.Auxiliares;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jobren8
 */
public class Reportes {

    public Reportes() {
    }

    //REPORTE DETALLADO MOVIMIENTO
    public boolean reporteMovimientoDetallado(int idMovimiento) {
        try {            
            ConexionBaseDatos con = new ConexionBaseDatos();
            con.abrirConexion();
            //Creamos un Map para los parametros del reporte
            Map parametros = new HashMap();
            parametros.put("BannerHeader", this.getClass().getResourceAsStream(
                    "/Imagenes/Reportes/LogoFundacionMaria.jpg"));
            parametros.put("Background", this.getClass().getResourceAsStream(
                    "/Imagenes/Reportes/Background.png"));
            parametros.put("Consecutivo", idMovimiento);

            //Cargamos el objeto JasperReport con el reporte correspondiente
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource(
                    "/Reportes/RM_Detalle_Movimiento.jasper"));

            //Llenamos el JasperPrint con el reporte y los datos correspondientes
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, con.getConexion());

            //Creamos un JasperViewer para visualizar el reporte
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);

            //Le ponemos un titulo personalizado al visor, y desplegamos el reporte.
            jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jasperViewer.setTitle("Detalle de Movimiento #" + idMovimiento);
            jasperViewer.setAlwaysOnTop(true);
            jasperViewer.setVisible(true);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "");
            return false;
        }
    }
}
