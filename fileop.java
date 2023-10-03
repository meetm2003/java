// java uses concept of stream to make I/O operation fast...
// java.io package is used...

// stream is sequence of data...
// In java stream is composed of bytes...

// 3 streams are created automatically and streams are attached with console...
// System.in  :: standard i/p stream
// System.out :: standard o/p stream
// System.err :: standard error stream

// Inputstream :: java provides the ip/s for read data from file, array, peripheral device...
// Outputstream :: java provides the op/s for write data in file, array, peripheral device...

// Outputstream class is an abstract class...
// it is superclass of all class...
// op/s accepts byte output and send them to some sink...

// public void write(int) throws IOException :: it is used to write byte to current op/s.
// public void write(arr[]) throws IOException :: it is used to write array of byte to current op/s.
// public void flush() throws IOException :: it is used to flushes current op/s.
// public void close() throws IOException :: it is used to close the current op/s.

// Inputstream class is an abstract class...
// it is superclass of all class...

// public abstract int read() throws IOException :: reads the next byte of data from ip/s.
//      it returns -1 at the end of file...
// public int available() throws IOException :: returns estimate of number of bytes,
//      that can be read from current ip/s.
// public void close() throws IOException :: it is used to close the current ip/s.


// FileOutputStream is output stream used for writing data to file...
// you can write primitive value, byte oriented and char oriented...
// for char oriented FileWriter is used, it is better...

// FileInputStream obtains input bytes from a file...
// byte oriented data like image, audio, video etc, char stream data... 
// FileReader class is used for char stream data... it is better...

import java.util.*;
import java.io.*;

class fileop{
    public static void main(String []args){

        try{
            FileOutputStream fos = new FileOutputStream("fout.txt");
            FileInputStream fis = new FileInputStream("fin.txt");
            // String s = "hello";
            // byte b[] = s.getBytes(); // convert into bytes...
            // fos.write(b);
            int j = 0;
            System.out.print("fileoutstream, fileInputsstream ::" );
            while((j = fis.read()) != -1){
                System.out.print((char)j);
                fos.write((char)j);
            }
             // here we have to write assci value and that convert into char...
            fos.close();
            fis.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        System.out.println();

        try{
            FileWriter fw = new FileWriter("./fliewr.txt");
            FileReader fr = new FileReader("./filerd.txt");
            int st;

            // read each character from string and write
            // into FileWriter
            System.out.print("filewriter, filereader ::");
            while ((st = fr.read()) != -1){
                System.out.print((char)st);
                fw.write((char)st);
            }
            fr.close();
            fw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        System.out.println();

        try{
            //reads line and write into another file...
            BufferedReader br = new BufferedReader(new FileReader("./buffrd.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("./buffwr.txt"));
            String line;//it create the file if it is not there...
            System.out.print("buff reader, writer :: ");
            while((line = br.readLine()) != null){//it takes line...
                System.out.println(line);
                bw.write(line);
            }
            br.close();
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println();

        try{
            File f = new File("./file.txt");
            // if(f.createNewFile()){
            //     System.out.println("created...");
            // }
            System.out.println(f.getName());
            System.out.println(f.canWrite());
            System.out.println(f.canRead());
            System.out.println(f.getAbsolutePath());
            System.out.println(f.length());//no of bytes..
        }
        catch(Exception e){
            System.out.println(e);
        }

        System.out.println();

        try{
            FileOutputStream fos1 = new FileOutputStream("./fout1.txt");
            PrintStream ps = new PrintStream(fos1);
            ps.println("hello");//it print in newline...
            ps.close();
            fos1.close(); 
        }
        catch(Exception e){
            System.out.println(e);
        }

        System.out.println();

        try{
            PrintWriter p = new PrintWriter(new File("./prwrite.txt"));
            // it is implementation of writer class used to print the formatted representation of object...
            // used to append...
            p.write("hello");// it is not go for newline...
            p.append("world");
            CharSequence csq = " meet mistry";
            p.append(csq);
            p.flush(); // free the memory...
            p.close(); 
        }
        catch(Exception e){
            System.out.println(e);
        }

        System.out.println();
        // Scanner s = new Scanner(System.in);
        // int i = s.nextInt();
        // System.out.println("this is from Scanner :: "+i);
        System.out.println("hello...");
        System.err.println("error");
        int j = 0;
        try{
            j = System.in.read();
            // it will return Ascci of first char...
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("this is from System.in.println :: " + (char)j);
        // it will print 1 letter or number...
    }
}