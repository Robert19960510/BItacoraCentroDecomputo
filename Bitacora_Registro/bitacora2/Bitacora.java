package com.company.bitacora;

import com.company.conexion.Conector;
import com.company.conexion.Conector2;
import com.company.controladores.*;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.company.modelo.baseDatos;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;

public class Bitacora extends Application
{
    private Stage primaryStage = new Stage();
    private Scene scene;
    int puertos[] = new int[56];
    public static Conector servidores[] = new Conector[56];
    String message;
    @Override
    public void start(Stage stage) throws Exception
    {
        initRootLayout();
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
        initServers();
        new Thread(nuevo).start();
    }

    //pantallas loader del resto del sistema

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Bitacora.class.getResource("FXMLDocument.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            scene = new Scene(rootLayout);
            FXMLDocumentController controlador = loader.getController();
            controlador.setStage(primaryStage);
            controlador.setBitacora(this);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reservaDialog(String matricula, int numMaquina, Stage stage2, Bitacora bitacora) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Bitacora.class.getResource("reservaDIalog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Reserva Rapida");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ReservaDIalogController controlador = loader.getController();
            controlador.setDialogStage(dialogStage);
            controlador.setDialogStage2(stage2);
            controlador.setMatricula(matricula);
            controlador.setEquipo(numMaquina);
            controlador.setB(bitacora);
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DialogoReservaRapida(String numMaquina, String sala) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Bitacora.class.getResource("reservaRapida.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            Stage stage = new Stage();
            ReservaRapidaController controlador = loader.getController();
            controlador.setDialogStage(stage);
            controlador.setLabel(numMaquina, sala);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(this.primaryStage);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mensajeError(String mensaje, String header) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Bitacora.class.getResource("generica.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            genericoError controlador = loader.getController();
            controlador.setStage(dialogStage);
            controlador.setTexto(mensaje);
            controlador.setHeader(header);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void advertencia(String titulo, String mensaje, String header) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Bitacora.class.getResource("advertencia.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            advertencia controlador = loader.getController();
            controlador.setStage(dialogStage);
            controlador.setTexto(titulo, mensaje, header);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String confirmacion() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Bitacora.class.getResource("confirmacion.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.initStyle(StageStyle.UNDECORATED);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            Confirmacion controlador = loader.getController();
            controlador.setStage(dialogStage);
            dialogStage.showAndWait();
            return controlador.getBandera();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void Success(String titulo, String header, String contenido) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Bitacora.class.getResource("success.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Scene scene = new Scene(page);
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            dialogStage.setScene(scene);
            Success controlador = loader.getController();
            controlador.setStage(dialogStage);
            controlador.setHeader(header);
            controlador.setTitulo(titulo);
            controlador.setContenido(contenido);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //servidores del sistema;

    public void initPuertos() {
        for (int i = 0; i < puertos.length; i++) {
            puertos[i] = 6000 + i + 1;
        }
    }

    public void initServers() {
        initPuertos();
        for (int i = 0; i < servidores.length; i++) {
            servidores[i] = new Conector(puertos[i]);
            servidores[i].start();
        }
    }

    //comunicacion con panel

    String ipAux = "10.19.50.58";
    int puerto = 7000;
    boolean verdad =true;
    static DataOutputStream salida;
    static DataInputStream entrada;
    static Socket s;
    static int timeClock=480;

    Runnable nuevo = () ->
    {
        try {
            initConexionServidor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public void initConexionServidor() throws InterruptedException{
        boolean init=true;
        while(init){
            try{
                initConexion();
                init = false;
            }catch(IOException e){
                Thread.sleep(3000);
            }
        }
        LoopSending();
    }

    public void LoopSending() throws InterruptedException{
        while(verdad){
            try{
                message = entrada.readUTF();
                System.out.println(message);
                String tools[] = message.split(",");
                if (tools[0].equals("Desbloqueo")){
                    timeClock=480;
                    send(tools, true);
                }else{
                timeClock=60;
                send(tools, false);
                }
                Thread.sleep(1000);
            }
            catch (IOException | NullPointerException e){
                try {
                    cerrarConexion();
                    initConexion();
                }catch (IOException ex){
                }
            }
        }
    }

    public void send(String tools[], boolean estado)
    {
        if (tools[2].equals("all")){
            if (tools[1].equals("1")){
                enviarMensaje(estado,1,24,0);
            }else{
                enviarMensaje(estado,25,56,0);
            }
        }else{
            enviarMensaje(estado,0,0,Integer.parseInt(tools[2]));
        }
    }

    public void enviarMensaje(boolean estado,int rango1,int rango2,int equipo)
    {
        Thread hiloReservar = new Thread(){
            @Override
            public void run() {
                boolean verdad = true;
                while (verdad) {
                    try {
                        if (equipo == 0) {
                            for (int i = rango1; i <= rango2; i++) {
                                enviarMensajeMaquinas(i-1,estado);
                                Thread.sleep(250);
                            }
                        } else {
                            enviarMensajeMaquinas(equipo-1,estado);
                        }
                        verdad = false;
                        Thread.sleep(1000);
                    }catch (NullPointerException | InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        hiloReservar.start();
    }

    baseDatos bd = new baseDatos();
    public void enviarMensajeMaquinas(int equipo, boolean estado){
        Thread hiloReservar = new Thread(){
            @Override
            public void run(){
                int count=0;
                boolean verdad = true;
                while (verdad){
                    try{
                        Thread.sleep(1000);
                        servidores[equipo].enviarM(estado);
                        if (estado==true){
                            bd.actualizarEquipos(equipo+1,1);
                        }else{
                            bd.actualizarEquipos(equipo+1,0);
                        }verdad = false;
                    }
                    catch (NullPointerException | IOException  | InterruptedException e){
                        if (count==timeClock){
                            if (estado==false){
                                bd.actualizarEquipos(equipo+1,0);
                            }verdad=false;
                        }else{
                            count++;
                        }
                    }
                }
            }
        };
        hiloReservar.start();
    }

    public static void cerrarConexion(){
        try
        {
            salida.close();
            entrada.close();
            s.close();
        }
        catch (IOException e){
        }
    }

    public void initConexion() throws IOException
    {
        this.s= new Socket(ipAux,this.puerto);
        this.salida = new DataOutputStream(s.getOutputStream());
        this.entrada = new DataInputStream(s.getInputStream());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
