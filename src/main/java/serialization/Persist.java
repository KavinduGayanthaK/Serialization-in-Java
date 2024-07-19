package serialization;

import serialization.dto.StudentDTO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persist {

    public static void main(String args[]){
        try{

            StudentDTO s1 =new StudentDTO("101","Kavindu");
            FileOutputStream fout=new FileOutputStream("f.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();

            out.close();
            System.out.println(out);
            System.out.println("success");
        }catch(Exception e){
            System.out.println(e);
        }

        try{

            ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
            StudentDTO s=(StudentDTO)in.readObject();
            System.out.println(s.getId()+" "+s.getName());
            in.close();
        }catch(Exception e){System.out.println(e);}
    }
}

