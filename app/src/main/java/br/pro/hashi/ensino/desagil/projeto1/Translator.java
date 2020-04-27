/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import java.util.HashMap;
import java.util.LinkedList;

public class Translator {
    private Node root;
    private HashMap<Character, Node> map;

    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {

        map = new HashMap<Character, Node>();

        Node root = new Node(' ');
        root.setLeft(e);
        root.setRight(t);

        Node a = new Node(a);
        a.setParent(e);
        a.setLeft(r);
        a.setRight(w);
        map.put(a, a);
            
        Node b = new Node(b);
        b.setParent(d);
        b.setLeft(num6);
        b.setRight(equal);
        map.put(b, a);

        Node c = new Node(c);
        c.setParent(k);
        map.put(c, c);

        Node d = new Node(d);
        d.setParent(n);
        d.setLeft(b);
        d.setRight(x);
        map.put(d, d);

        Node e = new Node(e);
        e.setParent(root);
        e.setLeft(i);
        e.setRight(a);
        map.put(e, e);

        Node f = new Node(f);
        f.setParent(u);
        map.put(f, f);

        Node g = new Node(g);
        g.setParent(m);
        g.setLeft(z);
        g.setRight(q);
        map.put(g, g);

        Node h = new Node(h);
        h.setParent(s);
        h.setLeft(num5);
        h.setRight(num4);
        map.put(h, h);

        Node i = new Node(i);
        i.setParent(e);
        i.setLeft(s);
        i.setRight(u);
        map.put(i, i);

        Node j = new Node(j);
        j.setParent(w);
        j.setRight(num1);
        map.put(j, j);

        Node k = new Node(k);
        k.setParent(n);
        k.setLeft(c);
        k.setRight(y);
        map.put(k, k);

        Node l = new Node(l);
        l.setParent(r);
        map.put(l, l);
        
        Node m = new Node(m);
        m.setParent(t);
        m.setLeft(g);
        m.setRight(o);
        map.put(m, m);

        Node n = new Node(n);
        n.setParent(t);
        n.setLeft(d);
        n.setRight(k);
        map.put(n, n);

        Node o = new Node(o);
        o.setParent(m);
        o.setLeft(vazio3);
        o.setRight(vazio4);
        map.put(o, o);
        

        Node p = new Node(p);
        p.setParent(w);
        map.put(p, p);

        Node q = new Node(q);
        q.setParent(g);
        map.put(q, q);

        Node r = new Node(r);
        r.setParent(a);
        r.setLeft(l);
        r.setRight(vazio2);
        map.put(r, r);

        Node s = new Node(s);
        s.setParent(i);
        s.setLeft(h);
        s.setRight(v);
        map.put(s, s);
        
        Node t = new Node(t);
        t.setParent(root);
        t.setLeft(n);
        t.setRight(m);
        map.put(t, t);

        Node u = new Node(u);
        u.setParent(i);
        u.setLeft(f);
        u.setRight(vazio1);
        map.put(u, u);

        Node v = new Node(v);
        v.setParent(s);
        v.setRight(num3);
        map.put(v, v);

        Node w = new Node(w);
        t.setParent(a);
        t.setLeft(p);
        t.setRight(j);
        map.put(w, w);
        
        Node x = new Node(x);
        x.setParent(d);
        x.setLeft(r);
        x.setRight(w);
        map.put(x, x);
        
        Node y = new Node(y);
        y.setParent(k);
        map.put(y, y);

        Node z = new Node(z);
        t.setParent(g);
        t.setLeft(num7);
        map.put(z, z);

        Node num1 = new Node(1);
        num1.setParent(j);
        map.put(1, num1);

        Node num2 = new Node(2);
        num1.setParent(vazio1);
        map.put(2, num2);

        Node num3 = new Node(3);
        num3.setParent(v);
        map.put(3, num3);

        Node num4 = new Node(4);
        num4.setParent(h);
        map.put(4, num4);

        Node num5 = new Node(5);
        num5.setParent(h);
        map.put(5, num5);
        
        Node num6 = new Node(6);
        num6.setParent(b);
        map.put(6, num6);

        Node num7 = new Node(7);
        num7.setParent(z);
        map.put(7, num7);

        Node num8 = new Node(8);
        num8.setParent(vazio3);
        map.put(8, num8);

        Node num9 = new Node(9);
        num9.setParent(vazio4);
        map.put(9, num9);

        Node num0 = new Node(0);
        num0.setParent(vazio4);
        map.put(0, num0);
        
        Node equal = new Node(=);
        equal.setParent(b);
        map.put(=, equal);

        Node barra = new Node(/);
        barra.setParent(x);
        map.put(/, barra);

        Node plus = new Node(+);
        plus.setParent(vazio2);
        map.put(+, plus);
        
        Node vazio1 = new Node(' ');
        vazio1.setParent(u);
        vazio1.setRight(num2);
        
        Node vazio2 = new Node(' ');
        vazio2.setParent(r); 
        vazio2.setLeft(plus);
        
        Node vazio3 = new Node(' ');
        vazio3.setParent(o);
        vazio3.setLeft(num8);

        Node vazio4 = new Node(' ');
        vazio4.setParent(o);
        vazio4.setLeft(num9);
        vazio4.setRight(num0);
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public char morseToChar(String code) {
        return ' ';
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    private String charToMorse(Node node) {
        return " ";
    }


    // Este método deve permanecer como está.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }


    ///////
    if (node.getLeft() == null) {
        Node newLeftNode = new Node(.);
        node.setLeft(newLeftNode);
        newLeftnode.setParent(node);
        node = newLeftNode;
    }
    else {
        return node;
    }

    if (node.getRight() == null) {
        Node newRightNode = new Node(_);
        node.setRight(newRightNode);
        newRightnode.setParent(node);
        node = newRightNode;
    }
    else {
        return node;
    }
    ///////

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {
        return new LinkedList<>();
    }
}
