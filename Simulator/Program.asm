ORG: 1000
JMP L0
LO: 1010
MVI A, 0
ADI 10
LXI AR, 64
MOV M, A
MVI A, 0
SUI 10
LXI AR, 68
MOV M, A
MVI A, 0
LXI AR, 68
ADD M
LXI AR, 65
MOV M, A
MVI A, 0
ADI 10
LXI AR, 66
ADD M
LXI AR, 69
MOV M, A
MVI A, 0
ADI 10
LXI AR, 69
SUB M
LXI AR, 64
MOV M, A
MVI A, 0
LXI AR, 65
ADD M
SUI 10
LXI AR, 6A
MOV M, A
MVI A, 0
LXI AR, 66
SUB M
SUI 10
LXI AR, 6B
MOV M, A
MVI A, 0
LXI AR, 64
ADD M
ADI 10
LXI AR, 66
ADD M
LXI AR, 6C
MOV M, A
MVI A, 0
LXI AR, 64
ADD M
LXI AR, 6A
SUB M
LXI AR, 6B
ADD M
LXI AR, 6C
ADD M
LXI AR, 66
MOV M, A
MVI A, 0
ADI 0
LXI AR, 65
SUB M
JNZ L1
MVI A, 0
ADI 10
LXI AR, 64
MOV M, A
L1:
MVI A, 0
ADI 10
LXI AR, 66
SUB M
LXI AR, 6D
MOV M, A
MVI A, 0
LXI AR, 6D
ADD M
LXI AR, 64
SUB M
JL L2
MVI A, 0
ADI 10
LXI AR, 66
SUB M
JNZ L3
MVI A, 0
ADI 10
ADI 10
LXI AR, 64
MOV M, A
L3:
L2:
L4:
MVI A, 0
SUI 10
LXI AR, 64
SUB M
JL L5
MVI A, 0
LXI AR, 64
ADD M
SUI 10
LXI AR, 64
MOV M, A
MVI A, 0
ADI 10
LXI AR, 65
MOV M, A
JMP L4
L5: 
L6:
MVI A, 0
ADI 10
LXI AR, 66
SUB M
JNZ L7
L8:
MVI A, 0
ADI 10
LXI AR, 64
SUB M
JNZ L9
MVI A, 0
ADI 10
LXI AR, 66
MOV M, A
MVI A, 0
ADI 10
LXI AR, 64
MOV M, A
JMP L8
L9: 
JMP L6
L7: 
CALL DISPLAY
HLT
DISPLAY:
MVI A, 0
ADI 10
LXI AR, 64
MOV M, A
RET
