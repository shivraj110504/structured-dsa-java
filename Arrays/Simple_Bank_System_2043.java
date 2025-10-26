package Arrays;

public class Simple_Bank_System_2043 {

    public static class Bank {
        private long[] bal; // balances stored 0-indexed, accounts are 1-indexed

        // Helper: check if account is valid (1-based)
        private boolean valid(int acc) {
            return acc >= 1 && acc <= bal.length;
        }

        // Constructor
        public Bank(long[] balance) {
            // Defensive copy to avoid external mutation
            this.bal = new long[balance.length];
            System.arraycopy(balance, 0, this.bal, 0, balance.length);
        }

        // Transfer money between accounts
        public boolean transfer(int from, int to, long money) {
            if (!valid(from) || !valid(to))
                return false;
            if (bal[from - 1] < money)
                return false;
            bal[from - 1] -= money;
            bal[to - 1] += money;
            return true;
        }

        // Deposit money into account
        public boolean deposit(int acc, long money) {
            if (!valid(acc))
                return false;
            bal[acc - 1] += money;
            return true;
        }

        // Withdraw money from account
        public boolean withdraw(int acc, long money) {
            if (!valid(acc))
                return false;
            if (bal[acc - 1] < money)
                return false;
            bal[acc - 1] -= money;
            return true;
        }
    }
    public static void main(String[] args) {
        String[] ops = new String[]{"Bank", "Withdraw", "Transfer", "Deposit", "Withdraw"};
        long[] balances = new long[]{10, 100, 20, 50, 30};
        Bank b = new Bank(balances);

        // Corresponding to input sequence:
        // ["Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"]
        System.out.println("null"); // Bank constructor
        System.out.println(b.withdraw(3, 10));
        System.out.println(b.transfer(5, 1, 20));
        System.out.println(b.deposit(5, 20));
        System.out.println(b.transfer(3, 4, 15));
        System.out.println(b.withdraw(10, 50));

        System.exit(0);
        Bank bank = new Bank(balances);

        System.out.println(bank.withdraw(1, 50)); // true
        System.out.println(bank.transfer(2, 3, 100)); // true
        System.out.println(bank.deposit(3, 200)); // true
        System.out.println(bank.withdraw(1, 100)); // false
        System.out.println(bank.transfer(1, 4, 50)); // false

        //output: [null, true, true, true, false, false]
    }
}
