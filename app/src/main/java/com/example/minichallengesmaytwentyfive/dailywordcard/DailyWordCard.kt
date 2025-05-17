package com.example.minichallengesmaytwentyfive.dailywordcard

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.minichallengesmaytwentyfive.R
import com.example.minichallengesmaytwentyfive.ui.theme.MiniChallengesMayTwentyFiveTheme
import java.util.Locale

@Composable
fun DailyWordCard() {
    val context = LocalContext.current
    val terms = listOf(
        Term("Photosynthesis", "The process by which green plants use sunlight to make their own food."),
        Term("Democracy", "A system of government in which power is held by the people, typically through elected representatives."),
        Term("Atom", "The smallest unit of matter that retains the properties of an element."),
        Term("Simile", "A figure of speech comparing two different things using “like” or “as.”"),
        Term("Ecosystem", "A community of living organisms and their physical environment interacting as a system."),
        Term("Revolution", "A significant change in political power or organizational structures that takes place in a relatively short period of time."),
        Term("Gravity", "The force that attracts two bodies toward each other, especially the pull of the Earth."),
        Term("Thesis", "A statement or theory that is put forward as a premise to be maintained or proved."),
        Term("Culture", "The ideas, customs, and social behavior of a particular group of people or society."),
        Term("Equator", "An imaginary line around the middle of the Earth, equidistant from the poles."),
        Term("Inference", "A conclusion reached on the basis of evidence and reasoning."),
        Term("Magnetism", "A physical phenomenon produced by the motion of electric charge, resulting in attractive and repulsive forces."),
        Term("Alliteration", "The repetition of the same sound at the beginning of closely connected words."),
        Term("Allegory", "A story, poem, or picture that can be interpreted to reveal a hidden meaning, typically a moral or political one."),
        Term("Monarchy", "A form of government with a monarch at the head."),
        Term("Hypothesis", "A proposed explanation made on the basis of limited evidence as a starting point for further investigation."),
        Term("Precipitation", "Any form of water—liquid or solid—that falls from clouds and reaches the ground."),
        Term("Perspective", "A point of view or way of looking at something, especially in writing or art."),
        Term("Dialogue", "A conversation between two or more people as a feature of a book, play, or movie."),
        Term("Tundra", "A vast, flat, treeless Arctic region in which the subsoil is permanently frozen.")
    )
    var tts by remember { mutableStateOf<TextToSpeech?>(null) }

    LaunchedEffect(Unit) {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale.UK
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            tts?.stop()
            tts?.shutdown()
        }
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF6B74F8),
                            Color(0xFFFDE5F3),
                            Color(0xFFFEF7EE)
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
                val randomTerm = terms.random()
                Box(
                    modifier = Modifier
                        .size(364.dp)
                        .shadow(
                            elevation = 20.dp,
                            shape = RoundedCornerShape(20.dp),
                            ambientColor = Color(0x0D13182C),
                            spotColor = Color(0x0D13182C)
                        )
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(all = 32.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = randomTerm.term,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge,
                        )
                        Text(
                            text = randomTerm.definition,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                }
                Button(
                    onClick = {
                        tts?.speak("${randomTerm.term}. ${randomTerm.definition}", TextToSpeech.QUEUE_FLUSH, null, null)
                    },
                    modifier = Modifier
                        .size(80.dp)
                        .shadow(
                            elevation = 20.dp,
                            shape = RoundedCornerShape(50.dp),
                            ambientColor = Color(0x1413182C),
                            spotColor = Color(0x1413182C)
                        ),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                      containerColor = Color(0xFF6B74F8)
                    )
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_volume_max),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

data class Term(val term: String, val definition: String)

@Preview
@Composable
fun DailyWordCardPreview() {
    MiniChallengesMayTwentyFiveTheme {
        DailyWordCard()
    }
}
