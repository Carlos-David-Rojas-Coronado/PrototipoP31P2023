/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoMarca;
/**
 *
 * @author visitante
 */
public class clsMarca {
    private int IdMarca;
    private String NombreMarca;
    private String EstatusMarca;

    public clsMarca() {
    }
    
    public clsMarca(int IdMarca) {
        this.IdMarca = IdMarca;
    }    
    
    public clsMarca(String NombreMarca, String EstatusMarca) {
        this.NombreMarca = NombreMarca;
        this.EstatusMarca = EstatusMarca;
    }
    
    public clsMarca(int IdMarca, String NombreMarca, String EstatusMarca) {
        this.IdMarca = IdMarca;
        this.NombreMarca = NombreMarca;
        this.EstatusMarca = EstatusMarca;
    }    

    public int getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(int IdMarca) {
        this.IdMarca = IdMarca;
    }

    public String getNombreMarca() {
        return NombreMarca;
    }

    public void setNombreMarca(String NombreMarca) {
        this.NombreMarca = NombreMarca;
    }

    public String getEstatusMarca() {
        return EstatusMarca;
    }

    public void setEstatusMarca(String EstatusMarca) {
        this.EstatusMarca = EstatusMarca;
    }
    @Override
    public String toString() {
        return "clsUsuario{" + "IdMarca=" + IdMarca + ", NombreMarca=" + NombreMarca + ", EstatusMarca=" + EstatusMarca + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsMarca getBuscarInformacionMarcasPorNombre(clsMarca marca)
    {
        daoMarca daomarca = new daoMarca();
        return daomarca.consultaMarcasPorNombre(marca);
    }
    public clsMarca getBuscarInformacionMarcasPorId(clsMarca marca)
    {
        daoMarca daomarca = new daoMarca();
        return daomarca.consultaMarcasPorId(marca);
    }    
    public List<clsMarca> getListadoMarcas()
    {
        daoMarca daomarca = new daoMarca();
        List<clsMarca> listadoMarcas = daomarca.consultaMarcas();
        return listadoMarcas;
    }
    public int setBorrarMarcas(clsMarca marca)
    {
        daoMarca daomarca = new daoMarca();
        return daomarca.borrarMarcas(marca);
    }          
    public int setIngresarMarcas(clsMarca marca)
    {
        daoMarca daousuario = new daoMarca();
        return daousuario.ingresaMarcas(marca);
    }              
    public int setModificarMarca(clsMarca marca)
    {
        daoMarca daomarca = new daoMarca();
        return daomarca.actualizaMarcas(marca);
    }              
}
