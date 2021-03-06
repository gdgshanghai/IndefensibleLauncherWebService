package com.dandelion.membership.controller;

import com.dandelion.membership.model.response.QiniuUploadTokenResponsePO;
import com.dandelion.membership.service.QiniuService;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.rs.PutPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

/**
 * Created by ouroc on 4/6/14.
 */
@Controller
public class QiniuController extends BaseController {
    @Autowired
    private QiniuService qiniuService;

    public static void main(String[] args) throws Exception {
        Config.ACCESS_KEY = ACCESS_KEY;
        Config.SECRET_KEY = SECRET_KEY;
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        String bucketName = BUCKET_NAME;
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uploadToken = putPolicy.token(mac);
        PutExtra extra = new PutExtra();
        String key = UUID.randomUUID().toString();
        String localFile = TEST_IMAGE_PATH;
        IoApi.putFile(uploadToken, key, localFile, extra);
    }

    @RequestMapping(value = QINIU_UPLOADTOKEN, method = RequestMethod.GET)
    public ResponseEntity<QiniuUploadTokenResponsePO> getUploadAccessToken() throws Exception {
        QiniuUploadTokenResponsePO qiniuUploadTokenResponsePO = qiniuService.getUploadAccessToken();
        return new ResponseEntity<QiniuUploadTokenResponsePO>(qiniuUploadTokenResponsePO, HttpStatus.OK);
    }
}
