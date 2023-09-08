// class student has data member like idno, rank. make an array of that class and retrive those
//students which rank in between user given number and also if the user input is negative then
//throw exception. 
import java.util.Scanner;

class student{
    int idno,rank;
    student(){
        idno = 0;
        rank = 0;
    }
    student(int i, int r){
        idno = i;
        rank = r;
    }
    void display(){
        System.out.println(idno+"\t"+rank);
    }
}

class student_main{

    public static void main(String []args){
        
        int r1=0, r2=0;
        Scanner sc = new Scanner(System.in);

        student s[] = new student[5];
        s[0] = new student(1,2);
        s[1] = new student(2,1);
        s[2] = new student(3,5);
        s[3] = new student(4,3);
        s[4] = new student(5,4);

        try{
            System.out.println("Enter the rank 1::");
            r1 = sc.nextInt();
            if ( r1 < 0 ) throw new IllegalArgumentException("Sorry, Negative number is not allowed.");
            System.out.println("Enter the rank 2::");
            r2 = sc.nextInt();
            if ( r2 < 0 ) throw new IllegalArgumentException("Sorry, Negative number is not allowed.");
        }
        catch(IllegalArgumentException e){
            System.out.println(e);
            return;
        }

        System.out.println();
        System.out.println("id\trank");

        for(int i = 0; i < 5; i++){
            if(s[i].rank >= r1 && s[i].rank <= r2){
                s[i].display();
            }
        }
    }
}