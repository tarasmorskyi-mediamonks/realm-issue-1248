package com.example.myapplication

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.realmListOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class Greeting {
    private val platform: Platform = getPlatform()
    private val bgScope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    val realmConfiguration = RealmConfiguration.Builder(
        setOf(
            TestRealmClass::class, TestSecondRealmClass::class, TestThirdRealmClass::class,
            ClassRepresentation::class,
            Subclass3::class,
            Subclass4::class,
            Subclass1::class,
            Subclass11::class,
            Subclass2::class,
            Subclass5::class,
            Subclass51::class,
            Subclass52::class,
            Subclass6::class
        )
    )
        .name("test.realm")
        .deleteRealmIfMigrationNeeded()
        .build()

    val realm = Realm.open(realmConfiguration)

    fun greet(): String {
        bgScope.launch {
            realm.write {
                delete(this.query(ClassRepresentation::class))
                val testValue = ClassRepresentation().apply {
                    value1 = Subclass1().apply {
                        value11 = Subclass11().apply {
                            value111 = true
                            value112 = "111"
                            value113 = "url"
                        }
                    }
                    value2 = Subclass2().apply {
                        value21 = "1"
                        value22 = "1"
                        value23 = "1"
                        value24 = "1"
                    }
                    value3 = Subclass3().apply {
                        value31 = true
                        value32 = true
                        value33 = true
                        value34 = true
                        value35 = true
                    }
                    value4 = Subclass4().apply {
                        value41 = true
                        value42 = true
                    }
                    value5 = true
                    value6 = true
                    value7 = true
                    value8 = Subclass5().apply {
                        value51 = true
                        value52 = "1"
                        value53 = "1"
                        value54 = "1"
                        value55 = Subclass51().apply {
                            value511 = 1
                            value512 = realmListOf("url")
                        }
                        value56 = Subclass52().apply {
                            value521 = 1
                            value522 = true
                        }
                    }
                    value9 = Subclass6().apply {
                        value61 = "ss"
                        value62 = "ss"
                    }
                    value10 = "ss"
                }
                copyToRealm(testValue)
            }
        }
        bgScope.launch {
            realm.write {
                copyToRealm(TestRealmClass())
            }
        }
        val count = realm.query(TestRealmClass::class).count().find()

        return "Hello, $count ${platform.name}!"
    }
}