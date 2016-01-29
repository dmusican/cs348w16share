class Mayhem {
    private int x = 0;
    private int y = 0;

    public void f() {
        synchronized(this) {
            x = 1;   // line A
            y = 1;   // line B
        }
    }

    public void g() {
        synchronized(this) {
            int a = y;   // line C
            int b = x;   // line D
            if (b < a)
                System.out.println("ERROR!");
        }
    }
}
