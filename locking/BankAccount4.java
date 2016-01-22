// Get it right!!!

class BankAccount {
    private int balance;

    public void setBalance(int balance) {
        synchronized (this) {
            this.balance = balance;
        }
    }

    public void withdraw(int amount) {
        synchronized (this) {
            if (amount > balance)
                throw new CallCopsException();
            balance = balance - amount;
            //setBalance(balance - amount);
        }
    }
}


    
