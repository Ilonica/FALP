% предикат max(+X, +Y, +U, -Z)
% Z - максимальное из чисел X, Y и U.
max(X, Y, U, X) :- X>Y, X>U, !.
max(_, Y, U, Y) :- Y>U, !.
max(_,_,U,U).

% предикат fact_up(+N, -X)
% факториал первого аргумента с помощью рекурсии вверх
fact_up(0, 1) :- !.
fact_up(N, X) :- N1 is N - 1, fact_up(N1, X1), X is N*X1.

% предикат fact_down(+N, -X)
% факториал первого аргумента с помощью рекурсии вниз
fact_down(N, X) :- fact_down(0, 1, N, X).
fact_down(N, Z, N, Z) :- !.
fact_down(N,_,N,_):-!,fail.
fact_down(Y, Z, N, X) :- Y1 is Y + 1, Z1 is Z*Y1, fact_down(Y1, Z1, N, X).

% предикат digit_sum(+X, -Sum)
% Sum - сумма цифр числа X (рекурсия вверх)
digit_sum(0,0):-!.
digit_sum(X,Sum):-X1 is X // 10, Rem is X mod 10, digit_sum(X1, Sum1), Sum is Sum1 + Rem.

% предикат digit_sum_down(+X, -Sum)
% Sum - сумма цифр числа X (рекурсия вниз).
digit_sum_down(X, Sum) :- digit_sum_down(X, 0, Sum).
digit_sum_down(0, SumCur, SumCur) :- !.
digit_sum_down(X1, SumCur, Sum) :- X2 is X1 // 10, Rem is X1 mod 10, SumNew is SumCur + Rem, digit_sum_down(X2, SumNew, Sum).

% предикат free_of_squares(+X)
% проверяет, свободно ли число X от квадратов.
free_of_squares(X) :- X>1, not(free_of_squares(2, X)).
free_of_squares(N, X) :- N *N =< X,(
0 is mod(X, N*N); N1 is N + 1,
                          free_of_squares(N1, X)
).

% предикат read_list(-List)
% считывает список с клавиатуры.
read_list(List) :- read_list([], List).

read_list(Acc, List) :-
    write('Enter an element (or press Enter to finish): '),
    read_line_to_string(user_input, Input),
    (   Input = ""
    ->  reverse(Acc, List)
    ;   (   atom_number(Input, Element)
        ->  true
        ;   Element = Input
        ),
        append(Acc, [Element], NewAcc),
        read_list(NewAcc, List)
    ).

% предикат write_list(+List)
% выводит список на экран.
write_list([]) :- !.
write_list([H|Tail]) :- write(H), nl, write_list(Tail).

% предикат sum_list_down(+List, -Summ)
% Summ - сумма элементов списка List (рекурсия вниз).
sum_list_down(List, Summ) :- sum_list_down(0, List, Summ).
sum_list_down(Acc, [], Acc).
sum_list_down(Acc, [H|Tail], Summ) :- NewAcc is Acc + H, sum_list_down(NewAcc, Tail, Summ).

% предикат sum_list_up(+List, -Sum)
% Sum - сумма элементов списка List (рекурсия вверх).
sum_list_up([], 0).
sum_list_up([H|T], Sum) :- sum_list_up(T, AccSum), Sum is AccSum + H.

% предикат remove_items_with_digit_sum(+List, +Sum, -Result)
% удаляет из списка List элементы, сумма цифр которых равна Sum.
remove_items_with_digit_sum([], _, []).
remove_items_with_digit_sum([H|T], Sum, Result) :-
    digit_sum(H, DigitSum),
    (   DigitSum =:= Sum
    ->  remove_items_with_digit_sum(T, Sum, Result)
    ;   Result = [H|NewResult],
        remove_items_with_digit_sum(T, Sum, NewResult)
    ).
