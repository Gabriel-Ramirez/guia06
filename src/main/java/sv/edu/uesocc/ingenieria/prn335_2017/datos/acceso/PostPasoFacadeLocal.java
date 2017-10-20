/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.PostPaso;


@Local
public interface PostPasoFacadeLocal {

    void create(PostPaso postPaso);

    void edit(PostPaso postPaso);

    void remove(PostPaso postPaso);

    PostPaso find(Object id);

    List<PostPaso> findAll();

    List<PostPaso> findRange(int[] range);

    int count();
    
}
