package co.edu.usb.rest.controllers;

import co.edu.usb.dto.mapper.IVehiculosMapper;
import co.edu.usb.modelo.*;
import co.edu.usb.modelo.dto.VehiculosDTO;
import co.edu.usb.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/vehiculos")
public class VehiculosRestController {
    private static final Logger log = LoggerFactory.getLogger(VehiculosRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IVehiculosMapper vehiculosMapper;

    @PostMapping(value = "/saveVehiculos")
    public void saveVehiculos(@RequestBody
    VehiculosDTO vehiculosDTO) throws Exception {
        try {
            Vehiculos vehiculos = vehiculosMapper.vehiculosDTOToVehiculos(vehiculosDTO);

            businessDelegatorView.saveVehiculos(vehiculos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteVehiculos/{vehNumero}")
    public void deleteVehiculos(@PathVariable("vehNumero")
    String vehNumero) throws Exception {
        try {
            Vehiculos vehiculos = businessDelegatorView.getVehiculos(vehNumero);

            businessDelegatorView.deleteVehiculos(vehiculos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateVehiculos/")
    public void updateVehiculos(@RequestBody
    VehiculosDTO vehiculosDTO) throws Exception {
        try {
            Vehiculos vehiculos = vehiculosMapper.vehiculosDTOToVehiculos(vehiculosDTO);

            businessDelegatorView.updateVehiculos(vehiculos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataVehiculos")
    public List<VehiculosDTO> getDataVehiculos() throws Exception {
        try {
            return businessDelegatorView.getDataVehiculos();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getVehiculos/{vehNumero}")
    public VehiculosDTO getVehiculos(@PathVariable("vehNumero")
    String vehNumero) throws Exception {
        try {
            Vehiculos vehiculos = businessDelegatorView.getVehiculos(vehNumero);

            return vehiculosMapper.vehiculosToVehiculosDTO(vehiculos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
