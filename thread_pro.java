// Thread has same address space, process may have multiple threads...
// it is light weight component, it divides process in multiple thread and run it simulteniously...
// it is library class of java.lang packages...
// it is not abstract class then we have to create object of it...
// it must be extends which class we are using...

// context switching :: b|w process and b|w thread { change the context of process & thread }

// access control mechanism for shared resoures...

// there are 2 threads main thread, child thread...

// main thread terminated when main returns... it terminate last...
// child thread terminated when run() returns... it terminate first...
// if child thread takes more time to execution and main thread terminates first then
// program will not give any error but object created in main grabage blocks...

// To avoid main thread termination until child gets termination so join() method is used..

// join() method is non static member method of class thread...
// it is called for perent thread for every child thread...
// it throws intrrupted exception...
// ex :: ct1.join()

// run() method is override by class who inherite thread class...

// runnable interface only have one abstract method..

// thread constructor :: thread(), thread(String name)...
// main thread methods :: void setName(String s), String getName(), static Thread.currentThread()
// void setPriority(int priority), int getPriority();

// priority queue is used to ready state...

// order of the thread execution may or may not be same...

import java.lang.*;

class child_thread extends Thread{

    String msg;
    int id;
    String n;

    child_thread(String name, int i, String m){
        super(name);
        n = name;
        id = i;
        msg = m;
        start(); // To wake up thread... there is no any method to wake up thread...
        // it is initializaton of thread...
        // places thread ready to run state...
        // called run()
    }

    public void run(){ 
        for(int i = 0; i < 3; ++i ){
            try{
                System.out.println("Thread "+ n +" id " + id + " " + msg );
                // wait(2000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

class thread_pro{
    public static void main(String []args){
        Thread t = Thread.currentThread();
        System.out.println(t);

        t.setName("new"); // no static method
        String s = t.getName(); // no static method
        System.out.println(s);

        System.out.println();

        child_thread ct0 = new child_thread("child 0",3,"run for 0 thread");
        child_thread ct1 = new child_thread("child 1",2,"run for 1 thread");
        child_thread ct2 = new child_thread("child 2",1,"run for 2 thread");

        ct2.setPriority(10); // set priority of thread...
        int prio = ct2.getPriority(); // get the priority of thread...
        System.out.println("priority of thread :: " + prio);
        System.out.println();

        for(int i = 0; i < 3; ++i ){
            try{
                System.out.println();
                Thread.sleep(2000); // static method, takes number as milisecond, it blocks the thread..
                // after the coming out the block state, it goes to ready to run state...
                // sleep method is interrupted cause it throws interrupte Exception...
                // we may have to write in try catch block...
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}