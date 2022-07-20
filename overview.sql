CREATE FUNCTION driversvictories(forename_ varchar,
surname_                                   varchar)
returns   int AS $$declare cont int;
driverid_ int;
begin
  SELECT driverid
  INTO   driverid_
  FROM   driver
  WHERE  forename = forename_
  AND    surname = surname_;
  
  select count(*)
  INTO   cont
  FROM   results
  JOIN   races
  ON     results.raceid = races.raceid
  WHERE  results.position = 1
  AND    results.driverid = driverid_;
  
  return cont;
end;$$LANGUAGE plpgsql;CREATE FUNCTION driversinterval( forename_ varchar,
surname_                                   varchar,
out initialyear                            int,
out endyear                                int )
returns setof record AS $$declare driverid_ int;
begin
  SELECT driverid
  INTO   driverid_
  FROM   driver
  WHERE  forename = forename_
  AND    surname = surname_;
  
  return query
  (
         SELECT extract('year' FROM min(r.date))::int initialyear,
                extract('year' FROM max(r.date))::int endyear
         FROM   results
         JOIN   races r
         ON     results.raceid = r.raceid
         WHERE  results.driverid = driverid_ );
end;$$LANGUAGE plpgsql;


CREATE FUNCTION driversconstructorsquantity(constructorsname varchar)
returns int AS $$declare cont bigint;
begin
  SELECT count(*)
  INTO   cont
  FROM   (
                         SELECT DISTINCT
                         ON (
                                                         d.driverid) d.driverid driver_id
                         FROM            results
                         JOIN            driver d
                         ON              results.driverid = d.driverid
                         JOIN            constructors c
                         ON              c.constructorid = results.constructorid
                         AND             c.NAME = constructorsname ) result;
  
  return cont;
end;$$LANGUAGE plpgsql;

CREATE FUNCTION victoriesconstructors(constructorname varchar)
returns int AS $$declare victories int;
begin
  SELECT cont
  INTO   victories
  FROM   (
                  SELECT   constructors.NAME,
                           races.year,
                           count(*) cont
                  FROM     results
                  JOIN     races
                  ON       races.raceid = results.raceid
                  JOIN     constructors
                  ON       constructors.constructorid = results.constructorid
                  WHERE    results.position = 1
                  GROUP BY grouping sets (races.year, constructors.NAME)
                  ORDER BY races.year ) result
  WHERE  result.NAME = constructorsname;
  
  return victories;
end;$$LANGUAGE plpgsql;


CREATE FUNCTION constructorsinterval( constructorsname varchar,
out initialyear                                        int,
out endyear                                            int )
returns setof record AS $$begin
RETURN query
(
       SELECT extract('year' FROM min(r.date))::int initialyear,
              extract('year' FROM max(r.date))::int endyear
       FROM   results
       JOIN   races r
       ON     results.raceid = r.raceid
       JOIN   constructors c
       ON     c.constructorid = results.constructorid
       AND    c.NAME = constructorsname );
end;
$$language plpgsql;

