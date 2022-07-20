SELECT X.forename,
       X.surname,
       Count(X.driverid) AS VICTORIES
FROM   driver AS X
       JOIN (SELECT *
             FROM   results
             WHERE  constructorid IN(SELECT constructorid
                                     FROM   constructors
                                     WHERE  constructorref = constructor_name)
                    AND positiontext = '1') RESULT
         ON RESULT.driverid = X.driverid
GROUP  BY X.driverid
ORDER  BY X.driverid

SELECT X.forename,
       X.surname,
       X.dob,
       X.nationality
FROM   driver AS X
WHERE  driverid IN(SELECT driverid
                   FROM   results
                   WHERE  constructorid IN(SELECT constructorid
                                           FROM   constructors
                                           WHERE
                          constructorref = constructor_name))
ORDER  BY driverid 