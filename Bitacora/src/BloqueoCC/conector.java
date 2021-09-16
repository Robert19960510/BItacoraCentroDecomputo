package BloqueoCC;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class conector extends Thread
{
    private Socket s;
    private DataOutputStream salida;
    private DataInputStream otra;
    private ObjectInputStream entrada;
    final int puerto;
    String numeroMaquina;
    Bloqueo prueba;
    public boolean estado = false;
    String ipAux;
    boolean verdad = true;
    ruta nueva = new ruta();
    String message;
    
    public void setPrueba(Bloqueo prueba)
    {
        this.prueba = prueba;
    }
    
    public conector(String ip) 
    {
        numeroMaquina = nueva.leerNumeroMaquina();
        boolean verdad=true;
        ipAux = ip;
        puerto = 6000+Integer.parseInt(nueva.leerNumeroMaquina());
        System.out.println("el numero de maquina es: " + numeroMaquina);
        System.out.println("El puerto es " + puerto);
        System.out.println("la ipAux:  " + ipAux);
        while(verdad)
        {
            try 
            {
                this.s= new Socket(ip,this.puerto);
                this.salida = new DataOutputStream(s.getOutputStream());
                salida.writeUTF("Connection successful");
                verdad=false;
                this.otra = new DataInputStream(s.getInputStream());
            } 
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void run() 
    {
        while(verdad)
        {
            try 
            {
                estado = otra.readBoolean();
            } 
            catch (IOException ex) 
            {
               desconectar();
               verdad = false;
            }
        }
    }

    public void enviarM(String msg)
    {
        try
        {
            salida = new DataOutputStream(s.getOutputStream());
            salida.writeUTF("el cliente dice:"+msg + "\n");
        }
        catch(IOException e)
        {
        }
    }
    
    public String leerM()
    {
        try
        {
            return otra.readUTF();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public void desconectar()
    {
        try
        {
            s.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
