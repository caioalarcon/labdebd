SELECT X.status AS STATUS,
       Count(*) AS COUNT
FROM   results Y
       INNER JOIN status X
               ON Y.statusid = X.statusid
WHERE  Y.driverid = 1
GROUP  BY X.status 