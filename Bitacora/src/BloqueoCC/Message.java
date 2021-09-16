package BloqueoCC;

import java.io.Serializable;

public class Message implements Serializable
{
    private String numeroMaquina;
    private int sala;
    private boolean estado;

    public Message(String numeroMaquina, int sala, boolean estado)
    {
        this.numeroMaquina = numeroMaquina;
        this.sala = sala;
        this.estado = estado;
    }

    public String getNumeroMaquina() {
        return numeroMaquina;
    }

    public void setNumeroMaquina(String numeroMaquina) {
        this.numeroMaquina = numeroMaquina;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
