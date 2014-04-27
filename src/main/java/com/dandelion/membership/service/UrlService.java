package com.dandelion.membership.service;

import com.dandelion.membership.constant.UrlEnum;
import com.dandelion.membership.dao.UrlDao;
import com.dandelion.membership.dao.csv.ReadCVS;
import com.dandelion.membership.dao.csv.UrlEntryConverter;
import com.dandelion.membership.dao.model.UrlCollection;
import com.dandelion.membership.exception.IndefensibleException;
import com.dandelion.membership.model.hackathonmodel.UrlCatalogueResponse;
import com.googlecode.jcsv.writer.CSVWriter;
import com.googlecode.jcsv.writer.internal.CSVWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

@Service
public class UrlService {
    public static final String CVS_PATH = "src/main/resources/urlCollection.csv";
    @Autowired
    private UrlDao urlDao;


    public Map<String, String> getUrlCollectonMapByUrlList(List<String> list) throws IndefensibleException {
        Map<String, String> map = new HashMap<String, String>();
        for (String url : list) {
            UrlCollection record = urlDao.selectUrlCollectionByUrl(url);
            if (record != null) {
                String type = record.getType();
                map.put(url, type);
            }
        }
        return map;
    }

    public UrlCatalogueResponse getCollection(List<String> list) throws IndefensibleException {
        Map<String, String> m = getUrlCollectonMapByUrlList(list);
        UrlCatalogueResponse catalogueResponse = getUrlCatalogueResponse(list, m);
        return catalogueResponse;
    }

    public UrlCatalogueResponse getCollectionFromMemory(List<String> list) {
        Map<String, String> m = urlDao.initUrlCatalogueMap();
        UrlCatalogueResponse catalogueResponse = getUrlCatalogueResponse(list, m);
        return catalogueResponse;
    }


    private UrlCatalogueResponse getUrlCatalogueResponse(List<String> list, Map<String, String> m) {
        List<String> work = new ArrayList<String>();
        List<String> home = new ArrayList<String>();
        List<String> news = new ArrayList<String>();
        List<String> social = new ArrayList<String>();
        List<String> finance = new ArrayList<String>();
        List<String> shopping = new ArrayList<String>();

        for (String s : list) {
            if (m.containsKey(s)) {
                String catalogue = m.get(s);
                if (catalogue.equals(UrlEnum.WORK.name())) {
                    work.add(s);
                }
                if (catalogue.equals(UrlEnum.HOME.name())) {
                    home.add(s);
                }
                if (catalogue.equals(UrlEnum.NEWS.name())) {
                    news.add(s);
                }
                if (catalogue.equals(UrlEnum.SOCIAL.name())) {
                    social.add(s);
                }
                if (catalogue.equals(UrlEnum.FINANCE.name())) {
                    finance.add(s);
                }
                if (catalogue.equals(UrlEnum.SHOPPING.name())) {
                    shopping.add(s);
                }
            }
        }
        UrlCatalogueResponse catalogueResponse = new UrlCatalogueResponse();
        catalogueResponse.setFinance(finance);
        catalogueResponse.setHome(home);
        catalogueResponse.setShopping(shopping);
        catalogueResponse.setNews(news);
        catalogueResponse.setSocial(social);
        catalogueResponse.setWork(work);
        return catalogueResponse;
    }


    public void updateCollectionFromCVS() throws IndefensibleException {
//        Map<String, String> updateUrlMap = urlDao.initUrlCatalogueMap();
        ReadCVS readCVS = new ReadCVS();
        File file = new File(CVS_PATH);
        Map<String, String> updateUrlMap = readCVS.read(file.getAbsolutePath());

        for (String keySet : updateUrlMap.keySet()) {
            Date date = new Date();
            UrlCollection record = new UrlCollection();
            record.setUrl(keySet);
            record.setType(updateUrlMap.get(keySet));
            record.setCreateddate(date);
            record.setModifieddate(date);
            urlDao.insertUrlCollection(record);
        }
    }

    public void updateCVSCollection() throws IOException {
        List<UrlCollection> Urls = urlDao.selectAllUrlCollection();
        writeCsv(Urls);
    }

    private void writeCsv(List<UrlCollection> urls) throws IOException {
        File file = new File(CVS_PATH);
        Writer out = new FileWriter(file.getAbsolutePath());
        CSVWriter<UrlCollection> csvWriter =
                new CSVWriterBuilder<UrlCollection>(out).
                entryConverter(new UrlEntryConverter()).build();
        csvWriter.writeAll(urls);
    }

    public static void main(String[] args) throws IOException {
        List<UrlCollection> list = new ArrayList<UrlCollection>();
        UrlCollection collection = new UrlCollection();
        collection.setUrl("1");
        collection.setType("2");
        list.add(collection);
        UrlService urlService = new UrlService();
        urlService.writeCsv(list);
    }
}
