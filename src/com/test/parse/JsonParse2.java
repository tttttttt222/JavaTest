package com.test.parse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.parse.dto.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/6/1
 */
public class JsonParse2 {


    public static void main(String[] args) throws Exception {

        String[] content = new String[2];

        String header = "{\"clientIp\":\"10.6.51.34\",\"dataType\":\"json\",\"memberId\":\"100000178\",\"platformFlag\":\"APIGateWayServer\",\"platformIp\":\"10.0.20.129\",\"serviceTp\":\"T-1001-003-01\",\"terminalId\":\"100000859\",\"verifyType\":\"1\"}";

        content[0] = header;

//        String body = "[{\"to_acc_dept\":\"浦东支行\",\"to_acc_name\":\"腾宇责任有限公司腾宇责任有限公司\",\"to_acc_no\":\"6217850800018933125\",\"to_bank_name\":\"中国银行\",\"to_city_name\":\"上海市\",\"to_pro_name\":\"上海市\",\"trans_cnap\":\"001100011002\",\"trans_money\":\"0.01\",\"trans_no\":\"SC4011532423187833\"},{\"to_acc_dept\":\"浦东支行\",\"to_acc_name\":\"腾宇责任有限公司腾宇责任有限公司\",\"to_acc_no\":\"6217850800018933125\",\"to_bank_name\":\"中国银行\",\"to_city_name\":\"上海市\",\"to_pro_name\":\"上海市\",\"trans_cnap\":\"001100011002\",\"trans_money\":\"0.01\",\"trans_no\":\"SC4011532423187840\"}]";
        String body = "{\n"
                + "    \"transContent\":{\n"
                + "        \"transNo\":\"SC4011532423187833\",\n"
                + "        \"transMoney\":\"0.01\",\n"
                + "        \"transType\":\"1\",\n"
                + "        \"transAccNo\":\"621785086668933125\",\n"
                + "        \"transAccName\":\"腾宇责任有限公司腾宇责任有限公司\",\n"
                + "        \"cardBankName\":\"中国银行\",\n"
                + "        \"cardCityName\":\"上海市\",\n"
                + "        \"cardProName\":\"上海市\",\n"
                + "        \"cardAccDept\":\"浦东支行\",\n"
                + "        \"cardCnap\":\"001100011002\",\n"
                + "        \"transIdCard\":\"32222188801014456\",\n"
                + "        \"transMobile\":\"1231231231231\",\n"
                + "        \"transSummary\":\"\"\n"
                + "    }\n"
                + "}";

        content[1] = body;

        decodeContent(content, TransReqBF0090001.class);

    }


    private static <T> TransApiParams<T> decodeContent(String[] content, Class<T> t) {

        TransApiParams transApiParams;

        String head = content[0].replaceAll("\\s*", "");
        String body = content[1].replaceAll("\\s*", "");
        JSONObject transContent = JSON.parseObject(body);

        if (transContent.get("transContent") instanceof JSONArray) {
            transApiParams=new TransApiParams<List<T>>();
            TransApiReqContent<List<T>> transApiReqContent = new TransApiReqContent<List<T>>();
            List<T> list = new ArrayList<T>();
            JSONArray jsonArray = transContent.getJSONArray("transContent");
            for (Object obj : jsonArray) {
                T res = JSON.parseObject(obj.toString(), t);
                list.add(res);
            }
            transApiReqContent.setTransContent(list);
            transApiParams.setBody(transApiReqContent);
        } else {
            transApiParams = new TransApiParams<T>();
            TransApiReqContent<T> tTransApiReqContent = new TransApiReqContent<>();
            String transContent1 = transContent.getString("transContent");
            T res = JSON.parseObject(transContent1, t);
            tTransApiReqContent.setTransContent(res);
            transApiParams.setBody(tTransApiReqContent);
        }

        TransApiReqHead res = JSON.parseObject(head, TransApiReqHead.class);
        transApiParams.setHeader(res);

        return transApiParams;

    }


//    private static <T> TransApiParams parseContent2(String[] content, Class<T> t) {
//
//        try {
//            TransApiParams TransApiParams;
//
//            String head = content[0].replaceAll("\\s*", "");
//            String body = content[1].replaceAll("\\s*", "");
//
//            if (body.startsWith("[")) {
//                TransApiParams = new TransApiParams<List<T>>();
//                List<T> list = new ArrayList<T>();
//                JSONArray jsonArray = JSON.parseArray(body);
//                for (Object obj : jsonArray) {
//                    T res = JSON.parseObject(obj.toString(), t);
//                    list.add(res);
//                }
//                TransApiParams.setBody(list);
//            } else {
//                TransApiParams = new TransApiParams<T>();
//                T res = JSON.parseObject(body, t);
//                TransApiParams.setBody(res);
//            }
//
//            TransApiReqHead res = JSON.parseObject(head, TransApiReqHead.class);
//            TransApiParams.setHeader(res);
//
//            return TransApiParams;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }



}
