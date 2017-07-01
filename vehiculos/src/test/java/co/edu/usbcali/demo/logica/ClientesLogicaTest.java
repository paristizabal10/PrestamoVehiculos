package co.edu.usbcali.demo.logica;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.usb.dataaccess.dao.ITiposDocumentosDAO;
import co.edu.usb.modelo.Clientes;
import co.edu.usb.modelo.TiposDocumentos;
import co.edu.usb.modelo.control.IClientesLogic;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class ClientesLogicaTest {
	
	private final static Logger log=LoggerFactory.getLogger(ClientesLogicaTest.class);
	
	@Autowired
	private IClientesLogic clientesLogica;
	
	@Autowired
	private ITiposDocumentosDAO tiposDocumentosDAO;	
	
	private Long cliId=17636L;

	@Test
	public void atest()throws Exception {
		assertNotNull(clientesLogica);
		assertNotNull(tiposDocumentosDAO);
		
		Clientes clientes=clientesLogica.getClientes(cliId);
		assertNull("El cliente ya existe", clientes);
		
		clientes=new Clientes();
		clientes.setCliDireccion("Avenida Siempre Viva 123");
		clientes.setCliId(cliId);
		clientes.setCliMail("hsimpson@gmail.com");
		clientes.setCliNombre("Homero J Simpson");
		clientes.setCliTelefono("555-5555");
		
		TiposDocumentos tiposDocumentos =tiposDocumentosDAO.findById(20L);
		assertNotNull("El tipo de documento no existe", tiposDocumentos);
		
		clientes.setTiposDocumentos(tiposDocumentos);
		
		clientesLogica.saveClientes(clientes);
		
	}
	
	
	@Test
	public void btest()throws Exception {
		assertNotNull(clientesLogica);
		assertNotNull(tiposDocumentosDAO);
		
		Clientes clientes=clientesLogica.getClientes(cliId);
		assertNotNull("El cliente no existe", clientes);
		
		log.info("Nombre:"+clientes.getCliNombre());
		
		
	}
	
	@Test
	public void ctest() throws Exception{
		assertNotNull(clientesLogica);
		assertNotNull(tiposDocumentosDAO);
		
		Clientes clientes=clientesLogica.getClientes(cliId);
		assertNotNull("El cliente no existe", clientes);
		
		
		clientes.setCliDireccion("Avenida Siempre Viva 123");
		clientes.setCliMail("hsimpson@hotmail.com");
		clientes.setCliNombre("Homero J Simpson");
		clientes.setCliTelefono("555-5555-44");
		
		TiposDocumentos tiposDocumentos =tiposDocumentosDAO.findById(10L);
		assertNotNull("El tipo de documento no existe", tiposDocumentos);
		
		clientes.setTiposDocumentos(tiposDocumentos);
		
		clientesLogica.updateClientes(clientes);
		
	}
	
	@Test
	public void dtest()throws Exception {
		assertNotNull(clientesLogica);
		assertNotNull(tiposDocumentosDAO);
		
		Clientes clientes=clientesLogica.getClientes(cliId);
		assertNotNull("El cliente no existe", clientes);
		
		clientesLogica.deleteClientes(clientes);
		
	}
	@Test
	
	public void etest() {
		assertNotNull(clientesLogica);
		assertNotNull(tiposDocumentosDAO);
		
		List<Clientes> losClientes = new ArrayList<Clientes>();
		try {
			losClientes = clientesLogica.getClientes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Clientes clientes : losClientes) {
			log.info(clientes.getCliNombre());
			log.info(clientes.getCliMail());
		}
		
		
	}

}




