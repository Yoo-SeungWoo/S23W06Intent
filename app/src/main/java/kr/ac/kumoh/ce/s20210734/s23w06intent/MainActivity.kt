package kr.ac.kumoh.ce.s20210734.s23w06intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import kr.ac.kumoh.ce.s20210734.s23w06intent.ui.theme.S23W06IntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S23W06IntentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("안드로이드")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    //Row 가로로 Column 세로로
    Column {
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                //url location
                //urn name
                //uri url+urn
                val uri = Uri.parse("https://www.youtube.com/results?search_query=%EB%89%B4%EC%A7%84%EC%8A%A4+%EB%85%B8%EB%9E%98%EB%B0%A9")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context, intent, null)
            }
        ) {
            Text(text = "유튜브")
        }
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("https://www.facebook.com/official.newjeans/")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context, intent, null)
            }
        ) {
            Text(text = "페이스북")
        }
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("geo:36.145014,128.393047?z=17")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context, intent, null)
            }
        ) {
            Text(text = "좌표")
        }
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                //val uri = Uri.parse("geo:0,0?q=경상북도 구미시 거의동")
                val uri = Uri.parse("geo:0,0?q=경복궁")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context, intent, null)
            }
        ) {
            Text(text = "우리집")
        }
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("tel:01010102350")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context, intent, null)
            }
        ) {
            Text(text = "전화")
        }
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                val uri = Uri.parse("sms:01012345678")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.putExtra("sms_body", "전화 부탁드립니다.")
                startActivity(context, intent, null)
            }
        ) {
            Text(text = "문자")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    S23W06IntentTheme {
        Greeting("Android")
    }
}