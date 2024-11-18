package core.order.application.domain;

public record OrderDetail (
      String orderName,
      int price,
      long seqMember
) {

}
