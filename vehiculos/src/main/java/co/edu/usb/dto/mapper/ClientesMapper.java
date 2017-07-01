package co.edu.usb.dto.mapper;

import co.edu.usb.modelo.*;
import co.edu.usb.modelo.Clientes;
import co.edu.usb.modelo.control.*;
import co.edu.usb.modelo.dto.ClientesDTO;

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
public class ClientesMapper implements IClientesMapper {
    private static final Logger log = LoggerFactory.getLogger(ClientesMapper.class);

    /**
    * Logic injected by Spring that manages TiposDocumentos entities
    *
    */
    @Autowired
    ITiposDocumentosLogic logicTiposDocumentos1;

    @Transactional(readOnly = true)
    public ClientesDTO clientesToClientesDTO(Clientes clientes)
        throws Exception {
        try {
            ClientesDTO clientesDTO = new ClientesDTO();

            clientesDTO.setCliId(clientes.getCliId());
            clientesDTO.setCliDireccion((clientes.getCliDireccion() != null)
                ? clientes.getCliDireccion() : null);
            clientesDTO.setCliMail((clientes.getCliMail() != null)
                ? clientes.getCliMail() : null);
            clientesDTO.setCliNombre((clientes.getCliNombre() != null)
                ? clientes.getCliNombre() : null);
            clientesDTO.setCliTelefono((clientes.getCliTelefono() != null)
                ? clientes.getCliTelefono() : null);
            clientesDTO.setTdocCodigo_TiposDocumentos((clientes.getTiposDocumentos()
                                                               .getTdocCodigo() != null)
                ? clientes.getTiposDocumentos().getTdocCodigo() : null);

            return clientesDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Clientes clientesDTOToClientes(ClientesDTO clientesDTO)
        throws Exception {
        try {
            Clientes clientes = new Clientes();

            clientes.setCliId(clientesDTO.getCliId());
            clientes.setCliDireccion((clientesDTO.getCliDireccion() != null)
                ? clientesDTO.getCliDireccion() : null);
            clientes.setCliMail((clientesDTO.getCliMail() != null)
                ? clientesDTO.getCliMail() : null);
            clientes.setCliNombre((clientesDTO.getCliNombre() != null)
                ? clientesDTO.getCliNombre() : null);
            clientes.setCliTelefono((clientesDTO.getCliTelefono() != null)
                ? clientesDTO.getCliTelefono() : null);

            TiposDocumentos tiposDocumentos = new TiposDocumentos();

            if (clientesDTO.getTdocCodigo_TiposDocumentos() != null) {
                tiposDocumentos = logicTiposDocumentos1.getTiposDocumentos(clientesDTO.getTdocCodigo_TiposDocumentos());
            }

            if (tiposDocumentos != null) {
                clientes.setTiposDocumentos(tiposDocumentos);
            }

            return clientes;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ClientesDTO> listClientesToListClientesDTO(
        List<Clientes> listClientes) throws Exception {
        try {
            List<ClientesDTO> clientesDTOs = new ArrayList<ClientesDTO>();

            for (Clientes clientes : listClientes) {
                ClientesDTO clientesDTO = clientesToClientesDTO(clientes);

                clientesDTOs.add(clientesDTO);
            }

            return clientesDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Clientes> listClientesDTOToListClientes(
        List<ClientesDTO> listClientesDTO) throws Exception {
        try {
            List<Clientes> listClientes = new ArrayList<Clientes>();

            for (ClientesDTO clientesDTO : listClientesDTO) {
                Clientes clientes = clientesDTOToClientes(clientesDTO);

                listClientes.add(clientes);
            }

            return listClientes;
        } catch (Exception e) {
            throw e;
        }
    }
}
