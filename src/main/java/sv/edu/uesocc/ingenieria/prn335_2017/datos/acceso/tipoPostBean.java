/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso;

import static com.sun.javafx.logging.PulseLogger.addMessage;
import java.awt.event.ActionEvent;
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
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPost;
import sv.edu.uesocc.ingenieria.prn335_2017.web.controladores.TipoPostFacadeLocal;

@Named(value = "tpBean")
@ViewScoped
public class tipoPostBean implements Serializable{
    public tipoPostBean() {
    }   
  boolean activo;

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    @EJB
    TipoPostFacadeLocal tipoPost;
    List<TipoPost> lista = new ArrayList<>();
    TipoPost tp =new TipoPost();

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
        public void chkCambio(){
        if(activo == true){
            this.lista = obtenerUtilizados();
            System.out.println("Funciona");
        }else{
            llenar();
            System.out.println("No funciona");
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
        
        if(salida != null){
        return salida;
        }else{
            return Collections.EMPTY_LIST;
        }
    }
    @PostConstruct
    public void llenar(){
        if(lista != null){
            this.lista=tipoPost.findAll();
        }else {
            this.lista=Collections.EMPTY_LIST;
        }
    }
    
    
}
