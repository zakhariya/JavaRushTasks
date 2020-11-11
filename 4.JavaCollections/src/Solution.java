import java.util.ArrayList;

public class Solution {
    public static int x;
    public static ArrayList<String> l;

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Bu");
            }
        };

        thread.start();

        Solution solution = new Solution();

        Some some = solution.new Some();

        some.gh = 6;

        System.out.println(some.gh);
    }

    private Some createSome() {
        return new Some();
    }

    Some s = new Some();


    private class Some {
        private int gh = 5;

//        public static void traTaTa() {
//
//        }
    }
}
