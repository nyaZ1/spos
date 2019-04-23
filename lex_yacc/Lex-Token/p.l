%{
#include<stdio.h>
%}

%%
[\t ]  //ignore
[\n ] //ignore
int|char|public|static|void|main|class|args|String	{printf("\n KEYWORDS  :\t %s",yytext);}
[a-zA-Z]+[a-zA-Z0-9]*		{printf("\nIDENTIFIERS :\t %s",yytext);}
[0-9]+				printf("\nNumbers :\t %s", yytext);
[<>=+-/*]			printf("\nBinary Op :\t %s",yytext);
\(|\)|\{|\}|\[|\]		printf("\nBrackets :\t %s",yytext);
;				printf("Termination Sym :\t %s",yytext);
%%

yywrap(){}

int main()
{
	yyin=fopen("input_token.java","r");
	yylex();
	return 0;
}
