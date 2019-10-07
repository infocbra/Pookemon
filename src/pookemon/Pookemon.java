package pookemon;

public abstract class Pookemon {

    private String nomePookemon;
    
    private float vidaPookemon;

    private float danoPookemon;

    public abstract String atacar();

    public Pookemon(String nomePookemon, float vidaPookemon) {
        this.nomePookemon = nomePookemon;
        this.vidaPookemon = 100;        
    }
    
    public String getNomePookemon() {
        return nomePookemon;
    }
    
    public float getVidaPookemon() {
        return vidaPookemon;
    }

    public void setVidaPookemon(float vidaPookemon) {
        this.vidaPookemon = vidaPookemon;
    }

    public float getDanoPookemon() {
        return danoPookemon;
    }

    public void setDanoPookemon(float danoPookemon) {
        this.danoPookemon = danoPookemon;
    }           
}

