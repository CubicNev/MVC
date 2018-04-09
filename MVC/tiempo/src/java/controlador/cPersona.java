/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;

/**
 *
 * @author Alumno
 */
public class cPersona {
    private String _nombre = "";
    private String _paterno = "";
    private String _materno = "";
    private String _correo = "";
    private String _pswd = "";
    private String _msj = "";
    private int _idp = 0;
    
    public cPersona(String usr, String psw ){
        
    }
    public cPersona(int idPersona){
        
    }
    public boolean guardaPersona(String nombre, String paterno, String materno, String correo, String pswd){
        _nombre = nombre;
        _paterno = paterno;
        _materno = materno;
        _correo = correo;
        _pswd = pswd;
        boolean salida = false;
        BD.cDatos sql = new BD.cDatos();
        try{
            
            sql.conectar();
            
            
            seguridad.cCifrados cif = new seguridad.cCifrados("miContrasenia");
            
            
            ResultSet rsGp = sql.consulta("call spGuardaPersona('"+_nombre+"', '"+_paterno+"', '"+_materno+"', '"+_correo+"', '"+_pswd+"','"+cif.encrypt(_pswd)+"');");
            
            while(rsGp.next()){
            _msj = rsGp.getString("MSJ");
            _idp = rsGp.getInt("idPersona");
            salida = true;
            }
            
            
        }
        catch(Exception xxxxxD){
            
        }
        
        return salida;
    }
    
    public String MSJ(){
        return _msj;
    }
}
