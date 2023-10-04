class fib extends Thread{
    int n;
    int sum;
    fib(int i){
        n = i;
    }
    public void run(){
        sum = fibbonaci(n);
    }
    int display(){
        return sum;
    }
    int fibbonaci(int i){
        if(i <= 1){
            return i;
        }
        else{
            return fibbonaci(i-1) + fibbonaci(i-2);
        }
    }
}
class fib_thread{
    public static void main(String []args){
        int sum;
        int n = 10;
        fib f = new fib(n-1);
        fib f1 = new fib(n-2);

        f.start();
        f1.start();
        try{
            f1.join();
            f1.join();
        }
        catch(Exception e){
            System.out.println(e);
        }
        sum = f.display() + f1.display();
        System.out.println(sum);
    }
}