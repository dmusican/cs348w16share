// Get it right!!!

class BankAccount {
    private int balance;

    public synchronized void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int amount) {
        if (amount > balance)
            throw new CallCopsException();
        //balance = balance - amount;
        setBalance(balance - amount);
    }
}


    
