package com.test.parse.dto;


import java.util.List;

public class TransReqDatas<T> {

    //为空则不显示
    private String count;

    //去掉<trans_reqData>父节点<trans_reqDatas>
    private List<T> trans_reqDatas;

    public TransReqDatas() {

    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }


    public List<T> getTrans_reqDatas() {
        return trans_reqDatas;
    }

    public void setTrans_reqDatas(List<T> trans_reqDatas) {
        this.trans_reqDatas = trans_reqDatas;
    }

}