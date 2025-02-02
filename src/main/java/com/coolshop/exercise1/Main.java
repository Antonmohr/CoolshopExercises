package com.coolshop.exercise1;

public class Main {
    public static void main(String[] args) throws Exception {
        String res = Server.getJSON();
        Functionalities functionalities = new Functionalities(res);
        functionalities.AllTogether();
    }
}