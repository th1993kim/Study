package core.payment.infastructure;

import core.payment.entity.PaymentEntity;
import core.payment.infastructure.jpa.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentMySqlRepository implements PaymentRepository {
    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public PaymentEntity save(PaymentEntity payment) {
        return paymentJpaRepository.save(payment);
    }
}
