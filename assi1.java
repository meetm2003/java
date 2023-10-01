import java.util.*;

class format{
    int id, runs, wickets, catches, rank;
    String name;
    format(){
        id = 0;
        runs = 0;
        wickets = 0;
        catches = 0;
        name = "";
        rank = 0;
    }
    format(int i, int r, int w, int c, String n){
        id = i;
        runs = r;
        wickets = w;
        catches = c;
        name = n;
        rank = 0;
    }
}
class cricketer{
    format odi;
    format t20;
    format test;
    int rank;

    cricketer(){
        odi = null;
        t20 = null;
        test = null;
        rank = 0;
    }
    cricketer(format tp){
        odi = null;
        t20 = null;
        test = null;

        if(tp.id == 0){
            odi = tp;
        }
        else if(tp.id == 1){
            t20 = tp;
        }
        else if(tp.id == 2){
            test = tp;
        }
        // calculateRank();
    }
//     void calculateRank() {
//         int totalRuns = 0;
//         int totalWickets = 0;
//         int totalCatches = 0;

//         if (odi != null) {
//             totalRuns += odi.runs;
//             totalWickets += odi.wickets;
//             totalCatches += odi.catches;
//         }
//         if (t20 != null) {
//             totalRuns += t20.runs;
//             totalWickets += t20.wickets;
//             totalCatches += t20.catches;
//         }
//         if (test != null) {
//             totalRuns += test.runs;
//             totalWickets += test.wickets;
//             totalCatches += test.catches;
//         }
//         int runsWeight = 1;
//         int wicketsWeight = 2;
//         int catchesWeight = 1;

//         rank = (totalRuns * runsWeight) + (totalWickets * wicketsWeight) + (totalCatches * catchesWeight);
//     }
 }
    class assi1{
        public static void main(String[] args){

            format p1 = new format(0,100,2,20,"virat");
            format p2 = new format(0,120,1,17,"rohit");
            format p3 = new format(0,90,50,25,"jadeja");

            format p4 = new format(1,100,2,20,"rohit");
            format p5 = new format(1,120,1,17,"virat");
            format p6 = new format(1,90,50,25,"jadeja");

            format p7 = new format(2,100,2,20,"jadeja");
            format p8 = new format(2,120,1,17,"virat");
            format p9 = new format(2,90,50,25,"rohit");

            cricketer []odi = new cricketer[3];
            odi[0] = new cricketer(p1);
            odi[1] = new cricketer(p2);
            odi[2] = new cricketer(p3);

            cricketer []t20 = new cricketer[3];
            t20[0] = new cricketer(p4);
            t20[1] = new cricketer(p5);
            t20[2] = new cricketer(p6);
            
            cricketer []test = new cricketer[3];
            test[0] = new cricketer(p7);
            test[1] = new cricketer(p8);
            test[2] = new cricketer(p9);

            System.out.println("Rank given by runs of top 3");

            try{
                //it sort array by descending order...
                Arrays.sort(odi, (a, b) -> Integer.compare(b.odi.runs, a.odi.runs));
            }
            catch(Exception e){
                System.out.println(e);
            }

            System.out.println("Odi");

            System.out.println("Rank\tName\tRuns\tWickets\tCatches\tScore");
            for(int i = 0; i < 3; i++){
                if(odi[i] != null){
                    odi[i].odi.rank = i + 1;
                    System.out.println(odi[i].odi.rank+"\t"+odi[i].odi.name+"\t"+odi[i].odi.runs+"\t"+odi[i].odi.wickets+"\t"+odi[i].odi.catches+"\t"+odi[i].rank);
                }
            }

            Arrays.sort(t20, (a, b) -> Integer.compare(b.t20.runs, a.t20.runs));
            System.out.println("t20");
            System.out.println("Rank\tName\tRuns\tWickets\tCatches\tScore");

            for(int i = 0; i < 3; i++){
                if(t20[i] != null){
                    t20[i].t20.rank = i + 1;
                    System.out.println(t20[i].t20.rank+"\t"+t20[i].t20.name+"\t"+t20[i].t20.runs+"\t"+t20[i].t20.wickets+"\t"+t20[i].t20.catches+"\t"+t20[i].rank);
                }
            }

            Arrays.sort(test, (a, b) -> Integer.compare(b.test.runs, a.test.runs));
            System.out.println("test");
            System.out.println("Rank\tName\tRuns\tWickets\tCatches\tScore");

            for(int i = 0; i < 3; i++){
                if(test[i] != null){
                    test[i].test.rank = i + 1;
                    System.out.println(test[i].test.rank+"\t"+test[i].test.name+"\t"+test[i].test.runs+"\t"+test[i].test.wickets+"\t"+test[i].test.catches+"\t"+test[i].rank);
                }
            }
        }
    }