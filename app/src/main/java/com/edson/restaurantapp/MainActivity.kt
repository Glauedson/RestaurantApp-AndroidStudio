package com.edson.restaurantapp

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.edson.restaurantapp.ui.theme.RestaurantAppTheme
import kotlinx.serialization.builtins.ArraySerializer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestaurantAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App(){
    Scaffold { pad ->
        Column (
            modifier = Modifier
                .padding(pad)
                .fillMaxSize()
                .background(color = Color.White)
        ) {
                // barra de pesquisa
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp , 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(35.dp),
                        tint = Color.Gray
                    )

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "location",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )
                        Text(text = "New York", color = Color.Black, fontWeight = FontWeight.Bold)
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(Color.DarkGray)
                            .size(40.dp),
                    )
                }

                // título
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp,0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Popular Food",
                        fontSize = 20.sp,
                        color = Color.Black,
                    )
                    Text(
                        text = "View all",
                        color = Color.Gray,
                        fontSize = 13.sp,
                    )
                }

                // carrossel
                val foodItems = listOf("🍜 Ramen", "🍣 Sushi", "🥮 Rolls", "🍱 Bentô")

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(foodItems) { name ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(50.dp))
                                .background(Color.White)
                                .border(1.dp, Color.LightGray, RoundedCornerShape(50.dp))
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text(text = name, fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color.Black)
                        }
                    }
                }

                // banner desconto
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(horizontal = 20.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.Black)
                ) {
                    Text(
                        text = "Discount 50%\nlearn more...",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(16.dp)
                    )
                }

                // Grid de proddutos
                data class Produto(
                    val nome: String,
                    val imagem: String,
                    val avaliacao: String,
                    val preco: String
                )

                val produtos = listOf(
                    Produto("Ichiraku Ramen", "y", "4.5", "15.00"),
                    Produto("Philadelhia roll", "y", "4.8", "9.50"),
                    Produto("Ichiraku Ramen", "y", "5", "15.00"),
                    Produto("Ichiraku Ramen", "y", "5", "15.00")
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    items(produtos) { produto ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().background(Color.White),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(12.dp))
                                        .height(180.dp)
                                        .background(Color.DarkGray)
                                        .fillMaxWidth(),
                                    // Aqui vai ficar as imagens dos lanches
                                )

                                Text(
                                    text = produto.nome,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.align(Alignment.Start).padding(start = 15.dp, end = 15.dp, bottom = 5.dp, top = 10.dp)
                                )

                                Row(
                                    modifier = Modifier.fillMaxWidth().padding( start = 15.dp, end = 15.dp, bottom = 10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "R$ ${produto.preco}", color = Color.Black, fontSize = 13.sp)

                                    Row( verticalAlignment = Alignment.CenterVertically ){
                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = null,
                                            modifier = Modifier.size(15.dp),
                                            tint = Color(0xFFFF9800),
                                        )
                                        Text(text = produto.avaliacao, color = Color.Black, fontSize = 13.sp)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


