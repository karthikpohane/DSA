# Write your MySQL query statement below
select
    "Low Salary" as category,
    count(income) as accounts_count
from accounts
where income < 20000
Union 
select
    "Average Salary" as category,
    count(income) as accounts_count
from accounts
where income >= 20000 and income <= 50000
Union
select
    "High Salary" as category,
    count(income) as accounts_count
from accounts
where income > 50000