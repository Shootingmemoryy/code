/**
 * @Shootingmemory
 * @create 2025-03-04-9:42
 */
//买卖股票的最佳时机
public class Main {
    public static void main(String[] args) {

    }
    class Solution {
        public int maxProfit(int[] prices) {
            int minprice=prices[0];
            int maxprofit=0;
            for(int i=0;i<prices.length;i++){
                if(prices[i]<minprice){
                    minprice=prices[i];
                }
                else if(prices[i]-minprice>maxprofit){
                    maxprofit=prices[i]-minprice;
                }
            }
            return maxprofit;

        }
    }
}