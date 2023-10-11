/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myserversocket;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gerdoc
 */
public class MyServerSocket implements Serializable
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ServerSocket serverSocket = null;
        Socket socket = null;
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        int port = 9999;
        String msgRead = null;
        try 
        {    
            serverSocket = new ServerSocket( port );
            Logger.getLogger(MyServerSocket.class.getName( ) ).log(Level.INFO, "Waiting..." );
            socket = serverSocket.accept( );
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            bufferedReader = new BufferedReader(new InputStreamReader( socket.getInputStream()));
            msgRead = bufferedReader.readLine( );
            Logger.getLogger(MyServerSocket.class.getName( ) ).log(Level.INFO, "--------------------" );
            Logger.getLogger(MyServerSocket.class.getName( ) ).log(Level.INFO, msgRead );
            Logger.getLogger(MyServerSocket.class.getName( ) ).log(Level.INFO, "--------------------" );
            if ("hola gerdoc".equals(msgRead )) 
            {
                printWriter.println("Hola mundo");
            }
            else 
            {
                printWriter.println("Hola");
            }
            
            bufferedReader.close( );
            printWriter.close( );
            socket.close( );
            serverSocket.close( );
            Logger.getLogger(MyServerSocket.class.getName( ) ).log(Level.INFO, "End" );
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MyServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
