package com.test.util;

import com.alibaba.fastjson.serializer.ValueFilter;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * 项目名称:fo-transfer-gw
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/3/19
 */
public class StringMarkUtil {
    // 卡号字段
    private static final List<String> MARK_CARD = Arrays.asList("bankCardNo", "recv_acc_no", "recvAccNo", "payAccNo", "bankAccount", "cardNo", "card_no", "trans_acc_no", "cardAccNo", "to_acc_no", "accountNo", "foAccountNo", "accNo",
             "transAccNo","payeePan","payerPan");
    private static final List<String> MARK_NAME = Arrays.asList("bankCardName", "recv_acc_name", "recvAccName", "payAccName", "cardHolderName", "card_name", "trans_acc_name", "cardAccName", "to_acc_name", "accountName", "foAccountName",
            "transAccName","payeeName","payerName");
    private static final List<String> MARK_ID_CARD = Arrays.asList("bankIdCardNo", "bankIdCard", "id_card_no", "idCard", "foCardId", "cardId", "trans_card_id","transIdCard","idCardNo","payeeIdCardNo","payerIdCardNo");
    private static final List<String> MARK_MOBILE = Arrays.asList("bankMobile", "mobile", "foMobile", "phoneNumber", "trans_mobile","transMobile","payeeMobile","payerMobile");
    private static final List<String> MARK_ALL = Arrays.asList("bankSecurityCode", "bankValidDate", "sms_code", "verifyCode", "content");

    private static final JSONValueFilter jsonValueFilter = new JSONValueFilter();

    private final static String data_type_json = "json";

    private final static String data_type_xml = "xml";


    public static String markDecryptString(String data, String dataType) {
        String res = "";
        if (StringUtils.isBlank(data) || StringUtils.isBlank(dataType)) {
            return "";
        }
        try {
            String trimData = data.replaceAll("\\s*", "");
            if (dataType.equals(data_type_json)) {
                String markJsonValue = getMarkJsonValue(MARK_CARD, trimData);
                String markJsonValue2 = getMarkJsonValue(MARK_NAME, markJsonValue);
                String markJsonValue3 = getMarkJsonValue(MARK_ID_CARD, markJsonValue2);
                String markJsonValue4 = getMarkJsonValue(MARK_ALL, markJsonValue3);
                res = getMarkJsonValue(MARK_MOBILE, markJsonValue4);
                return res;
            } else if (dataType.equals(data_type_xml)) {
                String markJsonValue = getMarkXMLValue(MARK_CARD, trimData);
                String markJsonValue2 = getMarkXMLValue(MARK_NAME, markJsonValue);
                String markJsonValue3 = getMarkXMLValue(MARK_ID_CARD, markJsonValue2);
                String markJsonValue4 = getMarkXMLValue(MARK_ALL, markJsonValue3);
                res = getMarkXMLValue(MARK_MOBILE, markJsonValue4);
                return res;
            }
        } catch (Exception e) {
            return "字符串脱敏异常" + e;
        }
        return "";
    }

    /**
     * JSON字符串掩码
     *
     * @param markString
     * @param target
     * @return
     */
    private static String getMarkJsonValue(List<String> markString, String target) {
        String value = "";
        boolean isString = false;
        for (String mark : markString) {
            int i = target.indexOf(mark);
            //校验key的正确
            if (i >= 0 && 34 == (target.charAt(i - 1)) && 34 == (target.charAt(i + mark.length()))) {
                int s = target.indexOf(":", i);
                int e = target.indexOf(",", i);
                if(e == -1){
                    e = target.indexOf("}", i);
                }
                value = target.substring(s + 1, e);
                if (value.contains("\"")) {  //检测是否是字符串
                    value = target.substring(s + 2, e - 1);
                    isString = true;
                }
                String markValue = markByName(mark, value);
                if (isString) {
                    return target.substring(0, s + 2) + markValue + target.substring(e - 1, target.length());
                } else {
                    return target.substring(0, s + 1) + markValue + target.substring(e, target.length());
                }
            }
        }
        return target;
    }


    /**
     * XML字符串掩码
     *
     * @param markString
     * @param target
     * @return
     */
    private static String getMarkXMLValue(List<String> markString, String target) {
        String value = "";
        for (String mark : markString) {
            int i = target.indexOf(mark);
            if (i >= 0 && 60 == (target.charAt(i - 1)) && 62 == (target.charAt(i + mark.length()))) {
                int s = target.indexOf(">", i);
                int e = target.indexOf("</", i);
                value = target.substring(s + 1, e);
                String markValue = markByName(mark, value);
                return target.substring(0, s + 1) + markValue + target.substring(e, target.length());
            }
        }
        return target;
    }


    public static String markBankCardNo(String propertyValue) {
        return markByName("recv_acc_no", propertyValue);
    }

    public static String markName(String propertyValue) {
        return markByName("recv_acc_name", propertyValue);
    }

    public static String markIdCardNo(String propertyValue) {
        return markByName("id_card_no", propertyValue);
    }

    public static String markMobileNo(String propertyValue) {
        return markByName("mobile", propertyValue);
    }


    public static JSONValueFilter getJsonValueFilter() {
        return jsonValueFilter;
    }

    public static String markString(int prelength, int lastlength, String propertyValue, int minlength) {
        return (String) mark(prelength, lastlength, propertyValue, minlength);
    }


    private static String markByName(String propertyName, String propertyValue) {
        Object obj = markContains(propertyName, propertyValue);
        if (obj == null) {
            return "";
        }
        String ret = (String) obj;
        return ret;
    }

    /**
     * 掩码处理
     *
     * @param prelength
     * @param lastlength
     * @param propertyValue
     * @param minlength
     * @return
     */
    private static Object mark(int prelength, int lastlength, Object propertyValue, int minlength) {
        try {
            if (propertyValue != null && StringUtils.length(propertyValue.toString()) >= minlength) {
                StringBuilder sb = new StringBuilder();
                sb.append(StringUtils.left(propertyValue.toString(), prelength)).append("***").append(
						StringUtils.right(propertyValue.toString(), lastlength));
                return sb.toString();
            } else {
                return propertyValue;
            }
        } catch (Exception e) {
            return null;
        }
    }


    private static Object markContains(String propertyName, Object propertyValue) {
        if (MARK_CARD.contains(propertyName)) {
            return mark(6, 4, propertyValue, 13);
        } else if (MARK_NAME.contains(propertyName)) {
            return mark(1, 0, propertyValue, 2);
        } else if (MARK_ID_CARD.contains(propertyName)) {
            return mark(6, 3, propertyValue, 18);
        } else if (MARK_MOBILE.contains(propertyName)) {
            return mark(3, 4, propertyValue, 11);
        } else if (MARK_ALL.contains(propertyName)) {
            return mark(0, 0, propertyValue, 1);
        } else {
            return propertyValue;
        }
    }


    /**
     * JSON掩码
     */
    public static class JSONValueFilter implements ValueFilter {

        @Override
        public Object process(Object source, String propertyName, Object propertyValue) {
            return markContains(propertyName, propertyValue);
        }

    }


}
