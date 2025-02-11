Entities:
  Course:
    Attributes: courseId, title, credit
    Relationships:
    One-to-One with CourseMaterial
    Many-to-One with Teacher
    Many-to-Many with Student
    Methods: addStudents
  CourseMaterial:
    Attributes: courseMaterialId, url
    Relationships: One-to-One with Course
  Guardian:
    Attributes: name, email, mobile
    Embedded in: Student
  Student:
    Attributes: studentIdentificationNumber, firstName, lastName, emailId
    Relationships: Embedded Guardian
  Teacher:
    Attributes: teacherId, firstName, lastName
    
Repositories:
  CourseMaterialRepository:
    Description: JPA repository for CourseMaterial entity.
 CourseRepository:
    Description: JPA repository for Course entity.
    Custom Methods:
    findByTitleContaining: Finds courses by title containing a specific string with pagination.
  StudentRepository:
    Description: JPA repository for Student entity.
    Custom Methods:
    findByFirstName: Finds students by first name.
    findByFirstNameContaining: Finds students by first name containing a specific string.
    findByLastNameNotNull: Finds students with a non-null last name.
    findByGuardianName: Finds students by guardian's name.
    findByFirstNameAndLastName: Finds a student by first and last name.
    getStudentByEmailAddress: Finds a student by email address using JPQL.
    getStudentFirstNameByEmailAddress: Finds a student's first name by email address using JPQL.
    getStudentFirstNameByEmailAddressNative: Finds a student by email address using a native query.
    getStudentFirstNameByEmailAddressNativeNamedParam: Finds a student by email address using a native query with named parameters.
    updateStudentNameByEmailId: Updates a student's name by email address using a native query.
    
Tests:
  CourseMaterialRepositoryTest:
    Tests:
    saveCourseMaterial: Saves a CourseMaterial with an associated Course.
    printAllCourseMaterials: Prints all CourseMaterial records.
  CourseRepositoryTest:
    Tests:
    printCourses: Prints all Course records.
    saveCourseWithTeacher: Saves a Course with an associated Teacher.
    findAllPagination: Tests pagination for Course records.
    findAllSorting: Tests sorting for Course records.
    printFindByTitleContaining: Finds and prints courses by title containing a specific string.
    saveCourseWithStudentAndTeacher: Saves a Course with associated Student and Teacher.
  StudentRepositoryTest:
    Tests:
    saveStudent: Saves a Student.
    saveStudentWithGuardianDetails: Saves a Student with embedded Guardian details.
    printAllStudent: Prints all Student records.
    printStudentByFirstNameContaining: Finds and prints students by first name containing a specific string.
    printStudentBasedOnGuardianName: Finds and prints students by guardian's name.
    printStudentByEmailAddress: Finds and prints a student by email address.
    printStudentFirstNameByEmailAddress: Finds and prints a student's first name by email address.
    getStudentFirstNameByEmailAddressNative: Finds and prints a student by email address using a native query.
    getStudentFirstNameByEmailAddressNativeNamedParam: Finds and prints a student by email address using a native query with named parameters.
    updateStudentNameByEmailId: Updates a student's name by email address using a native query.
  TeacherRepositoryTest:
    Tests:
    saveTeacher: Saves a Teacher with associated Course records.
