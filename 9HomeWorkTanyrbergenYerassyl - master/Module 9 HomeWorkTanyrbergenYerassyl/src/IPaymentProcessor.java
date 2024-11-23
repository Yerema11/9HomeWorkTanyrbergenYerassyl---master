interface IPaymentProcessor {
    void processPayment(double amount);
}
class PayPalPaymentProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Обработка платежа $" + amount);
    }
}
class StripePaymentService {
    public void makeTransaction(double totalAmount) {
        System.out.println("Транзакция завершена $" + totalAmount);
    }
}
class StripePaymentAdapter implements IPaymentProcessor {
    private final StripePaymentService stripeService;

    public StripePaymentAdapter(StripePaymentService stripeService) {
        this.stripeService = stripeService;
    }

    @Override
    public void processPayment(double amount) {
        stripeService.makeTransaction(amount);
    }
}
class AnotherPaymentService {
    public void executePayment(double value) {
        System.out.println("Платеж выполнен  $" + value);
    }
}
class AnotherPaymentAdapter implements IPaymentProcessor {
    private final AnotherPaymentService anotherService;

    public AnotherPaymentAdapter(AnotherPaymentService anotherService) {
        this.anotherService = anotherService;
    }

    @Override
    public void processPayment(double amount) {
        anotherService.executePayment(amount);
    }
}

