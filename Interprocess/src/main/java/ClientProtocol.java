import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
/**
 *
 * @author mpost
 */
public class ClientProtocol {
    static Socket socket;
    static DataInputStream din;
    static DataOutputStream dout;
    

   
   
    private void msg_done(java.awt.event.ActionEvent evt) {                                         
  
        try {
             String msgout = "Please input admission number";
      //  msgout = msg_text.getText().trim();
        dout.writeUTF(msgout);
            
        } catch (Exception e) {
        }
       
    }                                        

    private void msg_text(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
         
        try {
            socket = new Socket("127.0.0.1",5555);
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            String msgin="";
            
            while (!msgin.equals("exit")) {    
                msgin = din.readUTF();
                msg_area.setText(msg_area.getText().trim()+"\n Server:\t"+msgin);
                
            }
        } catch (Exception e) {
        }
    }

                   
    
}
 
