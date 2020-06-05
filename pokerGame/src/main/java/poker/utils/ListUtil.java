package poker.utils;

import java.util.List;

public class ListUtil {

    public static boolean isContinuityList(List<Integer> list){
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i+1) - list.get(i) != 1){
                return false;
            }
        }
        return true;
    }

}
