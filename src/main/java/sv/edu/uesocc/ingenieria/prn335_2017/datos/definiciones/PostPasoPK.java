/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author j3cs
 */
@Embeddable
public class PostPasoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_post")
    private int idPost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_paso")
    private int idPaso;

    public PostPasoPK() {
    }

    public PostPasoPK(int idPost, int idPaso) {
        this.idPost = idPost;
        this.idPaso = idPaso;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(int idPaso) {
        this.idPaso = idPaso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPost;
        hash += (int) idPaso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostPasoPK)) {
            return false;
        }
        PostPasoPK other = (PostPasoPK) object;
        if (this.idPost != other.idPost) {
            return false;
        }
        if (this.idPaso != other.idPaso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.PostPasoPK[ idPost=" + idPost + ", idPaso=" + idPaso + " ]";
    }
    
}
