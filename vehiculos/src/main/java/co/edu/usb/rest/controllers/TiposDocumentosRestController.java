package co.edu.usb.rest.controllers;

import co.edu.usb.dto.mapper.ITiposDocumentosMapper;
import co.edu.usb.modelo.*;
import co.edu.usb.modelo.dto.TiposDocumentosDTO;
import co.edu.usb.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/tiposDocumentos")
public class TiposDocumentosRestController {
    private static final Logger log = LoggerFactory.getLogger(TiposDocumentosRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITiposDocumentosMapper tiposDocumentosMapper;

    @PostMapping(value = "/saveTiposDocumentos")
    public void saveTiposDocumentos(
        @RequestBody
    TiposDocumentosDTO tiposDocumentosDTO) throws Exception {
        try {
            TiposDocumentos tiposDocumentos = tiposDocumentosMapper.tiposDocumentosDTOToTiposDocumentos(tiposDocumentosDTO);

            businessDelegatorView.saveTiposDocumentos(tiposDocumentos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTiposDocumentos/{tdocCodigo}")
    public void deleteTiposDocumentos(
        @PathVariable("tdocCodigo")
    Long tdocCodigo) throws Exception {
        try {
            TiposDocumentos tiposDocumentos = businessDelegatorView.getTiposDocumentos(tdocCodigo);

            businessDelegatorView.deleteTiposDocumentos(tiposDocumentos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTiposDocumentos/")
    public void updateTiposDocumentos(
        @RequestBody
    TiposDocumentosDTO tiposDocumentosDTO) throws Exception {
        try {
            TiposDocumentos tiposDocumentos = tiposDocumentosMapper.tiposDocumentosDTOToTiposDocumentos(tiposDocumentosDTO);

            businessDelegatorView.updateTiposDocumentos(tiposDocumentos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTiposDocumentos")
    public List<TiposDocumentosDTO> getDataTiposDocumentos()
        throws Exception {
        try {
            return businessDelegatorView.getDataTiposDocumentos();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTiposDocumentos/{tdocCodigo}")
    public TiposDocumentosDTO getTiposDocumentos(
        @PathVariable("tdocCodigo")
    Long tdocCodigo) throws Exception {
        try {
            TiposDocumentos tiposDocumentos = businessDelegatorView.getTiposDocumentos(tdocCodigo);

            return tiposDocumentosMapper.tiposDocumentosToTiposDocumentosDTO(tiposDocumentos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
