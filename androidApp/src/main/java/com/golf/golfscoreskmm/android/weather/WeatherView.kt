package com.golf.golfscoreskmm.android.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.golf.golfscoreskmm.android.R
import com.golf.golfscoreskmm.dtos.GetWeatherQuery
import com.golf.golfscoreskmm.dtos.type.Condition

@Composable
fun WeatherView(weatherInfo: GetWeatherQuery.Weather) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.weather_bottom_nav_title),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        val icon = when (weatherInfo.condition) {
            Condition.CLOUDY -> R.drawable.ic_weather_few_clouds
            Condition.MOSTLY_CLOUDY -> R.drawable.ic_weather_overcast
            else -> R.drawable.ic_sun
        }
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
        Text(
            text = weatherInfo.temperature,
            Modifier.padding(start = 16.dp, top = 16.dp),
            fontSize = 30.sp
        )
        Row {
            Text(
                text = weatherInfo.wind_speed,
                Modifier.padding(start = 16.dp, top = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = weatherInfo.wind_direction,
                Modifier.padding(start = 8.dp, top = 16.dp),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewWeatherView() {
    val weatherInfo = GetWeatherQuery.Weather(
        Condition.MOSTLY_CLOUDY,
        "59 °F",
        "2019-04-11 1:41:00 -0500",
        "CALM",
        "0 mph"
    )
    WeatherView(weatherInfo)
}
