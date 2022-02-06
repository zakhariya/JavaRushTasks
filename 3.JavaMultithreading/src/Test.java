import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test extends TestAbstract { // as implements TestInterface
    //TODO: remove
    public static final String FIRST_FILE = "e:\\for tests\\to_read.txt";
    public static final String SECOND_FILE = "e:\\for tests\\to_write.txt";
    public static final File file = new File("e:\\for tests\\some_class.dat");



    public static void main(String[] args) {
        String s1 = "JavaRush - лучший сайт для изучения Java!";
        String s2 = "JavaRush - лучший сайт для изучения Java!";

        String[] s3 = s1.split("");

        s2 += "";
        System.out.println(s1 == s2);
        System.out.println(Arrays.toString(s3));

        System.out.println(Integer.toBinaryString(342));
        System.out.println(String.format("%32s", Long.toBinaryString(342)).replace(' ', '0'));

        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);

        SortedMap<String, Solution> sortedMap = new TreeMap<>();

        sortedMap.put("f", new Solution());
        sortedMap.put("d", new Solution());

        System.out.println(sortedMap.keySet());

        Pattern p = Pattern.compile("(cat)");
        Matcher m = p.matcher("one cat, two cats, or three cats on a fence");
        StringBuffer sb = new StringBuffer();
        while (m.find())
            m.appendReplacement(sb, "$1erpillar");
        m.appendTail(sb);
        System.out.println(sb);

        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 5_000_000; i++) {
            linkedList.add(new Integer(i));
        }

        long start = System.currentTimeMillis();

        for(int i=0;i<100;i++){
//            linkedList.add(2_000_000, new Integer(Integer.MAX_VALUE));
            linkedList.add(2, new Integer(Integer.MAX_VALUE));
        }
        System.out.println(linkedList.size() + " Время работы для LinkedList (в милисекундах) = " + (System.currentTimeMillis()-start));


        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 5_000_000; i++) {
            arrayList.add(new Integer(i));
        }

        start = System.currentTimeMillis();

        for (int i=0;i<100;i++){
//            arrayList.add(2_000_000, new Integer(Integer.MAX_VALUE));
            arrayList.add(2, new Integer(Integer.MAX_VALUE));
        }
        System.out.println(arrayList.size() + " Время работы для ArrayList (в миллисекундах) = " + (System.currentTimeMillis()-start));

    }

    // from TestInterface
    @Override
    void someMethod() {

    }

    @Override
    public void doSomeThing() {
        super.someAnotherMethod();
        System.out.println("Print from subclass");
    }

    @Override
    public int compareTo(TestInterface o) {
        return 0;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

//    public abstract void abstr();
}
