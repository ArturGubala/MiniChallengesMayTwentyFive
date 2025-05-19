package com.example.minichallengesmaytwentyfive.searchablestudylist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.minichallengesmaytwentyfive.ui.theme.MiniChallengesMayTwentyFiveTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchableStudyList() {
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

@Preview
@Composable
fun SearchableStudyListView() {
    MiniChallengesMayTwentyFiveTheme {
        SearchableStudyList()
    }
}
