package com.test.parse.dto;


public class TransContent<T> {


    private TransHead trans_head;

    private TransReqDatas<T> trans_reqDatas;

    public TransContent() {
    }


    public TransHead getTrans_head() {
        return trans_head;
    }

    public void setTrans_head(TransHead trans_head) {
        this.trans_head = trans_head;
    }

    public TransReqDatas<T> getTrans_reqDatas() {
        return trans_reqDatas;
    }

    public void setTrans_reqDatas(TransReqDatas<T> trans_reqDatas) {
        this.trans_reqDatas = trans_reqDatas;
    }
}