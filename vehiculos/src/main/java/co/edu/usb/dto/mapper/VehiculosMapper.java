package co.edu.usb.dto.mapper;

import co.edu.usb.modelo.*;
import co.edu.usb.modelo.Vehiculos;
import co.edu.usb.modelo.control.*;
import co.edu.usb.modelo.dto.VehiculosDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class VehiculosMapper implements IVehiculosMapper {
    private static final Logger log = LoggerFactory.getLogger(VehiculosMapper.class);

    @Transactional(readOnly = true)
    public VehiculosDTO vehiculosToVehiculosDTO(Vehiculos vehiculos)
        throws Exception {
        try {
            VehiculosDTO vehiculosDTO = new VehiculosDTO();

            vehiculosDTO.setVehNumero(vehiculos.getVehNumero());
            vehiculosDTO.setVehCilindraje((vehiculos.getVehCilindraje() != null)
                ? vehiculos.getVehCilindraje() : null);
            vehiculosDTO.setVehMarca((vehiculos.getVehMarca() != null)
                ? vehiculos.getVehMarca() : null);
            vehiculosDTO.setVehModelo((vehiculos.getVehModelo() != null)
                ? vehiculos.getVehModelo() : null);
            vehiculosDTO.setVehPlaca((vehiculos.getVehPlaca() != null)
                ? vehiculos.getVehPlaca() : null);

            return vehiculosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Vehiculos vehiculosDTOToVehiculos(VehiculosDTO vehiculosDTO)
        throws Exception {
        try {
            Vehiculos vehiculos = new Vehiculos();

            vehiculos.setVehNumero(vehiculosDTO.getVehNumero());
            vehiculos.setVehCilindraje((vehiculosDTO.getVehCilindraje() != null)
                ? vehiculosDTO.getVehCilindraje() : null);
            vehiculos.setVehMarca((vehiculosDTO.getVehMarca() != null)
                ? vehiculosDTO.getVehMarca() : null);
            vehiculos.setVehModelo((vehiculosDTO.getVehModelo() != null)
                ? vehiculosDTO.getVehModelo() : null);
            vehiculos.setVehPlaca((vehiculosDTO.getVehPlaca() != null)
                ? vehiculosDTO.getVehPlaca() : null);

            return vehiculos;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<VehiculosDTO> listVehiculosToListVehiculosDTO(
        List<Vehiculos> listVehiculos) throws Exception {
        try {
            List<VehiculosDTO> vehiculosDTOs = new ArrayList<VehiculosDTO>();

            for (Vehiculos vehiculos : listVehiculos) {
                VehiculosDTO vehiculosDTO = vehiculosToVehiculosDTO(vehiculos);

                vehiculosDTOs.add(vehiculosDTO);
            }

            return vehiculosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Vehiculos> listVehiculosDTOToListVehiculos(
        List<VehiculosDTO> listVehiculosDTO) throws Exception {
        try {
            List<Vehiculos> listVehiculos = new ArrayList<Vehiculos>();

            for (VehiculosDTO vehiculosDTO : listVehiculosDTO) {
                Vehiculos vehiculos = vehiculosDTOToVehiculos(vehiculosDTO);

                listVehiculos.add(vehiculos);
            }

            return listVehiculos;
        } catch (Exception e) {
            throw e;
        }
    }
}
