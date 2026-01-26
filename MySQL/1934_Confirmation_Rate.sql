SELECT 
s.user_id, 
ROUND(AVG(IF (c.action = "confirmed", 1, 0)), 2) as confirmation_rate
FROM Confirmations as c right join Signups as s
ON s.user_id = c.user_id 
GROUP BY s.user_id;
