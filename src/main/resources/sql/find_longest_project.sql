SELECT
    id AS project_id,
    EXTRACT(MONTH FROM AGE(finish_date, start_date)) AS month_count
FROM project
WHERE EXTRACT(MONTH FROM AGE(finish_date, start_date)) = (
    SELECT MAX(EXTRACT(MONTH FROM AGE(finish_date, start_date)))
    FROM project
);