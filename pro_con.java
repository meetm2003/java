// producer consumer problem...

class buffer{   
    int info;
    volatile int flag;
    // volatile instruct to compiler for not go for optimization, also it is opposite of constant...
    // it saves the space...
    // Encapsulation get() put() uses info & flag thats why they should be in same class...

    buffer(){
        flag = 0;
    }
    synchronized void put(int n, int id){
        // synchronized method is called, the lock will place then any other synchronize() or thread
        // dont use it, but only reading is possible...
        // lock is oppend when method id returns... 
        // it is member method of object class (super class of all class)
                
        // common object of any class can call wait which is synchronized...
        // access control can be archive through sunchronized...

        if(flag == 1){
            try{
                wait(); // it is called when it is in sychronize method otherwise throw exception...
                // it is also called interrupt...
            }
            catch(InterruptedException i){
                System.out.println(i);
            }
        }
        flag = 1;
        info = n;
        System.out.println("Produce::"+id);
        System.out.println(info);
        notify(); // it is notify to other thread which is in Block state or who wait() 
        // first for wakeup...
        // wait will reamaining when notify() not called...
        //else should be not there, cause it will never execute after schedule...
    }
    synchronized void get(int id){
        if(flag == 0){
            try{    
                wait();
            }
            catch(InterruptedException i){
                System.out.println(i);
            }
        }
        System.out.println("consume::"+id);
        System.out.println(info);
        flag = 0;
        notify();
    }  
}
class producer extends Thread{
    buffer b_ref;
    int pid; // if multiple producer are there...
    producer(buffer dummy, int id){
        super();
        b_ref = dummy;
        pid = id;
        start();
    }
    public void run(){
        for(int i = 0; i < 5; i++){
            b_ref.put(i,pid);
            try{
                Thread.sleep(2000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
class consumer extends Thread{
    buffer b_ref;
    int cid;
    consumer(buffer dummy, int id){
        super();
        b_ref = dummy;
        cid = id;
        start();
    }
    public void run(){
        for(int i = 0; i < 5; i++){
            b_ref.get(cid);
            try{
                Thread.sleep(2000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

class pro_con{
    public static void main(String []args){
        buffer b_ref = new buffer();
        producer p = new producer(b_ref,0);
        consumer c = new consumer(b_ref,0);
        
        producer p1 = new producer(b_ref,1);
        consumer c1 = new consumer(b_ref,1);
        try{
            p.join();
            c.join();

            p1.join();
            c1.join();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}