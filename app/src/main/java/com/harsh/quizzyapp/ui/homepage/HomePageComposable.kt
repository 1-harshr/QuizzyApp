package com.harsh.quizzyapp.ui.homepage

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harsh.quizzyapp.R
import com.harsh.quizzyapp.data.model.Accuracy
import com.harsh.quizzyapp.data.model.Availability
import com.harsh.quizzyapp.data.model.OverallAccuracy
import com.harsh.quizzyapp.data.model.PerformanceByTopic
import com.harsh.quizzyapp.data.model.Quiz
import com.harsh.quizzyapp.data.model.QuizStreak
import com.harsh.quizzyapp.data.model.StudentHomePageDto
import com.harsh.quizzyapp.data.model.TodaySummary
import com.harsh.quizzyapp.data.model.WeeklyOverview


@Preview(showBackground = true)
@Composable
fun HomePageComposable(
    data: StudentHomePageDto = StudentHomePageDto.studentHomePageDto
) {

    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        topBar = {
            HeaderWidget(
                name = data.student.name,
                className = data.student.studentClass
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {

            item {
                MetricsCardsWidget(
                    availability = data.student.availability,
                    quiz = data.student.quiz,
                    accuracy = data.student.accuracy
                )
            }

            item {
                TodaySummaryWidget(
                    todaySummary = data.todaySummary
                )
            }

            item {
                WeeklyOverviewWidget(
                    weeklyOverview = data.weeklyOverview
                )
            }
        }

    }

}

@Composable
fun HeaderWidget(
    name: String,
    className: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Hello $name!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif

            )
            Text(
                text = className,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
            )
        }
        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notifications"
            )
        }
    }
}

@Composable
fun MetricsCardsWidget(
    availability: Availability,
    quiz: Quiz,
    accuracy: Accuracy
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        MetricCard(
            icon = R.drawable.ic_available,
            label = "Availability",
            value = if (availability.status == Availability.AvailabilityStatus.PRESENT) "Present" else "Absent",
            backgroundColor = Color(62,219,94),
            modifier = Modifier.weight(1f)
        )
        MetricCard(
            icon = R.drawable.ic_quiz,
            label = "Quiz",
            value = "${quiz.attempts} Attempt",
            backgroundColor = Color(0xFFFF9800),
            modifier = Modifier.weight(1f)
        )
        MetricCard(
            icon = R.drawable.ic_accuracy,
            label = "Accuracy",
            value = accuracy.current,
            backgroundColor = Color(0xFFE91E63),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun MetricCard(
    icon: Int,
    label: String,
    value: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.border(1.dp,backgroundColor,RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor.copy(alpha = 0.2f))
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label,
                tint = backgroundColor,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = label,
                color = Color.Black,
                fontSize = 12.sp,
                lineHeight = 18.sp
            )
            Text(
                text = value,
                color = backgroundColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 18.sp
            )
        }
    }
}

@Composable
fun TodaySummaryWidget(
    todaySummary: TodaySummary
) {
    Column {
        Text(
            text = "Today's Summary",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Card(
            modifier = Modifier.fillMaxWidth().border(1.dp, Color(153, 110, 181), RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(252, 247, 255, 1))
        ) {
            Spacer(Modifier.padding(10.dp))

            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_focused),
                    contentDescription = "Character",
                    modifier = Modifier.size(80.dp)
                )
                Text(
                    text = todaySummary.mood.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(153, 110, 181)
                )
                Text(
                    text = "“"+todaySummary.description+"”",
                    fontSize = 14.sp,
                    color = Color(27, 33, 36)
                )
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = todaySummary.recommendedVideo.actionText,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }


        }
    }
}

@Composable
fun WeeklyOverviewWidget(
    weeklyOverview: WeeklyOverview
) {
    Column {
        Text(
            text = "Weekly Overview",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Card(
            modifier = Modifier.fillMaxWidth().border(1.dp, Color(123, 127, 134), RoundedCornerShape(16.dp)).padding(20.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            QuizStreakSection(quizStreak = weeklyOverview.quizStreak)
            Spacer(modifier = Modifier.height(24.dp))
            AccuracySection(overallAccuracy = weeklyOverview.overallAccuracy)
            Spacer(modifier = Modifier.height(24.dp))
            PerformanceByTopicSection(performanceByTopic = weeklyOverview.performanceByTopic)

        }
    }
}

@Composable
fun QuizStreakSection(
    quizStreak: List<QuizStreak>
) {
    WeeklyOverviewItem(
        heading = "Quiz Streak",
        icon = R.drawable.ic_streak,
    ){
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            quizStreak.forEach { streak ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(
                            if (streak.status == QuizStreak.QuizStatus.DONE) {
                                Color(0xFF4CAF50)
                            } else {
                                Color(0xFFE0E0E0)
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (streak.status == QuizStreak.QuizStatus.DONE) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_tick),
                            contentDescription = "Done",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    } else {
                        Text(
                            text = streak.day.name.take(1),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AccuracySection(
    overallAccuracy: OverallAccuracy
) {

    WeeklyOverviewItem(
        heading = "Accuracy",
        icon = R.drawable.ic_accuracy_2,
    ){
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = overallAccuracy.label,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = { overallAccuracy.percentage / 100f },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = Color(0xFFE91E63),
            trackColor = Color(0xFFE0E0E0),
        )
    }
}

@Composable
fun PerformanceByTopicSection(
    performanceByTopic: List<PerformanceByTopic>
) {
    WeeklyOverviewItem(
        heading = "Performance by Topic",
        icon = R.drawable.ic_performace,
    ){
        performanceByTopic.forEach { topic ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = topic.topic,
                    fontSize = 14.sp
                )
                Text(
                    text = when (topic.trend) {
                        PerformanceByTopic.Trend.UP -> "↑"
                        PerformanceByTopic.Trend.DOWN -> "↓"
                        PerformanceByTopic.Trend.STABLE -> "→"
                    },
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = when (topic.trend) {
                        PerformanceByTopic.Trend.UP -> Color(0xFF4CAF50)
                        PerformanceByTopic.Trend.DOWN -> Color(0xFFE91E63)
                        PerformanceByTopic.Trend.STABLE -> Color(0xFF9E9E9E)
                    }
                )
            }
        }

    }
}

@Composable
fun WeeklyOverviewItem(
    heading: String,
    @DrawableRes icon :  Int,
    content: @Composable ColumnScope.() -> Unit
) {

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = heading,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 24.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Accuracy",
                tint = Color.Unspecified,
                modifier = Modifier.size(40.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(255, 255, 255, 1), Color.Black)
                    )
                )

        )
        content()
    }

}
