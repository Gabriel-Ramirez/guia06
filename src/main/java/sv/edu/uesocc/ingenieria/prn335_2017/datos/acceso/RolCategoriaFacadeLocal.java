/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.RolCategoria;

@Local
public interface RolCategoriaFacadeLocal {

    void create(RolCategoria rolCategoria);

    void edit(RolCategoria rolCategoria);

    void remove(RolCategoria rolCategoria);

    RolCategoria find(Object id);

    List<RolCategoria> findAll();

    List<RolCategoria> findRange(int[] range);

    int count();
    
}
