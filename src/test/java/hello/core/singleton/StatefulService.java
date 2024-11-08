package hello.core.singleton;

public class StatefulService {

    //singleton 객체에서는 상애를 유지하는 필드를 공유해서는 안된다......
    private int price; //상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price; //주문시 값을 변경할 수 있다.


    }

    public int getPrice() {
        return price;
    }
}
