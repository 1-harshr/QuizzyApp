package com.harsh.quizzyapp.data.model

data class StudentHomePageDto(
    val student: Student,
    val todaySummary: TodaySummary,
    val weeklyOverview: WeeklyOverview
) {
    companion object Companion {
        val studentHomePageDto = StudentHomePageDto(
            student = Student(
                name = "Gaurav",
                `class` = "10th Class",
                availability = Availability(
                    status = Availability.AvailabilityStatus.PRESENT
                ),
                quiz = Quiz(
                    attempts = 3
                ),
                accuracy = Accuracy(
                    current = "72%"
                )
            ),
            todaySummary = TodaySummary(
                mood = TodaySummary.Mood.FOCUSED,
                description = "Struggles with Apply-level Math today.",
                recommendedVideo = TodaySummary.RecommendedVideo(
                    title = "Apply Pythagoras Theorem",
                    actionText = "Watch: Apply Pythagoras Theorem"
                ),
                characterImage = "focused_character.png"
            ),
            weeklyOverview = WeeklyOverview(
                quizStreak = listOf(
                    QuizStreak(
                        day = QuizStreak.Day.MON,
                        status = QuizStreak.QuizStatus.DONE
                    ),
                    QuizStreak(
                        day = QuizStreak.Day.TUE,
                        status = QuizStreak.QuizStatus.DONE
                    ),
                    QuizStreak(
                        day = QuizStreak.Day.WED,
                        status = QuizStreak.QuizStatus.DONE
                    ),
                    QuizStreak(
                        day = QuizStreak.Day.THR,
                        status = QuizStreak.QuizStatus.DONE
                    ),
                    QuizStreak(
                        day = QuizStreak.Day.FRI,
                        status = QuizStreak.QuizStatus.PENDING
                    ),
                    QuizStreak(
                        day = QuizStreak.Day.SAT,
                        status = QuizStreak.QuizStatus.PENDING
                    ),
                    QuizStreak(
                        day = QuizStreak.Day.SUN,
                        status = QuizStreak.QuizStatus.PENDING
                    )
                ),
                overallAccuracy = OverallAccuracy(
                    percentage = 68,
                    label = "68% correct"
                ),
                performanceByTopic = listOf(
                    PerformanceByTopic(
                        topic = "Newton's Laws Of Motion",
                        trend = PerformanceByTopic.Trend.UP
                    ),
                    PerformanceByTopic(
                        topic = "Sources Of Energy",
                        trend = PerformanceByTopic.Trend.UP
                    ),
                    PerformanceByTopic(
                        topic = "Light Reflection And Refraction",
                        trend = PerformanceByTopic.Trend.DOWN
                    )
                )
            )
        )
    }
}

data class Student(
    val name: String,
    val `class`: String,
    val availability: Availability,
    val quiz: Quiz,
    val accuracy: Accuracy
)

data class Availability(
    val status: AvailabilityStatus
) {
    enum class AvailabilityStatus{
        PRESENT, ABSENT
    }
}

data class Quiz(
    val attempts: Int
)

data class Accuracy(
    val current: String
)

data class TodaySummary(
    val mood: Mood,
    val description: String,
    val recommendedVideo: RecommendedVideo,
    val characterImage: String
) {
    enum class Mood {
        FOCUSED, DISTRACTED, MOTIVATED, TIRED
    }

    data class RecommendedVideo(
        val title: String,
        val actionText: String
    )
}

data class WeeklyOverview(
    val quizStreak: List<QuizStreak>,
    val overallAccuracy: OverallAccuracy,
    val performanceByTopic: List<PerformanceByTopic>
)

data class QuizStreak(
    val day: Day,
    val status: QuizStatus
) {
    enum class Day {
        MON, TUE, WED, THR, FRI, SAT, SUN 
    }

    enum class QuizStatus {
        DONE, PENDING
    }
}

data class OverallAccuracy(
    val percentage: Int,
    val label: String
)

data class PerformanceByTopic(
    val topic: String,
    val trend: Trend
) {
    enum class Trend {
        UP, DOWN, STABLE
    }
}