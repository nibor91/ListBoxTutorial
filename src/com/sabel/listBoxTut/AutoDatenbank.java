package com.sabel.listBoxTut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * Created by Robin on 04.02.2017.
 */
public class AutoDatenbank {
    private ArrayList<Auto> autos;

    public AutoDatenbank() {
        autos = new ArrayList<Auto>();
    }

    public Object[] getAutoObjekte() {
        return autos.toArray();
    }

    public ArrayList<Auto> getAutoListe() {
        return autos;
    }

    public void addAuto(Auto auto) {
        autos.add(auto);
    }

    public Auto removeAuto(Auto auto) {
        Iterator<Auto> iterator = autos.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getFahrgestellnummer().equals(auto.getFahrgestellnummer())) {
                Auto x = (Auto) iterator;
                iterator.remove();
                return x;
            }
        }
        return null;
    }
}
