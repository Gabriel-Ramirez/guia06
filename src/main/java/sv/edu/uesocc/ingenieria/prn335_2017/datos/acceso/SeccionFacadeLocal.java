/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Seccion;


@Local
public interface SeccionFacadeLocal {

    void create(Seccion seccion);

    void edit(Seccion seccion);

    void remove(Seccion seccion);

    Seccion find(Object id);

    List<Seccion> findAll();

    List<Seccion> findRange(int[] range);

    int count();
    
}
