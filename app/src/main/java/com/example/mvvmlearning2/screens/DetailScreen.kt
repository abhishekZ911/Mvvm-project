package com.example.mvsharedViewModellearning2.screens

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmlearning2.viewmodels.FruitViewModel

@Composable
fun DetailScreen(
    sharedViewModel: FruitViewModel
){



    val details by sharedViewModel.detail.collectAsState()

    val query by sharedViewModel.query.collectAsState()
    LaunchedEffect(key1 = details) {
        Log.d("Akadjfljakl", details.toString())

    }


    Box(modifier = Modifier.fillMaxSize()
        .padding(20.dp),
        contentAlignment = Alignment.Center)
    {
        Card(colors = CardDefaults.cardColors(Color.Cyan),
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier.fillMaxWidth()
                .height(200.dp)
            ) {
            details?.let {
                Text(text = it.name,
                    modifier = Modifier.padding(10.dp)
                        .fillMaxWidth(),
                    fontSize = 20.sp,

                    textAlign = TextAlign.Center) }

        }
    }

}