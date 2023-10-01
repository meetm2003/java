// interface specifies what should be done, not how it is done...

// class m implements i1, i2{ ... }

// interface i extends m{ ... }

// Interface references can used, it can reffers to object of those class which implemented interface...
// powerfull feature...^

// class which implements Interface can define all method as well as if one of them is not there,
// it is permitted, but that class become abstract class...

// the class of interface has all methods are abstract...
// By defalut it is public...
// Data member are final...

interface i{ // if we can do it public, write in seprate class file...
    void m1(); // abstract method
}
interface j{
    int a = 7; // value must initialize when we make data member of interface...
    void m2();
}
class a implements i{
    int no;
    a(){
        no = 0;
    }
    a(int no){
        this.no = no;
    }
    public void m1(){ // when we define interface, it must me public...
        System.out.println("for A " + no);
    }
}
class b implements i, j{
    int no;
    b(){
        no = 0;
    }
    b(int no){
        this.no = no;
    }
    public void m1(){
        System.out.println("for b m1 " + no);
    }
    public void m2(){
        System.out.println("for b m2 " + no + ", interface : data member " + a);
    }
}
class inface{
    public static void main(String []args){
        a a_ref = new a(10);
        b b_ref = new b(4);

        a_ref.m1();
        b_ref.m1();

        i i_ref;
        i_ref = new a(30); // we can write this cause class a implemented i...
        i_ref.m1();
        
        j j_ref;
        j_ref = new b(20); // we can write this cause class a implemented i...
        j_ref.m2();

        // i i_ref2;
        // i_ref2 = new b(30);
        // i_ref2.m2(); // here it gives an error cause if m2() is abstract method of interface then
                        // not give any error...
    }
}