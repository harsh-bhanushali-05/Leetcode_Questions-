SELECT 
    r.contest_id, 
    ROUND((COUNT(r.user_id) / (SELECT COUNT(user_id) FROM Users)), 4)*100 AS percentage 
FROM 
    Register AS r 
LEFT JOIN 
    Users AS u 
ON 
    r.user_id = u.user_id 
GROUP BY 
    r.contest_id
order by percentage DESC  , r.contest_id 
;