package com.example.myapplication

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class Greeting {
    private val platform: Platform = getPlatform()
    private val bgScope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    val realmConfiguration = RealmConfiguration.Builder(
        setOf(
            TestRealmClass::class, TestSecondRealmClass::class, TestThirdRealmClass::class
        )
    )
        .name("test.realm")
        .deleteRealmIfMigrationNeeded()
        .build()

    val realm = Realm.open(realmConfiguration)

    fun greet(): String {
        bgScope.launch {
            realm.write {
                copyToRealm(TestRealmClass())
            }
        }
        val count = realm.query(TestRealmClass::class).count().find()

        return "Hello, $count ${platform.name}!"
    }
}