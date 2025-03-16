/**
 * @Shootingmemory
 * @create 2025-03-16-17:48
 */
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");


    }
    class Solution {
        public int compareVersion(String version1, String version2) {
            int length1=version1.length();
            int length2=version2.length();
            int i=0;
            int j=0;
            while(i<length1||j<length2){
                int x=0;
                for(;i<length1&&version1.charAt(i)!='.';i++){
                    x=x*10+version1.charAt(i)-'0';
                }
                i++;
                int y=0;
                for(;j<length2&&version2.charAt(j)!='.';j++){
                    y=y*10+version2.charAt(j)-'0';
                }
                j++;
                if(x!=y){
                    return x>y?1:-1;
                }
            }
            return 0;
        }
    }
}