%{
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include "y.tab.h"
%}

%%
he|she|me|we|I|her|his|they|mahesh {return SUB;}
is|are|was|were|be|been|being|will|would|shall|should|has|havae|had|do|did|does|read|paint|ride {return VERB;}
bike|book|wall {return OBJ;}
but|or|and|while {return CON;}
%%

int yywrap()
{
return 1;
}
