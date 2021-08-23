package VirtualCB;
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Server
{
    public static void serverMethod()throws Exception
    {
            ServerSocket ss = new ServerSocket(7000);
            reg_details rd = new reg_details();
            System.out.println("Waiting");
            Socket s = ss.accept();
            System.out.println("Join");
            while(1>0) {
                try {
                    ObjectInputStream d1 = new ObjectInputStream(s.getInputStream());
                    Object rd1 = d1.readObject();
                    reg_details r3=(reg_details)rd1;
                    //System.out.println(rd2.getName());
                    if (r3.getDesignation().equals("Student")) {
                        reg_details r2 = new dbFunction().viewDetails(rd1.toString());
                        ObjectOutputStream d2b = new ObjectOutputStream(s.getOutputStream());
                        d2b.writeObject(r2);
                    }
                    else {
                        reg_details rd2 = (reg_details) rd1;
                        boolean r1 = new dbFunction().insertTable(rd2);
                        ObjectOutputStream d2 = new ObjectOutputStream(s.getOutputStream());
                        if (r1)
                            d2.writeObject(new Boolean(true));
                        else
                            d2.writeObject(new Boolean(false));
                    }
                }
                catch (Exception e){
                    System.out.println("Hii");
                    break;
                }
            }
    }
    public static void main(String[] args) throws Exception {
        serverMethod();
    }

}

