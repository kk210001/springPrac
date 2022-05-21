package com.example.demo.lifeCycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient  {


    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public NetworkClient() {
        System.out.println("생성자 호출 : url: " + url);

    }

    //서비스 시작
    public void connect() {
        System.out.println("connect " + url);

    }

    public void call(String message) {
        System.out.println("call " + url + " message " + message);
    }

    //서비스 종료
    public void disconnect() {
        System.out.println("close " + url);
    }

    @PostConstruct//최신 스프링에서 권장, 외부라이브러리에서 적용 못함
    public void init()   {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close()   {
        System.out.println("NetworkClient.close");
        disconnect();
    }

}
