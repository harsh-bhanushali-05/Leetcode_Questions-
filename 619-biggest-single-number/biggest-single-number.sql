# 1st question of the day 
select max(num) AS num from (select num from MyNumbers group by num having count(num)=1) as oo;