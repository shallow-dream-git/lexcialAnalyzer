int
    i,j,k:integer;
begin
    i:=1;
    while i<=100 do begin
        j:=1;
        while j<=100 do begin
            k:=1;
            while k<=100 do begin
                writeln(i:4,j:4,k:4);
                inc(k);
            end;
            inc(j);
        end;
        inc(i);
    end;
end.