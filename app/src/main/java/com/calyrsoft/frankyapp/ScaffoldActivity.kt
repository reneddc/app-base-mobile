package com.calyrsoft.frankyapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.calyrsoft.frankyapp.ui.theme.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                scaffoldUI()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scaffoldUI() {
    val scope = rememberCoroutineScope()
    val snackbarhostState = remember {
        SnackbarHostState()
    }
    Scaffold(modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackbarhostState)
        },
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                Text(text = "Centered Top App Bar", maxLines = 1, overflow = TextOverflow.Ellipsis)
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = ""
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }
                )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    val result = snackbarhostState.showSnackbar(
                        message = "Snackbar",
                        actionLabel = "Undo",
                        duration = SnackbarDuration.Long
                    )
                    when ( result) {
                        SnackbarResult.Dismissed -> {

                        }
                        SnackbarResult.ActionPerformed -> {

                        }
                    }
                }
            }) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "")
            }
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Check, contentDescription = "")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Edit, contentDescription = "")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Face, contentDescription = "")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.CheckCircle, contentDescription = "")
                    }
                }
            )
        }
        ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text("Hola")
        }
    }
}
