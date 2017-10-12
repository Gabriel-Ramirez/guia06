/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPost;

@Local
public interface TipoPostFacadeLocal {

    void create(TipoPost tipoPost);

    void edit(TipoPost tipoPost);

    void remove(TipoPost tipoPost);

    TipoPost find(Object id);

    List<TipoPost> findAll();

    List<TipoPost> findRange(int[] range);

    int count();
    
}
