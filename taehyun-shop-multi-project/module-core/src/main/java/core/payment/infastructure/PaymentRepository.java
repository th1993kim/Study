package core.payment.infastructure;

import core.payment.entity.PaymentEntity;

public interface PaymentRepository {
    PaymentEntity save(PaymentEntity payment);
}
