public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(15000);
        double withdrawalAmount = 6000;
        while (true) {
            try {
                account.withdraw(withdrawalAmount);
                System.out.println("Снято " + withdrawalAmount + " сом. Остаток на счете: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println("Попытка снять больше, чем остаток на счете: " + e.getMessage());
                System.out.println("Снимаем доступную сумму: " + e.getRemainingAmount() + " сом");
                account.deposit(e.getRemainingAmount());
                break;
            }
        }
    }
}