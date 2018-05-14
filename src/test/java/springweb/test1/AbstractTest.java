package springweb.test1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTest {

    static final Logger logger = LoggerFactory.getLogger(AbstractTest.class);

    public String string = "ddddd%s";

    public String getString(String str) {
        return String.format(this.string, str);
    }

}
