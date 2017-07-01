package co.edu.usb.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "clientes", schema = "public")
public class Clientes implements java.io.Serializable {
    @NotNull
    private Long cliId;
    @NotNull
    private TiposDocumentos tiposDocumentos;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String cliDireccion;
    private String cliMail;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String cliNombre;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String cliTelefono;

    public Clientes() {
    }

    public Clientes(Long cliId, String cliDireccion, String cliMail,
        String cliNombre, String cliTelefono, TiposDocumentos tiposDocumentos) {
        this.cliId = cliId;
        this.tiposDocumentos = tiposDocumentos;
        this.cliDireccion = cliDireccion;
        this.cliMail = cliMail;
        this.cliNombre = cliNombre;
        this.cliTelefono = cliTelefono;
    }

    @Id
    @Column(name = "cli_id", unique = true, nullable = false)
    public Long getCliId() {
        return this.cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tdoc_codigo")
    public TiposDocumentos getTiposDocumentos() {
        return this.tiposDocumentos;
    }

    public void setTiposDocumentos(TiposDocumentos tiposDocumentos) {
        this.tiposDocumentos = tiposDocumentos;
    }

    @Column(name = "cli_direccion", nullable = false)
    public String getCliDireccion() {
        return this.cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    @Column(name = "cli_mail")
    public String getCliMail() {
        return this.cliMail;
    }

    public void setCliMail(String cliMail) {
        this.cliMail = cliMail;
    }

    @Column(name = "cli_nombre", nullable = false)
    public String getCliNombre() {
        return this.cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    @Column(name = "cli_telefono", nullable = false)
    public String getCliTelefono() {
        return this.cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }
}
