package co.edu.usb.presentation.backingBeans;

import co.edu.usb.exceptions.*;
import co.edu.usb.modelo.*;
import co.edu.usb.modelo.dto.VehiculosDTO;
import co.edu.usb.presentation.businessDelegate.*;
import co.edu.usb.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class VehiculosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(VehiculosView.class);
    private InputText txtVehCilindraje;
    private InputText txtVehMarca;
    private InputText txtVehModelo;
    private InputText txtVehPlaca;
    private InputText txtVehNumero;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<VehiculosDTO> data;
    private VehiculosDTO selectedVehiculos;
    private Vehiculos entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public VehiculosView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedVehiculos = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedVehiculos = null;

        if (txtVehCilindraje != null) {
            txtVehCilindraje.setValue(null);
            txtVehCilindraje.setDisabled(true);
        }

        if (txtVehMarca != null) {
            txtVehMarca.setValue(null);
            txtVehMarca.setDisabled(true);
        }

        if (txtVehModelo != null) {
            txtVehModelo.setValue(null);
            txtVehModelo.setDisabled(true);
        }

        if (txtVehPlaca != null) {
            txtVehPlaca.setValue(null);
            txtVehPlaca.setDisabled(true);
        }

        if (txtVehNumero != null) {
            txtVehNumero.setValue(null);
            txtVehNumero.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            String vehNumero = FacesUtils.checkString(txtVehNumero);
            entity = (vehNumero != null)
                ? businessDelegatorView.getVehiculos(vehNumero) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtVehCilindraje.setDisabled(false);
            txtVehMarca.setDisabled(false);
            txtVehModelo.setDisabled(false);
            txtVehPlaca.setDisabled(false);
            txtVehNumero.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtVehCilindraje.setValue(entity.getVehCilindraje());
            txtVehCilindraje.setDisabled(false);
            txtVehMarca.setValue(entity.getVehMarca());
            txtVehMarca.setDisabled(false);
            txtVehModelo.setValue(entity.getVehModelo());
            txtVehModelo.setDisabled(false);
            txtVehPlaca.setValue(entity.getVehPlaca());
            txtVehPlaca.setDisabled(false);
            txtVehNumero.setValue(entity.getVehNumero());
            txtVehNumero.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedVehiculos = (VehiculosDTO) (evt.getComponent().getAttributes()
                                               .get("selectedVehiculos"));
        txtVehCilindraje.setValue(selectedVehiculos.getVehCilindraje());
        txtVehCilindraje.setDisabled(false);
        txtVehMarca.setValue(selectedVehiculos.getVehMarca());
        txtVehMarca.setDisabled(false);
        txtVehModelo.setValue(selectedVehiculos.getVehModelo());
        txtVehModelo.setDisabled(false);
        txtVehPlaca.setValue(selectedVehiculos.getVehPlaca());
        txtVehPlaca.setDisabled(false);
        txtVehNumero.setValue(selectedVehiculos.getVehNumero());
        txtVehNumero.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedVehiculos == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Vehiculos();

            String vehNumero = FacesUtils.checkString(txtVehNumero);

            entity.setVehCilindraje(FacesUtils.checkString(txtVehCilindraje));
            entity.setVehMarca(FacesUtils.checkString(txtVehMarca));
            entity.setVehModelo(FacesUtils.checkString(txtVehModelo));
            entity.setVehNumero(vehNumero);
            entity.setVehPlaca(FacesUtils.checkString(txtVehPlaca));
            businessDelegatorView.saveVehiculos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                String vehNumero = new String(selectedVehiculos.getVehNumero());
                entity = businessDelegatorView.getVehiculos(vehNumero);
            }

            entity.setVehCilindraje(FacesUtils.checkString(txtVehCilindraje));
            entity.setVehMarca(FacesUtils.checkString(txtVehMarca));
            entity.setVehModelo(FacesUtils.checkString(txtVehModelo));
            entity.setVehPlaca(FacesUtils.checkString(txtVehPlaca));
            businessDelegatorView.updateVehiculos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedVehiculos = (VehiculosDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedVehiculos"));

            String vehNumero = new String(selectedVehiculos.getVehNumero());
            entity = businessDelegatorView.getVehiculos(vehNumero);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            String vehNumero = FacesUtils.checkString(txtVehNumero);
            entity = businessDelegatorView.getVehiculos(vehNumero);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteVehiculos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String action_modifyWitDTO(String vehCilindraje, String vehMarca,
        String vehModelo, String vehNumero, String vehPlaca)
        throws Exception {
        try {
            entity.setVehCilindraje(FacesUtils.checkString(vehCilindraje));
            entity.setVehMarca(FacesUtils.checkString(vehMarca));
            entity.setVehModelo(FacesUtils.checkString(vehModelo));
            entity.setVehPlaca(FacesUtils.checkString(vehPlaca));
            businessDelegatorView.updateVehiculos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("VehiculosView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtVehCilindraje() {
        return txtVehCilindraje;
    }

    public void setTxtVehCilindraje(InputText txtVehCilindraje) {
        this.txtVehCilindraje = txtVehCilindraje;
    }

    public InputText getTxtVehMarca() {
        return txtVehMarca;
    }

    public void setTxtVehMarca(InputText txtVehMarca) {
        this.txtVehMarca = txtVehMarca;
    }

    public InputText getTxtVehModelo() {
        return txtVehModelo;
    }

    public void setTxtVehModelo(InputText txtVehModelo) {
        this.txtVehModelo = txtVehModelo;
    }

    public InputText getTxtVehPlaca() {
        return txtVehPlaca;
    }

    public void setTxtVehPlaca(InputText txtVehPlaca) {
        this.txtVehPlaca = txtVehPlaca;
    }

    public InputText getTxtVehNumero() {
        return txtVehNumero;
    }

    public void setTxtVehNumero(InputText txtVehNumero) {
        this.txtVehNumero = txtVehNumero;
    }

    public List<VehiculosDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataVehiculos();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<VehiculosDTO> vehiculosDTO) {
        this.data = vehiculosDTO;
    }

    public VehiculosDTO getSelectedVehiculos() {
        return selectedVehiculos;
    }

    public void setSelectedVehiculos(VehiculosDTO vehiculos) {
        this.selectedVehiculos = vehiculos;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
