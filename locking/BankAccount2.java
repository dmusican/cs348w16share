// Try an ill-fated attempt to fix

class BankAccount {
    private int balance;
    private boolean busy = false;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        if (amount > balance)
            throw new CallCopsException();
        //balance = balance - amount;
        while (busy) {};  // spin-wait
        busy = true;
        int b = balance;  // push balance on stack
        int a = amount;   // push amount on stack
        int ans = b - a;  // subtract and push on stack
        balance = ans;    // pop off stack
        busy = false;
    }
}


    
