package ua.regin.badproduct.entity

import org.parceler.Parcel

@Parcel
class Additive {

    var id: Long? = null;
    var name: String? = null;
    var description: String? = null;
    var danger: Int? = null;
    var image: String? = null;
    var naturality: Naturality? = null;
    var synonym: String? = null;
    var similar: String? = null;

    constructor(similar: String?, id: Long?, name: String?, description: String?, danger: Int?, image: String?, naturality: Naturality?, synonym: String?) {
        this.similar = similar
        this.id = id
        this.name = name
        this.description = description
        this.danger = danger
        this.image = image
        this.naturality = naturality
        this.synonym = synonym
    }

    constructor()

    enum class Naturality {
        Natural, Synthetic, Unknown
    }
}
