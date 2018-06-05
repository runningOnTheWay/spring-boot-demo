package cn.newbie.test;

import cn.newbie.util.httpclient;

public class test1 {
    public static void main (String[] args){

//        String url = "https://api.github.com/repos/bitcoin/bitcoin/stats/commit_activity";
        String url = "https://api.github.com/repos/eosio/eos/stats/punch_card";

        String result = httpclient.sendGet(url,"");

        System.out.printf(result);
    }
}
