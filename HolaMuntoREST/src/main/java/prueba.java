
import Facade.FacadeDatosCaso;
import exception.ConexionException;
import modelo.Datoscaso;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author white
 */
public class prueba {
    public static void main(String[] args) throws ConexionException {
        Datoscaso dt = new Datoscaso();
        FacadeDatosCaso DFH = new FacadeDatosCaso();
        
        dt= DFH.get(1);
        
        System.out.println(DFH.findAll());
    }
}
