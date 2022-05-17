package order;

public interface OrderService {
    Order calculateOrder(Long memberId, String itemName, int itemPrice);
}
