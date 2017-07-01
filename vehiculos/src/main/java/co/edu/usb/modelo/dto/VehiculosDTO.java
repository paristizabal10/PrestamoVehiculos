package co.edu.usb.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class VehiculosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(VehiculosDTO.class);
    private String vehCilindraje;
    private String vehMarca;
    private String vehModelo;
    private String vehNumero;
    private String vehPlaca;

    public String getVehCilindraje() {
        return vehCilindraje;
    }

    public void setVehCilindraje(String vehCilindraje) {
        this.vehCilindraje = vehCilindraje;
    }

    public String getVehMarca() {
        return vehMarca;
    }

    public void setVehMarca(String vehMarca) {
        this.vehMarca = vehMarca;
    }

    public String getVehModelo() {
        return vehModelo;
    }

    public void setVehModelo(String vehModelo) {
        this.vehModelo = vehModelo;
    }

    public String getVehNumero() {
        return vehNumero;
    }

    public void setVehNumero(String vehNumero) {
        this.vehNumero = vehNumero;
    }

    public String getVehPlaca() {
        return vehPlaca;
    }

    public void setVehPlaca(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }
}
