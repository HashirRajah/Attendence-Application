--sp to update records--
--Update department attributes--
CREATE PROCEDURE sp_update_dept_name
    @id INTEGER,
    @newName VARCHAR(255)
AS
BEGIN
    UPDATE  department
    SET     name = @newName
    WHERE   deptId = @id;
END;

--update modules attributes--
GO;
CREATE PROCEDURE sp_update_module_name
    @id INTEGER,
    @newName VARCHAR(255)
AS
BEGIN
    UPDATE  modules
    SET     name = @newName
    WHERE   moduleId = @id;
END;

--update programs attributes--
GO;
CREATE PROCEDURE sp_update_programs
    @id INTEGER,
    @newName VARCHAR(255) = NULL,
    @newProgType VARCHAR(255) = NULL,
    @newDegreeType VARCHAR(255) = NULL
AS
BEGIN
    --name--
    IF(@newName IS NOT NULL)
    BEGIN
        UPDATE  programs
        SET     name = @newName
        WHERE   progId = @id;
    END;
    --progType--
    IF(@newProgType IS NOT NULL)
    BEGIN
        UPDATE  programs
        SET     progType = @newProgType
        WHERE   progId = @id;
    END;
    --degreeType--
    IF(@newDegreeType IS NOT NULL)
    BEGIN
        UPDATE  programs
        SET     degreeType = @newDegreeType
        WHERE   progId = @id;
    END;
END;


--update students attributes--
GO;
CREATE PROCEDURE sp_update_students
    @id INTEGER,
    @newFname VARCHAR(255) = NULL,
    @newLname VARCHAR(255) = NULL,
    @newAddress VARCHAR(255) = NULL,
    @newContact INTEGER = NULL,
    @newProgId INTEGER = NULL,
    @newPassword VARCHAR(255) = NULL
AS
BEGIN
    --fname--
    IF(@newFname IS NOT NULL)
    BEGIN
        UPDATE  students
        SET     fname = @newFname
        WHERE   studId = @id;
    END;
    --lname--
    IF(@newLname IS NOT NULL)
    BEGIN
        UPDATE  students
        SET     lname = @newLname
        WHERE   studId = @id;
    END;
    --address--
    IF(@newAddress IS NOT NULL)
    BEGIN
        UPDATE  students
        SET     address = @newAddress
        WHERE   studId = @id;
    END;
    --contact--
    IF(@newContact IS NOT NULL)
    BEGIN
        UPDATE  students
        SET     contact = @newContact
        WHERE   studId = @id;
    END;
    --progId--
    IF(@newProgId IS NOT NULL)
    BEGIN
        UPDATE  students
        SET     progId = @newProgId
        WHERE   studId = @id;
    END;
    --password--
    IF(@newPassword IS NOT NULL)
    BEGIN
        UPDATE  students
        SET     password = @newPassword
        WHERE   studId = @id;
    END;
END;

--update lecturer attributes--
GO;
CREATE PROCEDURE sp_update_lecturer
    @L_username VARCHAR(255),
    @newFname VARCHAR(255) = NULL,
    @newLname VARCHAR(255) = NULL,
    @newAddress VARCHAR(255) = NULL,
    @newContact INTEGER = NULL,
    @newType VARCHAR(255) = NULL,
    @newPassword VARCHAR(255) = NULL
AS
BEGIN
    --fname--
    IF(@newFname IS NOT NULL)
    BEGIN
        UPDATE  lecturer
        SET     fname = @newFname
        WHERE   l_username = @L_username;
    END;
    --lname--
    IF(@newLname IS NOT NULL)
    BEGIN
        UPDATE  lecturer
        SET     lname = @newLname
        WHERE   l_username = @L_username;
    END;
    --address--
    IF(@newAddress IS NOT NULL)
    BEGIN
        UPDATE  lecturer
        SET     address = @newAddress
        WHERE   l_username = @L_username;
    END;
    --contact--
    IF(@newContact IS NOT NULL)
    BEGIN
        UPDATE  lecturer
        SET     contact = @newContact
        WHERE   l_username = @L_username;
    END;
    --type--
    IF(@newType IS NOT NULL)
    BEGIN
        UPDATE  lecturer
        SET     type = @newType
        WHERE   l_username = @L_username;
    END;
    --password--
    IF(@newPassword IS NOT NULL)
    BEGIN
        UPDATE  lecturer
        SET     password = @newPassword
        WHERE   l_username = @L_username;
    END;
END;

--update admin attributes--
GO;
CREATE PROCEDURE sp_update_admin
    @a_username VARCHAR(255),
    @newFname VARCHAR(255) = NULL,
    @newLname VARCHAR(255) = NULL,
    @newAddress VARCHAR(255) = NULL,
    @newContact INTEGER = NULL,
    @newPassword VARCHAR(255) = NULL
AS
BEGIN
    --fname--
    IF(@newFname IS NOT NULL)
    BEGIN
        UPDATE  admin
        SET     fname = @newFname
        WHERE   a_username = @a_username;
    END;
    --lname--
    IF(@newLname IS NOT NULL)
    BEGIN
        UPDATE  admin
        SET     lname = @newLname
        WHERE   a_username = @a_username;
    END;
    --address--
    IF(@newAddress IS NOT NULL)
    BEGIN
        UPDATE  admin
        SET     address = @newAddress
        WHERE   a_username = @a_username;
    END;
    --contact--
    IF(@newContact IS NOT NULL)
    BEGIN
        UPDATE  admin
        SET     contact = @newContact
        WHERE   a_username = @a_username;
    END;
    --password--
    IF(@newPassword IS NOT NULL)
    BEGIN
        UPDATE  admin
        SET     password = @newPassword
        WHERE   a_username = @a_username;
    END;
END;

--update class attributes--
GO;
CREATE PROCEDURE sp_update_class
    @id INTEGER,
    @newMode VARCHAR(12) = NULL,
    @newStartTime TIME = NULL
AS
BEGIN
    --mode--
    IF(@newMode IS NOT NULL)
    BEGIN
        UPDATE  class
        SET     mode = @newMode
        WHERE   classId = @id;
    END;
    --starttime--
    IF(@newStartTime IS NOT NULL)
    BEGIN
        UPDATE  class
        SET     starttime = @newStartTime
        WHERE   classId = @id;
    END;
END;

--update room attributes--
GO;
CREATE PROCEDURE sp_update_room
    @classId INTEGER,
    @moduleId INTEGER,
    @newL_username VARCHAR(255)
AS
BEGIN
    UPDATE  room
    SET     l_username = @newL_username
    WHERE   classId = @classId AND moduleId = @moduleId;
END;
