select E.name , t.bonus from Employee as e Left Join Bonus as t on e.empId = t.empId where t.bonus < 1000 Or bonus is null ;