package com.test.parse.dto;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/7/25
 */
public class TransApiReqContent<T> {

    private T transContent;


    public T getTransContent() {
        return transContent;
    }

    public void setTransContent(T transContent) {
        this.transContent = transContent;
    }
}
