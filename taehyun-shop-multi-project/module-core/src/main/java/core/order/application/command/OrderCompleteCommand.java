package core.order.application.command;

import core.payment.entity.PaymentMethod;

public record OrderCompleteCommand (

        long seqShopOrder,
        PaymentMethod paymentMethod
){

}
