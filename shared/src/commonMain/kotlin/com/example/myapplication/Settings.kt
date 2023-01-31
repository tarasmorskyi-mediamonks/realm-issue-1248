package com.example.myapplication

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


class ClassRepresentation : RealmObject {

    var value1: Subclass1? = null
    var value2: Subclass2? = null
    var value3: Subclass3? = null
    var value4: Subclass4? = null
    var value5: Boolean? = null
    var value6: Boolean? = null
    var value7: Boolean? = null
    var value8: Subclass5? = null
    var value9: Subclass6? = null
    var value10: String? = null

    @PrimaryKey
    var id: Int = 0
}

class Subclass3 : RealmObject {
    var value31: Boolean? = null
    var value32: Boolean? = null
    var value33: Boolean? = null
    var value34: Boolean? = null
    var value35: Boolean? = null

}

class Subclass4 : RealmObject {
    var value41: Boolean? = null
    var value42: Boolean? = null
}

class Subclass1 : RealmObject {
    var value11: Subclass11? = null
}

class Subclass11 : RealmObject {
    var value111: Boolean? = null
    var value112: String? = null
    var value113: String? = null

}

class Subclass2 : RealmObject {
    var value21: String? = null
    var value22: String? = null
    var value23: String? = null
    var value24: String? = null

}

class Subclass5 : RealmObject {
    var value51: Boolean? = null
    var value52: String? = null
    var value53: String? = null
    var value54: String? = null
    var value55: Subclass51? = null
    var value56: Subclass52? = null

}

class Subclass51 : RealmObject {
    var value511: Int? = null
    var value512: RealmList<String> = realmListOf()

}

class Subclass52 : RealmObject {
    var value521: Int? = null
    var value522: Boolean? = null

}

class Subclass6 : RealmObject {
    var value61: String? = null
    var value62: String? = null
}
