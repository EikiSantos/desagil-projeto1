/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Translator {
    private Node root;
    private HashMap<Character, Node> map;

    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {

        map = new HashMap<Character, Node>();

        root = new Node(' ');
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');
        Node h = new Node('h');
        Node i = new Node('i');
        Node j = new Node('j');
        Node k = new Node('k');
        Node l = new Node('l');
        Node m = new Node('m');
        Node n = new Node('n');
        Node o = new Node('o');
        Node p = new Node('p');  
        Node q = new Node('q');
        Node r = new Node('r');   
        Node s = new Node('s');
        Node t = new Node('t');
        Node u = new Node('u');
        Node v = new Node('v');
        Node w = new Node('w');
        Node x = new Node('x');
        Node y = new Node('y');
        Node z = new Node('z');
        Node num1 = new Node('1');
        Node num2 = new Node('2');
        Node num3 = new Node('3');
        Node num4 = new Node('4');
        Node num5 = new Node('5');        
        Node num6 = new Node('6');
        Node num7 = new Node('7');
        Node num8 = new Node('8');
        Node num9 = new Node('9');
        Node num0 = new Node('0');
        Node equal = new Node('=');
        Node barra = new Node('/');
        Node plus = new Node('+');
        Node vazio1 = new Node(' ');
        Node vazio2 = new Node(' ');
        Node vazio3 = new Node(' ');
        Node vazio4 = new Node(' ');



        root.setLeft(e);
        root.setRight(t);

        a.setParent(e);
        a.setLeft(r);
        a.setRight(w);
        map.put('a', a);
            
        b.setParent(d);
        b.setLeft(num6);
        b.setRight(equal);
        map.put('b', a);

        c.setParent(k);
        map.put('c', c);

        d.setParent(n);
        d.setLeft(b);
        d.setRight(x);
        map.put('d', d);

        e.setParent(root);
        e.setLeft(i);
        e.setRight(a);
        map.put('e', e);

        f.setParent(u);
        map.put('f', f);

        g.setParent(m);
        g.setLeft(z);
        g.setRight(q);
        map.put('g', g);

        h.setParent(s);
        h.setLeft(num5);
        h.setRight(num4);
        map.put('h', h);

        i.setParent(e);
        i.setLeft(s);
        i.setRight(u);
        map.put('i', i);

        j.setParent(w);
        j.setRight(num1);
        map.put('j', j);

        k.setParent(n);
        k.setLeft(c);
        k.setRight(y);
        map.put('k', k);

        l.setParent(r);
        map.put('l', l);

        m.setParent(t);
        m.setLeft(g);
        m.setRight(o);
        map.put('m', m);

        n.setParent(t);
        n.setLeft(d);
        n.setRight(k);
        map.put('n', n);


        o.setParent(m);
        o.setLeft(vazio3);
        o.setRight(vazio4);
        map.put('o', o);
        

        p.setParent(w);
        map.put('p', p);

        q.setParent(g);
        map.put('q', q);

        r.setParent(a);
        r.setLeft(l);
        r.setRight(vazio2);
        map.put('r', r);

        s.setParent(i);
        s.setLeft(h);
        s.setRight(v);
        map.put('s', s);
        
        t.setParent(root);
        t.setLeft(n);
        t.setRight(m);
        map.put('t', t);

        u.setParent(i);
        u.setLeft(f);
        u.setRight(vazio1);
        map.put('u', u);

        v.setParent(s);
        v.setRight(num3);
        map.put('v', v);

        w.setParent(a);
        w.setLeft(p);
        w.setRight(j);
        map.put('w', w);
        
        x.setParent(d);
        x.setLeft(r);
        x.setRight(w);
        map.put('x', x);

        y.setParent(k);
        map.put('y', y);

        z.setParent(g);
        z.setLeft(num7);
        map.put('z', z);

        num1.setParent(j);
        map.put('1', num1);

        num1.setParent(vazio1);
        map.put('2', num2);

        num3.setParent(v);
        map.put('3', num3);

        num4.setParent(h);
        map.put('4', num4);

        num5.setParent(h);
        map.put('5', num5);

        num6.setParent(b);
        map.put('6', num6);

        num7.setParent(z);
        map.put('7', num7);

        num8.setParent(vazio3);
        map.put('8', num8);

        num9.setParent(vazio4);
        map.put('9', num9);

        num0.setParent(vazio4);
        map.put('0', num0);
        
        equal.setParent(b);
        map.put('=', equal);

        barra.setParent(x);
        map.put('/', barra);

        plus.setParent(vazio2);
        map.put('+', plus);
        
        vazio1.setParent(u);
        vazio1.setRight(num2);
        
        vazio2.setParent(r); 
        vazio2.setLeft(plus);
        
        vazio3.setParent(o);
        vazio3.setLeft(num8);

        vazio4.setParent(o);
        vazio4.setLeft(num9);
        vazio4.setRight(num0);
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public char morseToChar(String code) {
        Queue<Character> queue = new LinkedList<>();
        Node ch = root;

        char[] result = code.toCharArray();

        for (char letra : result){
            queue.add(letra);
        }
        
        while (!queue.isEmpty()) {

            char atual = queue.element();

            if (atual == '.'){
                ch = ch.getLeft();
            }

            if (atual == '-') {
                ch = ch.getRight();
            }

            queue.remove();
        }
        return ch.getValue();
    }

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    private String charToMorse(Node node) {
        // Node ch = node;
        // while (node != root) {
        // ch = node.getParentNode();

        // }
        return " ";
    }


    // Este método deve permanecer como está.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {
        return new LinkedList<>();
    }
}