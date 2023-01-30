package com.example.myapplication

import io.realm.kotlin.types.RealmObject

class TestRealmClass: RealmObject {
    var fieldone: String = ""
    var fieldtwo: Int = 1
    var testSecondRealmClass: TestSecondRealmClass = TestSecondRealmClass()
}

class TestSecondRealmClass: RealmObject {
    var testThirdRealmClass: TestThirdRealmClass = TestThirdRealmClass()
}

class TestThirdRealmClass: RealmObject {
    var enabled: Boolean? = false
    var minimumAppVersion: String? = "test"
    var contentUrl: String? = "test"
}