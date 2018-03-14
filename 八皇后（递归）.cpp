#include <stdio.h>
int col[8]={0};
int left[15]={0};
int right[15]={0};
int Q[8];
int cnt=0;
void PrinQueen(int cnt)
{
	printf("\n\n");
	int i;
	printf("µÚ%dÖÖ:\n",cnt);
	for(i=0;i<8;i++)
	printf("%5d",Q[i]);
	
}
void Queen(int i)
{
	int j;
	for(j=0;j<8;j++)
	{
		if(!col[j]&&!left[i+j]&&!right[i-j+7])
		{
			Q[i]=j;
			col[j]=left[i+j]=right[i-j+7]=1;
			if(i<7){
			Queen(i+1);
			col[j]=left[i+j]=right[i-j+7]=0;
	       	}
			if(i==7)
			{
				PrinQueen(++cnt);
				col[j]=left[i+j]=right[i-j+7]=0;
			}
		}
		
	}
}
int main()
{   int i=0;
	Queen(i);
}
