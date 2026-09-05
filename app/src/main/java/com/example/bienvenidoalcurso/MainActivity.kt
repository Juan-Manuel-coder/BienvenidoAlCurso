package com.example.bienvenidoalcurso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BienvenidoAlCursoTheme {
                AllComponents()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllComponents() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text("【 SECCIÓN 1 】 SURFACE + CARD + TEXT + SPACER", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        item {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surfaceVariant
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .border(2.dp, Color.Blue, RoundedCornerShape(8.dp))
                    ) {
                        Text("¡Bienvenido a mi App!",modifier = Modifier.padding(16.dp),fontSize = 18.sp )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Texto dentro de Surface - Ejemplo de Spacer")
                }
            }
        }

        item {
            Text("【 SECCIÓN 2 】 LAZYROW", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(4) { index ->
                    Card(
                        modifier = Modifier.size(80.dp, 50.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Item $index", modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }

        item {
            Text("【 SECCIÓN 3 】 GRID (LAZYVERTICALGRID)", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.height(100.dp)
            ) {
                items(4) { index ->
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(4.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Grid $index", modifier = Modifier.padding(12.dp))
                    }
                }
            }
        }

        item {
            Text("【 SECCIÓN 4 】 TOPAPPBAR + FAB + ICON", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        item {
            TopAppBar(title = { Text("Mi App", fontSize = 18.sp) })
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FloatingActionButton(onClick = {}) {
                    Icon(Icons.Default.Add, contentDescription = "Agregar")
                }
                Text("FAB con Icono +")
                Icon(Icons.Default.Favorite, contentDescription = "Favorito")
                Text("Icono Favorito")
            }
        }

        item {
            Text("【 SECCIÓN 5 】 CHIP (simulado con Button)", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(onClick = {}) { Text("Chip 1") }
                Button(onClick = {}) { Text("Chip 2") }
                Button(onClick = {}) { Text("Chip 3") }
            }
        }

        item {
            Text("【 SECCIÓN 6 】 ALERTDIALOG", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        item {
            val openDialog = remember { mutableStateOf(false) }
            Button(onClick = { openDialog.value = true }) {
                Text("Mostrar AlertDialog")
            }
            if (openDialog.value) {
                androidx.compose.material3.AlertDialog(
                    onDismissRequest = { openDialog.value = false },
                    title = { Text("AlertDialog") },
                    text = { Text("Este es un AlertDialog de ejemplo") },
                    confirmButton = {
                        Button(onClick = { openDialog.value = false }) {
                            Text("Aceptar")
                        }
                    }
                )
            }
        }

        item {
            Text("【 SECCIÓN 7 】 CHECKBOX + RADIOBUTTON + SLIDER + SWITCH", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        item {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = false, onCheckedChange = {})
                    Text("Checkbox - Activar opción")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = false, onClick = {})
                    Text("RadioButton - Seleccionar opción")
                }
                Text("Slider - Ajustar volumen")
                Slider(value = 0.5f, onValueChange = {})
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Switch(checked = false, onCheckedChange = {})
                    Text("Switch - Encender/Apagar")
                }
            }
        }

        item {
            Text("【 SECCIÓN 8 】 IMAGE + PROGRESSBAR", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Imagen",
                    modifier = Modifier.size(60.dp)
                )
                CircularProgressIndicator()
            }
        }

        item {
            Text("【 SECCIÓN 9 】 DIVIDER + OUTLINEDTEXTFIELD + TABROW", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        item {
            Column {
                Divider()
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Ingresa tu nombre") },
                    modifier = Modifier.fillMaxWidth()
                )
                TabRow(selectedTabIndex = 0) {
                    Tab(selected = true, onClick = {}) { Text("Tab 1") }
                    Tab(selected = false, onClick = {}) { Text("Tab 2") }
                    Tab(selected = false, onClick = {}) { Text("Tab 3") }
                }
            }
        }

        item {
            Text("【 SECCIÓN 10 】 FLOWROW + FLOWCOLUMN", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        item {
            Column {
                Text("FlowRow - Elementos en fila:")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("Item 1", modifier = Modifier.padding(4.dp))
                    Text("Item 2", modifier = Modifier.padding(4.dp))
                    Text("Item 3", modifier = Modifier.padding(4.dp))
                }
                Text("FlowColumn - Elementos en columna:")
                Column {
                    Text("Item A", modifier = Modifier.padding(4.dp))
                    Text("Item B", modifier = Modifier.padding(4.dp))
                }
            }
        }

        item {
            Text("【 SECCIÓN 11 】 BOTTOMNAVIGATION", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {}) {
                    Icon(Icons.Default.Favorite, contentDescription = null)
                    Text("Inicio")
                }
                Button(onClick = {}) {
                    Icon(Icons.Default.Add, contentDescription = null)
                    Text("Agregar")
                }
                Button(onClick = {}) {
                    Text("Perfil")
                }
            }
        }

        item {
            Text("【 SECCIÓN 12 】 NAVIGATIONRAIL", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {}) {
                    Icon(Icons.Default.Favorite, contentDescription = null)
                    Text("Inicio")
                }
                Button(onClick = {}) {
                    Icon(Icons.Default.Add, contentDescription = null)
                    Text("Agregar")
                }
                Button(onClick = {}) {
                    Text("Ajustes")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAll() {
    BienvenidoAlCursoTheme {
        AllComponents()
    }
}
