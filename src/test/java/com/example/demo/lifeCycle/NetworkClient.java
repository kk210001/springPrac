package com.example.demo.lifeCycle;

public class NetworkClient {

    private  String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public NetworkClient() {
        System.out.println("생성자 호출 : url: " + url);
        connect();
        call("초기화 연결 메시지");

    }
    //서비스 시작
    public void connect(){
        System.out.println("connect " + url);

    }

    public void call(String message){
        System.out.println("call " + url + " message " + message);
    }
    //서비스 종료
    public void  disconnect(){
        System.out.println("close " + url);
    }

}
