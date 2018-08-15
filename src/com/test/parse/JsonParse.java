package com.test.parse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.parse.dto.TransContent;
import com.test.parse.dto.TransHead;
import com.test.parse.dto.TransReqDatas;
import com.test.parse.dto.TransRespBF0001;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/6/1
 */
public class JsonParse {


    public static void main(String[] args) throws Exception {
        TransContent<TransRespBF0001> transContent = new TransContent<>();
        TransHead transHead = new TransHead();
        transContent.setTrans_head(transHead);
        transHead.setReturn_code("0000");
        transHead.setReturn_msg("请求交易成功");

        TransReqDatas<TransRespBF0001> transReqDatas = new TransReqDatas<>();
        transContent.setTrans_reqDatas(transReqDatas);

        List<TransRespBF0001> transRespBF0001s = new ArrayList<>();

        TransRespBF0001 transRespBF0001 = new TransRespBF0001();
        transRespBF0001.setAccount_type("1");
        transRespBF0001.setBalance("1000");
        transRespBF0001.setCurrency("1000");
        transRespBF0001s.add(transRespBF0001);

        TransRespBF0001 transRespBF0002 = new TransRespBF0001();
        transRespBF0002.setAccount_type("2");
        transRespBF0002.setBalance("2000");
        transRespBF0002.setCurrency("2000");
        transRespBF0001s.add(transRespBF0002);
//
//
//        TransRespBF0001 transRespBF0003 = new TransRespBF0001();
//        transRespBF0003.setAccount_type("3");
//        transRespBF0003.setBalance("3000");
//        transRespBF0003.setCurrency("3000");
//        transRespBF0001s.add(transRespBF0003);

        transReqDatas.setTrans_reqDatas(transRespBF0001s);

        String toXmlString = getToJsonString(transContent);

        System.out.println(toXmlString);

    }


    private static String getToJsonString(TransContent transRespContent) throws Exception {
        JSONObject jsonObjectResult = new JSONObject();

        JSONObject jsonAllParent = new JSONObject();
        jsonObjectResult.put("trans_content", jsonAllParent);

        if (transRespContent.getTrans_head() != null) {
            jsonAllParent.put("trans_head", transRespContent.getTrans_head());
        }
        if (transRespContent.getTrans_reqDatas() != null && transRespContent.getTrans_reqDatas().getTrans_reqDatas().size() > 0) {
            if (transRespContent.getTrans_reqDatas().getTrans_reqDatas().size() > 1) {
                JSONArray jsonAllRespDatasArray = new JSONArray();
                JSONObject jsonAllRespDataParent = new JSONObject();
                jsonAllRespDataParent.put("trans_reqData", jsonAllRespDatasArray);
                jsonAllParent.put("trans_reqDatas", jsonAllRespDataParent);
                for (Object obj : transRespContent.getTrans_reqDatas().getTrans_reqDatas()) {
                    jsonAllRespDatasArray.add(obj);
                }
            } else {
                JSONObject jsonAllRespDataParent = new JSONObject();
                jsonAllRespDataParent.put("trans_reqData", transRespContent.getTrans_reqDatas().getTrans_reqDatas().get(0));
                jsonAllParent.put("trans_reqDatas", jsonAllRespDataParent);
            }
        }
        return jsonObjectResult.toJSONString();
    }


}
