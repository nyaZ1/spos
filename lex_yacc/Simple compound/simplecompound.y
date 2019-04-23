%{
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
void yyerror(char*);
int yylex();
FILE *yyin;
%}

%token SUB VERB OBJ CON

%%
start: simple|compound;
simple: SUB VERB OBJ {printf("\nVALID SIMPLE SENTENCE");return 1;};
compound: SUB VERB OBJ CON SUB VERB OBJ  {printf("\nVALID COMPOUND SENTENCE");return 1;};
%%

void yyerror(char *str)
{
printf("Statement is not valid : %s",str);
}

int main()
{
yyin = fopen("input.txt","r");
yyparse();
return 0;
}
