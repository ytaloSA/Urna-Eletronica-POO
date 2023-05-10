package main.java.view.util;

import main.java.view.UrnaEletronicaView;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    private UrnaEletronicaView urnaEletronica;

    public ExceptionHandler (UrnaEletronicaView urna) {
        urnaEletronica = urna;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Exceção capturada: " + e.getMessage());
        e.printStackTrace();
    }
}