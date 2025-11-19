package Alvarez_ProgrammingAssignment02.SolarSystem;
/** 
 * This class is the main function for the virtual solar system model
 * @author J. Alvarez
 * 2588
 * SolarSystem.java
 * 2/21/2025
 */
import Alvarez_ProgrammingAssignment02.Exceptions.DuplicateCelestialBodyException;
import Alvarez_ProgrammingAssignment02.Exceptions.InvalidCelestialBodyException;

public class SolarSystem {
    public static void main(String[] args) throws
            DuplicateCelestialBodyException, InvalidCelestialBodyException{
                Star S1 = null;
                Planet P1 = null;
                Planet P2 = null;
                Planet P3 = null;
                Planet P4 = null;
                Planet P5 = null;
                Planet P6 = null;
                Planet P7 = null;
                Planet P8 = null;
                Moon M1 = null;
                Moon M2 = null;
                Moon M3 = null;
                try{
                    S1 = new Star("Sun", 5778000);
                    P1 = new Planet("Mercury" , S1);
                    P2 = new Planet("Venus", S1);
                    P3 = new Planet("Earth", S1);
                    P4 = new Planet("Mars", S1);
                    P5 = new Planet("Jupiter", S1);
                    P6 = new Planet("Saturn", S1);
                    P7 = new Planet("Uranus", S1);
                    P8 = new Planet("Neptune", S1);
                    //No Pluto :(
                    M1 = new Moon("Moon", P3);
                    M2 = new Moon("Phobos", P4);
                    M3 = new Moon("Deimos", P4);
                }
        catch (InvalidCelestialBodyException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            S1.add(P1);
            S1.add(P2);
            S1.add(P3);
            S1.add(P4);
            S1.add(P5);
            S1.add(P6);
            S1.add(P7);
            S1.add(P8);
            P3.add(M1);
            P4.add(M2);
            P4.add(M3);
        }
        catch (DuplicateCelestialBodyException e)
        {
            System.out.println(e.getMessage());
        }
        finally{
            P1.getOrbit();
            if (P2 != null){P2.getOrbit();}
            if (P3 != null){P3.getOrbit();}
            if (P4 != null){P4.getOrbit();}
            if (P5 != null){P5.getOrbit();}
            if (P6 != null){P6.getOrbit();}
            if (P7 != null){P7.getOrbit();}
            if (P8 != null){P8.getOrbit();}
            if (M1 != null){M1.getOrbit();}
            if (M2 != null){M2.getOrbit();}
            if (M3 != null){M3.getOrbit();}
        }
    }
}
