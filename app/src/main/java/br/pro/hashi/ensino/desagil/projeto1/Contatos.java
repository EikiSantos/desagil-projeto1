package br.pro.hashi.ensino.desagil.projeto1;

public class Contatos {
    private String number;
    private String name;
    public Contatos(){
        number = null;
        name = null;
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
