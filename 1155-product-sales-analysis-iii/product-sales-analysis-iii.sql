# Write your MySQL query statement below
--  This is the 7th problem of the day 
select product_id , year as first_year , quantity , price  from Sales where (product_id , year) in (Select product_id,min(year) from Sales group by product_id);