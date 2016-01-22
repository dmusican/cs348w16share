// Get it right!!!

class BankAccount {
    private int balance;
    public Object bankLock = new Object();

    public void setBalance(int balance) {
        synchronized (bankLock) {
            this.balance = balance;
        }
    }

    public void withdraw(int amount) {
        synchronized (bankLock) {
            if (amount > balance)
                throw new CallCopsException();
            //balance = balance - amount;
            setBalance(balance - amount);
        }
    }
}


    
