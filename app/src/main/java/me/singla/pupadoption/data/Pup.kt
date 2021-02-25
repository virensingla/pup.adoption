package me.singla.pupadoption.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import me.singla.pupadoption.R

@Parcelize
data class Pup(
    @DrawableRes val image: Int,
    val name: String,
    val breed: String,
    val location: String,
    val isMale: Boolean,
    val about: String? = null
) : Parcelable

val pupsData = listOf(
    Pup(image = R.drawable.pup_1,
        name = "Peanut",
        breed = "Golden Retriever",
        location = "1386 Cabell Avenue, Washington",
        isMale = false
    ),
    Pup(image = R.drawable.pup_2,
        name = "Bailey",
        breed = "Pinscher",
        location = "2682 Boone Crockett Lane, Port Angeles",
        isMale = true
    ),
    Pup(image = R.drawable.pup_3,
        name = "Coco",
        breed = "Golden Retriever",
        location = "2768 Beeghley Street, Alexander City",
        isMale = false
    ),
    Pup(image = R.drawable.pup_4,
        name = "Finn",
        breed = "French Bulldog",
        location = "1386 Cabell Avenue, Washington",
        isMale = true
    ),
    Pup(image = R.drawable.pup_5,
        name = "Lucy",
        breed = "Golden Retriever",
        location = "4953 Wildwood Street, Youngstown",
        isMale = false
    ),
    Pup(image = R.drawable.pup_6,
        name = "Henry",
        breed = "Beagle",
        location = "2965 East Avenue, Washington",
        isMale = true
    ),
    Pup(image = R.drawable.pup_7,
        name = "Lola",
        breed = "God Knows!",
        location = "1470 Deans Lane, New York",
        isMale = false
    ),
    Pup(image = R.drawable.pup_8,
        name = "Jasper",
        breed = "French Bulldog",
        location = "614 Carolyns Circle, Dallas",
        isMale = true
    ),
    Pup(image = R.drawable.pup_9,
        name = "Toby",
        breed = "Papillon",
        location = "1386 Cabell Avenue, Washington",
        isMale = true
    ),
    Pup(image = R.drawable.pup_10,
        name = "Rufus",
        breed = "Labrador Retriever",
        location = "31 Collins Street, Tampa",
        isMale = true
    ),
)