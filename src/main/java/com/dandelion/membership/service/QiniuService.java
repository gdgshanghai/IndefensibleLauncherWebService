package com.dandelion.membership.service;

import com.dandelion.membership.controller.BaseController;
import com.dandelion.membership.model.response.QiniuUploadTokenResponsePO;
import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;
import org.json.JSONException;
import org.springframework.stereotype.Service;

/**
 * Created by FengxiangZhu on 14-3-7.
 */
@Service
public class QiniuService {

    public QiniuUploadTokenResponsePO getUploadAccessToken() throws AuthException, JSONException {
        Config.ACCESS_KEY = BaseController.ACCESS_KEY;
        Config.SECRET_KEY = BaseController.SECRET_KEY;
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        String bucketName = BaseController.BUCKET_NAME;
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = putPolicy.token(mac);
        QiniuUploadTokenResponsePO qiniuUploadTokenResponsePO = new QiniuUploadTokenResponsePO();
        qiniuUploadTokenResponsePO.setUptoken(uptoken);
        return qiniuUploadTokenResponsePO;
    }
}
