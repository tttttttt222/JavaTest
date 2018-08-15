package com.test.parse.dto;



public class TransApiReqHead {
    private String memberId; //商户号  必传

    private String terminalId; //终端号  必传

    private String serviceTp; //需要和请求的url(服务编号)一致

    private String verifyType;  //加密类型

    private String clientIp;

    private String dataType;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getServiceTp() {
        return serviceTp;
    }

    public void setServiceTp(String serviceTp) {
        this.serviceTp = serviceTp;
    }

    public String getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(String verifyType) {
        this.verifyType = verifyType;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
