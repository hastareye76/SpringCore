package hello.core.singleton;

public class SingletonService {
    
    private static SingletonService instance = new SingletonService();
    
    public static SingletonService getInstance() {
        return instance;
    }
    
    //외부에서 new 로 생성하지 못하게 막는다.
    private SingletonService() {
        
    }
    
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
