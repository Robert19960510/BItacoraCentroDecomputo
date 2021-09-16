package BloqueoCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ruta
{
    private final String RUTA = "C:\\Users\\a123\\AppData\\Local\\Bitacora\\src\\BloqueoCC\\";
    
    public String getRuta()
    {
        return RUTA;
    }

    public String getIP() 
    {
        Path path = Paths.get(getRuta()+"ip.dat");
        String linea;
        try
        {
            BufferedReader br = new BufferedReader(Files.newBufferedReader(path,Charset.defaultCharset()));
            linea = br.readLine();
            br.close();
            return linea;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    

    public String leerNumeroMaquina()
    {
        Path path = Paths.get(getRuta()+"numMaquina.txt");
        String linea;
        try
        {
            BufferedReader br = new BufferedReader(Files.newBufferedReader(path,Charset.defaultCharset()));
            linea = br.readLine();
            br.close();
            return linea;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
