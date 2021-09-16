package BloqueoCC;


public class JavaPrueba
{
    static conector conect;
    static Bloqueo nuevo;
    public static void main(String[] args) 
    {
        /*nuevo = new Bloqueo();
        nuevo.setVisible(true);
        nuevo.setAlwaysOnTop(true);*/
        pantallaPrueba prueba = new pantallaPrueba();
        prueba.setVisible(true);
        prueba.setAlwaysOnTop(true);
    }
    
    public static void initCliente(String ip)
    {
        conect = new conector(ip);
        conect.start();
    }
}
