package com.example.comunidadesspinners.dataSet

import com.example.comunidadesspinners.model.ComunidadAutonoma
import com.example.comunidadesspinners.model.Provincia

class DataSet
{
    companion object
    {
        val comunidades = listOf(
            ComunidadAutonoma("Andalucía"),
            ComunidadAutonoma("Aragón"),
            ComunidadAutonoma("Asturias"),
            ComunidadAutonoma("Islas Baleares"),
            ComunidadAutonoma("Canarias"),
            ComunidadAutonoma("Cantabria"),
            ComunidadAutonoma("Castilla-La Mancha"),
            ComunidadAutonoma("Castilla y León"),
            ComunidadAutonoma("Cataluña"),
            ComunidadAutonoma("Comunidad Valenciana"),
            ComunidadAutonoma("Extremadura"),
            ComunidadAutonoma("Galicia"),
            ComunidadAutonoma("Comunidad de Madrid"),
            ComunidadAutonoma("Región de Murcia"),
            ComunidadAutonoma("Navarra"),
            ComunidadAutonoma("País Vasco"),
            ComunidadAutonoma("La Rioja"),
            ComunidadAutonoma("Ceuta"),
            ComunidadAutonoma("Melilla")
        )
        val listaProvincias : ArrayList<Provincia> =  arrayListOf(

        // ANDALUCÍA
        Provincia("Almería", 730000,"Andalucía", 8775),
        Provincia("Cádiz", 1240000, "Andalucía", 7440),
        Provincia("Córdoba", 780000, "Andalucía", 13771),
        Provincia("Granada", 915000, "Andalucía", 12647),
        Provincia("Huelva", 525000, "Andalucía", 10148),
        Provincia("Jaén", 625000, "Andalucía", 13496),
        Provincia("Málaga", 1700000, "Andalucía", 7306),
        Provincia("Sevilla", 1950000, "Andalucía", 14042),

        // ARAGÓN
        Provincia("Huesca", 225000, "Aragón", 15636),
        Provincia("Teruel", 135000, "Aragón", 14809),
        Provincia("Zaragoza", 970000, "Aragón", 17274),

        // ASTURIAS
        Provincia("Asturias", 1020000, "Asturias", 10604),

        // BALEARES
        Provincia("Balears, Illes", 1200000, "Islas Baleares", 4992),

        // CANARIAS
        Provincia("Las Palmas", 1120000, "Canarias", 4066),
        Provincia("Santa Cruz de Tenerife", 1040000, "Canarias", 3381),

        // CANTABRIA
        Provincia("Cantabria", 585000, "Cantabria", 5321),

        // CASTILLA-LA MANCHA
        Provincia("Albacete", 390000, "Castilla-La Mancha", 14858),
        Provincia("Ciudad Real", 505000, "Castilla-La Mancha", 19813),
        Provincia("Cuenca", 200000, "Castilla-La Mancha", 17141),
        Provincia("Guadalajara", 265000, "Castilla-La Mancha", 12214),
        Provincia("Toledo", 740000, "Castilla-La Mancha", 15370),

        // CASTILLA Y LEÓN
        Provincia("Ávila", 158000, "Castilla y León", 8050),
        Provincia("Burgos", 360000, "Castilla y León", 14022),
        Provincia("León", 450000, "Castilla y León", 15580),
        Provincia("Palencia", 160000, "Castilla y León", 8052),
        Provincia("Salamanca", 325000, "Castilla y León", 12349),
        Provincia("Segovia", 153000, "Castilla y León", 6921),
        Provincia("Soria", 90000, "Castilla y León", 10306),
        Provincia("Valladolid", 520000, "Castilla y León", 8110),
        Provincia("Zamora", 170000, "Castilla y León", 10561),

        // CATALUÑA
        Provincia("Barcelona", 5700000, "Cataluña", 7728),
        Provincia("Girona", 785000, "Cataluña", 5905),
        Provincia("Lleida", 435000, "Cataluña", 12172),
        Provincia("Tarragona", 820000, "Cataluña", 6302),

        // C. VALENCIANA
        Provincia("Alicante", 1900000, "Comunidad Valenciana", 5816),
        Provincia("Castellón", 585000, "Comunidad Valenciana", 6632),
        Provincia("Valencia", 2600000, "Comunidad Valenciana", 10763),

        // EXTREMADURA
        Provincia("Badajoz", 675000, "Extremadura", 21766),
        Provincia("Cáceres", 390000, "Extremadura", 19868),

        // GALICIA
        Provincia("A Coruña", 1120000, "Galicia", 7950),
        Provincia("Lugo", 325000, "Galicia", 9856),
        Provincia("Ourense", 310000, "Galicia", 7273),
        Provincia("Pontevedra", 945000, "Galicia", 4495),

        // MADRID
        Provincia("Madrid", 6700000, "Comunidad de Madrid", 8028),

        // MURCIA
        Provincia("Murcia", 1550000, "Región de Murcia", 11314),

        // NAVARRA
        Provincia("Navarra", 660000, "Navarra", 10391),

        // PAÍS VASCO
        Provincia("Álava", 330000, "País Vasco", 3037),
        Provincia("Guipúzcoa", 720000, "País Vasco", 1997),
        Provincia("Vizcaya", 1150000, "País Vasco", 2217),

        // LA RIOJA
        Provincia("La Rioja", 320000, "La Rioja", 5045),

        // CEUTA Y MELILLA
        Provincia("Ceuta", 85000, "Ceuta", 19),
        Provincia("Melilla", 86000, "Melilla", 12)
    )



    }
}