package co.edu.usb.modelo.control;

import co.edu.usb.modelo.Vehiculos;
import co.edu.usb.modelo.dto.VehiculosDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IVehiculosLogic {
    public List<Vehiculos> getVehiculos() throws Exception;

    /**
         * Save an new Vehiculos entity
         */
    public void saveVehiculos(Vehiculos entity) throws Exception;

    /**
         * Delete an existing Vehiculos entity
         *
         */
    public void deleteVehiculos(Vehiculos entity) throws Exception;

    /**
        * Update an existing Vehiculos entity
        *
        */
    public void updateVehiculos(Vehiculos entity) throws Exception;

    /**
         * Load an existing Vehiculos entity
         *
         */
    public Vehiculos getVehiculos(String vehNumero) throws Exception;

    public List<Vehiculos> findByCriteria(Object[] variables,
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
