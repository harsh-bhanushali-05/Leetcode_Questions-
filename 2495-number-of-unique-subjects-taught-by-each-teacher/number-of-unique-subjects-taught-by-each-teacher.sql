# Write your MySQL query statement below

select teacher_id , count( distinct subject_id) as cnt from Teacher group by teacher_id;
-- this is the 5th question of the day 
