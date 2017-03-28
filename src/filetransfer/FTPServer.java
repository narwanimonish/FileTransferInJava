/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetransfer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author monish
 */
public class FTPServer {
   public static void main(String args[]){
       ServerSocket server = null;
       try {
           server = new ServerSocket(9000);
       } catch (IOException ex) {
           Logger.getLogger(FTPServer.class.getName()).log(Level.SEVERE, null, ex);
       }
       InputStream is;
       byte byteArr[] = null;
       File fileName;
       FileOutputStream fos;
       BufferedOutputStream bos;
       while(true){
           try {
               Socket client = server.accept();
               is = client.getInputStream();
               fileName = new File("output.txt");
               fos = new FileOutputStream(fileName);
               bos = new BufferedOutputStream(fos);
               int bytesRead = is.read(byteArr);
               bos.write(byteArr);
               bos.close();
               client.close();
           } catch (IOException ex) {
               Logger.getLogger(FTPServer.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
       
   }
    
}
