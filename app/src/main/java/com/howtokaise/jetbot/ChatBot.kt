package com.howtokaise.jetbot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.howtokaise.jetbot.components.ChatFooter
import com.howtokaise.jetbot.components.ChatHadder
import com.howtokaise.jetbot.components.ChatList

@Composable
fun ChatBot (viewModel: ChatBotVM = viewModel()){
    Column (modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        ChatHadder()
        Box(modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center)
        {
            if (viewModel.list.isEmpty()){
                Text(text = "No Chat Available", color = Color.White)
            }else{
                ChatList(list = viewModel.list)
            }
        }
        ChatFooter {
            if (it.isNotEmpty()){
                viewModel.sendMessage(it)
            }

        }

    }

}
