package Clases.Auxiliares;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author JoBren8
 */
public class HelpMethods 
{
    public static double redondear(double numero,int numeroDecimales)
    {
        long mult=(long)Math.pow(10,numeroDecimales);
        double resultado=(Math.round(numero*mult))/(double)mult;
        return resultado;
    }
    
    public static boolean isNombresApellidos(String texto)
    {
        String caracteresNombres = "abcdefghiyjklmnñopqrstuvwxyzABCDEFGHYJKLMNÑOPQRSTUVWXYZáéíóúÁÉÍÓÚïÏüÜ.' ";
        for (int x = 0; x < texto.length(); x++)
        {
            if (caracteresNombres.indexOf(texto.charAt(x))<0)
            {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isAlfanumerico(String texto)
    {
        String caracteresNombres = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÍÓÚïÏüÜ0123456789.";
        for (int x = 0; x < texto.length(); x++)
        {
            if (caracteresNombres.indexOf(texto.charAt(x))<0)
            {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isInt(String texto)
    {
        String caracteresNombres = "0123456789";
        for (int x = 0; x < texto.length(); x++)
        {
            if (caracteresNombres.indexOf(texto.charAt(x))<0)
            {
                return false;
            }
        }
        try
        {
            int numero = Integer.parseInt(texto);
        }
        catch(Exception ex) 
        {
            return false;
        }        
        return true;
    }
    
    public static boolean isDouble(String texto)
    {
        String caracteresNombres = "0123456789.";
        for (int x = 0; x < texto.length(); x++)
        {
            if (caracteresNombres.indexOf(texto.charAt(x))<0)
            {                
                return false;
            }
        }
        try
        {
            double numero = Double.parseDouble(texto);
        }
        catch(Exception ex) 
        {
            return false;
        }        
        return true;
    }
    
    public static boolean isFecha(int dia, int mes, int año)
    {
        if (mes > 12) 
            return false;
        GregorianCalendar calendario = new GregorianCalendar();
        calendario.set(Calendar.YEAR , año);
        calendario.set(Calendar.MONTH , mes-1);
        calendario.set(Calendar.DAY_OF_MONTH , 1);
        while(calendario.get(Calendar.MONTH) == (mes-1))
        {
            if (calendario.get(Calendar.DAY_OF_MONTH) == dia)
            {
                return true;
            }
            calendario.add(Calendar.DAY_OF_MONTH,1);
        }
        return false;
    }   
}
