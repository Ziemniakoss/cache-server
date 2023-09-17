CREATE TABLE IF NOT EXISTS project(
    id CHAR(36) NOT NULL PRIMARY KEY,
    name CHAR(255) NOT NULL,
    description TEXT
);

COMMENT ON TABLE project IS $COMMENT$
Stores projects. Project in most cases would be single git repository hosted somewhere
$COMMENT$;

COMMENT ON COLUMN project.description IS $COMMENT$Optional project description$COMMENT$;
