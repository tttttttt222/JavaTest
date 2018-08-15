package com.test.parse;

import com.alibaba.fastjson.annotation.JSONField;
import com.test.parse.dto.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/6/1
 */
public class XmlParse {

    public final static String xml_head = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";


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


        TransRespBF0001 transRespBF0003 = new TransRespBF0001();
        transRespBF0003.setAccount_type("3");
        transRespBF0003.setBalance("3000");
        transRespBF0003.setCurrency("3000");
        transRespBF0001s.add(transRespBF0003);

        transReqDatas.setTrans_reqDatas(transRespBF0001s);

        String toXmlString = getToXmlString(transContent);

        System.out.println(toXmlString);


    }


    private static String getToXmlString(Object model) throws Exception {
        StringBuilder sb = new StringBuilder(xml_head + "<trans_content>");
        Method[] methods = model.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().startsWith("get") && !methods[i].getName().contains("getClass")) {
                methods[i].setAccessible(true);
                Object oj = methods[i].invoke(model, null);
                String methodName = methods[i].getName().substring(3, 4).toLowerCase() + methods[i].getName().substring(4);
                if (oj == null) {
                    continue;
                }
                try {//如果不存在会抛出异常直接往下继续执行
                    if (model.getClass().getDeclaredField(methodName) != null && model.getClass().getDeclaredField(methodName).getAnnotation(JSONField.class) != null) {
                        continue;
                    }
                } catch (Exception e) {
                }

                sb.append("<" + methodName + ">");
                if ("trans_reqDatas".equals(methodName)) {
                    List trans_reqDatas = ((TransReqDatas) oj).getTrans_reqDatas();
                    for (Object obj : trans_reqDatas) {
                        sb.append("<trans_reqData>");
                        sb.append(getToXmlObj(obj));
                        sb.append("</trans_reqData>");
                    }
                } else if ("trans_head".equals(methodName)) {
                    sb.append(getToXmlObj(oj));
                }
                sb.append("</" + methodName + ">");
            }
        }
        sb.append("</trans_content>");
        return sb.toString();
    }

    private static String getToXmlObj(Object target) throws Exception {
        StringBuilder sb = new StringBuilder();
        Method[] methods = target.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().startsWith("get") && !methods[i].getName().contains("getClass")) {
                String methodName = methods[i].getName().substring(3, 4).toLowerCase() + methods[i].getName().substring(4);
                try {//如果不存在会抛出异常直接往下继续执行
                    if (target.getClass().getDeclaredField(methodName) != null && target.getClass().getDeclaredField(methodName).getAnnotation(JSONField.class) != null) {
                        continue;
                    }
                } catch (Exception e) {
                }
                methods[i].setAccessible(true);
                Object oj = methods[i].invoke(target, null);
                if (oj == null) {
                    continue;
                }
                sb.append("<" + methodName + ">");
                sb.append(oj == null ? "" : oj);
                sb.append("</" + methodName + ">");
            }
        }
        return sb.toString();
    }
}
