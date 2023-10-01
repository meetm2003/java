// Object class is super class of all class...

// Auto boxing : equals() is member method of object class not string...

class wrapclass{
    public static void main(String []args){
        Integer i = new Integer(10);
        int j = i;
        // auto unboxing method, compiler autometically conversion of assignment...
        System.out.println(j);


        Integer k = 9;
        //Auto Boxing...
        System.out.println(k);
    }
}