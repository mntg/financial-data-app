package se.montag.michael.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * Created by mike on 6/29/14.
 */
public class Lab {
    public static void main(String[] args) {
        callbacks();
    }

    private static void callbacks() {
        System.out.println(uppercase("bla"));
        uppercaseAsync("bla", (String s) -> System.out.println(s));
    }

    private static void uppercaseAsync(String input, Consumer<String> callback) {
        callback.accept(input.toUpperCase());
    }

    private static String uppercase(String input) {
        return input.toUpperCase();
    }


    private static void flyweight() {
        List<Letter> text = new ArrayList<Letter>();
        Letter a = new Letter('a');
        text.add(a);
        text.add(a);
        text.add(a);
        System.out.println(text);
    }

    static class Letter {
        char c;

        public Letter(char c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return Character.toString(c);
        }
    }


    public static void observer() {
        Repo repo = new Repo();
        repo.addObserver(new PrintObserver());
        repo.addObserver(new PrintObserver());
        repo.inc();
        repo.inc();
    }

    static class Repo extends Observable {
        int value;
        public void inc() {
            value++;
            setChanged();
            notifyObservers();
        }
    }

    static class PrintObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("" + hashCode() + " " + ((Repo)o).value);
        }
    }
}
