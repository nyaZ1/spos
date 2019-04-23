%{
#include<stdio.h>
%}

%%
[\t ]+	//ignore
[\n ]+	//ignore
int|char|public|protected|private|String|args|if|else|do|while|class|package|static|void|main|float|double 		printf("\nKeywords- \t%s",yytext);
[a-zA-Z]+[a-zA-Z0-9]*	printf("\nIdentifier- \t%s",yytext);
[0-9]+			printf("\nConstant- \t%s",yytext);
[<>=+-/*]		printf("\nBinary operator- \t%s",yytext);
\(|\)|\[|\]|\{|\}	printf("\nBrackts- \t%s",yytext);
;			printf("\nTermination- \t%s",yytext);
[!@#$%^&,]		printf("\nSymbol- \t%s",yytext);

%%

yywrap(){}

int main()
{
	yyin=fopen("input_token.java","r");
	yylex();
	return 0;
}


