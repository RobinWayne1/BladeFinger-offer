/**
 *思路：设定整数点（如1、10、100等等）作为位置点i（对应n的各位、十位、百位等等），分别对每个数位上有多少包含1的点进行分析
 *根据设定的整数位置，对n进行分割，分为两部分，高位n/i，低位n%i
 *当i表示百位，且百位对应的数>=2,如n=31456,i=100，则a=314,b=56，此时百位为1的次数有a/10+1=32（最高两位0~31）,每一次都包含100个连续的点，即100,101,102
 *当i表示百位，且百位对应的数为1，如n=31156,i=100，则a=311,b=56，此时百位对应的就是1，则共有a/10(最高两位0-30)次是包含100个连续点，当最高两位为31（即a=311），本次只对应局部点00~56，共b+1次
 *当i表示百位，且百位对应的数为0,如n=31056,i=100，则a=310,b=56，此时百位为1的次数有a/10=31（最高两位0~30）
 * @author Robin
 * @date 2020/3/9 -20:48
 */
public class Solution
{
    public static int NumberOf1Between1AndN_Solution(int n)
    {
        String str=String.valueOf(n);
        int times=0;
        for(int i=str.length()-1,j=0;i>=0;i--,j++)
        {
           int a=Integer.valueOf(str.substring(0,i).equals("")?"0":str.substring(0,i));
           int b=Integer.valueOf(str.substring(i+1).equals("")?"0":str.substring(i+1));
           //此处我将目标位从a中分离了出来,不同于思路描述
           int cur=Integer.valueOf(str.substring(i,i+1));

           if(cur>1)
           {
               times+=(a+1)*Math.pow(10,j);
           }
           if(cur==1)
           {
               times+=a*Math.pow(10,j)+b+1;
           }
           if(cur==0)
           {
               times+=a*Math.pow(10,j);
           }
        }
        return times;
    }
    public static void main(String[]args)
    {
     String a="1";
     System.out.println(NumberOf1Between1AndN_Solution(123));

    }
}
