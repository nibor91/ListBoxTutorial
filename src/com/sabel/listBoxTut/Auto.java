package com.sabel.listBoxTut;

/**
 * Created by Robin on 04.02.2017.
 */
public class Auto {
    private String kennzeichen;
    private String fahrgestellnummer;
    private int punkteInFlenzburg;
    private int ps;

    public Auto( String fahrgestellnummer,String kennzeichen, int punkteInFlenzburg, int ps) {
        this.kennzeichen = kennzeichen;
        this.fahrgestellnummer = fahrgestellnummer;
        this.punkteInFlenzburg = punkteInFlenzburg;
        this.ps = ps;
    }

    public Auto( String fahrgestellnummer,String kennzeichen, int ps) {
        this.kennzeichen = kennzeichen;
        this.fahrgestellnummer = fahrgestellnummer;
        this.ps = ps;
    }

    public Auto( String fahrgestellnummer,String kennzeichen) {

        this.kennzeichen = kennzeichen;
        this.fahrgestellnummer = fahrgestellnummer;
    }

    public Auto(String fahrgestellnummer) {

        this.fahrgestellnummer = fahrgestellnummer;
    }

    @Override
    public String toString() {
        return kennzeichen;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getFahrgestellnummer() {
        return fahrgestellnummer;
    }

    public void setFahrgestellnummer(String fahrgestellnummer) {
        this.fahrgestellnummer = fahrgestellnummer;
    }

    public int getPunkteInFlenzburg() {
        return punkteInFlenzburg;
    }

    public void setPunkteInFlenzburg(int punkteInFlenzburg) {
        this.punkteInFlenzburg = punkteInFlenzburg;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }
}
