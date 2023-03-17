/*
package navigation


import com.arkivanov.decompose.statekeeper.Parcelable
import com.arkivanov.decompose.statekeeper.Parcelable
import com.arkivanov.decompose.statekeeper.Parcelize


*/
/*
    Configuración de niños:

    Uno de los principales objetivos de la biblioteca Decompose es la seguridad del tiempo de
    compilación. Cada niño es descrito por una clase llamada Configuration. El propósito del
    Configuration es describir qué niño debe usarse y qué argumentos tiene. Entonces, para cada
    niño hay una instancia de su propia clase 'Configuration'. Normalmente hay varios niños
    involucrados en la navegación, por lo que todo el conjunto de configuraciones es normalmente
    una clase sellada.

    Por ejemplo, para una navegación simple de Lista-Detalles, solo necesitamos dos entradas
 *//*

sealed class Configuration : Parcelable {
    @Parcelize
    object List : Configuration()
    @Parcelize
    data class Details(val itemId: Long) : Configuration()
}

*/
