package br.pro.hashi.ensino.desagil.projeto1;

import java.io.Serializable;
import java.util.LinkedList;

public class ListaContatos implements Serializable {
    private Contatos contato;
    private LinkedList<Contatos> listaContatos;
    private LinkedList<String> names;
    private LinkedList<String> numbers;

    public ListaContatos(){
        listaContatos = new LinkedList<>();
        names = new LinkedList<>();
        numbers = new LinkedList<>();
    }
    public void addContatos(Contatos contato){
        listaContatos.add(contato);
        names.add(contato.getName());
        numbers.add(contato.getNumber());
    }
    public void removeContatos(Contatos contato){
        listaContatos.remove(contato);
        names.remove(contato.getName());
        numbers.remove(contato.getNumber());
    }

    public LinkedList<Contatos> getContato() {
        return listaContatos;
    }

    public LinkedList<String> getNames(){
        return names;
    }
    public LinkedList<String> getNumbers(){
        return numbers;
    }

}
