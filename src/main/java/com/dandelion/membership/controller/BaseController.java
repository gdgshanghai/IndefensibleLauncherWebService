package com.dandelion.membership.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ouroc on 4/6/14.
 */
public class BaseController {
    public static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String DASHBOARD = "dashboard";
    public static final String LOGIN = "login";
    public static final String HOME = "home";
    public static final String NIL = "/";


    public static final String ACCESS_KEY = "7EAZL7bN77bzyRLd8_4aIBIVKC6J45hMQKulx69c";
    public static final String SECRET_KEY = "VRgfzWEf7jIILrnSKc_ewLHdKbGK2A2wwnE7PM2h";
    public static final String BUCKET_NAME = "indefensible-launcher";
    public static final String TEST_IMAGE_PATH = "/Users/ouroc/Desktop/Fullscreen_3_3_14__10_09_PM.png";

    public static final String QINIU_UPLOADTOKEN = "/qiniu/uploadtoken";


    protected Gson gson;

    public BaseController() {
        gson = new Gson();
    }

}
