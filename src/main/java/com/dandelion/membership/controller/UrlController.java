package com.dandelion.membership.controller;

import com.dandelion.membership.exception.IndefensibleErrors;
import com.dandelion.membership.exception.IndefensibleException;
import com.dandelion.membership.model.bo.IDLApp;
import com.dandelion.membership.model.hackathonmodel.IDLAppRequestPO;
import com.dandelion.membership.model.hackathonmodel.UrlCatalogueRequest;
import com.dandelion.membership.model.hackathonmodel.UrlCatalogueResponse;
import com.dandelion.membership.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/api/url")
public class UrlController extends BaseController {

    @Autowired
    private UrlService urlService;

    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public ResponseEntity<UrlCatalogueResponse> getCollection(@RequestParam(value = "j", required = true) String j)
            throws Exception {
        UrlCatalogueRequest catalogueRequest = gson.fromJson(j, UrlCatalogueRequest.class);
        if (catalogueRequest == null) {
            throw new IndefensibleException(
                    IndefensibleErrors.PARAM_ERROR_CODE,
                    IndefensibleErrors.PARAM_ERROR_MESSAGE);
        }
        List<String> list = catalogueRequest.getUrlList();
        UrlCatalogueResponse result = urlService.getCollectionByUrlList(list);
        return new ResponseEntity<UrlCatalogueResponse>(result, HttpStatus.OK);
    }

    /**
     * Indefensible-launcher
     * @param j
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/idlapp", method = RequestMethod.GET)
    public ResponseEntity<UrlCatalogueResponse> addCollection(@RequestParam(value = "j", required = true) String j)
            throws Exception {
        IDLAppRequestPO iDLAppRequestPO = gson.fromJson(j, IDLAppRequestPO.class);
        if (iDLAppRequestPO == null) {
            throw new IndefensibleException(
                    IndefensibleErrors.PARAM_ERROR_CODE,
                    IndefensibleErrors.PARAM_ERROR_MESSAGE);
        }
        List<IDLApp> list = iDLAppRequestPO.getUrlList();
        UrlCatalogueResponse result = urlService.getCollection(list);
        return new ResponseEntity<UrlCatalogueResponse>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/init/collection", method = RequestMethod.POST)
    public ResponseEntity<String> initCollection() throws IndefensibleException {
        urlService.updateCollectionFromCVS();
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "/csv", method = RequestMethod.POST)
    public ResponseEntity<String> initCsv() throws IOException {
        urlService.updateCVSCollection();
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
