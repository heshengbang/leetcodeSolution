-- SQL Schema
-- Write a SQL query to find all duplicate emails in a table named Person.
--
-- +----+---------+
-- | Id | Email   |
-- +----+---------+
-- | 1  | a@b.com |
-- | 2  | c@d.com |
-- | 3  | a@b.com |
-- +----+---------+
-- For example, your query should return the following for the above table:
--
-- +---------+
-- | Email   |
-- +---------+
-- | a@b.com |
-- +---------+
-- Note: All emails are in lowercase.


-- No. 1
select p.Email from (select count(Email) as num, Email as Email from Person group by Email) p where p.num >= 2;

-- No. 2
select email from person group by email having count(*) > 1