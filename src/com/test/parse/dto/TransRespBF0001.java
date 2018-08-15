package com.test.parse.dto;


/**
 * 余额查询
 *
 * @author Administrator
 */
public class TransRespBF0001 {

    private String account_type;

    private String currency;

    private String balance;

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }


}
