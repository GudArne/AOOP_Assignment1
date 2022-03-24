public class TestFilter implements Filter{

    @Override
    public boolean accept(String x) {
        if(x.length() >= 3)
            return true;
        return false;
    }

    public static void main(String[] args) {
        TestFilter tf = new TestFilter();
        String [] s = {"this", "is","a", "test"};
        s = Filter.filter(s,tf);
        System.out.println(s[0] + " " + s[1]); // this test
    }    
}
