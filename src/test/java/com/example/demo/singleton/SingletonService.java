package com.example.demo.singleton;

public class SingletonService {
    //스태틱 영역에 객체 1개만 생성
    private  static final SingletonService instance = new SingletonService();

    //객체 인스턴스 필요하면 매서드로 조회하도록 허용
    public static  SingletonService getInstance(){
        return instance;
    }
    //외부에서 생성 못하게 막기
    private  SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
