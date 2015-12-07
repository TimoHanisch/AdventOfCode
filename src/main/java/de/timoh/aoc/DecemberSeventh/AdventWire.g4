grammar AdventWire;

rules:  (assign | and | or | lshift | rshift | not)*;

operand: (IDENTIFIER | INTEGER);

assign: operand ASSIGN IDENTIFIER NEWLINE;
and: operand AND operand ASSIGN IDENTIFIER NEWLINE;
or: operand OR operand ASSIGN IDENTIFIER NEWLINE;
lshift: operand LSHIFT operand ASSIGN IDENTIFIER NEWLINE;
rshift: operand RSHIFT operand ASSIGN IDENTIFIER NEWLINE;
not: NOT operand ASSIGN IDENTIFIER NEWLINE;


AND: 'AND';
OR: 'OR';
NOT: 'NOT';
LSHIFT: 'LSHIFT';
RSHIFT: 'RSHIFT';
ASSIGN: '->';

NEWLINE: ('\r\n' | '\n');


IDENTIFIER
    :   [a-z]+
    ;

INTEGER
    : [0-9]+
    ;


SKIP
    : (' '|'\t'|'\u000C') -> skip
    ;