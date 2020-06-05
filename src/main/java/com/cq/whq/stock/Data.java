package com.cq.whq.stock;

/**
 * @author whq
 * @version 1.0
 * @date 2020/5/27 20:57
 */
public class Data {
    private Long transactionID;
    private Long tradeId;
    private Long version;
    private String securityCode;
    private Long quantity;
    private String option;
    private String calc;

    public Data(Long transactionID,Long tradeId,Long version,String securityCode,Long quantity,String option,String calc){
        this.transactionID=transactionID;
        this.tradeId=tradeId;
        this.version=version;
        this.securityCode=securityCode;
        this.quantity=quantity;
        this.option=option;
        this.calc=calc;
    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getCalc() {
        return calc;
    }

    public void setCalc(String calc) {
        this.calc = calc;
    }
}
