package com.jiangtf.demo.utils;

import com.jiangtf.demo.entity.TradeDeails;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class GeneratorDataUtil {
    private static Random random=new Random();

    //交易时间
    private static Date getRandomDate(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d=new Date(117,
                random.nextInt(7),
                (int)(Math.random()*28)+1,
                (int)(Math.random()*23)+1,
                (int)(Math.random()*59)+1,
                (int)(Math.random()*59)+1);
        System.out.println(format.format(d));
        return d;
    }
    static  Object[] accounts=null;
    static {
            Pair p1=new Pair<String,String> ("姜腾飞","001001001");
            Pair p2=new Pair<String,String> ("岳瑞瑞","002002002");
            Pair p3=new Pair<String,String> ("马兆鑫","003003003");
            Pair p4=new Pair<String,String> ("郭继鹏","004004004");
            accounts=new Object[]{p1,p2,p3,p4};
    }
    static Object[] oppAccounts=null;
    static {
        Pair p1=new Pair<String,String> ("姜一个","11111111111111");
        Pair p2=new Pair<String,String> ("姜两个","22222222222222");
        Pair p3=new Pair<String,String> ("姜三个","33333333333333");
        Pair p4=new Pair<String,String> ("姜发哦个","444444444444");
        Pair p5=new Pair<String,String> ("姜无个","555555555555555");
        oppAccounts=new Object[]{p1,p2,p3,p4,p5};
    }

    private static String generateSerialno(Date d){
        SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuffer key=new StringBuffer();
        key.append(formater.format(d));
        String uid= UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
        key.append(uid.substring(12));
        return key.toString();
    }
    private static Pair getRandomAccounts(){
        return (Pair) accounts[random.nextInt(accounts.length)];
    }
    private static Pair getRandomOppAccounts(){
        return (Pair) oppAccounts[random.nextInt(oppAccounts.length)];
    }

    static Object[] digests=null;
    static {
        String d1="转账";
        String d2="付款";
        String d3="百度买单";
        String d4="美团买单";
        String d5="淘宝买单";
        digests=new Object[]{d1,d2,d3,d4,d5};
    }
    private static String getRandomDigest(){
        return (String) digests[random.nextInt(digests.length)];
    }
    public static  void main(String args[]){
        System.err.println(getRandomBlance());
    }
    private static int getRanomCreditAmount(){
        return (int) ((Math.random()*100)+(Math.random()*300)+(Math.random()*80));
    }
    private static int getRandomBlance(){
        return (int) ((Math.random()*100000)+(Math.random()*3000)+(Math.random()*500));
    }
    public static TradeDeails generator(){
        TradeDeails td1=new TradeDeails();
        td1.setId(KeyUtil.generatorUUID());
        Date tradeDate=getRandomDate();

        td1.setId(generateSerialno(tradeDate));
        td1.setTradeId(KeyUtil.generatorUUID());
        td1.setTradeTime(tradeDate);
        td1.setDebitAmount(new BigDecimal(getRanomCreditAmount()));
        td1.setLenderAmount(new BigDecimal(0));
        td1.setTradeType("1");
        td1.setBalance(new BigDecimal(getRandomBlance()));

        Pair account=getRandomAccounts();
        td1.setAccountName((String) account.getObject1());
        td1.setAccountId((String) account.getObject2());

        Pair oppAccount=getRandomOppAccounts();
        td1.setOppAccountName((String) oppAccount.getObject1());
        td1.setOppAccountId((String) oppAccount.getObject2());

        td1.setDigesg(getRandomDigest());
        td1.setStatus("0");
        td1.setCreateBy("system");

        td1.setCreateTime(new Date());
        td1.setUpdateTime(new Date());

        return  td1;

    }

}
