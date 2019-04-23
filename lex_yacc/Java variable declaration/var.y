%{
#include<stdio.h>
#include<string.h>
void yyerror(char*);
int yylex();
FILE *yyin;
%}

%token TYPE AS NAME VAL SC

%%
start: type1 | type2 ;
type1: TYPE NAME SC {printf("\nVALID DECLARATION SIMPLE");return 0;};
type2: TYPE NAME AS VAL SC {printf("\nVALID DECLARATION COMPLEX");return 0;};
%%

void yyerror(char *str)
{
	printf("\nERROR : %s",str);
}

int main()
{
yyin = fopen("input.txt","r");
yyparse();
return 0;
}
