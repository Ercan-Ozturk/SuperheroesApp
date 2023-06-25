package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.Shapes
import com.example.superheroes.ui.theme.SuperheroesTheme
import com.example.superheroes.ui.theme.Typography

class HeroesScreen {


    @Composable
    fun HeroesCard(displayText: String = "Lorem",
                   bodyText: String = "Lorem",
                   imageRes: Int = R.drawable.android_superhero1

    ) {
        Card(
            Modifier
                .fillMaxWidth()
                , shape = Shapes.medium

        ) {
            Row(Modifier.padding(16.dp)) {
                Column(Modifier.weight(1f)) {
                    Text(text = displayText, style = Typography.displaySmall)
                    Text(text = bodyText, style = Typography.bodyLarge)

                }
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    modifier = Modifier.size(72.dp),
                    painter = painterResource(id = imageRes),
                    contentDescription = displayText
                )
            }
        }

    }

    @Composable
    fun HeroesList(modifier: Modifier) {
        SuperheroesTheme() {
            LazyColumn(
                Modifier.fillMaxSize(),
                contentPadding =
                PaddingValues(
                    top = 8.dp,
                    bottom = 8.dp,
                    start = 16.dp,
                    end = 16.dp
                )
            ) {
                HeroesRepository.heroes.forEach {
                    item {
                        HeroesCard(
                            displayText = stringResource(id = it.nameRes),
                            bodyText =
                            stringResource(
                                id = it.descriptionRes
                            ), imageRes = it.imageRes
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                    }
                }
            }
        }

    }
}