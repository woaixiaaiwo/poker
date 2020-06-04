package poker.factory;

import poker.cards.base.Card;
import poker.cards.base.PokerSequence;

import java.util.*;

public abstract class SequenceFactory {

    public abstract  PokerSequence getPokerSequence(List<Card> cardList);

    protected void calculate(List<Card> cardList,List<Integer> sequenceNumList,Map<Integer,List<Integer>> map){
        int[] arr = new int[15];
        for(int i=0;i<cardList.size();i++){
            arr[cardList.get(i).getCardNumber()]++;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] != 0){
                List<Integer> list = map.get(arr[i]);
                if(list == null){
                    list = new ArrayList<>();
                }
                list.add(i);
                map.put(arr[i],list);
                sequenceNumList.add(arr[i]);
            }
        }
        Collections.sort(sequenceNumList,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // 返回值为int类型，大于0表示正序，小于0表示逆序
                return o2-o1;
            }
        });
    }

}
