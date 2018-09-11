package com.test.designpatterns.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/11
 */
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
