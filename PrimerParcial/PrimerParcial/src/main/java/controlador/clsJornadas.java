/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoJornadas;
/**
 *
 * @author visitante
 */
public class clsJornadas {
    private String codigo_jornada;
    private String nombre_jornada;
    private String estatus_jornada;

    public clsJornadas() {
    }

    public clsJornadas(String codigo_jornada) {
        this.codigo_jornada = codigo_jornada;
    }

    public clsJornadas(String nombre_jornada, String estatus_jornada) {
        this.nombre_jornada = nombre_jornada;
        this.estatus_jornada = estatus_jornada;
    }

    public clsJornadas(String codigo_jornada, String nombre_jornada, String estatus_jornada) {
        this.codigo_jornada = codigo_jornada;
        this.nombre_jornada = nombre_jornada;
        this.estatus_jornada = estatus_jornada;
    }

    public String getCodigo_jornada() {
        return codigo_jornada;
    }

    public void setCodigo_jornada(String codigo_jornada) {
        this.codigo_jornada = codigo_jornada;
    }

    public String getNombre_jornada() {
        return nombre_jornada;
    }

    public void setNombre_jornada(String nombre_jornada) {
        this.nombre_jornada = nombre_jornada;
    }

    public String getEstatus_jornada() {
        return estatus_jornada;
    }

    public void setEstatus_jornada(String estatus_jornada) {
        this.estatus_jornada = estatus_jornada;
    }
    
    @Override
    public String toString() {
        return "clsJornadas{" + "codigo_jornada=" + codigo_jornada + ", nombre_jornada=" + nombre_jornada + ", estatus_jornada=" + estatus_jornada + '}';
    }
    //Metodos de acceso a la capa controlador
  public clsJornadas getBuscarInformacionJornadasPorNombre(clsJornadas jornada)
    {
        daoJornadas daojornada= new daoJornadas ();
        return daojornada.consultaJornadasPorNombre(jornada);
    }
    public clsJornadas getBuscarInformacionJornadasPorId(clsJornadas jornada)
    {
        daoJornadas daojornada= new daoJornadas();
        return daojornada.consultaJornadasporId(jornada);
    }    
    public List<clsJornadas> getListadoJornadas()
    {
        daoJornadas daojornada = new daoJornadas();
        List<clsJornadas> listadoJornadas = daojornada.consultaJornadas();
        return listadoJornadas;
    }
    public int setBorrarJornada(clsJornadas jornada)
    {
        daoJornadas daojornada = new daoJornadas();
        return daojornada.borrarJornada(jornada);
    }          
    public int setIngresarJornada(clsJornadas jornada)
    {
        daoJornadas daojornada = new  daoJornadas();
        return daojornada.ingresaJornadas(jornada);
    }              
    public int setModificarJornada(clsJornadas jornada)
    {
        daoJornadas daojornada = new daoJornadas();
        return daojornada.actualizaJornadas(jornada);
    }              

}




