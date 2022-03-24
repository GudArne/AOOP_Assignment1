public interface Filter {


    boolean accept(String x);


    public static String[] filter(String[] a, Filter f){
        
        String[] tempList = new String[a.length];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if(f.accept(a[i])){
                tempList[j++] = a[i];
            }
        }
        String[] retList = new String[j];
        for (int i = 0; i < j; i++) {
            retList[i] = tempList[i];
        }

        return retList;
    }

}

