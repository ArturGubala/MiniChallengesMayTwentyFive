package com.example.minichallengesmaytwentyfive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.minichallengesmaytwentyfive.searchablestudylist.SearchableStudyList
import com.example.minichallengesmaytwentyfive.ui.theme.MiniChallengesMayTwentyFiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        window.isNavigationBarContrastEnforced = false
        setContent {
            MiniChallengesMayTwentyFiveTheme {
//                Challenge 1
//                DailyWordCard()

//                Challenge 2
                SearchableStudyList()
            }
        }
    }
}
