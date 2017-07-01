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
import co.edu.usb.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private IClientesLogic clientesLogic;
    @Autowired
    private ITiposDocumentosLogic tiposDocumentosLogic;
    @Autowired
    private IVehiculosLogic vehiculosLogic;

    public List<Clientes> getClientes() throws Exception {
        return clientesLogic.getClientes();
    }

    public void saveClientes(Clientes entity) throws Exception {
        clientesLogic.saveClientes(entity);
    }

    public void deleteClientes(Clientes entity) throws Exception {
        clientesLogic.deleteClientes(entity);
    }

    public void updateClientes(Clientes entity) throws Exception {
        clientesLogic.updateClientes(entity);
    }

    public Clientes getClientes(Long cliId) throws Exception {
        Clientes clientes = null;

        try {
            clientes = clientesLogic.getClientes(cliId);
        } catch (Exception e) {
            throw e;
        }

        return clientes;
    }

    public List<Clientes> findByCriteriaInClientes(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return clientesLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Clientes> findPageClientes(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return clientesLogic.findPageClientes(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberClientes() throws Exception {
        return clientesLogic.findTotalNumberClientes();
    }

    public List<ClientesDTO> getDataClientes() throws Exception {
        return clientesLogic.getDataClientes();
    }

    public void validateClientes(Clientes clientes) throws Exception {
        clientesLogic.validateClientes(clientes);
    }

    public List<TiposDocumentos> getTiposDocumentos() throws Exception {
        return tiposDocumentosLogic.getTiposDocumentos();
    }

    public void saveTiposDocumentos(TiposDocumentos entity)
        throws Exception {
        tiposDocumentosLogic.saveTiposDocumentos(entity);
    }

    public void deleteTiposDocumentos(TiposDocumentos entity)
        throws Exception {
        tiposDocumentosLogic.deleteTiposDocumentos(entity);
    }

    public void updateTiposDocumentos(TiposDocumentos entity)
        throws Exception {
        tiposDocumentosLogic.updateTiposDocumentos(entity);
    }

    public TiposDocumentos getTiposDocumentos(Long tdocCodigo)
        throws Exception {
        TiposDocumentos tiposDocumentos = null;

        try {
            tiposDocumentos = tiposDocumentosLogic.getTiposDocumentos(tdocCodigo);
        } catch (Exception e) {
            throw e;
        }

        return tiposDocumentos;
    }

    public List<TiposDocumentos> findByCriteriaInTiposDocumentos(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tiposDocumentosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TiposDocumentos> findPageTiposDocumentos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tiposDocumentosLogic.findPageTiposDocumentos(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTiposDocumentos() throws Exception {
        return tiposDocumentosLogic.findTotalNumberTiposDocumentos();
    }

    public List<TiposDocumentosDTO> getDataTiposDocumentos()
        throws Exception {
        return tiposDocumentosLogic.getDataTiposDocumentos();
    }

    public void validateTiposDocumentos(TiposDocumentos tiposDocumentos)
        throws Exception {
        tiposDocumentosLogic.validateTiposDocumentos(tiposDocumentos);
    }

    public List<Vehiculos> getVehiculos() throws Exception {
        return vehiculosLogic.getVehiculos();
    }

    public void saveVehiculos(Vehiculos entity) throws Exception {
        vehiculosLogic.saveVehiculos(entity);
    }

    public void deleteVehiculos(Vehiculos entity) throws Exception {
        vehiculosLogic.deleteVehiculos(entity);
    }

    public void updateVehiculos(Vehiculos entity) throws Exception {
        vehiculosLogic.updateVehiculos(entity);
    }

    public Vehiculos getVehiculos(String vehNumero) throws Exception {
        Vehiculos vehiculos = null;

        try {
            vehiculos = vehiculosLogic.getVehiculos(vehNumero);
        } catch (Exception e) {
            throw e;
        }

        return vehiculos;
    }

    public List<Vehiculos> findByCriteriaInVehiculos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return vehiculosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Vehiculos> findPageVehiculos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return vehiculosLogic.findPageVehiculos(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberVehiculos() throws Exception {
        return vehiculosLogic.findTotalNumberVehiculos();
    }

    public List<VehiculosDTO> getDataVehiculos() throws Exception {
        return vehiculosLogic.getDataVehiculos();
    }

    public void validateVehiculos(Vehiculos vehiculos)
        throws Exception {
        vehiculosLogic.validateVehiculos(vehiculos);
    }
}
