SELECT X.status AS STATUS,
       Count(*) AS COUNT
FROM   results Y
       INNER JOIN status X
               ON r.statusid = X.statusid
WHERE  Y.constructorid = 1
GROUP  BY X.status 