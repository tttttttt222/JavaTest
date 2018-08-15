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
        String body = " {\t\n" +
                "\n" +
                "\n" +
                "\"transContent\":\n" +
                "[{\n" +
                "\"trans_orderid\":\"10001\",\n" +
                "\"trans_batchid\":\"20001\",\n" +
                "\t\"trans_no\":\"1234567A\",\n" +
                "\t\"trans_money\":\"1.23\",\n" +
                "\t\"to_acc_name\":\"周小忍\",\n" +
                "\t\"to_acc_no\":\"6222601234567890\",\n" +
                "\t\"to_acc_dept\":\"上海市|上海市|工商银行张江支行\",\n" +
                "\"trans_summary\":\"\"\n" +
                "},{\n" +
                "\"trans_orderid\":\"10002\",\n" +
                "\"trans_batchid\":\"20001\",\n" +
                "\t\"trans_no\":\"1234567B\",\n" +
                "\t\"trans_money\":\"2.34\",\n" +
                "\t\"to_acc_name\":\"周小忍\",\n" +
                "\t\"to_acc_no\":\"6222601234567890\",\n" +
                "\t\"to_acc_dept\":\"上海市|上海市|工商银行张江支行\",\n" +
                "\"trans_summary\":\"\"\n" +
                "}]\n" +
                "}";

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
            T res = JSON.parseObject(body, t);
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
