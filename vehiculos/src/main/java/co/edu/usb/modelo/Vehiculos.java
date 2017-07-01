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
@Table(name = "vehiculos", schema = "public")
public class Vehiculos implements java.io.Serializable {
    @NotNull
    private String vehNumero;
    @NotNull
    @NotEmpty
    @Size(max = 5)
    private String vehCilindraje;
    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String vehMarca;
    @NotNull
    @NotEmpty
    @Size(max = 4)
    private String vehModelo;
    @NotNull
    @NotEmpty
    @Size(max = 10)
    private String vehPlaca;

    public Vehiculos() {
    }

    public Vehiculos(String vehNumero, String vehCilindraje, String vehMarca,
        String vehModelo, String vehPlaca) {
        this.vehNumero = vehNumero;
        this.vehCilindraje = vehCilindraje;
        this.vehMarca = vehMarca;
        this.vehModelo = vehModelo;
        this.vehPlaca = vehPlaca;
    }

    @Id
    @Column(name = "veh_numero", unique = true, nullable = false)
    public String getVehNumero() {
        return this.vehNumero;
    }

    public void setVehNumero(String vehNumero) {
        this.vehNumero = vehNumero;
    }

    @Column(name = "veh_cilindraje", nullable = false)
    public String getVehCilindraje() {
        return this.vehCilindraje;
    }

    public void setVehCilindraje(String vehCilindraje) {
        this.vehCilindraje = vehCilindraje;
    }

    @Column(name = "veh_marca", nullable = false)
    public String getVehMarca() {
        return this.vehMarca;
    }

    public void setVehMarca(String vehMarca) {
        this.vehMarca = vehMarca;
    }

    @Column(name = "veh_modelo", nullable = false)
    public String getVehModelo() {
        return this.vehModelo;
    }

    public void setVehModelo(String vehModelo) {
        this.vehModelo = vehModelo;
    }

    @Column(name = "veh_placa", nullable = false)
    public String getVehPlaca() {
        return this.vehPlaca;
    }

    public void setVehPlaca(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }
}
