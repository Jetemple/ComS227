package lab10;

import java.util.Random;

public class Portrait1ZKR extends Portrait {

    //He always liked Randoms.
    Random rng;
    double headPercent;

    public Portrait1ZKR() {
        super(0);
        // TODO Auto-generated constructor stub

        //You're welcome to mess around with this.
        rng = new Random();
        headPercent = rng.nextDouble() % 0.3;

        //Can't call constructors in other constructors.
        init();
    }

    public void init()
    {
        setHeadRadius(headPercent);

        //~Ninetails <3
        //(Tbf, calling it spread eagleness is kinda asking for this XP)
        setSpreadEagleness(1.1 - headPercent);
    }

}