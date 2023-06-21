package MusicCount;

public class Pessoa {
    private String nome;
    private int rock;
    private int pop;
    private int funk;
    private int forro;
    private int axe;
    private int country;
    private int mpb;
    private int pagode;
    private int jazz;
    private int rap;
    private int contagem = 0;

    public Pessoa(){}
    public Pessoa(String nome, int rock ,int pop ,int funk ,int forro ,int axe ,int country,int mpb ,int pagode ,int jazz, int rap) {

        this.nome = nome;
        this.rock = rock;
        this.pop = pop;
        this.funk = funk;
        this.forro = forro;
        this.axe = axe;
        this.country = country;
        this.mpb = mpb;
        this.pagode = pagode;
        this.jazz = jazz;
        this.rap = rap;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRock() {
        return rock;
    }

    public void setRock(int rock) {
        this.rock = rock;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public int getFunk() {
        return funk;
    }

    public void setFunk(int funk) {
        this.funk = funk;
    }

    public int getForro() {
        return forro;
    }

    public void setForro(int forro) {
        this.forro = forro;
    }

    public int getAxe() {
        return axe;
    }

    public void setAxe(int axe) {
        this.axe = axe;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getMpb() {
        return mpb;
    }

    public void setMpb(int mpb) {
        this.mpb = mpb;
    }

    public int getPagode() {
        return pagode;
    }

    public void setPagode(int pagode) {
        this.pagode = pagode;
    }

    public int getJazz() {
        return jazz;
    }

    public void setJazz(int jazz) {
        this.jazz = jazz;
    }

    public int getRap() {
        return rap;
    }

    public void setRap(int rap) {
        this.rap = rap;
    }

    public int getContagem() {
        return contagem;
    }

    public void setContagem(int contagem) {
        this.contagem = contagem;
    }
}
