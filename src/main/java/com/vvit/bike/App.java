package com.vvit.bike;

import java.util.logging.Logger;

import java.util.logging.Level;

interface Bike {

    public void assemble();
}
class BasicBike implements Bike {

    public void assemble() {
        System.out.print("Basic Bike.");
    }

}

class BikeDecorator implements Bike {

    protected Bike bike;

    public BikeDecorator(Bike c){
        this.bike=c;
    }


    public void assemble() {
        this.bike.assemble();
    }

}
class SportsBike extends BikeDecorator {

    public SportsBike(Bike c) {
        super(c);
    }


    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Sports Bike.");
    }
}
class LuxuryBike extends BikeDecorator {

    public LuxuryBike(Bike c) {
        super(c);
    }


    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Luxury Bike.");
    }
}


public class App
{
    private static final Logger l=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main( String[] args )
    {
        l.log(Level.INFO,"use of memento behaviour pattern and decorate structural pattern");
        Bike sportsBike = new SportsBike(new BasicBike());
        Bike lC=new LuxuryBike(new BasicBike());
        sportsBike.assemble();
        lC.assemble();
        System.out.println("\n*****");

        Bike sportsLuxuryBike = new SportsBike(new LuxuryBike(new BasicBike()));
        sportsLuxuryBike.assemble();
        l.log(Level.INFO,"program terminated");

    }
}