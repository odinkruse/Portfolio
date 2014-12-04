program mathTest;
var a, b, c, d, e, f: boolean;
    x, y, z: integer;

begin

a := true;
b := false;
c := a and b;
writeln('a and b = ', )c;

c := a or b;
writeln('a or b = ', c);

c := a or b;
writeln('a or b = ', c);

c := not a;
writeln('a = ', a, ' and b = ', b, ' and not b = ', c);

x := 1; y := 2; z := 3;
c := (x < y) and (y < z);
writeln('x = ', x, ' and y = ', y, ' and z = ', z, ' and c = ', c);
end.

