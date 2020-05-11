package br.pro.hashi.ensino.desagil.projeto1;

public class Contatos {
    private String number;
    private String name;
    public Contatos(String number, String name){
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
