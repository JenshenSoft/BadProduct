package ua.regin.badproduct.entity


class Additive {

    var id: Long? = null;
    var name: String? = null;
    var description: String? = null;
    var danger: Int? = null;
    var image: String? = null;
    var naturality: String? = null;
    var similar: String? = null;

    constructor(id: Long?, name: String?, description: String?, danger: Int?, image: String?, naturality: String?, similar: String?) {
        this.id = id
        this.name = name
        this.description = description
        this.danger = danger
        this.image = image
        this.naturality = naturality
        this.similar = similar
    }

    constructor();
}
