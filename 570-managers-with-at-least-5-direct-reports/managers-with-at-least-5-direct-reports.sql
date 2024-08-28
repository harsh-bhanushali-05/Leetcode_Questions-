# Write your MySQL query statement below
select manager.name from Employee as manager Left join Employee as sub on manager.id = sub.managerId group by manager.id having count(manager.id) > 4;