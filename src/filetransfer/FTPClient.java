/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetransfer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author monish
 */
public class FTPClient {
     public static void main(String args[]){
        Socket client = null; 
        Scanner scan = new Scanner(System.in);
        try {
            client = new Socket(InetAddress.getLocalHost(),9000);
        } catch (IOException ex) {
            Logger.getLogger(FTPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connectin established to server on port 9000");
        System.out.println("Enter filename to send");
        String fileName = scan.nextLine();
        File fileObj;
        byte byteArr[];
        FileInputStream fin;
        OutputStream outStream;
        InputStream inStream;
         BufferedInputStream bis;
        
        try {
            fileObj= new File(fileName);
            byteArr = new byte [(int) fileObj.length()];
            fin = new FileInputStream(fileObj);
            bis = new BufferedInputStream(fin);
            bis.read(byteArr, 0, byteArr.length); //Reading data from file
            outStream = client.getOutputStream();
            inStream = client.getInputStream();
            outStream.write(byteArr, 0, byteArr.length);
            outStream.flush();
            client.close();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(FTPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
}
