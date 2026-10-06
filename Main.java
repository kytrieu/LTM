import java.io.*;
import java.net.*;


public class Main{
    public static void main(String[] args) {
        String sh = "36.50.135.242";
        int sp = 2207;
        String qc = "UIhzvOOP";
        String sc = "B23DCNC476";
        
        try(DatagramSocket sk = new DatagramSocket()) {
            String mess = ";" + qc + ";" + sc;
            byte[] sd = mess.getBytes();
            InetAddress sa  = InetAddress.getByName(sh);
            DatagramPacket dp = new DatagramPacket(
                    sd,
                    sd.length,
                    sa,
                    sp
            );
            sk.send(dp);
            
            
            byte[] rd = new byte[4096];
            DatagramPacket rp = new DatagramPacket(rd, rd.length);
            sk.receive(rp);
            
            String res = new String(
                    rp.getData(),
                    0,
                    rp.getLength()
            );
            
            String[] parts = res.split(";");
            
            String id = parts[0];
            String[] nums = parts[1].split(",");
            
            
            String ans = id + ";";
            
            byte[] ad = ans.getBytes();
            DatagramPacket ap = new DatagramPacket(
                    ad,
                    ad.length,
                    rp.getAddress(),
                    rp.getLength()
            );
            
            sk.send(ap);
            
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}