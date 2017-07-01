package co.edu.usb.rest.controllers;

import co.edu.usb.dto.mapper.IClientesMapper;
import co.edu.usb.modelo.*;
import co.edu.usb.modelo.dto.ClientesDTO;
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
@RequestMapping("/clientes")
public class ClientesRestController {
    private static final Logger log = LoggerFactory.getLogger(ClientesRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IClientesMapper clientesMapper;

    @PostMapping(value = "/saveClientes")
    public void saveClientes(@RequestBody
    ClientesDTO clientesDTO) throws Exception {
        try {
            Clientes clientes = clientesMapper.clientesDTOToClientes(clientesDTO);

            businessDelegatorView.saveClientes(clientes);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteClientes/{cliId}")
    public void deleteClientes(@PathVariable("cliId")
    Long cliId) throws Exception {
        try {
            Clientes clientes = businessDelegatorView.getClientes(cliId);

            businessDelegatorView.deleteClientes(clientes);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateClientes/")
    public void updateClientes(@RequestBody
    ClientesDTO clientesDTO) throws Exception {
        try {
            Clientes clientes = clientesMapper.clientesDTOToClientes(clientesDTO);

            businessDelegatorView.updateClientes(clientes);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataClientes")
    public List<ClientesDTO> getDataClientes() throws Exception {
        try {
            return businessDelegatorView.getDataClientes();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getClientes/{cliId}")
    public ClientesDTO getClientes(@PathVariable("cliId")
    Long cliId) throws Exception {
        try {
            Clientes clientes = businessDelegatorView.getClientes(cliId);

            return clientesMapper.clientesToClientesDTO(clientes);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
