package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Dice()
                }
            }
        }
    }
}

@Composable
fun Dice() {
    Box(modifier = Modifier.fillMaxSize()) {

        // remember { mutableIntStateOf((1..6).random()) } -> تلخيصها
        // remember -> هي الطريقة التي نجعل الكود ينتبه لكل العناصر المتعلقة بالمتغير ويذكر الكود بإجراء تعديلات ان لزم
        // mutableIntStateOf -> هي الطريقة التي نجعل فيها حالة المتغير كقيمته فينتبه الكود عند تغير حالته أي قيمته

        var number by remember { mutableIntStateOf((1..6).random()) }
        val images = listOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
        )
        Column(modifier = Modifier.align(Alignment.Center)) {
            Image(
                painter = painterResource(id = images[number - 1]), // استخدام دالة الرسم باستعمال معرف الرسمة
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(text = "Rolled: $number",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Button(onClick = { number = (1..6).random() },
                modifier = Modifier
                    .widthIn(150.dp) // تحديد عرض الزر كحد أدنى
                    .align(Alignment.CenterHorizontally) // تحديد موقع الزر في العامود
                    .padding(top = 24.dp) // ترك فراغ من فوق بقيمة 24 dp
            ) {
                Text("Roll", fontSize = 24.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceRollerTheme {
        Dice()
    }
}