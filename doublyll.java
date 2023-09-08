// linear doubly linked list program, insert in ascending order. 

class node{
    node next;
    node pre;
    int info;

    node(){
        next = null;
        pre = null;
        info = 0;
    }
    node(int n){
        info = n;
        next = null;
        pre = null;
    }
    void travrse(){
        node tp = this;
        node test = this;
        System.out.println("ascending order...");
        while(tp != null){
            System.out.println(tp.info+" ");
            test = tp;
            tp = tp.next;
        }
        System.out.println("descending order...");
        while(test != null){
            System.out.println(test.info+" ");
            test = test.pre;
        }
        
    }
    node insert_node(node new1) {
        node tp = this;

        if(tp.info > new1.info){
            new1.next=tp;
            tp.pre=new1;
            return new1;
        }
        
        while (tp.next != null && tp.next.info < new1.info) {
            tp = tp.next;
        }

        // Insert new node between tp and tp.next
        new1.next = tp.next;
        if (tp.next != null) {
            tp.next.pre = new1;
        }
        tp.next = new1;
        new1.pre = tp;
        return this;
    }

}
class doublyll{
    public static void main(String [] args){
        node first = new node(2);
        node n2 = new node(5);
        node n3 = new node(1);
        first=first.insert_node(n2);
        first=first.insert_node(n3);
        first.travrse();
    }
}