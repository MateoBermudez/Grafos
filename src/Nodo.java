public class Nodo {
    private char vertice;
    private int peso, camino;
    private Nodo liga;

    public Nodo(char vertice, int peso, int camino, Nodo liga) {
        this.vertice = vertice;
        this.peso = peso;
        this.liga = liga;
        this.camino = camino;
    }

    public char getVertice() {
        return vertice;
    }

    public void setVertice(char vertice) {
        this.vertice = vertice;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCamino() {
        return camino;
    }

    public void setCamino(int camino) {
        this.camino = camino;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
}
