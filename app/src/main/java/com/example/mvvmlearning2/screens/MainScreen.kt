package com.example.mvvmlearning2.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mvvmlearning2.R
import com.example.mvvmlearning2.viewmodels.FruitViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    sharedViewModel: FruitViewModel
) {

    val context = LocalContext.current;



    val detail by sharedViewModel.detail.collectAsState()

    val toastMessage by sharedViewModel.toastMessage.observeAsState()

    val query by sharedViewModel.query.collectAsState()

    Log.d("abhishek", detail.toString())


    LaunchedEffect(key1 = toastMessage) {
        toastMessage.let {
            if (it.equals("")) {
                return@let
            } else {
                Toast.makeText(context, it, Toast.LENGTH_LONG);
                sharedViewModel.shownToast()
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.5f),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = "background image"
        )
        OutlinedTextField(
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color.White),
            value = query!!,
            onValueChange = {
                sharedViewModel.query.value = it
            },
            placeholder = {
                Text(text = "Enter fruit name")
            })
        ElevatedButton(modifier = Modifier
            .width(180.dp)
            .height(40.dp)
            .align(Alignment.Center)
            .offset(0.dp, 80.dp),
            colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.Cyan, contentColor = Color.Black ),
            onClick = {
                sharedViewModel.getDetails()
                navController.navigate("detailScreen")
            }) {
            Text(fontSize = 18.sp,
                text = "Get Details"
            )
        }

    }

}