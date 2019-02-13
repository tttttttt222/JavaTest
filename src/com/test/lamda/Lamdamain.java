package com.test.lamda;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/12/3
 */
public class Lamdamain {

    public static void main(String[] args) {

//        String s = new Lamdatest() {
//            @Override
//            public void say() {
//
//            }
//
//            @Override
//            public void how() {
//
//            }
//
//            @Override
//            public String tosay() {
//                return null;
//            }
//        }.tosay();

        String s = new Lamdatestimpl().flifehowtodoisright(() -> "Swasda");
        System.out.println(s);
    }


}
