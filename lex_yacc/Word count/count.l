%{
#include<stdio.h>
#include<string.h>
int w=0,l=0,c=0;
%}

%%
[\t ]+		//ignore
[\n ]+		{l=l+1;}
[a-zA-Z0-9]+	{c=c+yyleng;w=w+1;}
%%

yywrap(){}
int main()
{
yyin = fopen("input.txt","r");
yylex();
printf("\nNo of lines : %d",l);
printf("\nNo of words : %d",w);
printf("\nNo of characters : %d",c);
return 0;
}
