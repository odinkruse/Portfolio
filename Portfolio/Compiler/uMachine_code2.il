MOV SP D0
RD 0(d0)
RD 1(d0)
RD 2(d0)
RD 3(d0)
RD 4(d0)
PUSH #100
WRTS
PUSH 0(d0)
WRTS
PUSH #100
WRTS
PUSH 0(d0)
PUSH 1(d0)
MULS
WRTS
PUSH 2(d0)
PUSH 3(d0)
DIVS
WRTS
PUSH 0(d0)
PUSH 4(d0)
MODS
WRTS
PUSH 0(d0)
PUSH 1(d0)
ADDS
WRTS
PUSH 2(d0)
PUSH 1(d0)
SUBS
WRTS
PUSH #88
WRTS
PUSH #66
NEGS
WRTS
PUSH 0(d0)
PUSH 1(d0)
ADDS
WRTS
PUSH 0(d0)
PUSH 1(d0)
ADDS
NEGS
WRTS
HLT
