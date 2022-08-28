package com.demo.dialogandalertdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.demo.dialogandalertdialog.ui.theme.DialogAndAlertDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogAndAlertDialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   AlertDialogScreen()
                }
            }
        }
    }
}



@Composable
fun DialogScreen(){

    var isDialog by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { isDialog = true }) {
            Text(text = "Click Here")
        }

}

if(isDialog)

Dialog(onDismissRequest = {
        isDialog = false
    }) {
        CircularProgressIndicator()
    }

}

@Composable
fun AlertDialogScreen(){
    
    var isDialog by remember {
        mutableStateOf(false)
    }
    
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
            ) {
        Button(onClick = { isDialog=true }) {
            Text(text = "Click Here")

        }


        if (isDialog) {
            AlertDialog(onDismissRequest = {  },
                title = {
                    Text(text = "Dialog Box")
                },
                text = {
                    Text(text = "This is Dialog Box content")
                },
                modifier = Modifier.fillMaxWidth(),
                buttons = {
                    Button(
                        onClick = { isDialog=false},
                        modifier = Modifier.align(CenterHorizontally)
                    ) {
                        Text(text = "OK")
                    }
                })
        }
    }

}