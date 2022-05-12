--sp to delete records--

CREATE PROCEDURE sp_delete_department
    @pk INT(20)
AS
BEGIN

    DELETE FROM department WHERE deptId = @pk;

END;

GO;

CREATE PROCEDURE sp_delete_modules
    @pk INT(20)
AS
BEGIN

    DELETE FROM modules WHERE moduleId = @pk;

END;

GO;

CREATE PROCEDURE sp_delete_programs
    @pk INT(20)
AS
BEGIN

    DELETE FROM programs WHERE progId = @pk;

END;

GO;

CREATE PROCEDURE sp_delete_students
    @pk INT(20)
AS
BEGIN

    DELETE FROM students WHERE studId = @pk;

END;

GO;

CREATE PROCEDURE sp_delete_lecturer
    @pk INT(20)
AS
BEGIN

    DELETE FROM lecturer WHERE l_username = @pk;

END;

GO;

CREATE PROCEDURE sp_delete_admin
    @pk INT(20)
AS
BEGIN

    DELETE FROM admin WHERE a_username = @pk;

END;

GO;

CREATE PROCEDURE sp_delete_class
    @pk INT(20)
AS
BEGIN

    DELETE FROM class WHERE classId = @pk;

END;

GO;

CREATE PROCEDURE sp_delete_room
    @fkMod INT(20),
    @fkL_username INT(20),
    @fkClass INT(20)
AS
BEGIN

    DELETE FROM room WHERE moduleId = @fkMod AND l_username = @fkL_username AND classId = @fkClass;

END;

GO;

CREATE PROCEDURE sp_delete_groups
    @pkGrName VARCHAR(255),
    @pkGrLevel TINYINT
AS
BEGIN

    DELETE FROM groups WHERE grName = @pkGrName AND grLevel = @pkGrLevel;

END;

GO;

CREATE PROCEDURE sp_delete_attendance
    @fkClassId INT(20),
    @fkStudId INT(20)
AS
BEGIN

    DELETE FROM attendance WHERE classId = @fkClassId AND studId = @fkStudId;

END;

GO;