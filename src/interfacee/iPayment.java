package interfacee;

public interface iPayment {
	void addPayment(int PaymentID ,int OrderID, String PaymentMethod, String PaymentDate);
    void updatePayment(int PaymentID ,int OrderID, String PaymentMethod, String PaymentDate);
    void deletePayment(int PaymentID);
    void showPayment();
}
