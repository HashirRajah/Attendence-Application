--sp for Inserts--
--sp to add students--

CREATE PROCEDURE sp_add_student  @fname VARCHAR(255), @lname VARCHAR(255), @gender CHAR(1), @address VARCHAR(255),  @email VARCHAR(255), @contact INT, @progId INT
AS
BEGIN


	BEGIN TRY
		INSERT INTO students
		VALUES ( @fname, @lname, @gender, @address, @email, @contact, @progId);
		PRINT 'Insert successful';
	END TRY

	BEGIN CATCH
		PRINT 'INSERT FAILED!';
		PRINT ERROR_NUMBER();
		PRINT ERROR_MESSAGE();
	END CATCH

END;

--sp to add modules--
CREATE PROCEDURE sp_add_module  @name VARCHAR(255)
AS
BEGIN


	BEGIN TRY
		INSERT INTO modules
		VALUES ( @name);
		PRINT 'Insert successful';
	END TRY

	BEGIN CATCH
		PRINT 'INSERT FAILED!';
		PRINT ERROR_NUMBER();
		PRINT ERROR_MESSAGE();
	END CATCH

END;

--sp to add programs--
CREATE PROCEDURE sp_add_module  @name VARCHAR(255), @progType VARCHAR(255), @deptId INT, @degreeType VARCHAR(255)
AS
BEGIN


	BEGIN TRY
		INSERT INTO programs
		VALUES ( @name , @progType, deptId, degreeType);
		PRINT 'Insert successful';
	END TRY

	BEGIN CATCH
		PRINT 'INSERT FAILED!';
		PRINT ERROR_NUMBER();
		PRINT ERROR_MESSAGE();
	END CATCH

END;

--sp to add lecturer--
CREATE PROCEDURE sp_add_lecturer  @fname VARCHAR(255), @lname VARCHAR(255), @gender CHAR(1), @address VARCHAR(255),  @email VARCHAR(255), @contact INT, @type VARCHAR(255), @password VARCHAR(255)
AS
BEGIN


	BEGIN TRY
		INSERT INTO lecturer
		VALUES ( @fname , @lname , @gender , @address ,  @email, @contact , @type, @password );
		PRINT 'Insert successful';
	END TRY

	BEGIN CATCH
		PRINT 'INSERT FAILED!';
		PRINT ERROR_NUMBER();
		PRINT ERROR_MESSAGE();
	END CATCH

END;

--sp to add admin-
CREATE PROCEDURE sp_add_admin  @fname VARCHAR(255), @lname VARCHAR(255), @gender CHAR(1), @address VARCHAR(255),  @email VARCHAR(255), @contact INT, @type VARCHAR(255), @password VARCHAR(255)
AS
BEGIN


	BEGIN TRY
		INSERT INTO admin
		VALUES ( @fname , @lname , @gender , @address ,  @email, @contact , @type, @password );
		PRINT 'Insert successful';
	END TRY

	BEGIN CATCH
		PRINT 'INSERT FAILED!';
		PRINT ERROR_NUMBER();
		PRINT ERROR_MESSAGE();
	END CATCH

END;

--sp to add class-
CREATE PROCEDURE sp_add_class  @mode VARCHAR(12) , @type VARCHAR(255) , @duration TIME, @starttime TIME, @grName VARCHAR(255), @grLevel TINYINT, @progId INT
AS
BEGIN


	BEGIN TRY
		INSERT INTO class
		VALUES ( @mode, @type , @duration , @starttime , @grName, @grLevel, @progId );
		PRINT 'Insert successful';
	END TRY

	BEGIN CATCH
		PRINT 'INSERT FAILED!';
		PRINT ERROR_NUMBER();
		PRINT ERROR_MESSAGE();
	END CATCH

END;

--sp to add groups-
CREATE PROCEDURE sp_add_groups @grName VARCHAR(255), @grLevel TINYINT, @progId INT
AS
BEGIN


	BEGIN TRY
		INSERT INTO groups
		VALUES ( @grName , @grLevel, @progId );
		PRINT 'Insert successful';
	END TRY

	BEGIN CATCH
		PRINT 'INSERT FAILED!';
		PRINT ERROR_NUMBER();
		PRINT ERROR_MESSAGE();
	END CATCH

END;

--sp to add room-
CREATE PROCEDURE sp_add_rooms @moduleId INT , @l_username INT, @classId INT
AS
BEGIN


	BEGIN TRY
		INSERT INTO room
		VALUES ( @moduleId, @l_username, @classId);
		PRINT 'Insert successful';
	END TRY

	BEGIN CATCH
		PRINT 'INSERT FAILED!';
		PRINT ERROR_NUMBER();
		PRINT ERROR_MESSAGE();
	END CATCH

END;

--sp to add attendance-
CREATE PROCEDURE sp_add_attendance   @studId INT ,@date DATE, @classId INT ,@presence VARCHAR(12) ,@week TINYINT, @semester TINYINT, @status VARCHAR(9)
AS
BEGIN


	BEGIN TRY
		INSERT INTO attendance
		VALUES ( @studId  ,@date , @classId  ,@presence  ,@week , @semester , @status);
		PRINT 'Insert successful';
	END TRY

	BEGIN CATCH
		PRINT 'INSERT FAILED!';
		PRINT ERROR_NUMBER();
		PRINT ERROR_MESSAGE();
	END CATCH

END;

--sp to add dept
CREATE PROCEDURE sp_add_department deptId INT , @name VARCHAR(255)
AS
BEGIN


	BEGIN TRY
		INSERT INTO department
		VALUES ( deptId  , @name );
		PRINT 'Insert successful';
	END TRY

	BEGIN CATCH
		PRINT 'INSERT FAILED!';
		PRINT ERROR_NUMBER();
		PRINT ERROR_MESSAGE();
	END CATCH

END;