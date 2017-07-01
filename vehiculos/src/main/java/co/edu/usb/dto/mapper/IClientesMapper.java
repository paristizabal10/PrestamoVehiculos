package co.edu.usb.dto.mapper;

import co.edu.usb.modelo.Clientes;
import co.edu.usb.modelo.dto.ClientesDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IClientesMapper {
    public ClientesDTO clientesToClientesDTO(Clientes clientes)
        throws Exception;

    public Clientes clientesDTOToClientes(ClientesDTO clientesDTO)
        throws Exception;

    public List<ClientesDTO> listClientesToListClientesDTO(
        List<Clientes> clientess) throws Exception;

    public List<Clientes> listClientesDTOToListClientes(
        List<ClientesDTO> clientesDTOs) throws Exception;
}
