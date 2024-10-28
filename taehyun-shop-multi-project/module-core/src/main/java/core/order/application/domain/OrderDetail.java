package core.order.application.domain;

public record OrderDetail (
      String orderName,
      int price,
      int regId
) {

}
