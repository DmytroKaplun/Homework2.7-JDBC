SELECT 'youngest' AS TYPE, NAME, BIRTHDAY
FROM worker
WHERE birthday = (SELECT MAX(birthday) FROM worker)

UNION

SELECT 'oldest' AS type, name, birthday
FROM worker
WHERE birthday = (SELECT MIN(birthday) FROM worker)
ORDER BY birthday DESC;