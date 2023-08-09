package hello.core.lifecycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient  {
     private String Url;

     public NetworkClient(){
         System.out.println("생성자 호출, Url = " + Url);
         connect();
         call("초기화 연결 메시지");
     }

    public void setUrl(String url) {
        Url = url;
    }
    //서비스 시작
    public void connect(){
        System.out.println("connect : " + Url);
    }
    public void call(String string){
        System.out.println("call: " + Url + " message: " + string);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close : "+Url);

    }


    @PostConstruct
    public void init() {
         //프로퍼티 세팅이 끝나면, 호출해줄게.
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");

    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
