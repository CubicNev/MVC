/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alumno
 */
@WebService(serviceName = "wsOtro")
public class wsOtro {

    /**
     * This is a sample web service operation
     */
    

    @WebMethod(operationName = "guardaPer")
    public String guardaPer(@WebParam(name = "nombre")String nombre,
            @WebParam(name = "paterno")String paterno,
            @WebParam(name = "materno")String materno,
            @WebParam(name = "correo")String correo,
            @WebParam(name = "psw")String psw) {

        String salida = "";
        controlador.cPersona per = new controlador.cPersona(0);

        if (per.guardaPersona(nombre, paterno, materno, correo, psw)) {

            salida = per.MSJ();
        } else {
            salida = per.MSJ();
        }
        return salida;
    }
}
