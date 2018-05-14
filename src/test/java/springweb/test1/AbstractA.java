package springweb.test1;

public class AbstractA extends AbstractTest {

    private String dd;

    public AbstractA(String string) {
        this.dd = string;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public void gg() {
        this.logger.info("ss");
    }

}
