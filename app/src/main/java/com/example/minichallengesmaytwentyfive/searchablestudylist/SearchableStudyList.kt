package com.example.minichallengesmaytwentyfive.searchablestudylist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.minichallengesmaytwentyfive.ui.theme.GreenPillBg
import com.example.minichallengesmaytwentyfive.ui.theme.GreenPillText
import com.example.minichallengesmaytwentyfive.ui.theme.MiniChallengesMayTwentyFiveTheme
import com.example.minichallengesmaytwentyfive.ui.theme.OrangePillBg
import com.example.minichallengesmaytwentyfive.ui.theme.OrangePillText
import com.example.minichallengesmaytwentyfive.ui.theme.PinkPillBg
import com.example.minichallengesmaytwentyfive.ui.theme.PinkPillText
import com.example.minichallengesmaytwentyfive.ui.theme.PurplePillBg
import com.example.minichallengesmaytwentyfive.ui.theme.PurplePillText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchableStudyList() {
    val topics = listOf(
        Topic("Photosynthesis", listOf("Biology", "Environmental Science")),
        Topic("World War II Timeline", listOf("History", "Social Studies")),
        Topic("Introduction to Fractions", listOf("Math")),
        Topic("Elements of a Story", listOf("Literature", "Language Arts")),
        Topic("The Water Cycle", listOf("Geography", "Environmental Science")),
        Topic("Basic French Greetings", listOf("Language", "French")),
        Topic("The Human Skeleton", listOf("Biology", "Health")),
        Topic("Ancient Egyptian Civilizations", listOf("History", "Archaeology")),
        Topic("Solving for X (Algebra Basics)", listOf("Math")),
        Topic("Types of Clouds", listOf("Geography", "Earth Science")),
        Topic("Writing a Thesis Statement", listOf("Writing", "Language Arts")),
        Topic("The Constitution Explained", listOf("Civics", "History")),
        Topic("Food Chains and Webs", listOf("Biology", "Ecology")),
        Topic("Understanding Supply & Demand", listOf("Economics", "Social Studies")),
        Topic("Literary Devices in Poetry", listOf("Literature", "English")),
        Topic("Basic Spanish Verbs", listOf("Language", "Spanish")),
        Topic("Introduction to Coding", listOf("Computer Science", "Technology")),
        Topic("Earthquake Safety Basics", listOf("Geography", "Earth Science")),
        Topic("Subject‑Verb Agreement", listOf("Grammar", "Language Arts")),
        Topic("The Solar System Overview", listOf("Astronomy", "Science"))
    )

    val topicStyles = mapOf(
        "Biology" to TopicStyle(backgroundColor = GreenPillBg, textColor = GreenPillText),
        "Environmental Science" to TopicStyle(backgroundColor = PurplePillBg, textColor = PurplePillText),
        "History" to TopicStyle(backgroundColor = GreenPillBg, textColor = GreenPillText),
        "Social Studies" to TopicStyle(backgroundColor = OrangePillBg, textColor = OrangePillText),
        "Math" to TopicStyle(backgroundColor = PinkPillBg, textColor = PinkPillText),
        "Literature" to TopicStyle(backgroundColor = PinkPillBg, textColor = PinkPillText),
        "Language Arts" to TopicStyle(backgroundColor = PurplePillBg, textColor = PurplePillText),
        "Geography" to TopicStyle(backgroundColor = OrangePillBg, textColor = OrangePillText),
        "Language" to TopicStyle(backgroundColor = OrangePillBg, textColor = OrangePillBg),
        "French" to TopicStyle(backgroundColor = PurplePillBg, textColor = PurplePillText),
        "Health" to TopicStyle(backgroundColor = PurplePillBg, textColor = PurplePillText),
        "Archaeology" to TopicStyle(backgroundColor = PurplePillBg, textColor = PurplePillText),
        "Earth Science" to TopicStyle(backgroundColor = GreenPillBg, textColor = GreenPillText),
        "Writing" to TopicStyle(backgroundColor = OrangePillBg, textColor = OrangePillText),
        "Civics" to TopicStyle(backgroundColor = OrangePillBg, textColor = OrangePillText),
        "Ecology" to TopicStyle(backgroundColor = GreenPillBg, textColor = GreenPillText),
        "Economics" to TopicStyle(backgroundColor = GreenPillBg, textColor = GreenPillText),
        "English" to TopicStyle(backgroundColor = PurplePillBg, textColor = PurplePillText),
        "Spanish" to TopicStyle(backgroundColor = PinkPillBg, textColor = PinkPillText),
        "Computer Science" to TopicStyle(backgroundColor = PurplePillBg, textColor = PurplePillText),
        "Technology" to TopicStyle(backgroundColor = OrangePillBg, textColor = OrangePillText),
        "Grammar" to TopicStyle(backgroundColor = PinkPillBg, textColor = PinkPillText),
        "Astronomy" to TopicStyle(backgroundColor = PinkPillBg, textColor = PinkPillText),
        "Science" to TopicStyle(backgroundColor = PurplePillBg, textColor = PurplePillText),
    )

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 20.dp, bottom = 12.dp, end = 20.dp)
            ) {
                Text(
                    text = "Study Topics",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                SearchBar(
                    inputField = {
                        SearchBarDefaults.InputField(
                            query = "",
                            onQueryChange = { },
                            onSearch = {
                            },
                            expanded = false,
                            onExpandedChange = {  },
                            modifier = Modifier
                                .height(48.dp),
                            placeholder = { Text("Search") }
                        )
                    },
                    expanded = false,
                    onExpandedChange = { },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {}
            }
        },
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0x266B74F8),
                            Color(0x26FDE5F3),
                            Color(0x26FEF7EE)
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.spacedBy(40.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            }
        }
    }
}

@Composable
fun SearchableStudyItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = Color(0x0813182C),
                spotColor = Color(0x0813182C)
            )
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(all = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row {

            }
            Text("Test")
        }
    }
}

data class Topic(
    val topic: String,
    val subjectTags: List<String>
)

data class TopicStyle(
    val backgroundColor: Color,
    val textColor: Color
)


@Preview
@Composable
fun SearchableStudyListView() {
    MiniChallengesMayTwentyFiveTheme {
        SearchableStudyList()
    }
}

@Preview
@Composable
fun SearchableStudyItemView() {
    MiniChallengesMayTwentyFiveTheme {
        SearchableStudyItem()
    }
}
