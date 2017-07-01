package co.edu.usb.dataaccess.dao;

import co.edu.usb.dataaccess.api.JpaDaoImpl;
import co.edu.usb.modelo.TiposDocumentos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * TiposDocumentos entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.TiposDocumentos
 */
@Scope("singleton")
@Repository("TiposDocumentosDAO")
public class TiposDocumentosDAO extends JpaDaoImpl<TiposDocumentos, Long>
    implements ITiposDocumentosDAO {
    private static final Logger log = LoggerFactory.getLogger(TiposDocumentosDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ITiposDocumentosDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ITiposDocumentosDAO) ctx.getBean("TiposDocumentosDAO");
    }
}
