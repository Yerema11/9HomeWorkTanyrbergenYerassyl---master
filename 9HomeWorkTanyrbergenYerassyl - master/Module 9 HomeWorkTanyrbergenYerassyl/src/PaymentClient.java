public class PaymentClient {
    public static void main(String[] args) {
        IPaymentProcessor paypalProcessor = new PayPalPaymentProcessor();
        StripePaymentService stripeService = new StripePaymentService();
        IPaymentProcessor stripeProcessor = new StripePaymentAdapter(stripeService);
        AnotherPaymentService anotherService = new AnotherPaymentService();
        IPaymentProcessor anotherProcessor = new AnotherPaymentAdapter(anotherService);

        processPayment(paypalProcessor, 100.0);
        processPayment(stripeProcessor, 200.0);
        processPayment(anotherProcessor, 300.0);
    }
    private static void processPayment(IPaymentProcessor processor, double amount) {
        System.out.println("Обработка...");
        processor.processPayment(amount);
        System.out.println("Платеж успешно обработан.\n");
    }
}

