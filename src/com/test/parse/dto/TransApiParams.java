package com.test.parse.dto;

/**
 * 项目名称:baofoo-fopay-api
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/7/23
 */
public class TransApiParams<T> {


    private TransApiReqHead header;

    private TransApiReqContent<T> body;    //加密之后的数据部分  必传


    public TransApiReqHead getHeader() {
        return header;
    }

    public void setHeader(TransApiReqHead header) {
        this.header = header;
    }

    public TransApiReqContent<T> getBody() {
        return body;
    }

    public void setBody(TransApiReqContent<T> body) {
        this.body = body;
    }
}
