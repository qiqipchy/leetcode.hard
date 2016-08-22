public class Solution {
    public int minDistance(String word1, String word2) {
       
		int[][] common=new int[word1.length()+1][word2.length()+1];
		
		for(int i=0;i<=word1.length();i++)
			common[i][0]=i;
		for(int j=1;j<=word2.length();j++)
			common[0][j]=j;
				
		for(int i=1;i<=word1.length();i++)
		{
			char ch1=word1.charAt(i-1);
			for(int j=1;j<=word2.length();j++)
			{
				char ch2=word2.charAt(j-1);
				if(ch1==ch2)
					common[i][j]=common[i-1][j-1];
				else
					common[i][j]=Math.min(Math.min(common[i-1][j],common[i][j-1])+1,common[i-1][j-1]+1);
			}
		}
		return common[word1.length()][word2.length()];
    }

}
