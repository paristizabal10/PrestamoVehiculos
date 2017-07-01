package co.edu.usb.dataaccess.dao;

import co.edu.usb.dataaccess.api.JpaDaoImpl;
import co.edu.usb.modelo.Clientes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Clientes entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Clientes
 */
@Scope("singleton")
@Repository("ClientesDAO")
public class ClientesDAO extends JpaDaoImpl<Clientes, Long>
    implements IClientesDAO {
    private static final Logger log = LoggerFactory.getLogger(ClientesDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IClientesDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IClientesDAO) ctx.getBean("ClientesDAO");
    }
}
