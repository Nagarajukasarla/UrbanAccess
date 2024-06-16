package com.example.buspassapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.pm.ShortcutInfoCompat
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.White
import toResponsiveDp

@Composable
fun SearchBar(
    onSearchTextChanged: (String) -> Unit,
    onSearchClicked: () -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.toResponsiveDp())
            .background(color = Color(0xFFEEFEFD),shape = RoundedCornerShape(16.toResponsiveDp())),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(){
        BasicTextField(
            value = searchText,
            onValueChange = {
                searchText = it
                onSearchTextChanged(it)
            },
            textStyle = TextStyle(color = Color.Black),
            singleLine = true,
            modifier = Modifier
                .padding(end = 8.toResponsiveDp())
                
        )

        IconButton(
            onClick = { onSearchClicked() }
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        }
    }
    }
}

@Composable
fun SearchScreen() {
    var searchQuery by remember { mutableStateOf("") }
        SearchBar(
            onSearchTextChanged = { query ->
                searchQuery = query
            },
            onSearchClicked = {

            }
        )
}

@Composable
@Preview
fun MyApp() {
   SearchScreen()
}
