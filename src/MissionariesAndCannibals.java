import java.util.HashSet;
import java.util.Set;

public class MissionariesAndCannibals {
    public static int solutions = 0;

    public static void main(String[] args) {

        Set<String> states = new HashSet<String>();
        MissionariesAndCannibals(3, 3, 0, 0, 0, 0, states, "", 0);

    }

    public static void MissionariesAndCannibals(int lm, int lc, int rm, int rc, int bs1, int bs2, Set<String> states, String path, int count) {

        //second, we put out restrictions

        if (lm < 0 || lc < 0 || rm < 0 || rc < 0) {                 //if the missionaries or cannibals on any side are less than zero it will return.
            return;
        }

        if ((lm < lc && lm != 0) || (rm < rc && rm != 0)) {           //if the missionaries on either side are less then the cannibals it will return
            return;
        }

        if (count > 0) {
            String picture = count % 2 == 1 ? drawLeave(rm, rc, lm, lc, bs1, bs2) : drawArrive(lm, lc, rm, rc, bs1, bs2);         //here, if count is equal to or greater then it will show the first iteration because the boat starts from the river bank. hence, there is this restriction here. MY MISTAKE WAS HERE IN THE FIRST SUBMIISION IN THE drawLeave CAll sorry.
            path += picture + "\n";     //I learned how to use ternary conditional operator from this project. the ternary conditional operator is similar to if and else statement. here, if string picture meets the given condition, then it will execute drawLeave, if not, then it will execute drawArrive.
        }

        lm += bs1;              //this compound operators are here so that cannibals and missionaries get out of the boat when it reaches the shore.
        lc += bs2;


        if ((lm < lc && lm != 0)) {                     // this restriction is here to check whether missionaries are less then cannibals. it is considering both numbers, on the riverbank and on the boat
            return;
        }
        if (count % 2 == 0 && lm == 0) {
            String finalPath = String.join("\n", path) + "\n\n\n\n";                        //<--- missionaries reached on the other side safely
            System.out.println(String.format("Solution %d\n\n", ++solutions) + finalPath);
            return;
        }

        String state = String.format("%d,%d,%d,%d,%d", count % 2, lm, lc, rm, rc, bs1, bs2);                // <--- this restriction is here to avoid infinite recursion
        if (states.contains(state)) {
            return;
        }
        states.add(state);

        // THIS IS THE IMPORTANT PART OF THE ANSWER BECAUSE THIS IS RECURSION, WHERE IT CHECKS FOR EVERY COMBINATION FOR THE NEXT TIME.

        MissionariesAndCannibals(rm, rc, lm - 2, lc, 2, 0, new HashSet(states), path, count + 1);
        MissionariesAndCannibals(rm, rc, lm, lc - 2, 0, 2, new HashSet(states), path, count + 1);
        MissionariesAndCannibals(rm, rc, lm - 1, lc - 1, 1, 1, new HashSet(states), path, count + 1);
        MissionariesAndCannibals(rm, rc, lm - 1, lc, 1, 0, new HashSet(states), path, count + 1);
        MissionariesAndCannibals(rm, rc, lm, lc - 1, 0, 1, new HashSet(states), path, count + 1);

    }



    /*
    from here on, there are different methods about the picture such as when the boat leaves the riverbank,
    when the boat arrives at the river bank, the restrictions of the boat, the restriction to avoid duplicate moves.
    */

    public static String drawLeave(int lm, int lc, int rm, int rc, int mb, int cb) {

        String l3a = "|" + duplicate(lm, "m") + "| " + "|" + duplicate(lc, "c") + "|";
        String l3b = "     ~~~~~~~~~~(" + boat(mb, cb) + ")---->  ~~~~~~~~~~     ";
        String l3c = "|" + duplicate(rm, "m") + "|" + "|" + duplicate(rc, "c") + "|";
        String l3 = l3a + l3b + l3c + "\n";
        String description = "";
        if (mb * cb >= 1) {
            description = "Missionary and Cannibal depart to destination";
        } else if (mb == 2) {
            description = "2 Missionaries depart to destination";
        } else if (mb == 1){
            description = "1 Missionary departs to destination";
        } else if (mb == 0){
            description = String.format("%d Cannibal(s) depart to destination", cb);
        }
        return description + "\n"  + l3;
    }

    public static String drawArrive(int lm, int lc, int rm, int rc, int mb, int cb) {

        String l3a = "|" + duplicate(lm,"m") + "|" + "|" + duplicate(lc,"c") + "|";
        String l3b = "    ~~~~~~~~~~  <----(" + boat(mb,cb) + ")~~~~~~~~~~     ";
        String l3c = "|" + duplicate(rm,"m") + "|" + "|" + duplicate(rc,"c") + "|";
        String l3  = l3a + l3b + l3c + "\n";
        String description = "";
        if (mb * cb >= 1){
            description = "Missionary and Cannibal return to origin";
        } else if (mb == 2) {
            description = "2 Missionaries return to origin";
        } else if (mb == 1) {
            description = "1 Missionary returns to origin";
        } else if (mb == 0) {
            description = String.format("%d Cannibal(s) returns to origin", cb);
        }

        return description + "\n" + l3;
    }
    public static String duplicate(int n, String s) {               //this method handles duplicates
        String result = "";
        for (int i = 0; i < n; i++) {
            result += s + " ";
        }
        return (result + "       ").substring(0,5);
    }

    public static String boat(int m, int c) {                   // this defines the properties of boat
        if (m == 2) {
            return "M M";
        }
        if (c == 2) {
            return "C C";
        }
        return (m == 1 ? "M " : "  ") + (c == 1 ? "C" : " "); //ternary statement says that if m == 1, return "M", if not return " ". similar with the c == 1
    }
}
// at the end we get two solutions for it. all missionaries are safely on the other side.