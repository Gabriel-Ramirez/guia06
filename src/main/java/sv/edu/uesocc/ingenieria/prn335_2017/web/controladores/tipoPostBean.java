/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.primefaces.event.SelectEvent;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPost;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.TipoPostFacadeLocal;

@Named(value = "tpBean")
@ViewScoped
public class tipoPostBean implements Serializable {

    public tipoPostBean() {
    }
    boolean activo, btnEditar = false;

    public boolean isActivo() {
        return activo;
    }

    public boolean isBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(boolean btnEditar) {
        this.btnEditar = btnEditar;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    @EJB
    TipoPostFacadeLocal tipoPost;
    List<TipoPost> lista = new ArrayList<>();
    TipoPost tp = new TipoPost();

    public TipoPost getTp() {
        return tp;
    }

    public void setTp(TipoPost tp) {
        this.tp = tp;
    }

    public TipoPostFacadeLocal getTipoPost() {
        return tipoPost;
    }

    public void setTipoPost(TipoPostFacadeLocal tipoPost) {
        this.tipoPost = tipoPost;
    }

    public List<TipoPost> getLista() {
        return lista;
    }

    public void setLista(List<TipoPost> lista) {
        this.lista = lista;
    }

    /*
   Se encarga obtener los datos y enviarlos a la clase encargada de persistirlos
     */
    public void crear() {
        try {
            tipoPost.create(tp);
            llenar();
            showMessage("Regitros Guardados con Exito");
            tp = new TipoPost();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            showMessage("Error al ingresar los datos.");
        }

    }
    
    /*
    Obtiene la lista de los elemetos filtrados en la tabla, es decir los obtiene los elementos no ultilizados
    */
    public void chkCambio() {
        if (activo == true) {
            this.lista = obtenerUtilizados();
            System.out.println("Funciona");
        } else {
            llenar();
            System.out.println("No funciona");
        }
    }

    /*
    Este metodo se encarga de la edicion de los registros de una entity, los cuales son realizados atravez de un formulario. 
    */
    public void editar() {
        try {
            tipoPost.edit(tp);
            llenar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Edicion correcta."));
            btnEditar = false;
            tp = new TipoPost();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al editar registro."));
        }
    }
/*
    se encarga de remover registros de la base de datos 
    */
    public void eliminar() {
        try {
            tipoPost.remove(tp);
            llenar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro removido correctamente."));
            btnEditar = false;
            tp = new TipoPost();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al eliminar."));
        }
    }



    /*
    Se encarga mostrar procesar mensajes de notificacion 
     */
    public void showMessage(String Mensaje) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(Mensaje));
    }

    /*
        Se encarga de obtener los datos de las entities
        puede ser utilizado en para mostrar datos existentes en una base de datos
     */
    public List<TipoPost> obtenerUtilizados() {
        List salida;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uesocc.edu.sv.ingenieria.prn335_webproject3_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        Query c = em.createNamedQuery("TipoPost.noUtilizados");
        salida = c.getResultList();

        if (salida != null) {
            return salida;
        } else {
            return Collections.EMPTY_LIST;
        }
    }
    
    /*
    Realiza un evento justo despues de hacer clic sobre la fila de una tabla  
    */
        public void onRowSelect(SelectEvent event) {
        btnEditar = true;
    }

        /*
       maneja la instruccion de cancelar en el xhtml, ademas de la visibilidad del boton cancelar 
        */
    public void btnCancelar() {
        tp = new TipoPost();
        btnEditar = false;
    }

    /*
    Se encarga de obtener los datos de una tabla en una base de datos manejada atravez de una entity  
    */
    @PostConstruct
    public void llenar() {
        if (lista != null) {
            this.lista = tipoPost.findAll();
        } else {
            this.lista = Collections.EMPTY_LIST;
        }
    }

}
