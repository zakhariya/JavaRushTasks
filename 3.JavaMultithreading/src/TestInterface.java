import java.io.Externalizable;
import java.io.Serializable;
import java.rmi.Remote;

public interface TestInterface extends Cloneable, Serializable, Externalizable, Remote, Comparable<TestInterface> {

    void doSomeThing();

    @Override
    int compareTo(TestInterface o);

}
