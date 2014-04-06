package com.dandelion.membership.service;

import com.dandelion.membership.dianpingsdk.DianpingSign;
import com.dandelion.membership.model.hackathonmodel.*;
import com.dandelion.membership.util.OkHttpRequest;
import com.dandelion.membership.util.Util;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DianpingService {

    public static final String FIND_BUSINESSES = "http://api.dianping.com/v1/business/find_businesses?";
    public static final String FIND_DEALS = "http://api.dianping.com/v1/deal/find_deals?";

    public static void main(String[] args) throws MalformedURLException, IOException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("latitude", "31.18268013000488");
        map.put("longitude", "121.42769622802734");
        map.put("city", "上海");

        String params = DianpingSign.sign(map);
        String apiUrl = "http://api.dianping.com/v1/business/find_businesses?" + params;
        System.out.println(apiUrl);
        OkHttpRequest okHttpRequest = new OkHttpRequest();
        String response = okHttpRequest.get(new URL(apiUrl));
        System.out.println(response);
    }

    @Deprecated
    public VeneusListResponse getVeneus() {
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        VeneusResponse veneus1 = new VeneusResponse();
        veneus1.setId("1");
        veneus1.setTitle("85°C");
        veneus1.setUrl("www.google.com");
        VeneusResponse veneus2 = new VeneusResponse();
        veneus2.setId("2");
        veneus2.setTitle("M记");
        veneus2.setUrl("www.baidu.com");
        Gson gson = new Gson();
        array.put(gson.toJson(veneus1));
        array.put(gson.toJson(veneus2));
        List<VeneusResponse> list = new ArrayList<VeneusResponse>();
        list.add(veneus1);
        list.add(veneus2);
        VeneusListResponse veneusListResponse = new VeneusListResponse();
        veneusListResponse.setVeneus(list);
        return veneusListResponse;
    }

    /**
     * 查找商户
     *
     * @param latitude
     * @param longitude
     * @param keyword
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    public VeneusListResponse findbusiness(String latitude, String longitude, String keyword) throws MalformedURLException, IOException {
        Map<String, String> map = new HashMap<String, String>();
        if (!Util.isEmpty(latitude)) {
            map.put("latitude", latitude);
        }
        if (!Util.isEmpty(longitude)) {
            map.put("longitude", longitude);
        }
        if (!Util.isEmpty(keyword)) {
            map.put("keyword", keyword);
        }
        map.put("city", "上海");
        String params = DianpingSign.sign(map);
        String url = FIND_BUSINESSES + params;
        OkHttpRequest okHttpRequest = new OkHttpRequest();
        String response = okHttpRequest.get(new URL(url));
        Gson gson = new Gson();
        DianpingVeneusResponse dianpingVeneusResponse = gson.fromJson(response, DianpingVeneusResponse.class);
        List<DianpingBusinessResponse> list = dianpingVeneusResponse.getBusinesses();
        List<VeneusResponse> veneus = new ArrayList<VeneusResponse>();
        for (DianpingBusinessResponse l : list) {
            VeneusResponse veneusResponse = new VeneusResponse();
            veneusResponse.setId(l.getBusiness_id());
            veneusResponse.setTitle(l.getName());
            veneusResponse.setUrl(l.getBusiness_url());
            veneus.add(veneusResponse);
        }
        VeneusListResponse veneusListResponse = new VeneusListResponse();
        veneusListResponse.setVeneus(veneus);
        return veneusListResponse;
    }

    /**
     * 查找团购
     *
     * @param latitude
     * @param longitude
     * @return
     * @throws IOException
     * @throws MalformedURLException
     */
    public VeneusListResponse finddeals(String latitude, String longitude) throws MalformedURLException, IOException {
        Map<String, String> map = new HashMap<String, String>();
        if (!Util.isEmpty(latitude)) {
            map.put("latitude", latitude);
        }
        if (!Util.isEmpty(longitude)) {
            map.put("longitude", longitude);
        }
        map.put("city", "上海");
        String params = DianpingSign.sign(map);
        String url = FIND_DEALS + params;
        OkHttpRequest okHttpRequest = new OkHttpRequest();
        String response = okHttpRequest.get(new URL(url));
        Gson gson = new Gson();
        DianpingDealsListResponse dealsListResponse = gson.fromJson(response, DianpingDealsListResponse.class);
        List<DianpingDealInfoResponse> deals = dealsListResponse.getDeals();
        List<VeneusResponse> veneus = new ArrayList<VeneusResponse>();
        for (DianpingDealInfoResponse l : deals) {
            VeneusResponse veneusResponse = new VeneusResponse();
            veneusResponse.setId(l.getDeal_id());
            veneusResponse.setTitle(l.getTitle());
            veneusResponse.setUrl(l.getDeal_url());
            veneus.add(veneusResponse);
        }
        VeneusListResponse veneusListResponse = new VeneusListResponse();
        veneusListResponse.setVeneus(veneus);
        return veneusListResponse;
    }
}
