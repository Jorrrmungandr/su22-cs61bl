package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {

    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static GuitarString[] strings = new GuitarString[37];

    public static void main(String[] args) {
        // initialize guitar strings
        for(int i=0; i<37; ++i){
            strings[i] = new GuitarString(440 * Math.pow(2, (i - 14) / 12.0));
        }
        // poll
        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int ret = keyboard.indexOf(key);
                if(ret != -1){
                    strings[ret].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0;
            for(int i=0; i<37; ++i){
                sample += strings[i].sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for(int i=0; i<37; ++i){
                strings[i].tic();
            }
        }
    }

}
