package com.dandelion.membership.dao;

import com.dandelion.membership.constant.UrlEnum;
import com.dandelion.membership.dao.data.UrlCollectionMapper;
import com.dandelion.membership.dao.model.UrlCollection;
import com.dandelion.membership.dao.model.UrlCollectionExample;
import com.dandelion.membership.exception.IndefensibleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UrlDao extends BaseDao {

    @Autowired
    private UrlCollectionMapper urlCollectionMapper;

    public void insertUrlCollection(UrlCollection record) throws IndefensibleException {
        String url = record.getUrl();
        UrlCollection temp = selectUrlCollectionByUrl(url);
        if (temp == null) {
            urlCollectionMapper.insertSelective(record);
        }
    }

    public UrlCollection selectUrlCollectionByUrl(String url) throws IndefensibleException {
        UrlCollectionExample example = new UrlCollectionExample();
        example.createCriteria().andUrlEqualTo(url);
        List<UrlCollection> list = urlCollectionMapper.selectByExample(example);
        return (UrlCollection) getUniqueRecordFromList(list);
    }


    public Map<String, String> initUrlCatalogueMap() {
        Map<String, String> map = new HashMap<String, String>();
        //work
        map.put("mingdao.com", UrlEnum.WORK.name());
        map.put("drive.google.com", UrlEnum.WORK.name());
        map.put("github.com", UrlEnum.WORK.name());
        map.put("stackoverflow.com", UrlEnum.WORK.name());
        map.put("mail.google.com", UrlEnum.WORK.name());
        map.put("google.com", UrlEnum.WORK.name());
        //home
        map.put("youku.com", UrlEnum.HOME.name());
        map.put("yyets.com", UrlEnum.HOME.name());
        map.put("bilibili.tv", UrlEnum.HOME.name());
        map.put("bilibili.kankanews.com", UrlEnum.HOME.name());
        map.put("taobao.com", UrlEnum.HOME.name());
        map.put("mojichina.com", UrlEnum.HOME.name());
        //news
        map.put("sina.com.cn", UrlEnum.NEWS.name());
        map.put("news.163.com", UrlEnum.NEWS.name());
        map.put("news.qq.com", UrlEnum.NEWS.name());
        map.put("36kr.com", UrlEnum.NEWS.name());
        map.put("engadget.com", UrlEnum.NEWS.name());
        map.put("news.dbanotes.net", UrlEnum.NEWS.name());
        map.put("pingwest.com", UrlEnum.NEWS.name());
        //social
        map.put("wx.qq.com", UrlEnum.SOCIAL.name());
        map.put("facebook.com", UrlEnum.SOCIAL.name());
        map.put("twitter.com", UrlEnum.SOCIAL.name());
        map.put("weibo.com", UrlEnum.SOCIAL.name());
        map.put("renren.com", UrlEnum.SOCIAL.name());
        map.put("plus.google.com", UrlEnum.SOCIAL.name());
        map.put("zhihu.com", UrlEnum.SOCIAL.name());
        map.put("accounts.google.com", UrlEnum.SOCIAL.name());
        //finance
        map.put("icbc.com.cn", UrlEnum.FINANCE.name());
        map.put("boc.cn", UrlEnum.FINANCE.name());
        map.put("alipay.com", UrlEnum.FINANCE.name());
        map.put("wallet.google.com", UrlEnum.FINANCE.name());
        //shopping
        map.put("jd.com", UrlEnum.SHOPPING.name());
        map.put("yhd.com", UrlEnum.SHOPPING.name());
        map.put("tmall.com", UrlEnum.SHOPPING.name());
        return map;
    }
}
