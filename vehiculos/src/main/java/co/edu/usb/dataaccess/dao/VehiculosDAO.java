package co.edu.usb.dataaccess.dao;

import co.edu.usb.dataaccess.api.JpaDaoImpl;
import co.edu.usb.modelo.Vehiculos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Vehiculos entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Vehiculos
 */
@Scope("singleton")
@Repository("VehiculosDAO")
public class VehiculosDAO extends JpaDaoImpl<Vehiculos, String>
    implements IVehiculosDAO {
    private static final Logger log = LoggerFactory.getLogger(VehiculosDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IVehiculosDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IVehiculosDAO) ctx.getBean("VehiculosDAO");
    }
}
