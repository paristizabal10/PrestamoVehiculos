package co.edu.usb.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "tipos_documentos", schema = "public")
public class TiposDocumentos implements java.io.Serializable {
    @NotNull
    private Long tdocCodigo;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String tdocNombre;
    private Set<Clientes> clienteses = new HashSet<Clientes>(0);

    public TiposDocumentos() {
    }

    public TiposDocumentos(Long tdocCodigo, Set<Clientes> clienteses,
        String tdocNombre) {
        this.tdocCodigo = tdocCodigo;
        this.tdocNombre = tdocNombre;
        this.clienteses = clienteses;
    }

    @Id
    @Column(name = "tdoc_codigo", unique = true, nullable = false)
    public Long getTdocCodigo() {
        return this.tdocCodigo;
    }

    public void setTdocCodigo(Long tdocCodigo) {
        this.tdocCodigo = tdocCodigo;
    }

    @Column(name = "tdoc_nombre", nullable = false)
    public String getTdocNombre() {
        return this.tdocNombre;
    }

    public void setTdocNombre(String tdocNombre) {
        this.tdocNombre = tdocNombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tiposDocumentos")
    public Set<Clientes> getClienteses() {
        return this.clienteses;
    }

    public void setClienteses(Set<Clientes> clienteses) {
        this.clienteses = clienteses;
    }
}
