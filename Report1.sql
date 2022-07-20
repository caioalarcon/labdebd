SELECT X.status,
       Count(*)
FROM   results
       JOIN status X
         ON results.statusid = X.statusid
GROUP  BY grouping sets ( X.status )
ORDER  BY ( X.status ) 