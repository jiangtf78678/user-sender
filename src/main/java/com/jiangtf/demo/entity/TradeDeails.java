package com.jiangtf.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
//com.jiangtf.demo.entity.TradeDeails
public class TradeDeails  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private String tradeId;

    private Date tradeTime;

    private BigDecimal debitAmount;

    private BigDecimal lenderAmount;

    private BigDecimal balance;

    private String tradeType;

    private String oppAccountName;

    private String oppAccountId;

    private String accountName;

    private String accountId;

    private String digesg;

    private String status;

    private String createBy;

    private Date updateTime;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId == null ? null : tradeId.trim();
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    public String getOppAccountName() {
        return oppAccountName;
    }

    public void setOppAccountName(String oppAccountName) {
        this.oppAccountName = oppAccountName == null ? null : oppAccountName.trim();
    }

    public String getOppAccountId() {
        return oppAccountId;
    }

    public void setOppAccountId(String oppAccountId) {
        this.oppAccountId = oppAccountId == null ? null : oppAccountId.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getDigesg() {
        return digesg;
    }

    public void setDigesg(String digesg) {
        this.digesg = digesg == null ? null : digesg.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}