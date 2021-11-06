package a1DataStructures.ds5Maps.practiseProblems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Contains3 {

    public boolean contains3(List<String> list){
        if(list.size() == 0)
            return false;

        Map<String,Integer> map = new HashMap<>();

        for (String str: list) {
            map.put(str, map.getOrDefault(str,0) + 1);
        }


        Iterator<String> itr = map.keySet().iterator();
        while (itr.hasNext()){
            String key = itr.next();
            int val = map.get(key);

            if(val == 3)
                return true;
        }
        return false;
    }
}
