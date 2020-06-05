package poker.sequence;

import poker.sequence.base.Card;

import java.util.*;

/**
 * 可统计牌序列
 */
public class CountableSequence {

    /**
     * 卡牌序列
     */
    protected List<Card> cardList;

    /**
     * 卡牌排重序列
     */
    protected List<Integer> cardNumList;

    /**
     * 牌出现次数序列，从大到小
     */
    protected List<Integer> sequenceNumList;

    /**
     * 牌次数序列->牌数字 映射
     */
    protected Map<Integer,List<Integer>> sequenceMap;

    protected void refreshInfo(){
        int[] arr = new int[15];
        sequenceNumList = new ArrayList<>();
        cardNumList = new ArrayList<>();
        sequenceMap = new HashMap<>();
        for(int i=0;i<cardList.size();i++){
            arr[cardList.get(i).getCardNumber()]++;
            if(!cardNumList.contains(cardList.get(i).getCardNumber())){
                cardNumList.add(cardList.get(i).getCardNumber());
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] != 0){
                List<Integer> list = sequenceMap.get(arr[i]);
                if(list == null){
                    list = new ArrayList<>();
                }
                list.add(i);
                sequenceMap.put(arr[i],list);
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
