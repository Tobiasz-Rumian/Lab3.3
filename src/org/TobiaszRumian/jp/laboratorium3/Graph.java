package org.TobiaszRumian.jp.laboratorium3;

/**
 * Created by Tobiasz Rumian on 03.11.2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
 *  Program GraphicEditor
 *  Pozwala rysować przy użyciu dostępnych figur.
 *  Pozwala także na zmianę ich rozmiaru, przemieszczanie za pomocą myszy jak i klawiatury.
 *  Pozwala zmienić rozmiar figury za pomocą rolki myszy.
 *  Pozwala zapisać utworzony obraz jak i go wczytać.
 *  implementuje 6 figur: punkt, koło, trójkąt, klepsydrę, gwiazę oraz pięciokąt.
 *  Pozwala zmienić kolor figury w czasie rzeczywistym.
 *  Pozwala stworzyć dozwolone figury w podanych przez urzytkownika rozmiarach.
 *
 *  @author Tobiasz Rumian
 *  @version 1.0
 *   Data: 01 Listopad 2016 r.
 *   Indeks: 226131
 *   Grupa: śr 13:15 TN
 */

public class Graph extends JFrame implements ActionListener {

    private static final long serialVersionUID = 3727471814914970170L;


    public final static int SCREEN_X = 800;

    public final static int SCREEN_Y = 800;

    private ArrayList<JSlider> sliders = new ArrayList<>();
    private final String DESCRIPTION =
            "OPIS PROGRAMU\n\n" +
                    "Aktywna klawisze:\n" +
                    "   strzalki ==> przesuwanie figur\n" +
                    "   SHIFT + strzalki ==> szybkie przesuwanie figur\n" +
                    "   +,-  ==> powiekszanie, pomniejszanie\n" +
                    "   DEL  ==> kasowanie figur\n" +
                    "   p  ==> dodanie nowego punktu\n" +
                    "   c  ==> dodanie nowego kola\n" +
                    "   t  ==> dodanie nowego trojkata\n" +
                    "   g  ==> dodanie nowej gwiazdy\n" +
                    "   k  ==> dodanie nowej klepsydry\n" +
                    "   f  ==> dodanie nowego pięciokąta\n" +
                    "\nOperacje myszka:\n" + "   klik ==> zaznaczanie figur\n" +
                    "   ALT + klik ==> zmiana zaznaczenia figur\n" +
                    "   przeciaganie ==> przesuwanie figur\n"+
                    "   Kółko myszki ==> Zmiana rozmiaru figury";

    private final MainPanel mainPanel;
    private final MainPanel subPanel;
    private JMenuBar menuBar;
    private ArrayList<JMenu> menus = new ArrayList<>();
    //private JMenu[] menu = {new JMenu("Figury"), new JMenu("Edytuj"), new JMenu("Pomoc")};
    private JMenu[] menu1 = {new JMenu("Punkt"), new JMenu("Koło"), new JMenu("Trójkąt"), new JMenu("Gwiazda"), new JMenu("Klepsydra"), new JMenu("Pięciokąt")};
    private JMenuItem[] items = {new JMenuItem("Losowy Punkt"),//0
            new JMenuItem("Zadany Punkt"),//1
            new JMenuItem("Losowe Koło"),//2
            new JMenuItem("Zadane Koło"),//3
            new JMenuItem("Losowy Trójkąt"),//4
            new JMenuItem("Zadany Trójkąt"),//5
            new JMenuItem("Losowa Gwiazda"),//6
            new JMenuItem("Zadana Gwiazda"),//7
            new JMenuItem("Losowa Klepsydra"),//8
            new JMenuItem("Zadana Klepsydra"),//9
            new JMenuItem("Losowy Pięciokąt"),//10
            new JMenuItem("Zadany Pięciokąt"),//11
            new JMenuItem("Wypisz wszystkie"),//12
            new JMenuItem("Przesun w gore"),//13
            new JMenuItem("Przesun w dol"),//14
            new JMenuItem("Powieksz"),//15
            new JMenuItem("Pomniejsz"),//16
            new JMenuItem("Autor"),//17
            new JMenuItem("Opis programu"),//18
            new JMenuItem("Zapisz obraz"),//19
            new JMenuItem("Odczytaj obraz")//20
    };

    private Graph() {
        super("Edytor graficzny");
        setSize(SCREEN_X, SCREEN_Y);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel = new MainPanel();
        subPanel = new MainPanel();
        menuBar = new JMenuBar();

        mainPanel.add(subPanel,BorderLayout.CENTER);

        subPanel.setFocusable(true);
        subPanel.setLayout(new BorderLayout());
        //for (JMenu aMenu : menu) menuBar.add(aMenu);

        createSlider(JSlider.VERTICAL,0,360,0,360/4,360/8,"Przesuń");
        createSlider(JSlider.VERTICAL,0,100,10,50,10,"SkalujX");
        createSlider(JSlider.VERTICAL,0,100,10,50,10,"SkalujY");
        createSlider(JSlider.VERTICAL,1,1000,10,100,500,"Próbkowanie");
        setJMenuBar(menuBar);
        setContentPane(subPanel);
        setVisible(true);
        subPanel.createGraph();
        subPanel.addLine(new Point(0,Graph.SCREEN_Y/2),new Point(Graph.SCREEN_X,Graph.SCREEN_Y/2));
        subPanel.addLine(new Point(Graph.SCREEN_X/2,0),new Point(Graph.SCREEN_X/2,Graph.SCREEN_Y));
    }

    public static void main(String[] args) {
        new Graph();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    private void createSlider(int arrangement,int start, int end,
                              int now, int major, int minor,String name){
        JSlider slider=new JSlider(arrangement,start,end,now);

        slider.addChangeListener(subPanel);
        slider.setMajorTickSpacing(major);
        slider.setMinorTickSpacing(minor);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setName(name);
        //subPanel.add(slider,place);
        JMenu menu = new JMenu(name);
        menu.add(slider);
        menuBar.add(menu);
        sliders.add(slider);
    }
}

