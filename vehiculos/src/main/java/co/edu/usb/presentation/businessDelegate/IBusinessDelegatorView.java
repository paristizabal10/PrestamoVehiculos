package co.edu.usb.presentation.businessDelegate;

import co.edu.usb.modelo.Clientes;
import co.edu.usb.modelo.TiposDocumentos;
import co.edu.usb.modelo.Vehiculos;
import co.edu.usb.modelo.control.ClientesLogic;
import co.edu.usb.modelo.control.IClientesLogic;
import co.edu.usb.modelo.control.ITiposDocumentosLogic;
import co.edu.usb.modelo.control.IVehiculosLogic;
import co.edu.usb.modelo.control.TiposDocumentosLogic;
import co.edu.usb.modelo.control.VehiculosLogic;
import co.edu.usb.modelo.dto.ClientesDTO;
import co.edu.usb.modelo.dto.TiposDocumentosDTO;
import co.edu.usb.modelo.dto.VehiculosDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Clientes> getClientes() throws Exception;

    public void saveClientes(Clientes entity) throws Exception;

    public void deleteClientes(Clientes entity) throws Exception;

    public void updateClientes(Clientes entity) throws Exception;

    public Clientes getClientes(Long cliId) throws Exception;

    public List<Clientes> findByCriteriaInClientes(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Clientes> findPageClientes(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberClientes() throws Exception;

    public List<ClientesDTO> getDataClientes() throws Exception;

    public void validateClientes(Clientes clientes) throws Exception;

    public List<TiposDocumentos> getTiposDocumentos() throws Exception;

    public void saveTiposDocumentos(TiposDocumentos entity)
        throws Exception;

    public void deleteTiposDocumentos(TiposDocumentos entity)
        throws Exception;

    public void updateTiposDocumentos(TiposDocumentos entity)
        throws Exception;

    public TiposDocumentos getTiposDocumentos(Long tdocCodigo)
        throws Exception;

    public List<TiposDocumentos> findByCriteriaInTiposDocumentos(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TiposDocumentos> findPageTiposDocumentos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTiposDocumentos() throws Exception;

    public List<TiposDocumentosDTO> getDataTiposDocumentos()
        throws Exception;

    public void validateTiposDocumentos(TiposDocumentos tiposDocumentos)
        throws Exception;

    public List<Vehiculos> getVehiculos() throws Exception;

    public void saveVehiculos(Vehiculos entity) throws Exception;

    public void deleteVehiculos(Vehiculos entity) throws Exception;

    public void updateVehiculos(Vehiculos entity) throws Exception;

    public Vehiculos getVehiculos(String vehNumero) throws Exception;

    public List<Vehiculos> findByCriteriaInVehiculos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Vehiculos> findPageVehiculos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberVehiculos() throws Exception;

    public List<VehiculosDTO> getDataVehiculos() throws Exception;

    public void validateVehiculos(Vehiculos vehiculos)
        throws Exception;
}
