package com.bd.f1.model

import javax.persistence.*


@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var userid: Long? = null
    var login: String? = null
    var password: String? = null
    var tipo: String? = null
    var idOriginal: Long? = null
}