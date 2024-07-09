enum class Level { BEGINNER, INTERMEDIATE, ADVANCED }

data class User(
    val name: String,
    val email: String,
    val age: Int
)

data class EducationalContent(
    val name: String,
    val duration: Int = 60, // Default duration of 60 minutes
    val author: String
)

class Course(
    val name: String,
    val level: Level, // Using the Level enum to represent the level
    var contents: MutableList<EducationalContent> = mutableListOf()
) {
    val enrolledStudents = mutableListOf<User>()

    fun enroll(user: User) {
        enrolledStudents.add(user)
        println("User ${user.name} enrolled in course $name")
    }

    fun addContent(content: EducationalContent) {
        contents.add(content)
        println("Content ${content.name} added to course $name")
    }

    fun removeContent(content: EducationalContent) {
        if (contents.remove(content)) {
            println("Content ${content.name} removed from course $name")
        } else {
            println("Content ${content.name} not found in course $name")
        }
    }

    fun details() {
        println("Course: $name")
        println("Level: $level") // Prints the name of the level (e.g., "INTERMEDIATE")
        println("Contents:")
        if (contents.isEmpty()) {
            println("   No content added yet.")
        } else {
            for (content in contents) {
                println(" - ${content.name} (${content.duration} minutes) - (by ${content.author})")
            }
        }

        println("Enrolled Students:")
        if (enrolledStudents.isEmpty()) {
            println("   No students enrolled yet.")
        } else {
            for (student in enrolledStudents) {
                println(" - ${student.name} (${student.email})")
            }
        }
    }
}

fun main() {
    val user1 = User("Paul", "paul@gmail.com", 35)
    val user2 = User("Cleber", "ckb@gmail.com", 21)

    val content1 = EducationalContent("Introduction to Kotlin", 90, "Professor A")
    val content2 = EducationalContent("Introduction to Java", 120, "Professor B") // Duration changed to 120 minutes

    val javaCourse = Course("Java Course", Level.INTERMEDIATE)
    javaCourse.addContent(content1) // Adding the correct contents
    javaCourse.addContent(content2)

    javaCourse.enroll(user1)
    javaCourse.enroll(user2)

    javaCourse.details()
}
