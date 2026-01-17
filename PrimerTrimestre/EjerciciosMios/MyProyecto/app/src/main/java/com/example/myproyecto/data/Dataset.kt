package com.example.productos.data

import android.annotation.SuppressLint
import android.widget.Toast
import com.example.myproyecto.model.Producto
import com.google.android.material.snackbar.Snackbar

class Dataset {

    companion object{

        val totalProductos : ArrayList<Producto> = arrayListOf(
            Producto(
                nombre = "Reloj inteligente Xiaomi Mi Band 8",
                precio = 39,
                imagen = "https://m.media-amazon.com/images/I/61r6oAiR1JL._AC_SX679_.jpg",
                stock = 15,
                descripcion = "Pulsera de actividad y salud con monitor cardiaco.",
                categoria = "tecnologia"
            ),
            Producto(
                nombre = "Mascarilla reutilizable negra",
                precio = 8,
                imagen = "https://m.media-amazon.com/images/I/61jq2p1JaJL._AC_SY450_.jpg",
                stock = 120,
                descripcion = "Mascarilla lavable para protección diaria.",
                categoria = "ropa"
            ),
            Producto(
                nombre = "Auriculares inalámbricos JBL Tune 510BT",
                precio = 49,
                imagen = "https://m.media-amazon.com/images/I/71N8GZ52TRL._AC_SX679_.jpg",
                stock = 23,
                descripcion = "Bluetooth, micrófono integrado y sonido potente.",
                categoria = "tecnologia"
            ),
            Producto(
                nombre = "Humidificador ultrasónico TaoTronics",
                precio = 29,
                imagen = "https://m.media-amazon.com/images/I/61EkrDsv4lL._AC_SX679_.jpg",
                stock = 59,
                descripcion = "Mejora la calidad del aire y la salud respiratoria.",
                categoria = "mueble"
            ),
            Producto(
                nombre = "Mochila deportiva Under Armour Hustle",
                precio = 42,
                imagen = "https://m.media-amazon.com/images/I/713xlDbK6sL._AC_SX679_.jpg",
                stock = 33,
                descripcion = "Resistente al agua, con múltiples compartimentos.",
                categoria = "ropa"
            ),
            Producto(
                nombre = "Freidora de aire Cosori 4.7L",
                precio = 99,
                imagen = "https://m.media-amazon.com/images/I/71SOIo4loPL._AC_SX679_.jpg",
                stock = 8,
                descripcion = "Cocina saludable sin aceite, fácil limpieza.",
                categoria = "mueble"
            ),
            Producto(
                nombre = "Teclado gaming Logitech G213",
                precio = 59,
                imagen = "https://m.media-amazon.com/images/I/81a6hk+3UIL._AC_SX679_.jpg",
                stock = 19,
                descripcion = "RGB, resistente a salpicaduras, ideal para gamers.",
                categoria = "tecnologia"
            ),
            Producto(
                nombre = "Tablet Samsung Galaxy Tab A8",
                precio = 199,
                imagen = "https://m.media-amazon.com/images/I/81D3N903b6L._AC_SX679_.jpg",
                stock = 10,
                descripcion = "Tablet de 10.5 pulgadas, 64GB almacenamiento.",
                categoria = "tecnologia"
            ),
            Producto(
                nombre = "Pendientes de plata Tous",
                precio = 69,
                imagen = "https://m.media-amazon.com/images/I/71FK4TUXRAL._AC_SY450_.jpg",
                stock = 25,
                descripcion = "Pendientes originales Tous en plata.",
                categoria = "belleza"
            ),
            Producto(
                nombre = "Leggings deportivos Nike One",
                precio = 36,
                imagen = "https://m.media-amazon.com/images/I/71kfnPOfqVL._AC_UX522_.jpg",
                stock = 40,
                descripcion = "Elásticos y cómodos para deporte.",
                categoria = "ropa"
            ),
            Producto(
                nombre = "Botella de agua Chillys 500ml",
                precio = 22,
                imagen = "https://m.media-amazon.com/images/I/615fH5rvedL._AC_SX679_.jpg",
                stock = 80,
                descripcion = "Botella de acero inoxidable, mantiene frío/calor.",
                categoria = "mueble"
            ),
            Producto(
                nombre = "Esterilla de yoga Amazon Basics",
                precio = 17,
                imagen = "https://m.media-amazon.com/images/I/81Dy9tKEuML._AC_SX679_.jpg",
                stock = 50,
                descripcion = "Ideal para yoga y pilates, antideslizante.",
                categoria = "belleza"
            ),
            Producto(
                nombre = "Juego de mesa Catan",
                precio = 36,
                imagen = "https://m.media-amazon.com/images/I/91FqpFhfFPL._AC_SX679_.jpg",
                stock = 12,
                descripcion = "El clásico juego de estrategia y recursos.",
                categoria = "mueble"
            ),
            Producto(
                nombre = "Aceite esencial Lavanda Pranarom",
                precio = 15,
                imagen = "https://m.media-amazon.com/images/I/61-nrBWWlGL._AC_SY450_.jpg",
                stock = 60,
                descripcion = "Relajante y natural para difusores.",
                categoria = "belleza"
            ),
            Producto(
                nombre = "Silla de escritorio ergonómica Hbada",
                precio = 109,
                imagen = "https://m.media-amazon.com/images/I/71HMZ-8lTtL._AC_SX679_.jpg",
                stock = 7,
                descripcion = "Ajuste lumbar, ruedas suaves, diseño moderno.",
                categoria = "mueble"
            ),
            Producto(
                nombre = "Aspiradora robot Cecotec Conga",
                precio = 179,
                imagen = "https://m.media-amazon.com/images/I/61LwrBFGpeL._AC_SX679_.jpg",
                stock = 15,
                descripcion = "Robot inteligente auto limpieza para hogar.",
                categoria = "mueble"
            ),
            Producto(
                nombre = "Panel solar portátil Bluetti",
                precio = 229,
                imagen = "https://m.media-amazon.com/images/I/51nkrFhQHcL._AC_SX679_.jpg",
                stock = 5,
                descripcion = "Energía renovable portátil para viajes.",
                categoria = "tecnologia"
            ),
            Producto(
                nombre = "Té matcha japonés Bio",
                precio = 12,
                imagen = "https://m.media-amazon.com/images/I/71IeJaoBDlL._AC_SY450_.jpg",
                stock = 34,
                descripcion = "Matcha premium, antioxidante y energizante.",
                categoria = "belleza"
            ),
            Producto(
                nombre = "Trípode móvil Joby GripTight",
                precio = 18,
                imagen = "https://m.media-amazon.com/images/I/51KKo1EyFeL._AC_SX679_.jpg",
                stock = 27,
                descripcion = "Trípode flexible para smartphone y cámaras.",
                categoria = "tecnologia"
            ),
            Producto(
                nombre = "Vintage jeans Levi’s 501",
                precio = 85,
                imagen = "https://m.media-amazon.com/images/I/81HbQZQJwEL._AC_UX466_.jpg",
                stock = 18,
                descripcion = "Vaqueros clásicos vintage, edición especial.",
                categoria = "ropa"
            ),
            Producto(
                nombre = "Pestañas postizas MAGNETIC Ardell",
                precio = 11,
                imagen = "https://m.media-amazon.com/images/I/41xZmyShfYL._AC_SX466_.jpg",
                stock = 58,
                descripcion = "Fácil aplicación, resultado profesional.",
                categoria = "belleza"
            ),
            Producto(
                nombre = "Corrector de postura Beurer",
                precio = 29,
                imagen = "https://m.media-amazon.com/images/I/613XrU3sTVL._AC_SY450_.jpg",
                stock = 22,
                descripcion = "Ajustable para espalda, alivia dolores.",
                categoria = "belleza"
            ),
            Producto(
                nombre = "Cama para gatos Amazon Basics",
                precio = 27,
                imagen = "https://m.media-amazon.com/images/I/71EcmyDIa9L._AC_SX679_.jpg",
                stock = 36,
                descripcion = "Cama mullida y segura para mascotas.",
                categoria = "mueble"
            ),
            Producto(
                nombre = "Coletero scrunchie satinado",
                precio = 4,
                imagen = "https://m.media-amazon.com/images/I/61I8yHjMK7L._AC_SX679_.jpg",
                stock = 100,
                descripcion = "Accesorio de moda para el cabello.",
                categoria = "belleza"
            ),
            Producto(
                nombre = "Lavadora portátil COSTWAY Mini",
                precio = 139,
                imagen = "https://m.media-amazon.com/images/I/718XPlGVnOS._AC_SX679_.jpg",
                stock = 4,
                descripcion = "Pequeña, eficiente y fácil de transportar.",
                categoria = "mueble"
            ),
            Producto(
                nombre = "Caña de pescar telescópica Sougayilang",
                precio = 29,
                imagen = "https://m.media-amazon.com/images/I/718-V4cM4RL._AC_SX679_.jpg",
                stock = 21,
                descripcion = "Ideal para pesca deportiva y recreativa.",
                categoria = "mueble"
            ),
            Producto(
                nombre = "Rascador para gatos Feandrea",
                precio = 59,
                imagen = "https://m.media-amazon.com/images/I/81zsMZBJPAL._AC_SX679_.jpg",
                stock = 15,
                descripcion = "Juguete multifunción, sisal natural.",
                categoria = "mueble"
            ),
            Producto(
                nombre = "Mochila portabebés Ergobaby",
                precio = 139,
                imagen = "https://m.media-amazon.com/images/I/715I2Q0vRuL._AC_SX679_.jpg",
                stock = 7,
                descripcion = "Ergonómica, segura y fácil de ajustar.",
                categoria = "mueble"
            ),
            Producto(
                nombre = "Batidora portátil TOPESCT",
                precio = 26,
                imagen = "https://m.media-amazon.com/images/I/61mrhYDa7pL._AC_SX679_.jpg",
                stock = 24,
                descripcion = "Batidora personal con USB recargable.",
                categoria = "mueble"
            ),
            Producto(
                nombre = "Pantalón Cargo Urban Classics",
                precio = 34,
                imagen = "https://m.media-amazon.com/images/I/71LRDAr9JiL._AC_UX569_.jpg",
                stock = 20,
                descripcion = "Pantalón con bolsillos, estilo casual.",
                categoria = "ropa"
            )
        )  //El RecyclerView.Adapter necesita ArrayList (mutable) para notifyDataSetChanged()

        @SuppressLint("SuspiciousIndentation")
        fun getProductosPorCategoria(cateoria: String) : ArrayList<Producto>{

            var productosPorCategoria = arrayListOf<Producto>()

            //si es "Todas añadimos toda la lista de productos"
            if(cateoria=="Todas"){
                productosPorCategoria.addAll(totalProductos)
            }
            //Si no filtramos por categoria y añadimos solo los productos de dicha categoria
            else productosPorCategoria.addAll(totalProductos.filter { it.categoria == cateoria })

            return productosPorCategoria
        }

        var listaFavoritos: ArrayList<Producto> = arrayListOf()//lista de favoritos que se llenará con el boton add fav
        fun getListaFavoritos(producto: Producto) {

            listaFavoritos.add(producto)
        }

        fun eliminarFavorito(producto: Producto){
            listaFavoritos.remove(producto)
        }

        @SuppressLint("SuspiciousIndentation")
        fun getListaCarrito() : ArrayList<Producto>{

            var listaCarrito = listaFavoritos
            return listaCarrito
        }


    }
}