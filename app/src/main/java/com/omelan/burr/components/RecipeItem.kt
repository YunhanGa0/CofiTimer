package com.omelan.burr.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.omelan.burr.R
import com.omelan.burr.model.Recipe
import com.omelan.burr.ui.BurrTheme
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController

@Composable
fun RecipeItem(recipe: Recipe, navigateToRecipe: (recipeId: String) -> Unit) {
    fun onClickRecipe() {
        navigateToRecipe(recipe.id)
    }
    BurrTheme {
        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.padding(10.dp),
        )
        {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .clickable(onClick = { onClickRecipe() })
                    .padding(horizontal = 10.dp),
            ) {
                Icon(
                    Icons.Rounded.Add,
                    modifier = Modifier.height(25.dp).aspectRatio(1f)
                        .align(Alignment.CenterVertically)
                )
                Column(modifier = Modifier.padding(15.dp)) {
                    Text(text = recipe.name)
                    Text(text = recipe.description)
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewRecipeItem() {
    RecipeItem(
        recipe = Recipe(
            id = "1",
            name = "Ultimate V60",
            description = "Recipe by Hoffman",
            iconName = R.drawable.ic_drip
        ),
        navigateToRecipe = {}
    )
}