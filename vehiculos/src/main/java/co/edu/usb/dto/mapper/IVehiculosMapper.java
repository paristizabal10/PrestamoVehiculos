package co.edu.usb.dto.mapper;

import co.edu.usb.modelo.Vehiculos;
import co.edu.usb.modelo.dto.VehiculosDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IVehiculosMapper {
    public VehiculosDTO vehiculosToVehiculosDTO(Vehiculos vehiculos)
        throws Exception;

    public Vehiculos vehiculosDTOToVehiculos(VehiculosDTO vehiculosDTO)
        throws Exception;

    public List<VehiculosDTO> listVehiculosToListVehiculosDTO(
        List<Vehiculos> vehiculoss) throws Exception;

    public List<Vehiculos> listVehiculosDTOToListVehiculos(
        List<VehiculosDTO> vehiculosDTOs) throws Exception;
}
